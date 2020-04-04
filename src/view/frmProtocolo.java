/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import controller.ProtocoloBD;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import model.Usuario;
import controller.UsuarioBD;
import model.Protocolo;
import model.ProtocoloString;
import model.ValorExtenso;
import view.frmTela;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmProtocolo extends javax.swing.JFrame {

    /**
     * Creates new form frmProtocolo
     */
    List<Protocolo> lista;
    view.frmTela telaUrbano;
    List<Object> listaString= new ArrayList<>();
    private ImageIcon icone;
    DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
    ProtocoloString certidaoString = new ProtocoloString();
    ValorExtenso extenso = new ValorExtenso();
    String nome=" ",dataSistema=" ";
    int op=0;
    int salvar=0;
    int cont=0;
    int zerar=0;
    int fiscal=0;
    int codigo;
    int protoc;
    String lancadoria= "";
    int contImprimir=0;
    Usuario us = null;
    List<Protocolo> cert = null;

    public frmProtocolo(view.frmTela tu, Usuario u) {
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        telaUrbano = tu;
        us = u;
        //buscaValorProtocolo();
        setarDados();
        teclaEnter();
        buscaProtocolo();
        desativaBotoes();
        limpar();
        txtData.setText(getData());
        desativarTexto();
        travarAcesso();
    }
    
    public void travarAcesso(){
        if(telaUrbano.getUs().getPermissao()==4){
            btnNovo.setEnabled(false);
            txtData.setEnabled(false);
            txtSolicitante.setEditable(false);
            txtServico.setEditable(false);
            btnSalvar.setEnabled(false);
        }else{
            btnNovo.setEnabled(true);
            txtData.setEnabled(true);
            txtSolicitante.setEditable(true);
            txtServico.setEditable(true);
            btnSalvar.setEnabled(true);
        }
    }
    public void desativaBotoes(){
        btnNovo.setEnabled(false);
        btnImprimir.setEnabled(false);
    }
    public void ativaBotoes(){
        btnNovo.setEnabled(true);
        btnImprimir.setEnabled(true);
        btnSalvar.setEnabled(true);
    }
    public void desativarTexto(){
        txtData.setEditable(false);
        txtSolicitante.setEditable(false);
        txtProtocolo.setEditable(false);
        txtExercicio.setEditable(false);
        txtServico.setEditable(false);
        txtLaudo.setEditable(false);
    }
    
     public void ativarTexto(){
        txtData.setEditable(true);
        txtSolicitante.setEditable(true);
        txtProtocolo.setEditable(true);
        txtExercicio.setEditable(true);
        txtServico.setEditable(true);
    }
    
    public void retornaDados(){
         salvar = 1;
         btnImprimir.setEnabled(true);
         if(telaUrbano.getUs().getPermissao()==4){
            btnNovo.setEnabled(false);
         }else{
             btnNovo.setEnabled(true);
         }
         btnSalvar.setEnabled(true);
         int contProt=0;
         //btnSalvar.setEnabled(false);
         
         try {
            int indice = tbResultado.getSelectedRow();
            List<Usuario> listaUs= new UsuarioBD().buscaUsuarios2(cert.get(indice).getUsuario());
            if(cert.get(indice).getLaudo().equals(" ")){
                 txtLaudo.setEditable(true);
            }else{
                  txtLaudo.setEditable(false);
            }
            txtExercicio.setText(String.valueOf(cert.get(indice).getExercicio()));
            txtProtocolo.setText(String.valueOf(cert.get(indice).getProtocolo()));
            txtSolicitante.setText(String.valueOf(cert.get(indice).getSolicitante()));
            txtServico.setText(String.valueOf(cert.get(indice).getServico()));
            txtLaudo.setText(String.valueOf(cert.get(indice).getLaudo()));
            txtData.setText(converteData(cert.get(indice).getDataProtocolo()));
            dataSistema = cert.get(indice).getDataSistema();
            lblUsuario2.setText(listaUs.get(0).getNome());
            //lblFiscal.setText("");
            List<Usuario> listFiscal= new UsuarioBD().buscaUsuarios2(cert.get(indice).getFiscal());
             if(cert.get(indice).getUsuario()==cert.get(indice).getFiscal()){
                lblFiscal.setText(" ");
                btnSalvar.setEnabled(true);
                txtLaudo.setEditable(true);
            }else{
                lblFiscal.setText(listFiscal.get(0).getNome());
                btnSalvar.setEnabled(false);
                txtLaudo.setEditable(false);
            }
            lancadoria = String.valueOf(cert.get(indice).getUsuario());
            codigo = cert.get(indice).getCod();
            protoc= cert.get(indice).getProtocolo();
            certidaoString.cadastrar(txtProtocolo.getText(),
                                     txtData.getText(),
                                     converteData(dataSistema),
                                     txtSolicitante.getText(),
                                     txtServico.getText(),
                                     txtExercicio.getText(),
                                     String.valueOf(telaUrbano.getUs()));
            listaString.add(certidaoString);
           
            
            //cbCargo.addItem(fun.get(tbResultado.getSelectedRow()).getFuncao().getDescricao());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     public void limpaTabela(DefaultTableModel dtm){
        dtm.setRowCount(0);        
    }
    
    public void buscaProtocolo() {
        //nome = txtPesquisa.getText();
        //op  = cbxConsultaMedico.getSelectedIndex()+1;
                
        int contProt=0;
        try{
            cert= new ProtocoloBD().listaTabela(txtPesquisa.getText(),cbxConsulta.getSelectedIndex()+1);
            DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
            limpaTabela(dtm);
            int i = 0;
            for(Protocolo c:cert){
                dtm.addRow(cert.get(i).addTable());
                List<Usuario> listFiscal= new UsuarioBD().buscaUsuarios2(cert.get(i).getFiscal());
                if((cert.get(i).getUsuario()==cert.get(i).getFiscal())){
                    contProt++;
                    lblFiscal.setText(" ");
                }else{
                    lblFiscal.setText(listFiscal.get(0).getNome());
                }
                if(contProt>0){
                    if(contProt==1){
                        lblMensagem.setText("ATENÇÃO!!! "+contProt+" pedido em aberto.");
                    }else{
                        lblMensagem.setText("ATENÇÃO!!! "+contProt+" pedidos em aberto.");
                    }
                }else{
                        lblMensagem.setText(" ");
                }
                    
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco", "Erro", JOptionPane.ERROR_MESSAGE);  
        }       
    }
    
public boolean validata (String data) throws ParseException{
        try {
            String dia, mes, ano;
            int diaint, mesint, anoint;
            int verificarano;//variável usada para ver se o ano termina em 00
            String verano;//variável usada para capturar os dois dígitos finais do ano
            int bissexto=0; //igual à zero = bissexto, diferente disto ano normal
            dia = data.substring(0,2);//captura apenas o dia
            mes = data.substring(3,5);//captura apenas o mês
            ano = data.substring(6, 10);//captura apenas o ano
            diaint = Integer.parseInt(dia);//transforma o valor de String para int
            mesint = Integer.parseInt(mes);
            anoint = Integer.parseInt(ano);
            //Verificar se ano é bissexto
            int valorano = anoint%4;//captura o valor do resto
            if(valorano==0){//Anos em que o resto será zero
                verano = data.substring(8,10);//captura os dois dígitos finais do ano
                verificarano = Integer.parseInt(verano);//transforma verano em int
                bissexto=0;//aciona ano bissexto, senão tiver esta linha os anos que são bissexto mas não termina em 00, serão anos normais
                if(verificarano==0){
                    //***validação de datas para anos com fim 00
                    valorano = anoint%400;
                    if(valorano==0){
                        bissexto=0;//ano bissexto
                    }
                    else{
                        bissexto=1;//ano normal
                    }
                    //***fim da validação de datas para anos com fim 00        
                }//fim do verificarano==0
            }//fim do valorano==0
            else{//Anos em que o resto não será zero
                bissexto=1;//ano normal
            }
            //verificar validade do mês
            if(mesint>0 && mesint<=12){
            //verificar se o mês é fevereiro
            if(mesint==02){
                if(diaint>=30 && bissexto==0){//ano bissexto
                    JOptionPane.showMessageDialog(null,"Dia inválido.","Erro!!!",0);
                }
                else if(diaint>=29 && bissexto==1){//ano normal
                    JOptionPane.showMessageDialog(null,"Dia inválido.","Erro!!!",0);
                }                
                else{
                    return true;
                }
            }
            else if(mesint==1 || mesint==3 || mesint==5 || mesint==7 || mesint==8 || 
                    mesint==10 || mesint==12){
                if(diaint>31){
                    JOptionPane.showMessageDialog(null,"Dia inválido.","Erro!!!",0);
                }
                else{
                    return true;
                }
            }
            else if(mesint==4 || mesint==6 || mesint==9 || mesint==11){
                if(diaint>30){
                    JOptionPane.showMessageDialog(null,"Dia inválido.","Erro!!!",0);
                }
                else{
                    return true;
                }
            }
            }//fim do mesint>12 || mesint <=0
            else{
                JOptionPane.showMessageDialog(null,"Mês inválido.","Erro!!!",0);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro!", 0);            
        }
        return false;
    }    

public boolean isValidDate(String inDate) {
        if (inDate == null) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
}
    
    public void setarDados(){
        txtData.setText(getData());
        txtProtocolo.setText(getData());
        txtSolicitante.setText(null);
        txtServico.setText(null);
    }
    
    public void imprimirCertidao1(){
                contImprimir=1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjProtocoloUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 JasperPrint cert = null;
                 HashMap map = new HashMap();
              ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjValorVenal\\src\\view.jasperreports\\protocolo.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    
     public void imprimirCertidao2(){
                contImprimir=1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjProtocoloUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 JasperPrint cert = null;
                 HashMap map = new HashMap();
              ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjValorVenal\\src\\view.jasperreports\\protocolo.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    
    
    public String converteData(String data){
        String d = data.substring(8,10) +"/"+data.substring(5,7)+"/"+ data.substring(0,4);        
        return d;
    } 
     public String formataDataParaBD(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
    }
    public void limpar(){
       txtExercicio.setText(String.valueOf(telaUrbano.getExercicio()));
       txtSolicitante.setText("");
       txtServico.setText("");
       txtProtocolo.setText("");
       lblUsuario2.setText(" ");
       txtLaudo.setText(" ");
       lblFiscal.setText(" ");
    }
    
    public void teclaEnter(){
        KeyStroke keyEscape = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);   
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEscape, "enter");  
        getRootPane().getActionMap().put("enter", new AbstractAction() {  
  
            @Override  
            public void actionPerformed(ActionEvent ae) {  
                try{
                    UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
                    //calcular();
               }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas ao calcular");
               }
                    }  
           });       
    }
public void buscaValorProtocolo() {
            try {
                lista = new ProtocoloBD().listaProtocolo(telaUrbano.getExercicio());              
            } catch (SQLException ex) {
            }
    }

public String getData()  {  
           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
           return formatter.format( new Date() );  
 }  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int width = d.width - (in.left + in.top);
        int height = d.height - (in.top + in.bottom);
        this.setLocation(0, 0);
        this.setSize(width, height);
        setResizable(false);
        this.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                setEnabled(false);
                setEnabled(true);
            }
        });
        jPanel1 = new javax.swing.JPanel();
        txtExercicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSolicitante = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtProtocolo = new javax.swing.JFormattedTextField();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        cbxConsulta = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtServico = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLaudo = new javax.swing.JTextArea();
        lblFiscal = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERAR PROTOCOLO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				if(contImprimir==1){
					 try {
						 telaUrbano.setEnabled(true);
						 telaUrbano.setVisible(true);
						 telaUrbano = new view.frmTela(us, null, 0);
					 } catch (Exception ex) {
						 Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
					 }
				 }else{
					telaUrbano.setEnabled(true);
					telaUrbano.setVisible(true);
				 }
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(469, 407));

        txtExercicio.setEditable(false);
        txtExercicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtExercicio.setText("                                ");
        txtExercicio.setFocusable(false);
        txtExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExercicioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Execicio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Protocolo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Solicitante:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pedido realizado por:");

        txtSolicitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSolicitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSolicitanteActionPerformed(evt);
            }
        });
        txtSolicitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSolicitanteKeyPressed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataKeyPressed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setText("<--Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtProtocolo.setEditable(false);
        txtProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtProtocolo.setFocusable(false);
        txtProtocolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProtocoloKeyPressed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Exercicio", "Proprietário", "Data protocolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultadoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbResultadoMouseReleased(evt);
            }
        });
        tbResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbResultadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbResultadoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultado);

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        cbxConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Protocolo", "Exercício", "Proprietário", "Data Protocolo" }));
        cbxConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxConsultaActionPerformed(evt);
            }
        });
        cbxConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxConsultaKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Pesquisar certidão por:");

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(204, 0, 0));
        lblUsuario2.setText("                                         ");

        txtServico.setColumns(20);
        txtServico.setRows(5);
        txtServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServicoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtServico);

        jButton1.setText("Zerar Protocolo");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Laudo de vistoria da Fiscalização realizado por:");

        txtLaudo.setColumns(20);
        txtLaudo.setRows(5);
        jScrollPane3.setViewportView(txtLaudo);

        lblFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFiscal.setForeground(new java.awt.Color(204, 0, 0));
        lblFiscal.setText("                                         ");

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(204, 0, 0));
        lblMensagem.setText("                                         ");

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(3, 3, 3)
                                .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 161, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 78, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFiscal))
                    .addComponent(lblUsuario2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoltar)
                        .addComponent(btnImprimir)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExercicioActionPerformed

    private void txtSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSolicitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSolicitanteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Protocolo certidao = new Protocolo();
        ProtocoloBD certidaoBD = new ProtocoloBD();
        if(salvar == 0){
                    if(zerar==1){
                        cont=1;
                    }else{
                        try {
                            List<Protocolo> listProt= new ProtocoloBD().listaCertidao3(Integer.valueOf(txtExercicio.getText()));
                             if(listProt.size()>0){
                                cont=listProt.size()+1;
                             }else{
                                cont=1;
                            } 
                        } catch (SQLException ex) {
                            Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    txtProtocolo.setText(String.valueOf(cont++));

                    try {
                        if(txtData.getText().equals("  /  /    ") || validata(txtData.getText())==false){
                            JOptionPane.showMessageDialog(null, "Informe uma data válida!!!");
                        }
                        else if(txtSolicitante.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "Informe o solicitante!!!");
                        }
                        else if(txtServico.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "Informe o serviço!!!");
                        }else{
                            certidao.cadastrar( Integer.parseInt(txtProtocolo.getText()),
                                    txtData.getText(),
                                    getData(),
                                    txtSolicitante.getText(),
                                    txtServico.getText(),
                                    " ",
                                    Integer.parseInt(txtExercicio.getText()),
                                    telaUrbano.getUs().getId(),
                                    telaUrbano.getUs().getId());

                            try {
                                certidaoBD.salvar(certidao);
                                ativaBotoes();
                                buscaValorProtocolo();
                                //limpar();
                                //setarDados();
                            } catch (SQLException ex) {
                                Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            certidaoString.cadastrar(   txtProtocolo.getText(),
                                    txtData.getText(),
                                    getData(),
                                    txtSolicitante.getText().toString(),
                                    txtServico.getText().toString(),
                                    txtExercicio.getText(),
                                    String.valueOf(telaUrbano.getUs())
                            );
                            listaString.add(certidaoString);
                            int op = JOptionPane.showConfirmDialog(null,"Deseja imprimir protocolo?","Atencão",JOptionPane.YES_NO_OPTION);             
                            if(op == 0){
                                    Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                                    imprimirCertidao1();
                            }
                            buscaProtocolo();
                            limpar();
                            setarDados();
                            desativarTexto();
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
            }
                    zerar=0;
                    cont=0;
        }else{
                    try {
                        if(txtData.getText().equals("  /  /    ") || validata(txtData.getText())==false){
                            JOptionPane.showMessageDialog(null, "Informe uma data válida!!!");
                        }
                        else if(txtSolicitante.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "Informe o solicitante!!!");
                        }
                        else if(txtServico.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "Informe o serviço!!!");
                        }else{
                            certidao.alterar(   codigo,
                                                Integer.parseInt(txtProtocolo.getText()),
                                                txtData.getText(),
                                                getData(),
                                                txtSolicitante.getText(),
                                                txtServico.getText(),
                                                txtLaudo.getText(),
                                                Integer.parseInt(txtExercicio.getText()),
                                                Integer.parseInt(lancadoria),
                                                telaUrbano.getUs().getId());
                            try {
                                certidaoBD.alterar(certidao);
                                buscaProtocolo();
                                ativaBotoes();
                                limpar();
                                setarDados();   
                            } catch (SQLException ex) {
                                Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            /*
                            certidaoString.cadastrar(   txtProtocolo.getText(),
                                    txtData.getText(),
                                    getData(),
                                    txtSolicitante.getText().toString(),
                                    txtServico.getText().toString(),
                                    txtExercicio.getText(),
                                    String.valueOf(telaUrbano.getUs())
                            );
                            listaString.add(certidaoString);
                            int op = JOptionPane.showConfirmDialog(null,"Deseja imprimir certidão?","Atencão",JOptionPane.YES_NO_OPTION);             
                            if(op == 0){
                                    imprimirCertidao1();
                            }
                            desativarTexto();
                            buscaProtocolo();*/
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    zerar=0;
                    cont=0;
                    salvar=0;
                    limpar();  
                    desativarTexto();
                    travarAcesso();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
         if(contImprimir==1){
             try {
                 telaUrbano.setEnabled(true);
                 telaUrbano = new view.frmTela(us, null, 0);
                 this.dispose();
             } catch (Exception ex) {
                 Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
            telaUrbano.setEnabled(true);
            this.dispose();
         }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
            imprimirCertidao1();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmProtocolo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tbResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseReleased
        desativarTexto();
        retornaDados();
    }//GEN-LAST:event_tbResultadoMouseReleased

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        nome = txtPesquisa.getText();
        op  = cbxConsulta.getSelectedIndex()+1;
        limpar();
        //fechado();
        buscaProtocolo();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void cbxConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConsultaActionPerformed
        txtPesquisa.setText(null);
        limpar();
        buscaProtocolo();
    }//GEN-LAST:event_cbxConsultaActionPerformed

    private void cbxConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxConsultaKeyReleased
        txtPesquisa.setText(null);
    }//GEN-LAST:event_cbxConsultaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        zerar=1;
        if(telaUrbano.getUs().getPermissao()==1){
            int op = JOptionPane.showConfirmDialog(null,"Ao confirmar esta operação a sequencia do protocolo sera iniciada a partir de '1'.\nDeseja Realmente executar esta operação?","Atencão",JOptionPane.YES_NO_OPTION);
                                if(op == 0){
                                    txtProtocolo.setText("1");
                                }
         }else{
              JOptionPane.showMessageDialog(null, "Você não tem permissão para realizar esta operação!!!");
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtData.setText(getData());
        ativarTexto();
        btnImprimir.setEnabled(false);
        btnSalvar.setEnabled(true);
        setarDados();
        limpar();
        salvar=0;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void tbResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyPressed
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyPressed

    private void tbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyReleased
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyReleased

    private void tbResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseClicked
        retornaDados();
    }//GEN-LAST:event_tbResultadoMouseClicked

    private void txtProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProtocoloKeyPressed
       
    }//GEN-LAST:event_txtProtocoloKeyPressed

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtSolicitante.requestFocus();
        }
    }//GEN-LAST:event_txtDataKeyPressed

    private void txtSolicitanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSolicitanteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtServico.requestFocus();
        }
    }//GEN-LAST:event_txtSolicitanteKeyPressed

    private void txtServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicoKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_txtServicoKeyPressed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbxConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFiscal;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JTable tbResultado;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JTextArea txtLaudo;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtProtocolo;
    private javax.swing.JTextArea txtServico;
    private javax.swing.JTextField txtSolicitante;
    // End of variables declaration//GEN-END:variables
}

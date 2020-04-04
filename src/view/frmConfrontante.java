/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import controller.ConfrontanteBD;
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
import model.Confrontante;
import model.ConfrontanteString;
import model.ValorExtenso;
import view.frmTela;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmConfrontante extends javax.swing.JFrame {

   List<Confrontante> lista;
    view.frmTela telaUrbano;
    List<Object> listaString= new ArrayList<>();
    private ImageIcon icone;
    DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
    ConfrontanteString certidaoString = new ConfrontanteString();
    ValorExtenso extenso = new ValorExtenso();
    String nome=" ",dataSistema=" ";
    int op=0;
    int contImprimir=0;
    Usuario us = null;
    List<Confrontante> cert = null;
    
    public frmConfrontante(view.frmTela tu,model.Usuario u) {
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        telaUrbano = tu;
        us=u;
        buscaValorVenal();
        carregarCampos();
        //limpar();
        //setarDados();
        teclaEnter();
        buscaCertidao();
        desativaBotoes();

    }
     public void carregarCampos(){
       txtBairro.setText(telaUrbano.getBairro());
       txtExercicio.setText(String.valueOf(telaUrbano.getExercicio()));
       txtInscCadastral.setText(telaUrbano.getInscricao());
       txtNumero.setText(telaUrbano.getNumero());
       txtProprietario.setText(telaUrbano.getProprietario());
      // txtProtocolo.setText("");
       txtData.setValue(getData());
       txtLogradouro.setText(telaUrbano.getLogradouro());
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
        txtBairro.setEnabled(false);
        txtData.setEnabled(false);
        txtInscCadastral.setEnabled(false);
        txtNumero.setEnabled(false);
        txtProprietario.setEnabled(false);
        txtProtocolo.setEnabled(false);
        txtLogradouro.setEnabled(false);
        txtExercicio.setEnabled(false);
        txtProprietario1.setEnabled(false);
        txtProprietario2.setEnabled(false);
        txtProprietario3.setEnabled(false);
        txtFundos.setEnabled(false);
        txtEsquerdo.setEnabled(false);
        txtDireito.setEnabled(false);
    }
    
     public void ativarTexto(){
        txtBairro.setEnabled(true);
        txtData.setEnabled(true);
        txtInscCadastral.setEnabled(true);
        txtNumero.setEnabled(true);
        txtProprietario.setEnabled(true);
        txtProtocolo.setEnabled(true);
        txtLogradouro.setEnabled(true);
        txtExercicio.setEnabled(true);
        txtProprietario1.setEnabled(true);
        txtProprietario2.setEnabled(true);
        txtProprietario3.setEnabled(true);
        txtFundos.setEnabled(true);
        txtEsquerdo.setEnabled(true);
        txtDireito.setEnabled(true);
    }
    
    public void retornaDados(){
         btnImprimir.setEnabled(true);
         btnNovo.setEnabled(true);
         btnSalvar.setEnabled(false);
         
         try {
            int indice = tbResultado.getSelectedRow();
            List<Usuario> listaUs= new UsuarioBD().buscaUsuarios2(cert.get(indice).getUsuario());
            
            txtExercicio.setText(String.valueOf(cert.get(indice).getExercicio()));
            txtProtocolo.setText(String.valueOf(cert.get(indice).getProtocolo()));
            txtBairro.setText(cert.get(indice).getBairro());
            txtData.setText(converteData(cert.get(indice).getDataProtocolo()));
            txtInscCadastral.setText(String.valueOf(cert.get(indice).getInscCadastral()));
            txtNumero.setText(String.valueOf(cert.get(indice).getNumero()));
            txtProprietario.setText(String.valueOf(cert.get(indice).getProprietario()));
            txtProprietario1.setText(String.valueOf(cert.get(indice).getProprietario1()));
            txtProprietario2.setText(String.valueOf(cert.get(indice).getProprietario2()));
            txtProprietario3.setText(String.valueOf(cert.get(indice).getProprietario3()));
            txtLogradouro.setText(String.valueOf(cert.get(indice).getRua()));
            txtFundos.setText(String.valueOf(cert.get(indice).getFundos()).replace(".",","));
            txtDireito.setText(String.valueOf(cert.get(indice).getDireito()).replace(".",","));
            txtEsquerdo.setText(String.valueOf(cert.get(indice).getEsquerdo()).replace(".",","));
            lblUsuario2.setText("Gerado por "+listaUs.get(0).getNome());
            dataSistema = cert.get(indice).getDataSistema();
            
            certidaoString.cadastrar(txtProtocolo.getText(),
                                     txtData.getText(),
                                     txtBairro.getText(), 
                                     txtLogradouro.getText(),
                                     txtInscCadastral.getText(),
                                     txtProprietario.getText(),
                                     txtProprietario1.getText(),
                                     txtProprietario2.getText(),
                                     txtProprietario3.getText(),
                                     txtFundos.getText()+"m",
                                     txtDireito.getText()+"m",
                                     txtEsquerdo.getText()+"m",
                                     converteData(dataSistema),
                                     txtNumero.getText(),
                                     txtExercicio.getText()
                                    );
            listaString.add(certidaoString);
             //cbCargo.addItem(fun.get(tbResultado.edvaldgetSelectedRow()).getFuncao().getDescricao());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     public void limpaTabela(DefaultTableModel dtm){
        dtm.setRowCount(0);        
    }
    
    public void buscaCertidao() {
        //nome = txtPesquisa.getText();
        //op  = cbxConsultaMedico.getSelectedIndex()+1;
        try{
            cert= new ConfrontanteBD().listaTabela(txtPesquisa.getText(),cbxConsulta.getSelectedIndex()+1);
            DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
            limpaTabela(dtm);
            int i = 0;
            for(Confrontante c:cert){
                dtm.addRow(cert.get(i).addTable());
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
        txtBairro.setText("");
        txtData.setText(null);
        txtInscCadastral.setText(null);
        txtNumero.setText(null);
        txtProprietario.setText("");
        txtProtocolo.setText(null);
        txtLogradouro.setText("");
    }
    
    public void imprimirCertidao1(){
                contImprimir=1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjVenalUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 JasperPrint cert = null;
                 HashMap map = new HashMap();
              ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjValorVenal\\src\\view.jasperreports\\certidaoConfrontante.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    
     public void imprimirCertidao2(){
                contImprimir=1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjVenalUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 JasperPrint cert = null;
                 HashMap map = new HashMap();
              ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjValorVenal\\src\\view.jasperreports\\certidaoConfrontante1.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
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
       txtBairro.setText("");
       txtExercicio.setText(String.valueOf(telaUrbano.getExercicio()));
       txtInscCadastral.setText("");
       txtNumero.setText("");
       txtProprietario.setText("");
       txtProtocolo.setText("");
       txtLogradouro.setText("");
       txtProprietario1.setText("");
       txtProprietario2.setText("");
       txtProprietario3.setText("");
       txtFundos.setText("");
       txtEsquerdo.setText("");
       txtDireito.setText("");
       lblUsuario2.setText(" ");
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
public void buscaValorVenal() {
            try {
                lista = new ConfrontanteBD().listaCertidao1(telaUrbano.getExercicio());              
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProprietario = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtInscCadastral = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtNumero = new javax.swing.JFormattedTextField();
        txtProtocolo = new javax.swing.JFormattedTextField();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        cbxConsulta = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        txtFundos = new javax.swing.JFormattedTextField();
        txtProprietario1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDireito = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txtProprietario2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEsquerdo = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtProprietario3 = new javax.swing.JTextField();
        lblUsuario2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CERTIDÃO DE CONFRONTANTE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				if(contImprimir==1){
					 try {						 
						 telaUrbano = new frmTela(us, null, 0);
						 telaUrbano.setEnabled(true);
						 telaUrbano.setVisible(true);
					 } catch (Exception ex) {
						 Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
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

        txtExercicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtExercicio.setText("                                ");
        txtExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExercicioActionPerformed(evt);
            }
        });
        txtExercicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExercicioKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Execicio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Protocolo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Proprietário:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Rua:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Bairro:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Inscrição Cadastral:");

        txtProprietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProprietarioActionPerformed(evt);
            }
        });
        txtProprietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProprietarioKeyPressed(evt);
            }
        });

        txtLogradouro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });
        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyPressed(evt);
            }
        });

        txtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });

        txtInscCadastral.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInscCadastral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInscCadastralActionPerformed(evt);
            }
        });
        txtInscCadastral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInscCadastralKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("n°:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Fundos:");

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

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        txtProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Protocolo", "Exercicio", "Proprietário", "Lançamento"
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
        cbxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Protocolo", "Exercício", "Proprietário", "Lançamento" }));
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

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(71, 25));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        txtFundos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtFundos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFundos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFundosFocusGained(evt);
            }
        });
        txtFundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFundosActionPerformed(evt);
            }
        });
        txtFundos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFundosKeyPressed(evt);
            }
        });

        txtProprietario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProprietario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProprietario1ActionPerformed(evt);
            }
        });
        txtProprietario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProprietario1KeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Proprietário:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Direito:");

        txtDireito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtDireito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDireito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireitoFocusGained(evt);
            }
        });
        txtDireito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireitoActionPerformed(evt);
            }
        });
        txtDireito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireitoKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Proprietário:");

        txtProprietario2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProprietario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProprietario2ActionPerformed(evt);
            }
        });
        txtProprietario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProprietario2KeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Esquerdo:");

        txtEsquerdo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtEsquerdo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEsquerdo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEsquerdoFocusGained(evt);
            }
        });
        txtEsquerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsquerdoActionPerformed(evt);
            }
        });
        txtEsquerdo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEsquerdoKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Proprietário:");

        txtProprietario3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProprietario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProprietario3ActionPerformed(evt);
            }
        });
        txtProprietario3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProprietario3KeyPressed(evt);
            }
        });

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(204, 0, 0));
        lblUsuario2.setText("                                         ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProtocolo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProprietario))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBairro))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtLogradouro)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtData)
                                                        .addGap(76, 76, 76))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtInscCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFundos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProprietario1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProprietario2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEsquerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProprietario3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtInscCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProprietario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDireito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProprietario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtEsquerdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProprietario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnImprimir)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExercicioActionPerformed

    private void txtProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietarioActionPerformed

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtInscCadastralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInscCadastralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInscCadastralActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Confrontante certidao = new Confrontante();
        ConfrontanteBD certidaoBD = new ConfrontanteBD();

        if(txtBairro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Informe o bairro!!!");
        }
        else try {
            if(txtData.getText().equals("  /  /    ") || validata(txtData.getText())==false){
                JOptionPane.showMessageDialog(null, "Informe uma data válida!!!");
            }
            else if(txtInscCadastral.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a inscrição cadastral!!!");
            }
            else if(txtNumero.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o número!!!");
            }
            else if(txtProprietario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário!!!");
            }
            else if(txtProprietario1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário de fundos!!!");
            }
            else if(txtProprietario2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário da direita!!!");
            }
            else if(txtProprietario3.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário da esquerda!!!");
            }
            else if(txtProtocolo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o protocolo!!!");
            }
             else if(txtFundos.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a metragem de fundos!!!");
            }
             else if(txtDireito.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a metragem da direita!!!");
            }
             else if(txtEsquerdo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a metragem da esquerda!!!");
            }
            else if(txtLogradouro.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a rua!!!");
            }else{
                certidao.cadastrar(Integer.parseInt(txtProtocolo.getText()),
                    txtData.getText(),
                    txtBairro.getText(),
                    txtLogradouro.getText(),
                    txtInscCadastral.getText(),
                    txtProprietario.getText(),
                    txtProprietario1.getText(),
                    txtProprietario2.getText(),
                    txtProprietario3.getText(),
                    Double.parseDouble(txtFundos.getText().replace(",",".")),
                    Double.parseDouble(txtDireito.getText().replace(",",".")),
                    Double.parseDouble(txtEsquerdo.getText().replace(",",".")),
                    getData(),
                    Integer.parseInt(txtNumero.getText()),
                    Integer.parseInt(txtExercicio.getText()),
                    telaUrbano.getUs().getId()
                );
                try {
                    certidaoBD.salvar(certidao);
                    ativaBotoes();
                    btnSalvar.setEnabled(false);
                    buscaValorVenal();
                } catch (SQLException ex) {
                    Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
                }

                certidaoString.cadastrar(String.valueOf(lista.get(0).getProtocolo()),
                    converteData(lista.get(0).getDataProtocolo()),
                    lista.get(0).getBairro(),
                    lista.get(0).getRua(),
                    lista.get(0).getInscCadastral(),
                    lista.get(0).getProprietario(),
                    lista.get(0).getProprietario1(),
                    lista.get(0).getProprietario2(),
                    lista.get(0).getProprietario3(),
                    String.valueOf(txtFundos.getText()).replace(".",",")+"m",
                    String.valueOf(txtDireito.getText()).replace(".",",")+"m",
                    String.valueOf(txtEsquerdo.getText()).replace(".",",")+"m",
                    String.valueOf(formatador.format(new Date())),
                    String.valueOf(lista.get(0).getNumero()),
                    txtExercicio.getText()
                );
                listaString.add(certidaoString);
                int op = JOptionPane.showConfirmDialog(null,"Deseja imprimir certidão?","Atencão",JOptionPane.YES_NO_OPTION);
                if(op == 0){
                        Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                        UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                        imprimirCertidao1();
                }
                btnSalvar.setEnabled(false);
                desativarTexto();
                buscaCertidao();
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if(contImprimir==1){
             try {
                 telaUrbano.setEnabled(true);
                 telaUrbano = new frmTela(us, null, 0);
                 this.dispose();
             } catch (Exception ex) {
                 Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
             }
        }else{
            telaUrbano.setEnabled(true);
            this.dispose();
         }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
       try {
           UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
       } catch (UnsupportedLookAndFeelException ex) {
           Logger.getLogger(frmConfrontante.class.getName()).log(Level.SEVERE, null, ex);
       }
            imprimirCertidao1();
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
        buscaCertidao();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void cbxConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConsultaActionPerformed
        txtPesquisa.setText(null);
        limpar();
        buscaCertidao();
    }//GEN-LAST:event_cbxConsultaActionPerformed

    private void cbxConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxConsultaKeyReleased
        txtPesquisa.setText(null);
    }//GEN-LAST:event_cbxConsultaKeyReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        ativarTexto();
        btnImprimir.setEnabled(false);
        btnSalvar.setEnabled(true);
        setarDados();
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtFundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFundosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFundosActionPerformed

    private void txtFundosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFundosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFundosFocusGained

    private void txtFundosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFundosKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtProprietario1.requestFocus();
        }
    }//GEN-LAST:event_txtFundosKeyPressed

    private void txtProprietario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietario1ActionPerformed

    private void txtDireitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireitoActionPerformed

    private void txtDireitoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireitoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireitoFocusGained

    private void txtDireitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireitoKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtProprietario2.requestFocus();
        }
    }//GEN-LAST:event_txtDireitoKeyPressed

    private void txtProprietario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietario2ActionPerformed

    private void txtEsquerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsquerdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsquerdoActionPerformed

    private void txtEsquerdoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEsquerdoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsquerdoFocusGained

    private void txtEsquerdoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEsquerdoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtProprietario3.requestFocus();
        }
    }//GEN-LAST:event_txtEsquerdoKeyPressed

    private void txtProprietario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietario3ActionPerformed

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

    private void txtExercicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExercicioKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtProtocolo.requestFocus();
        }
    }//GEN-LAST:event_txtExercicioKeyPressed

    private void txtProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProtocoloKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtData.requestFocus();
        }
    }//GEN-LAST:event_txtProtocoloKeyPressed

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtProprietario.requestFocus();
        }
    }//GEN-LAST:event_txtDataKeyPressed

    private void txtProprietarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProprietarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtLogradouro.requestFocus();
        }
    }//GEN-LAST:event_txtProprietarioKeyPressed

    private void txtLogradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogradouroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtNumero.requestFocus();
        }
    }//GEN-LAST:event_txtLogradouroKeyPressed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtBairro.requestFocus();
        }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtInscCadastral.requestFocus();
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtInscCadastralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInscCadastralKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtFundos.requestFocus();
        }
    }//GEN-LAST:event_txtInscCadastralKeyPressed

    private void txtProprietario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProprietario1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtDireito.requestFocus();
        }
    }//GEN-LAST:event_txtProprietario1KeyPressed

    private void txtProprietario2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProprietario2KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtEsquerdo.requestFocus();
        }
    }//GEN-LAST:event_txtProprietario2KeyPressed

    private void txtProprietario3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProprietario3KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_txtProprietario3KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDireito;
    private javax.swing.JFormattedTextField txtEsquerdo;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JFormattedTextField txtFundos;
    private javax.swing.JTextField txtInscCadastral;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtProprietario;
    private javax.swing.JTextField txtProprietario1;
    private javax.swing.JTextField txtProprietario2;
    private javax.swing.JTextField txtProprietario3;
    private javax.swing.JFormattedTextField txtProtocolo;
    // End of variables declaration//GEN-END:variables
}

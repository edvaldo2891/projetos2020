/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.rural;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import controller.RuralBD;
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
import model.Rural;
import model.RuralString;
import model.ValorExtenso;
import view.frmEspelho;
import view.frmEspelho;
import view.frmTela;
import view.frmVenal;
import view.frmVenal;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmRural extends javax.swing.JFrame {
    List<Rural> lista;
    view.frmTela telaUrbano;
    List<Object> listaString= new ArrayList<>();
    private ImageIcon icone;
    DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
    RuralString certidaoString = new RuralString();
    ValorExtenso extenso = new ValorExtenso();
    String nome=" ",dataSistema=" ";
    String medida;
    int op=0;
    int contImprimir =0;
    Usuario us = null;
    List<Rural> cert = null;
    /**
     * Creates new form frmRural
     */
    public frmRural(view.frmTela tu,Usuario u) {
        icone = new ImageIcon("C:\\prjVenalUrbano\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        telaUrbano = tu;
        us = u;
        buscaValorVenal();
        limpar();
        setarDados();
        teclaEnter();
        buscaCertidao();
        desativaBotoes();
        txtFracao.setEnabled(false);
    }

    public String verificaMedida(){
        if(rdbAlqueire.isSelected()){
            medida="alqueire";
        }
        if(rdbHectare.isSelected()){
            medida="hectare";
        }
        return medida;
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
        txtDataProtocolo.setEnabled(false);
        txtInscCadastral.setEnabled(false);
        txtMedida.setEnabled(false);
        txtProprietario.setEnabled(false);
        txtProtocolo.setEnabled(false);
        txtImovel.setEnabled(false);
        txtExercicio.setEnabled(false);
        txtSolicitante.setEnabled(false);
        txtValorVenal.setEnabled(false);
        rdbAlqueire.setEnabled(false);
        rdbHectare.setEnabled(false);
        chkFracao.setEnabled(false);
        txtFracao.setEnabled(false);
    }
    
     public void ativarTexto(){
        txtBairro.setEnabled(true);
        txtDataProtocolo.setEnabled(true);
        txtInscCadastral.setEnabled(true);
        txtMedida.setEnabled(true);
        txtProprietario.setEnabled(true);
        txtProtocolo.setEnabled(true);
        txtImovel.setEnabled(true);
        txtExercicio.setEnabled(true);
        txtSolicitante.setEnabled(true);
        rdbAlqueire.setEnabled(true);
        rdbHectare.setEnabled(true);
        chkFracao.setEnabled(true);
        txtFracao.setEditable(true);
        txtValorVenal.setEnabled(true);
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
            txtDataProtocolo.setText(converteData(cert.get(indice).getDataprotocolo()));
            txtSolicitante.setText(String.valueOf(cert.get(indice).getSolicitante()));
            txtBairro.setText(cert.get(indice).getBairro());
            txtInscCadastral.setText(String.valueOf(cert.get(indice).getInsccadastral()));
            txtProprietario.setText(String.valueOf(cert.get(indice).getProprietario()));
            txtImovel.setText(String.valueOf(cert.get(indice).getDescimovel()));
            txtMedida.setText(String.valueOf(cert.get(indice).getMedida()));
            txtValorVenal.setText(NumberFormat.getCurrencyInstance().format(cert.get(indice).getValorvenal()));
            txtFracao.setText(String.valueOf(cert.get(indice).getFracao()));
            lblUsuario2.setText("Gerado por "+listaUs.get(0).getNome());
            dataSistema = cert.get(indice).getDatasistema();
            
            certidaoString.cadastrar(txtProtocolo.getText(),
                                     txtDataProtocolo.getText(),
                                     txtSolicitante.getText(),
                                     txtBairro.getText(), 
                                     txtImovel.getText(),
                                     txtMedida.getText(),
                                     txtProprietario.getText(),
                                     txtInscCadastral.getText(),
                                     txtExercicio.getText(),
                                     txtValorVenal.getText()+"("+extenso.valorPorExtenso(cert.get(indice).getValorvenal())+")",
                                     converteData(dataSistema),
                                     txtFracao.getText());
            listaString.add(certidaoString);
            //cbCargo.addItem(fun.get(tbResultado.getSelectedRow()).getFuncao().getDescricao());
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
            cert= new RuralBD().listaTabela(txtPesquisa.getText(),cbxConsulta.getSelectedIndex()+1);
            DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
            limpaTabela(dtm);
            int i = 0;
            for(Rural c:cert){
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
        txtDataProtocolo.setText(null);
        txtInscCadastral.setText(null);
        txtSolicitante.setText(null);
        txtProprietario.setText("");
        txtProtocolo.setText(null);
        txtFracao.setText(null);
        txtImovel.setText("");
        txtMedida.setText("");
    }
    
    public void imprimirCertidao1(){
                 contImprimir=1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjVenalUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 JasperPrint cert = null;
                 HashMap map = new HashMap();
              ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjVenalUrbano\\src\\certidao\\certidaoRural.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmRural.class.getName()).log(Level.SEVERE, null, ex);
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
                 String arquivoJasper = "C:\\prjVenalUrbano\\src\\certidao\\certidaoRural2.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmVenal.class.getName()).log(Level.SEVERE, null, ex);
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
       txtSolicitante.setText("");
       txtProprietario.setText("");
       txtProtocolo.setText("");
       txtImovel.setText("");
       txtMedida.setText("");
       txtFracao.setText(null);
       txtValorVenal.setText(String.valueOf(telaUrbano.getVenalTotal()).replace(".",","));
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
                lista = new RuralBD().listaCertidao1(telaUrbano.getExercicio());              
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        txtSolicitante = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDataProtocolo = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtProtocolo = new javax.swing.JFormattedTextField();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        cbxConsulta = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        txtMedida = new javax.swing.JFormattedTextField();
        txtValorVenal = new javax.swing.JFormattedTextField();
        txtInscCadastral = new javax.swing.JFormattedTextField();
        lblHectare = new javax.swing.JLabel();
        rdbHectare = new javax.swing.JRadioButton();
        lblAlqueire = new javax.swing.JLabel();
        rdbAlqueire = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtImovel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFracao = new javax.swing.JFormattedTextField();
        chkFracao = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CERTIDÃO NEGATIVA RURAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
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
        jLabel5.setText("Solicitante:");

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Medida:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Valor Venal: R$");

        try {
            txtDataProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataProtocolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDataProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataProtocoloKeyPressed(evt);
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

        txtProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
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

        txtMedida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtMedida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMedida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMedidaFocusGained(evt);
            }
        });
        txtMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedidaActionPerformed(evt);
            }
        });
        txtMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMedidaKeyPressed(evt);
            }
        });

        txtValorVenal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorVenal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtValorVenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVenalActionPerformed(evt);
            }
        });
        txtValorVenal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorVenalKeyPressed(evt);
            }
        });

        try {
            txtInscCadastral.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtInscCadastral.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInscCadastral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInscCadastralKeyPressed(evt);
            }
        });

        lblHectare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHectare.setText("Hectare");

        buttonGroup1.add(rdbHectare);
        rdbHectare.setSelected(true);
        rdbHectare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHectareActionPerformed(evt);
            }
        });
        rdbHectare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbHectareKeyPressed(evt);
            }
        });

        lblAlqueire.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAlqueire.setText("Alqueire");

        buttonGroup1.add(rdbAlqueire);
        rdbAlqueire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAlqueireActionPerformed(evt);
            }
        });
        rdbAlqueire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbAlqueireKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Imóvel:");

        txtImovel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImovelActionPerformed(evt);
            }
        });
        txtImovel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImovelKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fração ideal:");

        txtFracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtFracao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFracao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFracaoFocusGained(evt);
            }
        });
        txtFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFracaoActionPerformed(evt);
            }
        });
        txtFracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFracaoKeyPressed(evt);
            }
        });

        chkFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFracaoActionPerformed(evt);
            }
        });
        chkFracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chkFracaoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("%");

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(204, 0, 0));
        lblUsuario2.setText("                                         ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProprietario))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSolicitante))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtInscCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtImovel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lblHectare)
                                        .addGap(2, 2, 2)
                                        .addComponent(rdbHectare)
                                        .addGap(0, 0, 0)
                                        .addComponent(lblAlqueire)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbAlqueire)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))))
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
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFracao, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkFracao)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorVenal, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblUsuario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtInscCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAlqueire)
                        .addComponent(rdbAlqueire)
                        .addComponent(rdbHectare)
                        .addComponent(lblHectare)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFracao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtFracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtValorVenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
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

    private void txtSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSolicitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSolicitanteActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Rural certidao = new Rural();
        RuralBD certidaoBD = new RuralBD();
        
        if(txtBairro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Informe o bairro!!!");
        }
        else try {
            if(txtDataProtocolo.getText().equals("  /  /    ") || validata(txtDataProtocolo.getText())==false){
                JOptionPane.showMessageDialog(null, "Informe uma data válida!!!");
            }
            else if(txtInscCadastral.getText().equals("   .   .   .   - ")){
                JOptionPane.showMessageDialog(null, "Informe a inscrição cadastral!!!");
            }
            else if(txtSolicitante.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o solicitante!!!");
            }
            else if(txtProprietario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário!!!");
            }
            else if(txtImovel.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o Imóvel!!!");
            }
            else if(txtProtocolo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o protocolo!!!");
            }
            else if(txtFracao.getText().equals("") && chkFracao.isSelected()){
                JOptionPane.showMessageDialog(null, "Informe a Fracao!!!");
            }
            else if(txtMedida.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe a medida!!!");
            }else{
                certidao.cadastrar( Integer.parseInt(txtProtocolo.getText()),
                    txtDataProtocolo.getText(),
                    txtSolicitante.getText(),
                    txtBairro.getText(),
                    txtImovel.getText(),
                    txtMedida.getText()+verificaMedida(),
                    txtProprietario.getText(),
                    txtInscCadastral.getText(),
                    Integer.parseInt(txtExercicio.getText()),
                    Double.parseDouble(txtValorVenal.getText().replace(",",".")),
                    getData(),
                    txtFracao.getText()+"%",
                    telaUrbano.getUs().getId());

                try {
                    certidaoBD.salvar(certidao);
                    ativaBotoes();
                    btnSalvar.setEnabled(false);
                    buscaValorVenal();
                } catch (SQLException ex) {
                    Logger.getLogger(frmRural.class.getName()).log(Level.SEVERE, null, ex);
                }

                certidaoString.cadastrar(   String.valueOf(lista.get(0).getProtocolo()),
                    converteData(lista.get(0).getDataprotocolo()),
                    lista.get(0).getSolicitante(),
                    lista.get(0).getBairro(),
                    lista.get(0).getDescimovel(),
                    lista.get(0).getMedida(),
                    lista.get(0).getProprietario(),
                    String.valueOf(lista.get(0).getInsccadastral()),
                    txtExercicio.getText(),
                    NumberFormat.getCurrencyInstance().format(lista.get(0).getValorvenal())+"("+extenso.valorPorExtenso(lista.get(0).getValorvenal())+")",
                    String.valueOf(formatador.format(new Date())),
                    lista.get(0).getFracao()
                );
                listaString.add(certidaoString);
                int op = JOptionPane.showConfirmDialog(null,"Deseja imprimir certidão?","Atencão",JOptionPane.YES_NO_OPTION);
                if(op == 0){
                       if(!chkFracao.isSelected()){
                           Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                           UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                           imprimirCertidao1();
                       }else{
                            Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                            imprimirCertidao2();
                       }
                }
                btnSalvar.setEnabled(false);
                desativarTexto();
                buscaCertidao();
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmEspelho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmRural.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if(contImprimir==1){
             try {
                 telaUrbano.setEnabled(true);
                 telaUrbano = new view.frmTela(us, null, 0);
                 this.dispose();
             } catch (Exception ex) {
                 Logger.getLogger(frmRural.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
            telaUrbano.setEnabled(true);
            this.dispose();
         }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            if(txtFracao.getText().equals("") || txtFracao.getText().equals(null)){
                Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                imprimirCertidao1();
            }else{
                Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                imprimirCertidao2();
           }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmRural.class.getName()).log(Level.SEVERE, null, ex);
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

    private void txtMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaActionPerformed

    private void txtMedidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedidaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaFocusGained

    private void txtMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedidaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            rdbHectare.requestFocus();
        }
    }//GEN-LAST:event_txtMedidaKeyPressed

    private void txtValorVenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVenalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVenalActionPerformed

    private void rdbHectareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHectareActionPerformed
        //calcular();
    }//GEN-LAST:event_rdbHectareActionPerformed

    private void rdbAlqueireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAlqueireActionPerformed
        //calcular();
    }//GEN-LAST:event_rdbAlqueireActionPerformed

    private void txtImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImovelActionPerformed

    private void txtFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFracaoActionPerformed

    private void txtFracaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFracaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFracaoFocusGained

    private void txtFracaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFracaoKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            chkFracao.requestFocus();
        }
    }//GEN-LAST:event_txtFracaoKeyPressed

    private void chkFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFracaoActionPerformed
        if(chkFracao.isSelected()){
            txtFracao.setEnabled(true);
        }else{
            txtFracao.setText("");
            txtFracao.setEnabled(false);
        }
    }//GEN-LAST:event_chkFracaoActionPerformed

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
            txtDataProtocolo.requestFocus();
        }
    }//GEN-LAST:event_txtProtocoloKeyPressed

    private void txtDataProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataProtocoloKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtProprietario.requestFocus();
        }
    }//GEN-LAST:event_txtDataProtocoloKeyPressed

    private void txtProprietarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProprietarioKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtSolicitante.requestFocus();
        }
    }//GEN-LAST:event_txtProprietarioKeyPressed

    private void txtSolicitanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSolicitanteKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtImovel.requestFocus();
        }
    }//GEN-LAST:event_txtSolicitanteKeyPressed

    private void txtImovelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImovelKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtBairro.requestFocus();
        }
    }//GEN-LAST:event_txtImovelKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtInscCadastral.requestFocus();
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtInscCadastralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInscCadastralKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtMedida.requestFocus();
        }
    }//GEN-LAST:event_txtInscCadastralKeyPressed

    private void rdbHectareKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbHectareKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            rdbAlqueire.requestFocus();
        }
    }//GEN-LAST:event_rdbHectareKeyPressed

    private void rdbAlqueireKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbAlqueireKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtFracao.requestFocus();
        }
    }//GEN-LAST:event_rdbAlqueireKeyPressed

    private void chkFracaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chkFracaoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtValorVenal.requestFocus();
        }
    }//GEN-LAST:event_chkFracaoKeyPressed

    private void txtValorVenalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorVenalKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_txtValorVenalKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxConsulta;
    private javax.swing.JCheckBox chkFracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel lblAlqueire;
    private javax.swing.JLabel lblHectare;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JRadioButton rdbAlqueire;
    private javax.swing.JRadioButton rdbHectare;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtDataProtocolo;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JFormattedTextField txtFracao;
    private javax.swing.JTextField txtImovel;
    private javax.swing.JFormattedTextField txtInscCadastral;
    private javax.swing.JFormattedTextField txtMedida;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtProprietario;
    private javax.swing.JFormattedTextField txtProtocolo;
    private javax.swing.JTextField txtSolicitante;
    private javax.swing.JFormattedTextField txtValorVenal;
    // End of variables declaration//GEN-END:variables
}

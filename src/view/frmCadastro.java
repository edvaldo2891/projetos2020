/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import controller.AreasBD;
import controller.CadastroBD;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
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
import model.Areas;
import model.Cadastro;
import model.CadastroString;
import model.Usuario;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmCadastro extends javax.swing.JFrame {
     DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
     CadastroString certidaoString = new CadastroString();
     List<Cadastro> listCert;
     List<CadastroString> listaString= new ArrayList<>();
     List<CadastroString> listaString2= new ArrayList<>();
     List<Areas> listaAreas= new ArrayList<>();
     frmTela tela;
     int contLinha=0;
     int contCelulas=0;
     String nome=" ",dataSistema=" ";
     int op=0;
     List<String> tabelaString= new ArrayList<>();
     String tabela=" ";
     int contImprimir=0;
     Usuario us = null;
     
    /**
     * Creates new form frmCadastro
     */
    private ImageIcon icone;
    public frmCadastro(view.frmTela t,model.Usuario u) {
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        tela=t;
        us=u;
        txtExercicio.setText(String.valueOf(tela.getExercicio()));
        buscaCertidao();
        teclaEnter();
    }
    
    public void desativarTexto(){
        txtData.setEnabled(false);
        txtProprietario.setEnabled(false);
        txtProtocolo.setEnabled(false);
        txtExercicio.setEnabled(false);
        btnAddLinha.setEnabled(false);
        btnRemoverLinha.setEnabled(false);
        btnSalvar.setEnabled(false);
        tbAreas.setEnabled(false);
    }
    
     public void ativarTexto(){
        txtData.setEnabled(true);
        txtProprietario.setEnabled(true);
        txtProtocolo.setEnabled(true);
        txtExercicio.setEnabled(false);
        btnAddLinha.setEnabled(true);
        btnRemoverLinha.setEnabled(true);
        btnSalvar.setEnabled(true);
        tbAreas.setEnabled(true);
    }
    
     public void limpar(){
       txtExercicio.setText(String.valueOf(tela.getExercicio()));     
       txtProprietario.setText("");
       txtProtocolo.setText("");
       lblUsuario2.setText(" ");
       txtData.setText(null);
       DefaultTableModel dtm = (DefaultTableModel)tbAreas.getModel();
       limpaTabela(dtm);
       contCelulas=0;
       contLinha=0;
    }
    
     public void retornaDados(){
         desativarTexto();
         btnImprimir.setEnabled(true);
         btnNovo.setEnabled(true);
         btnSalvar.setEnabled(false);
         tbAreas.setEnabled(false);
         tabela=" ";
         listaString2.clear();
         tabelaString.clear();
         listaAreas.clear();
       
         try {
            int indice = tbResultado.getSelectedRow();
            List<Usuario> listaUs= new UsuarioBD().buscaUsuarios2(listaString.get(indice).getUsuario());
            
            txtExercicio.setText(String.valueOf(listaString.get(indice).getExercicio()));
            txtProtocolo.setText(String.valueOf(listaString.get(indice).getProtocolo()));
            txtData.setText(converteData(listaString.get(indice).getDataProtocolo()));
            txtProprietario.setText(String.valueOf(listaString.get(indice).getProprietario()));
            dataSistema = listaString.get(indice).getDataSistema();
            lblUsuario2.setText("Gerado por "+listaUs.get(0).getNome());
            
            buscaAreas(listaString.get(indice).getCod());
            
            DefaultTableModel dtm = (DefaultTableModel)tbAreas.getModel();
            limpaTabela(dtm);
            int i = 0;
            for(Areas a:listaAreas){
                dtm.addRow(listaAreas.get(i).addTable());
                i++;
            }
                for(int aux1=0; aux1<listaAreas.size(); aux1++){
                            tabelaString.add((aux1+1)+") Inscrição Cadastral n°"+listaAreas.get(aux1).getInscCadastral().toUpperCase()+
                                    ", localizado a RUA "+listaAreas.get(aux1).getRua().toUpperCase()+
                                    ", "+listaAreas.get(aux1).getArea().toUpperCase()+
                                    ", com uma área de terreno medindo: "+String.valueOf(listaAreas.get(aux1).getTerreno()).replace(".",",")+"m².\n");
                }
                
                 for(int aux1=0; aux1<listaAreas.size(); aux1++){
                     tabela+=tabelaString.get(aux1)+"\n";
                 }
                 
            certidaoString.cadastrar(tela.getUs().getId(),
                                     txtProtocolo.getText(),
                                     txtData.getText(),                                   
                                     txtProprietario.getText(),                                   
                                     txtExercicio.getText(),
                                     converteData(dataSistema),
                                     tabela);
           listaString2.add(certidaoString);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
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
      
    public int verificarTabela(){
       int cont=0;
       for(int aux1=0;aux1<contLinha;aux1++){
            if(tbAreas.getValueAt(aux1,0)==null || tbAreas.getValueAt(aux1,1)==null || tbAreas.getValueAt(aux1,2)==null || tbAreas.getValueAt(aux1,3)==null){
                 cont++;
            }
       }
       return cont;
    }
    
    public void teclaEnter(){
        KeyStroke keyEscape = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);   
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEscape, "enter");  
        getRootPane().getActionMap().put("enter", new AbstractAction() {  
  
            @Override  
            public void actionPerformed(ActionEvent ae) {  
                try{
                    UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
                   // calcular();
                   if(contLinha>0){
                      addLinhaTabela(); 
                   }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas na tabela!!");
               }
            }  
        });       
    }
    public void imprimirCertidao(){
                contImprimir = 1;
               //JasperReport report = JasperCompileManager .compileReport("C:\\Users\\EDVALDO ANTUNES\\Documents\\NetBeansProjects\\prjVenalUrbano\\src\\tabela.jrxml"); 
               //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                 System.out.println("Relatório gerado.");
                 @SuppressWarnings("UnusedAssignment")
                 JasperPrint cert = new JasperPrint();
               ///alterar endereco desta pagina 
                 String arquivoJasper = "C:\\prjValorVenal\\src\\view.jasperreports\\certidaoCadastro.jasper";                  
                    try {
                            cert = JasperFillManager.fillReport(arquivoJasper,null,new JRBeanCollectionDataSource(listaString2));
                            JasperViewer.viewReport(cert, false);
                        } catch (JRException ex) {
                            Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    
    public void limpaTabela(DefaultTableModel dtm){
        dtm.setRowCount(0);        
    }
    public void buscaAreas(Integer cod) {
        try{
            listaAreas= new AreasBD().listaAreas(cod);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco", "Erro", JOptionPane.ERROR_MESSAGE);  
        }       
    }
     public void buscaCertidao() {
        try{
            listaString= new CadastroBD().listaCertidaoString2(txtPesquisa.getText(),cbxConsulta.getSelectedIndex()+1);
            DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
            limpaTabela(dtm);
            int i = 0;
            for(CadastroString c:listaString){
                dtm.addRow(listaString.get(i).addTable());
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco", "Erro", JOptionPane.ERROR_MESSAGE);  
        }       
    }
    
public void addLinhaTabela(){
    contLinha++;
    DefaultTableModel dtm = (DefaultTableModel)tbAreas.getModel();
    Vector rowData = null;
    dtm.addRow(rowData); 
}
public void removeLinhaTabela(){
    DefaultTableModel dtm = (DefaultTableModel)tbAreas.getModel();
    if(contLinha>0){
        dtm.removeRow(contLinha-1); 
        contLinha--;
    }
}

public String getData()  {  
           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
           return formatter.format( new Date() );  
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAreas = new javax.swing.JTable();
        btnAddLinha = new javax.swing.JButton();
        txtExercicio = new javax.swing.JTextField();
        txtProtocolo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProprietario = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxConsulta = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        btnRemoverLinha = new javax.swing.JButton();
        lblUsuario2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CERTIDÃO DE LANÇAMENTO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				if(contImprimir==1){
					 try {
						 tela.setEnabled(true);
						 tela.setVisible(true);
						 tela = new frmTela(us, null, 0);
					 } catch (Exception ex) {
						 Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
					 }
				}else{
					tela.setEnabled(true);
					tela.setVisible(true);
				}
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbAreas.setBackground(new java.awt.Color(204, 204, 255));
        tbAreas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbAreas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lançamento", "Rua", "Area", "Terreno(m²)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbAreas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbAreas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbAreas);

        btnAddLinha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddLinha.setText("Adicionar linha");
        btnAddLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLinhaActionPerformed(evt);
            }
        });
        btnAddLinha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddLinhaKeyPressed(evt);
            }
        });

        txtExercicio.setEditable(false);
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

        txtProtocolo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtProtocolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProtocoloKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Execicio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Protocolo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data do protocolo:");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Proprietário:");

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

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(71, 25));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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
                "Protocolo", "Exercício", "Proprietáiro", "Data de emissão"
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
        jScrollPane2.setViewportView(tbResultado);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Lista de certidões cadastradas");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Pesquisar certidão por:");

        cbxConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Protocolo", "Exercício", "Proprietário", "Data(ex: 2016-06-06)" }));
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

        btnRemoverLinha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverLinha.setText("Remover linha");
        btnRemoverLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverLinhaActionPerformed(evt);
            }
        });

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(204, 0, 0));
        lblUsuario2.setText("                                         ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProprietario)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                        .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddLinha)
                        .addGap(0, 0, 0)
                        .addComponent(btnRemoverLinha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblUsuario2))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddLinha)
                    .addComponent(btnRemoverLinha))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnImprimir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLinhaActionPerformed
        addLinhaTabela();
        contCelulas=contLinha*4;
    }//GEN-LAST:event_btnAddLinhaActionPerformed

    private void txtExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExercicioActionPerformed

    private void txtProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietarioActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Cadastro certidao = new Cadastro();
        CadastroBD certidaoBD = new CadastroBD();
        Areas ar = new Areas();
        AreasBD arBD = new AreasBD();
        try {
            if(txtData.getText().equals("  /  /    ") || validata(txtData.getText())==false){
                JOptionPane.showMessageDialog(null, "Informe uma data válida!!!");
            }                     
            else if(txtProprietario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o proprietário!!!");
            }
            else if(txtProtocolo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o protocolo!!!");
            }else if(contLinha==0){
                JOptionPane.showMessageDialog(null, "Adicione linha na tabela!!!");  
            }else if(verificarTabela()>0){
                  JOptionPane.showMessageDialog(null, "Preencha todos os campos da tabela!!!"); 
            }else{
                certidao.cadastrar( Integer.parseInt(txtProtocolo.getText()),
                        txtData.getText(),
                        txtProprietario.getText(),                       
                        Integer.parseInt(txtExercicio.getText()),
                        getData(),
                        tela.getUs().getId());
                try {
                    certidaoBD.salvar(certidao);
                   // ativaBotoes();
                    //btnSalvar.setEnabled(false);
                    //buscaValorVenal();
                } catch (SQLException ex) {
                    Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
                             
                listCert= new CadastroBD().listaCertidao();
                for(int aux1=0; aux1<contLinha; aux1++){
                        ar.cadastrar(listCert.get(0).getCod(),
                                       String.valueOf(tbAreas.getValueAt(aux1,0)),//lançamento
                                       String.valueOf(tbAreas.getValueAt(aux1,1)),//rua
                                       String.valueOf(tbAreas.getValueAt(aux1,2)),//area
                                       Double.parseDouble(String.valueOf(tbAreas.getValueAt(aux1,3)).replace(",",".")));//terreno
                        arBD.salvar(ar);
                }
                buscaAreas(listCert.get(0).getCod());
                for(int aux1=0; aux1<contLinha; aux1++){
                            tabelaString.add((aux1+1)+") Inscrição Cadastral n°"+listaAreas.get(aux1).getInscCadastral().toUpperCase()+
                                    ", localizado a RUA "+listaAreas.get(aux1).getRua().toUpperCase()+
                                    ", "+listaAreas.get(aux1).getArea().toUpperCase()+
                                    ", com uma área de terreno medindo: "+String.valueOf(listaAreas.get(aux1).getTerreno()).replace(".",",")+"m².\n");
                }
                 for(int aux1=0; aux1<contLinha; aux1++){
                     tabela+=tabelaString.get(aux1)+"\n";
                 }
                certidaoString.cadastrar( tela.getUs().getId(),
                                          txtProtocolo.getText(),
                                          txtData.getText(), 
                                          txtProprietario.getText().toUpperCase(),
                                          txtExercicio.getText(),
                                          formatador.format(new Date()), 
                                          tabela);
                 
                listaString2.add(certidaoString);
                int op = JOptionPane.showConfirmDialog(null,"Deseja imprimir certidão?","Atencão",JOptionPane.YES_NO_OPTION);
                if(op == 0){
                    Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                    imprimirCertidao();
                }
                ativarTexto();
                limpar();
                btnImprimir.setEnabled(false);
                btnSalvar.setEnabled(true);

                desativarTexto();
                buscaCertidao();
                listaAreas.clear();
                tabelaString.clear();
                tabela="";
               // btnSalvar.setEnabled(false);
            }                                      
        } catch (ParseException ex) {
            Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if(contImprimir==1){
             try {
                 tela.setEnabled(true);
                 tela = new frmTela(us, null, 0);
                 this.dispose();
             } catch (Exception ex) {
                 Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
            tela.setEnabled(true);
            this.dispose();
         }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
         try {   
                Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                imprimirCertidao();
        } catch (Exception ex) {
            Logger.getLogger(frmCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
              
              listaAreas.clear();
              tabelaString.clear();
              tabela=" ";
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        ativarTexto();
        limpar();
        btnImprimir.setEnabled(false);
        btnSalvar.setEnabled(true);
        listaAreas.clear();
        tabelaString.clear();
        tabela=" ";
//        setarDados();
    //    limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void cbxConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConsultaActionPerformed
        txtPesquisa.setText(null);
        //limpar();
        buscaCertidao();
    }//GEN-LAST:event_cbxConsultaActionPerformed

    private void cbxConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxConsultaKeyReleased
        txtPesquisa.setText(null);
    }//GEN-LAST:event_cbxConsultaKeyReleased

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        nome = txtPesquisa.getText();
        op  = cbxConsulta.getSelectedIndex()+1;
        //limpar();
        //fechado();
        buscaCertidao();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnRemoverLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverLinhaActionPerformed
        removeLinhaTabela();
    }//GEN-LAST:event_btnRemoverLinhaActionPerformed

    private void tbResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseReleased
         retornaDados();
    }//GEN-LAST:event_tbResultadoMouseReleased

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
            btnAddLinha.requestFocus();
        }
    }//GEN-LAST:event_txtProprietarioKeyPressed

    private void btnAddLinhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddLinhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_btnAddLinhaKeyPressed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLinha;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemoverLinha;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JTable tbAreas;
    private javax.swing.JTable tbResultado;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtProprietario;
    private javax.swing.JFormattedTextField txtProtocolo;
    // End of variables declaration//GEN-END:variables
}

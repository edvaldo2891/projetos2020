package view;


import controller.ColetaLixoBD;
import controller.ExercicioBD;
import controller.SinistroBD;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import model.ColetaLixo;
import model.Exercicio;
import model.Sinistro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmPlantaGenerica extends javax.swing.JFrame {
    frmTela tela;
    view.rural.frmTela telaRural;
    
    /**
     * Creates new form frmPlantaGenerica
     */
    private ImageIcon icone;
    
    public frmPlantaGenerica(frmTela t) {
        tela = t;
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        txtExercicio.setText(String.valueOf(tela.lista.get(0).getExercicio()));
        telaRural = new view.rural.frmTela(tela);
        teclaEnter();
    }

    public void teclaEnter(){
        KeyStroke keyEscape = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);   
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEscape, "enter");  
        getRootPane().getActionMap().put("enter", new AbstractAction() {  
  
            @Override  
            public void actionPerformed(ActionEvent ae) {  
                try{
                    UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
                        gerarPalntaGenerica();
               }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas ao calcular");
               }
                    }  
           });       
    }
    
    
    public void gerarPalntaGenerica(){
        double correcao;
        double ufesp;
        int verifica=0;
        int exercicio=tela.lista.get(0).getExercicio()+1;
        
        Exercicio ex = new Exercicio();
        ExercicioBD exBd = new ExercicioBD();
        ColetaLixo cl = new ColetaLixo();
        ColetaLixoBD clBD = new ColetaLixoBD();
        model.rural.Exercicio ruralExe = new model.rural.Exercicio();
        controller.rural.ExercicioBD ruralExeBd = new controller.rural.ExercicioBD();
        Sinistro s = new Sinistro();
        SinistroBD sBD = new SinistroBD();
        DecimalFormat df = new DecimalFormat("#.00");
        
        if(txtUfesp.getText().length()>0 && txtCorrecao.getText().length()>0){
                        ufesp = Double.parseDouble(txtUfesp.getText().replace(",","."));
                        correcao= Double.parseDouble(txtCorrecao.getText().replace(',','.'));
                        correcao=correcao/100;

                        for(int aux=0;aux<tela.listaVerifica.size();aux++){
                            if(tela.listaVerifica.get(aux).getExercicio()==exercicio){
                                verifica=1;
                            }
                        }
                        if(verifica==1){
                            JOptionPane.showMessageDialog(null, "Exercicio de "+exercicio+" já possui planta genérica!!!");
                            verifica=0;
                        }else{
                            int op = JOptionPane.showConfirmDialog(null,"Deseja Realmente executar esta operação?","Atencão",JOptionPane.YES_NO_OPTION);
                            if(op == 0){
                                        ex.cadastrar(tela.lista.get(0).getExercicio()+1,Double.parseDouble(df.format((tela.lista.get(0).getA_1_0()*correcao)+tela.lista.get(0).getA_1_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_1_1()*correcao)+tela.lista.get(0).getA_1_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_1_2()*correcao)+tela.lista.get(0).getA_1_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_1_3()*correcao)+tela.lista.get(0).getA_1_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_2_0()*correcao)+tela.lista.get(0).getA_2_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_2_1()*correcao)+tela.lista.get(0).getA_2_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_2_2()*correcao)+tela.lista.get(0).getA_2_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_2_3()*correcao)+tela.lista.get(0).getA_2_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_3_0()*correcao)+tela.lista.get(0).getA_3_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_3_1()*correcao)+tela.lista.get(0).getA_3_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_3_2()*correcao)+tela.lista.get(0).getA_3_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_3_3()*correcao)+tela.lista.get(0).getA_3_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getA_terreno()*correcao)+tela.lista.get(0).getA_terreno()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_1_0()*correcao)+tela.lista.get(0).getB_1_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_1_1()*correcao)+tela.lista.get(0).getB_1_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_1_2()*correcao)+tela.lista.get(0).getB_1_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_1_3()*correcao)+tela.lista.get(0).getB_1_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_2_0()*correcao)+tela.lista.get(0).getB_2_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_2_1()*correcao)+tela.lista.get(0).getB_2_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_2_2()*correcao)+tela.lista.get(0).getB_2_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_2_3()*correcao)+tela.lista.get(0).getB_2_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_3_0()*correcao)+tela.lista.get(0).getB_3_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_3_1()*correcao)+tela.lista.get(0).getB_3_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_3_2()*correcao)+tela.lista.get(0).getB_3_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_3_3()*correcao)+tela.lista.get(0).getB_3_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getB_terreno()*correcao)+tela.lista.get(0).getB_terreno()).replace(",",".")),                         
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_1_0()*correcao)+tela.lista.get(0).getC_1_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_1_1()*correcao)+tela.lista.get(0).getC_1_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_1_2()*correcao)+tela.lista.get(0).getC_1_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_1_3()*correcao)+tela.lista.get(0).getC_1_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_2_0()*correcao)+tela.lista.get(0).getC_2_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_2_1()*correcao)+tela.lista.get(0).getC_2_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_2_2()*correcao)+tela.lista.get(0).getC_2_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_2_3()*correcao)+tela.lista.get(0).getC_2_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_3_0()*correcao)+tela.lista.get(0).getC_3_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_3_1()*correcao)+tela.lista.get(0).getC_3_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_3_2()*correcao)+tela.lista.get(0).getC_3_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_3_3()*correcao)+tela.lista.get(0).getC_3_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getC_terreno()*correcao)+tela.lista.get(0).getC_terreno()).replace(",",".")),                        
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_1_0()*correcao)+tela.lista.get(0).getD_1_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_1_1()*correcao)+tela.lista.get(0).getD_1_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_1_2()*correcao)+tela.lista.get(0).getD_1_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_1_3()*correcao)+tela.lista.get(0).getD_1_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_2_0()*correcao)+tela.lista.get(0).getD_2_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_2_1()*correcao)+tela.lista.get(0).getD_2_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_2_2()*correcao)+tela.lista.get(0).getD_2_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_2_3()*correcao)+tela.lista.get(0).getD_2_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_3_0()*correcao)+tela.lista.get(0).getD_3_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_3_1()*correcao)+tela.lista.get(0).getD_3_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_3_2()*correcao)+tela.lista.get(0).getD_3_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_3_3()*correcao)+tela.lista.get(0).getD_3_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getD_terreno()*correcao)+tela.lista.get(0).getD_terreno()).replace(",",".")),                          
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_1_0()*correcao)+tela.lista.get(0).getE_1_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_1_1()*correcao)+tela.lista.get(0).getE_1_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_1_2()*correcao)+tela.lista.get(0).getE_1_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_1_3()*correcao)+tela.lista.get(0).getE_1_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_2_0()*correcao)+tela.lista.get(0).getE_2_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_2_1()*correcao)+tela.lista.get(0).getE_2_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_2_2()*correcao)+tela.lista.get(0).getE_2_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_2_3()*correcao)+tela.lista.get(0).getE_2_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_3_0()*correcao)+tela.lista.get(0).getE_3_0()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_3_1()*correcao)+tela.lista.get(0).getE_3_1()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_3_2()*correcao)+tela.lista.get(0).getE_3_2()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_3_3()*correcao)+tela.lista.get(0).getE_3_3()).replace(",",".")),
                                                                                        Double.parseDouble(df.format((tela.lista.get(0).getE_terreno()*correcao)+tela.lista.get(0).getE_terreno()).replace(",","."))
                                                          );
                                        ruralExe.cadastrar(tela.lista.get(0).getExercicio()+1,
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getAparecida_salto()*correcao)+telaRural.lista.get(0).getAparecida_salto()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getBarreirinho()*correcao)+telaRural.lista.get(0).getBarreirinho()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getCacador()*correcao)+telaRural.lista.get(0).getCacador()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getCerrado()*correcao)+telaRural.lista.get(0).getCerrado()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getFurnas()*correcao)+telaRural.lista.get(0).getFurnas()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getHerval()*correcao)+telaRural.lista.get(0).getHerval()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getItopava()*correcao)+telaRural.lista.get(0).getItopava()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getQuadro_seda()*correcao)+telaRural.lista.get(0).getQuadro_seda()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getLajeado()*correcao)+telaRural.lista.get(0).getLajeado()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getMatao()*correcao)+telaRural.lista.get(0).getMatao()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getMorro_chato()*correcao)+telaRural.lista.get(0).getMorro_chato()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getMorro_vermelho()*correcao)+telaRural.lista.get(0).getMorro_vermelho()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getMorro_azul()*correcao)+telaRural.lista.get(0).getMorro_azul()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getPedra_branca()*correcao)+telaRural.lista.get(0).getPedra_branca()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getPonte_alta()*correcao)+telaRural.lista.get(0).getPonte_alta()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getSta_barbara()*correcao)+telaRural.lista.get(0).getSta_barbara()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getSanta_cruz()*correcao)+telaRural.lista.get(0).getSanta_cruz()).replace(",",".")),
                                                Double.parseDouble(df.format((telaRural.lista.get(0).getDemais_bairros()*correcao)+telaRural.lista.get(0).getDemais_bairros()).replace(",","."))
                                                );
                                        cl.cadastrar(tela.lista.get(0).getExercicio()+1, 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getA_residencial()*correcao)+tela.listaColeta.get(0).getA_residencial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getA_comercial()*correcao)+tela.listaColeta.get(0).getA_comercial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getB_residencial()*correcao)+tela.listaColeta.get(0).getB_residencial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getB_comercial()*correcao)+tela.listaColeta.get(0).getB_comercial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getC_residencial()*correcao)+tela.listaColeta.get(0).getC_residencial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getC_comercial()*correcao)+tela.listaColeta.get(0).getC_comercial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getD_residencial()*correcao)+tela.listaColeta.get(0).getD_residencial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getD_comercial()*correcao)+tela.listaColeta.get(0).getD_comercial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getE_residencial()*correcao)+tela.listaColeta.get(0).getE_residencial()).replace(",",".")), 
                                                     Double.parseDouble(df.format((tela.listaColeta.get(0).getE_comercial()*correcao)+tela.listaColeta.get(0).getE_comercial()).replace(",",".")));

                                        s.cadastrar(tela.lista.get(0).getExercicio()+1,ufesp);
                                try {
                                    exBd.salvar(ex);
                                    ruralExeBd.salvar(ruralExe);
                                    clBD.salvar(cl);
                                    sBD.salvar(s);
                                    JOptionPane.showMessageDialog(null, "Nova planta gernérica gerada com sucesso!!!");
                                    tela.buscaExercicios();
                                    tela.frmPlanta.setVisible(false);
                                    tela.frmPlanta = null;
                                    tela.setEnabled(true);
                       this.dispose();
                                } catch (SQLException ex1) {
                                    Logger.getLogger(frmPlantaGenerica.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                            }
                            }
        }else{
              JOptionPane.showMessageDialog(null, "Preencha os campos: Correção e UFESP!!!");  
        }
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
        jLabel1 = new javax.swing.JLabel();
        txtExercicio = new javax.swing.JTextField();
        btnGerar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtCorrecao = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtUfesp = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERAR NOVA PLANTA GENÉRICA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				tela.setEnabled(true);
				tela.setVisible(true);
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Exercicio de referencia:");

        txtExercicio.setEditable(false);
        txtExercicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtExercicio.setText("      ");
        txtExercicio.setFocusable(false);
        txtExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExercicioActionPerformed(evt);
            }
        });

        btnGerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGerar.setText("Gerar ");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Porcentagem do  reajuste:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("%");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("<--Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCorrecao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCorrecao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorrecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorrecaoActionPerformed(evt);
            }
        });
        txtCorrecao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorrecaoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Valor da UFESP: R$");

        txtUfesp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtUfesp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUfesp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUfespKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGerar, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtExercicio))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUfesp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUfesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnGerar))
                .addContainerGap(188, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExercicioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       tela.setEnabled(true);
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
       gerarPalntaGenerica();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void txtCorrecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorrecaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorrecaoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void txtCorrecaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrecaoKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            txtUfesp.requestFocus();
        }
    }//GEN-LAST:event_txtCorrecaoKeyPressed

    private void txtUfespKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUfespKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnGerar.requestFocus();
        }
    }//GEN-LAST:event_txtUfespKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JFormattedTextField txtCorrecao;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JFormattedTextField txtUfesp;
    // End of variables declaration//GEN-END:variables
}

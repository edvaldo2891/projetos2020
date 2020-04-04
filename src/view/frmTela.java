package view;


import view.frmVenal;
import java.awt.AWTKeyStroke;
import model.Calculo;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticTheme;
import com.jgoodies.looks.plastic.theme.AbstractSkyTheme;
import com.jgoodies.looks.plastic.theme.BrownSugar;
import com.jgoodies.looks.plastic.theme.DarkStar;
import com.jgoodies.looks.plastic.theme.DesertBluer;
import com.jgoodies.looks.plastic.theme.DesertGreen;
import com.jgoodies.looks.plastic.theme.DesertYellow;
import com.jgoodies.looks.plastic.theme.ExperienceGreen;
import com.jgoodies.looks.plastic.theme.ExperienceRoyale;
import com.jgoodies.looks.plastic.theme.LightGray;
import com.jgoodies.looks.plastic.theme.Silver;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import com.jgoodies.looks.plastic.theme.SkyGreen;
import com.jgoodies.looks.plastic.theme.SkyKrupp;
import com.jgoodies.looks.plastic.theme.SkyPink;
import com.jgoodies.looks.plastic.theme.SkyRed;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import controller.ColetaLixoBD;
import controller.ExercicioBD;
import controller.SinistroBD;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import model.ColetaLixo;
import model.Exercicio;
import model.PlantaString;
import model.Sinistro;
import model.Usuario;


/**
 *
 * @author EDVALDO ANTUNES
 */
public final class frmTela extends javax.swing.JFrame {
    List<Exercicio> listaTabela = new ArrayList<>();
    List<Exercicio> lista;
    List<ColetaLixo> listaColeta;
    List<Sinistro> listaSinistro;
    List<Exercicio> listaVerifica;
    Calculo calculo = new Calculo();
    private double correcao=0.1067;//Parâmetro a ser corrigido conforme o IPCA
    private double construcao=0;
    private double terreno=0;
    private int cont=0;
    private double venalContrucao=0;
    private double venalTerreno=0;
    private double venalTotal=0;
    private int exercicio;
    private double construcaoCert;
    private double terrenoCert;
    private String bairro;
    private String logradouro;
    private String exerc;
    private String inscricao;
    private String numero;
    private String proprietario;
   
    Usuario us = null;
    frmLancamento lanc = null;

    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getExerc() {
        return exerc;
    }

    public void setExerc(String exerc) {
        this.exerc = exerc;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    public double getConstrucaoCert() {
        return construcaoCert;
    }

    public void setConstrucaoCert(double construcaoCert) {
        this.construcaoCert = construcaoCert;
    }

    public double getTerrenoCert() {
        return terrenoCert;
    }

    public void setTerrenoCert(double terrenoCert) {
        this.terrenoCert = terrenoCert;
    }

    
    
    public double getConstrucao() {
        return construcao;
    }

    public void setConstrucao(double construcao) {
        this.construcao = construcao;
    }

    public double getTerreno() {
        return terreno;
    }

    public void setTerreno(double terreno) {
        this.terreno = terreno;
    }

    
    public double getVenalContrucao() {
        return venalContrucao;
    }

    public void setVenalContrucao(double venalContrucao) {
        this.venalContrucao = venalContrucao;
    }

    public double getVenalTerreno() {
        return venalTerreno;
    }

    public void setVenalTerreno(double venalTerreno) {
        this.venalTerreno = venalTerreno;
    }

    public double getVenalTotal() {
        return venalTotal;
    }

    public void setVenalTotal(double venalTotal) {
        this.venalTotal = venalTotal;
    }

    
    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }
    /**
     * Creates new form frmTela
     */
    private ImageIcon icone;
    public frmTela(Usuario u,frmLancamento l,Integer verificador) throws Exception {
        //tema();
        us = u;
        lanc = l;
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setResizable(true);
        LookAndFeels(u.getLayout());
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        limpar();
        limparbaseDados();
        buscaExercicios();
        teclaEnter();
        lblUsuario.setText("Usuário: "+u.getNome());
        travarAcesso(); 
        if(verificador!=0){
           recebeDadosLanc();
        }
    }
    
     public void verificaCombo(){
            if(lanc.lancTemp.getPadrao().equals("ALVENARIA")){
                 cbxPadrao.setSelectedIndex(1);     
            }else if(lanc.lancTemp.getPadrao().equals("MISTA")){
              cbxPadrao.setSelectedIndex(2);
            }else if(lanc.lancTemp.getPadrao().equals("MADEIRA")){
              cbxPadrao.setSelectedIndex(3);
            }else{
               cbxPadrao.setSelectedIndex(0);
            }
            
            if(lanc.lancTemp.getTipo().equals("LUXO")){
              cbxTipo.setSelectedIndex(1);
            }else if(lanc.lancTemp.getTipo().equals("PRIMEIRA")){
               cbxTipo.setSelectedIndex(2);     
            }else if(lanc.lancTemp.getTipo().equals("SEGUNDA")){
              cbxTipo.setSelectedIndex(3);
            }else if(lanc.lancTemp.getTipo().equals("TERCEIRA")){
              cbxTipo.setSelectedIndex(4);
            }else{
              cbxTipo.setSelectedIndex(0);
            }
            
            if(lanc.lancTemp.getSetor()!=0){
              cbxSetor.setSelectedIndex(lanc.lancTemp.getSetor());
            }else{
               cbxSetor.setSelectedIndex(0);     
            }    
     }
    
    public void recebeDadosLanc(){
        lblInscricao.setText("Incrição:  "+lanc.lancTemp.getInscricao());
        lblBairro.setText("Bairro:  "+lanc.lancTemp.getBairro()+"     Lote:  "+lanc.lancTemp.getLote()+"    Quadra:  "+lanc.lancTemp.getQuadra());
        lblLogradouro.setText("Logradouro:  "+lanc.lancTemp.getLogradouro()+"    Nº:  "+lanc.lancTemp.getNumero());
        lblProprietario.setText("Proprietário:  "+lanc.lancTemp.getProprietario());
        txtTerreno.setText(String.valueOf(lanc.lancTemp.getTerreno()).replace(".",","));
        txtConstrucao.setText(String.valueOf(lanc.lancTemp.getConstrucao()).replace(".",","));
        setInscricao(lanc.lancTemp.getInscricao());
        setBairro(lanc.lancTemp.getBairro());
        setNumero(lanc.lancTemp.getNumero());
        setLogradouro(lanc.lancTemp.getLogradouro());
        setProprietario(lanc.lancTemp.getProprietario());
        setTerreno(lanc.lancTemp.getTerreno());
        if(lanc.lancTemp.getConstrucao()==0){
            setConstrucao(0.0);
        }else{
            setConstrucao(lanc.lancTemp.getConstrucao());
        }
        verificaCombo();
       
    }
    
    public void travarAcesso(){
        if(us.getPermissao()!=1){
            btnCalcular.setEnabled(false);
            btnLimpar.setEnabled(false);
            txtConstrucao.setEnabled(false);
            txtTerreno.setEnabled(false);
            jMenuCertidao.setEnabled(false);
            jMenuManutencao.setEnabled(false);
            jMenuVenalRural.setEnabled(false);
            cbxCategoria.setEnabled(false);
            cbxExercicios.setEnabled(false);
            cbxPadrao.setEnabled(false);
            cbxSetor.setEnabled(false);
            cbxTipo.setEnabled(false);  
        }
    }
    
    public void teclaEnter(){
        KeyStroke keyEscape = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);   
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEscape, "enter");  
        getRootPane().getActionMap().put("enter", new AbstractAction() {  
  
            @Override  
            public void actionPerformed(ActionEvent ae) {  
                try{
                    UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
                    calcular();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas ao calcular");
               }
            }  
        });       
    }
    
     public void LookAndFeels(int opcao) throws Exception{//Função para alterar tema
          
        try{
            switch(opcao){
                case 0:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/beigeazulthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 1:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 2:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyBluer());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;   
                case 3:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyGreen());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 4:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyKrupp());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;  
                case 5:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyPink());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;   
                case 6:
                     Plastic3DLookAndFeel.setPlasticTheme(new SkyRed());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break; 
                case 7:
                     Plastic3DLookAndFeel.setPlasticTheme(new ExperienceGreen());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 8:
                     Plastic3DLookAndFeel.setPlasticTheme(new ExperienceRoyale());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 9:
                     Plastic3DLookAndFeel.setPlasticTheme(new DesertGreen());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 10:
                     Plastic3DLookAndFeel.setPlasticTheme(new DesertBluer());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 11:
                     Plastic3DLookAndFeel.setPlasticTheme(new DesertYellow());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 12:
                     Plastic3DLookAndFeel.setPlasticTheme(new LightGray());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 13:
                     Plastic3DLookAndFeel.setPlasticTheme(new Silver());
                     UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                break;
                case 14:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/amarachthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 15:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/aquathemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 16:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/architectBluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 17:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/architectOlivethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 18:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/b0sumiErgothempack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 19:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/b0sumithemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 20:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/bbjthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 21:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/beigeazulthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 22:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/beosthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 23:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/blueMetalthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 24:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/BlueResh_ravenThemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 25:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/blueTurquesathemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 26:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/cellshadedthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 27:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/chaNinja-Bluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 28:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/coronaHthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 29:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/cougarthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 30:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/crystal2themepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 31:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/fatalEthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 32:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/gfxOasisthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 33:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/gorillathemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 34:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/hmmXPBluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 35:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/hmmXPMonoBluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 36:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/iBarthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 37:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/macosthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 38:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/midnightthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 39:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/mmMagra-Xthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 40:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/modernthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 41:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/oliveGreenLunaXPthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 42:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/opusLunaSilverthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 43:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/opusOSBluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 44:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/opusOSDeepthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 45:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/opusOSOlivethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 46:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/resh_raventhemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 47:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/xplunathemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 48:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/roueBluethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 49:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/roueBrownthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 50:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/roueGreenthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 51:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/royalInspiratthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 52:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/silverLunaXPthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 53:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/solunaRthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 54:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/tigerGraphitethemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 55:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/tigerthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 56:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/toxicthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 57:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/underlingthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                case 58:
                     JFrame.setDefaultLookAndFeelDecorated(true);
                     SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/whistlerthemepack.zip"));
                     UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                break;
                
            }   
            SwingUtilities.updateComponentTreeUI(this);
        }catch(UnsupportedLookAndFeelException ex){
            ex.printStackTrace();
        }
    }
 
     public void tema() throws Exception{
        SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:\\prjVenalUrbano\\temas\\xplunathemepack.zip"));
        UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
        this.setDefaultLookAndFeelDecorated(true);
    }
     
    public void limpaTabela(){
            int aux;
            DefaultTableModel dtm= (DefaultTableModel)tbIptu.getModel();
            for(aux=cont; aux!=0; aux--){
                 dtm.removeRow(0);  
            }
            cont=0;
    }
    public void limpar(){
        limpaTabela();
        txtConstrucao.setText("0");
        txtTerreno.setText("0");
        cbxPadrao.setSelectedIndex(0);
        cbxSetor.setSelectedIndex(0);
        cbxTipo.setSelectedIndex(0);
        cbxCategoria.setSelectedIndex(0); 
        lblBairro.setText("");
        lblInscricao.setText("");
        lblLogradouro.setText("");
        lblProprietario.setText("");
        lblValorConstrucao.setText("");
        lblValorTerreno.setText("");
    }
    public void limparbaseDados(){
        calculo.setColLixo(0.00);
        calculo.setIpu(0.00);
        calculo.setItu(0.00);
        calculo.setIptu(0.00);
        lblVenal.setText(" ");
        lblValorConstrucao.setText(" ");
        lblValorTerreno.setText(" ");
        venalContrucao=0;
        venalTerreno=0;
        venalTotal=0;
    }
    public void limpaColetaLixo(){
        calculo.setColLixo(0.00);
        calculo.setIpu(0.00);
        calculo.setItu(0.00);
        calculo.setIptu(0.00);
    }
    
    public void cadastrar(){
            calculo.cadastrar(Double.valueOf(txtTerreno.getText().replace(',','.')), Double.valueOf(txtConstrucao.getText().replace(',','.')), Integer.valueOf(cbxPadrao.getSelectedIndex()),  
                    Integer.valueOf(cbxTipo.getSelectedIndex()-1),  Integer.valueOf(cbxSetor.getSelectedIndex()),0.00/*calcularSinistro()*/);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void calcularValorVenal(){
        construcao = Double.parseDouble(txtConstrucao.getText().replace(',','.'));
        terreno = Double.parseDouble(txtTerreno.getText().replace(',','.'));
        
            
            if(calculo.getPadrao()==1 && calculo.getTipo()==0 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_1_0();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==1 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_1_1();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==2 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_1_2();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==3 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_1_3();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==0 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_2_0();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==1 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_2_1();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==2 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_2_2();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==3 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_2_3();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==0 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_3_0();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==1 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_3_1();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==2 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_3_2();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==3 && calculo.getSetor()==1 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getA_3_3();
                venalTerreno= terreno*lista.get(0).getA_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            else if(calculo.getPadrao()==0 && calculo.getTipo()==-1 && calculo.getSetor()==1 && construcao<=0){
                venalTerreno=terreno*lista.get(0).getA_terreno();
                venalTotal=venalTerreno;
            }
//----------------------------------------------------------------------------------------------------------------
             if(calculo.getPadrao()==1 && calculo.getTipo()==0 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_1_0();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==1 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_1_1();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==2 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_1_2();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==3 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_1_3();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==0 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_2_0();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==1 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_2_1();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==2 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_2_2();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==3 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_2_3();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==0 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_3_0();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==1 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_3_1();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==2 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_3_2();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==3 && calculo.getSetor()==2 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getB_3_3();
                venalTerreno= terreno*lista.get(0).getB_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             else if(calculo.getPadrao()==0 && calculo.getTipo()==-1 && calculo.getSetor()==2 && construcao<=0){
                 venalTerreno=terreno*lista.get(0).getB_terreno();
                 venalTotal=venalTerreno;
            }
//------------------------------------------------------------------------------------------------------------------------
            if(calculo.getPadrao()==1 && calculo.getTipo()==0 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_1_0();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==1 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_1_1();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==2 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_1_2();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==3 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_1_3();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==0 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_2_0();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==1 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_2_1();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==2 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_2_2();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==3 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_2_3();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==0 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_3_0();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==1 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_3_1();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==2 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_3_2();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==3 && calculo.getSetor()==3 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getC_3_3();
                venalTerreno= terreno*lista.get(0).getC_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             else if(calculo.getPadrao()==0 && calculo.getTipo()==-1 && calculo.getSetor()==3 && construcao<=0){
                 venalTerreno=terreno*lista.get(0).getC_terreno();
                 venalTotal=venalTerreno;
            }
//----------------------------------------------------------------------------------------------------------------
             if(calculo.getPadrao()==1 && calculo.getTipo()==0 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_1_0();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==1 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_1_1();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==2 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_1_2();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==1 && calculo.getTipo()==3 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_1_3();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==0 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_2_0();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==1 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_2_1();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==2 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_2_2();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==3 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_2_3();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==0 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_3_0();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==1 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_3_1();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==2 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_3_2();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==3 && calculo.getSetor()==4 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getD_3_3();
                venalTerreno= terreno*lista.get(0).getD_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            else if(calculo.getPadrao()==0 && calculo.getTipo()==-1 && calculo.getSetor()==4 && construcao<=0){
                venalTerreno=terreno*12.23; 
                venalTotal=venalTerreno;
            }
//------------------------------------------------------------------------------------------------------------------------
             if(calculo.getPadrao()==1 && calculo.getTipo()==0 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_1_0();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==1 && calculo.getTipo()==1 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_1_1();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==1 && calculo.getTipo()==2 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_1_2();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==1 && calculo.getTipo()==3 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_1_3();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==0 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_2_0();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==2 && calculo.getTipo()==1 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_2_1();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==2 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_2_2();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==2 && calculo.getTipo()==3 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_2_3();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
             if(calculo.getPadrao()==3 && calculo.getTipo()==0 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_3_0();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==1 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_3_1();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==2 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_3_2();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            if(calculo.getPadrao()==3 && calculo.getTipo()==3 && calculo.getSetor()==5 && construcao!= 0){
                venalContrucao= construcao*lista.get(0).getE_3_3();
                venalTerreno= terreno*lista.get(0).getE_terreno();
                venalTotal= venalContrucao + venalTerreno;
            }
            else if(calculo.getPadrao()==0 && calculo.getTipo()==-1 && calculo.getSetor()==5 && construcao<=0){
                 venalTerreno=terreno*lista.get(0).getE_terreno();
                 venalTotal=venalTerreno;
            }
            lblValorTerreno.setText(NumberFormat.getCurrencyInstance().format(venalTerreno=venalTerreno));
            lblValorConstrucao.setText(NumberFormat.getCurrencyInstance().format(venalContrucao=venalContrucao));
            lblVenal.setText(NumberFormat.getCurrencyInstance().format(venalTotal=venalTotal));
    }
    public void cadastrarIptu(){
           if(construcao==0){
                calculo.setItu(venalTotal*0.025);
            }else{
                calculo.setIpu(venalContrucao*0.005);
                calculo.setItu(venalTerreno*0.005);
                if(cbxCategoria.getSelectedIndex()==1 && cbxSetor.getSelectedIndex()==1){
                    calculo.setColLixo(listaColeta.get(0).getA_residencial());
                }
                if(cbxCategoria.getSelectedIndex()==2 && cbxSetor.getSelectedIndex()==1){
                    calculo.setColLixo(listaColeta.get(0).getA_comercial());
                }
                if(cbxCategoria.getSelectedIndex()==1 && cbxSetor.getSelectedIndex()==2){
                    calculo.setColLixo(listaColeta.get(0).getB_residencial());
                }
                if(cbxCategoria.getSelectedIndex()==2 && cbxSetor.getSelectedIndex()==2){
                    calculo.setColLixo(listaColeta.get(0).getB_comercial());
                }
                if(cbxCategoria.getSelectedIndex()==1 && cbxSetor.getSelectedIndex()==3){
                    calculo.setColLixo(listaColeta.get(0).getC_residencial());
                }
                if(cbxCategoria.getSelectedIndex()==2 && cbxSetor.getSelectedIndex()==3){
                    calculo.setColLixo(listaColeta.get(0).getC_comercial());
                }
                if(cbxCategoria.getSelectedIndex()==1 && cbxSetor.getSelectedIndex()==4){
                    calculo.setColLixo(listaColeta.get(0).getD_residencial());
                }
                if(cbxCategoria.getSelectedIndex()==2 && cbxSetor.getSelectedIndex()==4){
                    calculo.setColLixo(listaColeta.get(0).getD_comercial());
                }
                if(cbxCategoria.getSelectedIndex()==1 && cbxSetor.getSelectedIndex()==5){
                    calculo.setColLixo(listaColeta.get(0).getE_residencial());
                }
                if(cbxCategoria.getSelectedIndex()==2 && cbxSetor.getSelectedIndex()==5){
                    calculo.setColLixo(listaColeta.get(0).getE_comercial());
                }
            }       
                DefaultTableModel dtm= (DefaultTableModel)tbIptu.getModel();
                dtm.addRow(calculo.addTable());       
    }
    
    public double calcularSinistro(){
        
        double construcao = Double.parseDouble(txtConstrucao.getText().replace(",","."));
        double sinistro = 0;
        if(construcao==0 || lista.get(0).getExercicio()<2015){
            sinistro=0.00;
        }else{
            if(construcao<=300.00){//Risco baixo:Residencial e serviço de hospedagem
                sinistro= listaSinistro.get(0).getUfesp()*construcao*0.010;            
            }
            if(construcao>300.00 && construcao<=1200.00){//Risco medio: Comercial,Serviço profissional, Educacional e cultura fisica, Local de Reunião de Publico, Serviço de Saúde e Institucional
                sinistro= listaSinistro.get(0).getUfesp()*construcao*0.015;
            }
            if(construcao>1200.00){//Risco alto: Indudtria, Deposito, Esplosivos
                sinistro= listaSinistro.get(0).getUfesp()*construcao*0.020;
            }
        }
  
        return sinistro;
    }
    
     public void buscaExercicios() {
        try {
            //cbxExercicios = new JComboBox<>();
            List<Exercicio> list = new ExercicioBD().listaExercicios();
            listaVerifica=list;
            //DefaultComboBoxModel dcbm = (DefaultComboBoxModel) cbxExercicios.getModel();//OUtra forma de carregar "cbxExercicios" 
            //dcbm.removeAllElements();
            for(Exercicio x:list){
                 //dcbm.addElement(x.getExercicio());
                 cbxExercicios.addItem(x.getExercicio());//retorno do combo do tipo Object    
            }
        } catch (SQLException exc) {
        }
    }
     
     public void buscaTabela() {
        if((Integer) cbxExercicios.getSelectedItem()==null){
           
        }else{
            try {
                lista = new ExercicioBD().listaTabela((Integer) cbxExercicios.getSelectedItem());
                exercicio = lista.get(0).getExercicio();
            } catch (SQLException ex) {
            }
        }
    }
     
     public void buscaColetalixo() {
        if((Integer) cbxExercicios.getSelectedItem()==null){
           
        }else{
            try {
                listaColeta = new ColetaLixoBD().listaColetaLixo((Integer) cbxExercicios.getSelectedItem());
            } catch (SQLException ex) {
            }
        }
    }
     
     public void buscaSinistro() {
        if((Integer) cbxExercicios.getSelectedItem()==null){
           
        }else{
            try {
                listaSinistro = new SinistroBD().listaSinistro((Integer) cbxExercicios.getSelectedItem());
            } catch (SQLException ex) {
            }
        }
    }
     
    public void calcular(){
        setConstrucaoCert(Double.parseDouble(txtConstrucao.getText().replace(",",".")));
        setTerrenoCert(Double.parseDouble(txtTerreno.getText().replace(",",".")));
         if(cbxPadrao.getSelectedIndex()>0 && cbxSetor.getSelectedIndex()>0 && cbxTipo.getSelectedIndex()>0 && (txtConstrucao.getText().equals(""))){
            txtConstrucao.setText("0");
        }else{
            if(cont>0){
                limparbaseDados();
                limpaTabela();
                cadastrar();
                calcularValorVenal();
                cadastrarIptu();
                cont++;
            }else{
                limpaTabela();
                cadastrar();
                calcularValorVenal();
                cadastrarIptu();
                cont++;
            }
        }
    }
     
     public void abrePlantaGenerica() throws Exception{
        if(frmPlanta == null){
            frmPlanta = new frmPlantaGenerica(this);
            frmPlanta.setVisible(true);
        }
    }
    public static void ajustaAviso(JInternalFrame fr){    
          Dimension d = fr.getDesktopPane().getSize();    
          fr.setLocation(465,0);       
    } 
    
    public void imprimePlantaGenerica() throws SQLException, JRException{
        List<PlantaString> lp= new ArrayList<PlantaString>();
        ExercicioBD eBD = new ExercicioBD();
        List<Object> listaString= new ArrayList<>();
        PlantaString pString = new PlantaString();
        List<Exercicio> listEx= new ExercicioBD().listaTabela(lista.get(0).getExercicio());   
        lp = eBD.imprimePlantaGenerica(lista.get(0).getExercicio());  
        
       if(lp.size()==0){
            JOptionPane.showMessageDialog(null,"É necessario atualizar a planta genérica da Zona Rural!!");
        }else{
                    pString.converterString(lp.get(0).getExercicio(),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_1_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_1_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_1_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_1_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_2_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_2_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_2_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_2_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_3_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_3_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_3_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_3_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getA_terreno())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_1_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_1_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_1_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_1_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_2_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_2_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_2_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_2_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_3_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_3_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_3_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_3_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getB_terreno())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_1_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_1_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_1_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_1_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_2_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_2_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_2_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_2_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_3_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_3_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_3_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_3_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getC_terreno())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_1_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_1_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_1_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_1_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_2_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_2_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_2_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_2_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_3_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_3_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_3_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_3_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getD_terreno())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_1_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_1_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_1_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_1_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_2_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_2_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_2_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_2_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_3_0())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_3_1())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_3_2())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_3_3())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getE_terreno())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getAparecida_salto())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getBarreirinho())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getCacador())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getCerrado())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getFurnas())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getHerval())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getItopava())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getQuadro_seda())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getLajeado())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getMatao())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getMorro_chato())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getMorro_vermelho())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getMorro_azul())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getPedra_branca())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getPonte_alta())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getSta_barbara())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getSanta_cruz())),
                                                           NumberFormat.getCurrencyInstance().format(Double.parseDouble(lp.get(0).getDemais_bairros())),
                                                           "01/01/"+lp.get(0).getExercicio()+"."
                                                           );
                    listaString.add(pString);
                    //JasperReport report = JasperCompileManager .compileReport("C:\\prjVenalUrbano\\src\\urbano\\tabela.jrxml"); 
                    //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaString)); 
                    System.out.println("Relatório gerado.");
                    JasperPrint tabela= null;
                    HashMap map = new HashMap();
                    ///alterar endereco desta pagina 
                    String arquivoJasper = "C:\\prjVenalUrbano\\src\\urbano\\tabela.jasper";
                    tabela = JasperFillManager.fillReport(arquivoJasper, null,new JRBeanCollectionDataSource(listaString));
                    JasperViewer.viewReport(tabela, false);
  
                    
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
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
        Painel2 = new javax.swing.JPanel();
        cbxPadrao = new javax.swing.JComboBox();
        cbxTipo = new javax.swing.JComboBox();
        cbxSetor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTerreno = new javax.swing.JFormattedTextField();
        txtConstrucao = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbIptu = new javax.swing.JTable();
        Painel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblVenal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblValorTerreno = new javax.swing.JLabel();
        lblValorConstrucao = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        Painel1 = new javax.swing.JPanel();
        cbxExercicios = new javax.swing.JComboBox<Object>();
        jLabel10 = new javax.swing.JLabel();
        btnInscricao = new javax.swing.JButton();
        lblInscricao = new javax.swing.JLabel();
        lblProprietario = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuManutencao = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuVenalRural = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuCertidao = new javax.swing.JMenu();
        jMenuVenal = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuLançamento = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuEspelho = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuConfrontante = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuRural = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuInterdicao = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuForum = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuProtocolo = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VALOR VENAL URBANO");

        Painel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxPadrao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxPadrao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------", "ALVENARIA", "MISTA", "MADEIRA" }));
        cbxPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPadraoActionPerformed(evt);
            }
        });
        cbxPadrao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxPadraoKeyPressed(evt);
            }
        });

        cbxTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------------", "LUXO", "PRIMEIRA", "SEGUNDA", "TERCEIRA" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        cbxTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipoKeyPressed(evt);
            }
        });

        cbxSetor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------", "A", "B", "C", "D", "E" }));
        cbxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSetorActionPerformed(evt);
            }
        });
        cbxSetor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxSetorKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TERRENO m²:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CONSTRUÇÃO m²:");

        txtTerreno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtTerreno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTerreno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTerrenoFocusGained(evt);
            }
        });
        txtTerreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTerrenoActionPerformed(evt);
            }
        });
        txtTerreno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTerrenoKeyPressed(evt);
            }
        });

        txtConstrucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtConstrucao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtConstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConstrucaoActionPerformed(evt);
            }
        });
        txtConstrucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConstrucaoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PADRÃO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("TIPO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("SETOR");

        cbxCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------", "RESIDENCIAL", "COMERCIAL" }));
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });
        cbxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCategoriaKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CATEGORIA");

        javax.swing.GroupLayout Painel2Layout = new javax.swing.GroupLayout(Painel2);
        Painel2.setLayout(Painel2Layout);
        Painel2Layout.setHorizontalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createSequentialGroup()
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbxPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, 0)
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Painel2Layout.createSequentialGroup()
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConstrucao, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(txtTerreno))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Painel2Layout.setVerticalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7))
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tbIptu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbIptu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IMPOSTO TERRITORIAL", "IMPOSTO PREDIAL", "COL. LIXO", "SINISTRO", "I.P.T.U"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbIptu);

        Painel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VALOR VENAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL:           ");

        lblVenal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVenal.setText("                                                                            ");
        lblVenal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblVenal.setMaximumSize(new java.awt.Dimension(4, 4));
        lblVenal.setMinimumSize(new java.awt.Dimension(4, 4));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Terreno:      ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Construção:   ");

        lblValorTerreno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValorTerreno.setText("                                                                            ");
        lblValorTerreno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblValorTerreno.setMaximumSize(new java.awt.Dimension(309, 19));
        lblValorTerreno.setMinimumSize(new java.awt.Dimension(309, 19));

        lblValorConstrucao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValorConstrucao.setText("                            ");
        lblValorConstrucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblValorConstrucao.setPreferredSize(new java.awt.Dimension(308, 19));

        javax.swing.GroupLayout Painel3Layout = new javax.swing.GroupLayout(Painel3);
        Painel3.setLayout(Painel3Layout);
        Painel3Layout.setHorizontalGroup(
            Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblValorTerreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVenal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblValorConstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Painel3Layout.setVerticalGroup(
            Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblValorTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorConstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblVenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        Painel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxExercicios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxExercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxExerciciosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbxExerciciosMouseReleased(evt);
            }
        });
        cbxExercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxExerciciosActionPerformed(evt);
            }
        });
        cbxExercicios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxExerciciosKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Escolha o exercicio:");

        btnInscricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInscricao.setText("BUSCAR INSCRIÇÃO");
        btnInscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscricaoActionPerformed(evt);
            }
        });

        lblInscricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblProprietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblLogradouro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout Painel1Layout = new javax.swing.GroupLayout(Painel1);
        Painel1.setLayout(Painel1Layout);
        Painel1Layout.setHorizontalGroup(
            Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel1Layout.createSequentialGroup()
                        .addComponent(btnInscricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addComponent(lblInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addComponent(lblLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel1Layout.createSequentialGroup()
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        Painel1Layout.setVerticalGroup(
            Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnInscricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setText("jLabel11");
        lblUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuBar2.setAutoscrolls(true);
        jMenuBar2.setFocusTraversalPolicyProvider(true);

        jMenuManutencao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuManutencao.setText("    Manutenção");
        jMenuManutencao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem1.setText("Gerar Planta genérica");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuManutencao.add(jMenuItem1);
        jMenuManutencao.add(jSeparator1);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("Imprimir Planta Genérica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuManutencao.add(jMenuItem2);
        jMenuManutencao.add(jSeparator7);

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem4.setText("Cadastrar usuário");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuManutencao.add(jMenuItem4);
        jMenuManutencao.add(jSeparator8);

        jMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem7.setText("Alterar tema");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuManutencao.add(jMenuItem7);
        jMenuManutencao.add(jSeparator11);

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuManutencao.add(jMenuItem5);

        jMenuBar2.add(jMenuManutencao);

        jMenuVenalRural.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuVenalRural.setText("   Venal Rural");
        jMenuVenalRural.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuVenalRural.setPreferredSize(new java.awt.Dimension(103, 19));
        jMenuVenalRural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVenalRuralActionPerformed(evt);
            }
        });

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("Abrir Calculo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuVenalRural.add(jMenuItem3);

        jMenuBar2.add(jMenuVenalRural);

        jMenuCertidao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuCertidao.setText("     Certidão  ");
        jMenuCertidao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuCertidao.setPreferredSize(new java.awt.Dimension(103, 19));

        jMenuVenal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuVenal.setText("1- Valor Venal");
        jMenuVenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVenalActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuVenal);
        jMenuCertidao.add(jSeparator2);

        jMenuLançamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuLançamento.setText("2- Lançamento");
        jMenuLançamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLançamentoActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuLançamento);
        jMenuCertidao.add(jSeparator3);

        jMenuEspelho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuEspelho.setText("3- Espelho");
        jMenuEspelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEspelhoActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuEspelho);
        jMenuCertidao.add(jSeparator4);

        jMenuConfrontante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuConfrontante.setText("4- Confrontante");
        jMenuConfrontante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConfrontanteActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuConfrontante);
        jMenuCertidao.add(jSeparator5);

        jMenuRural.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuRural.setText("5- Rural");
        jMenuRural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRuralActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuRural);
        jMenuCertidao.add(jSeparator6);

        jMenuInterdicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuInterdicao.setText("6- Interdição");
        jMenuInterdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInterdicaoActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuInterdicao);
        jMenuCertidao.add(jSeparator9);

        jMenuForum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuForum.setText("7- Venal Fórum");
        jMenuForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuForumActionPerformed(evt);
            }
        });
        jMenuCertidao.add(jMenuForum);
        jMenuCertidao.add(jSeparator10);

        jMenuBar2.add(jMenuCertidao);

        jMenuProtocolo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuProtocolo.setText("   Protocolo");
        jMenuProtocolo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuProtocolo.setPreferredSize(new java.awt.Dimension(103, 19));
        jMenuProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProtocoloActionPerformed(evt);
            }
        });

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem6.setText("Gerar protocolo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuProtocolo.add(jMenuItem6);

        jMenuBar2.add(jMenuProtocolo);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Painel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(Painel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Painel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Painel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcular)
                    .addComponent(btnLimpar))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lblUsuario))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSetorActionPerformed
        calcular();
    }//GEN-LAST:event_cbxSetorActionPerformed

    private void txtTerrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTerrenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerrenoActionPerformed

    private void txtConstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConstrucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConstrucaoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcular();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();    
        limparbaseDados();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cbxExerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxExerciciosActionPerformed
            buscaTabela();
            buscaColetalixo();
            buscaSinistro();
            calcular();
    }//GEN-LAST:event_cbxExerciciosActionPerformed

    private void cbxExerciciosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxExerciciosMouseReleased
     
    }//GEN-LAST:event_cbxExerciciosMouseReleased

    private void cbxExerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxExerciciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxExerciciosMouseClicked

    private void cbxPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPadraoActionPerformed
         calcular();
    }//GEN-LAST:event_cbxPadraoActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        calcular();
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        calcular();
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            if(us.getPermissao()==1){
                    new frmPlantaGenerica(this).setVisible(true);
                    setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"Voce não tem permissão para esta operação!");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
            imprimePlantaGenerica();
            LookAndFeels(us.getLayout());
        } catch (SQLException ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuVenalRuralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVenalRuralActionPerformed
        
    }//GEN-LAST:event_jMenuVenalRuralActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            new view.rural.frmTela(this).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtTerrenoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTerrenoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtConstrucao.requestFocus();
        }
    }//GEN-LAST:event_txtTerrenoKeyPressed

    private void txtTerrenoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTerrenoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerrenoFocusGained

    private void jMenuVenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVenalActionPerformed
        try {
            new view.frmVenal(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuVenalActionPerformed

    private void jMenuLançamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLançamentoActionPerformed
         try {
            new view.frmCadastro(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuLançamentoActionPerformed

    private void jMenuEspelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEspelhoActionPerformed
         try {
            new view.frmEspelho(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuEspelhoActionPerformed

    private void jMenuConfrontanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConfrontanteActionPerformed
          try {
            new view.frmConfrontante(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuConfrontanteActionPerformed

    private void jMenuRuralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRuralActionPerformed
        try {
            new view.rural.frmRural(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuRuralActionPerformed

    private void jMenuInterdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInterdicaoActionPerformed
        try {
            new view.frmInterdicao(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuInterdicaoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         try {
            if(us.getPermissao()==1){
                    new frmControleUsuario(this).setVisible(true);
                    setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"Voce não tem permissão para esta operação!");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuForumActionPerformed
        try {
            new view.frmForum(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuForumActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       try {
            new view.frmProtocolo(this,us).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProtocoloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuProtocoloActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         try {
            if(us.getPermissao()==1){
                    new frmTema(this).setVisible(true);
                    setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"Voce não tem permissão para esta operação!");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void cbxPadraoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxPadraoKeyPressed
         if(evt.getKeyCode() == evt.VK_ENTER){
            
            cbxTipo.requestFocus();
        }
    }//GEN-LAST:event_cbxPadraoKeyPressed

    private void cbxTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoKeyPressed
         if(evt.getKeyCode() == evt.VK_ENTER){
            
            cbxSetor.requestFocus();
        }
    }//GEN-LAST:event_cbxTipoKeyPressed

    private void cbxSetorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSetorKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            cbxCategoria.requestFocus();
        }
    }//GEN-LAST:event_cbxSetorKeyPressed

    private void cbxCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtTerreno.requestFocus();
        }
    }//GEN-LAST:event_cbxCategoriaKeyPressed

    private void txtConstrucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConstrucaoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            btnCalcular.requestFocus();
        }
    }//GEN-LAST:event_txtConstrucaoKeyPressed

    private void cbxExerciciosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxExerciciosKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            cbxPadrao.requestFocus();
        }
    }//GEN-LAST:event_cbxExerciciosKeyPressed

    private void btnInscricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscricaoActionPerformed
        try {
            new frmLancamento(us,this).setVisible(true);
            setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(frmTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInscricaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel1;
    private javax.swing.JPanel Painel2;
    private javax.swing.JPanel Painel3;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnInscricao;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cbxCategoria;
    private javax.swing.JComboBox<Object> cbxExercicios;
    private javax.swing.JComboBox cbxPadrao;
    private javax.swing.JComboBox cbxSetor;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCertidao;
    private javax.swing.JMenuItem jMenuConfrontante;
    private javax.swing.JMenuItem jMenuEspelho;
    private javax.swing.JMenuItem jMenuForum;
    private javax.swing.JMenuItem jMenuInterdicao;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuLançamento;
    private javax.swing.JMenu jMenuManutencao;
    private javax.swing.JMenu jMenuProtocolo;
    private javax.swing.JMenuItem jMenuRural;
    private javax.swing.JMenuItem jMenuVenal;
    private javax.swing.JMenu jMenuVenalRural;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblInscricao;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValorConstrucao;
    private javax.swing.JLabel lblValorTerreno;
    private javax.swing.JLabel lblVenal;
    private javax.swing.JTable tbIptu;
    private javax.swing.JFormattedTextField txtConstrucao;
    private javax.swing.JFormattedTextField txtTerreno;
    // End of variables declaration//GEN-END:variables

    frmPlantaGenerica frmPlanta;
    private void listaTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

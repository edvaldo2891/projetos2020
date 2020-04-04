package view.rural;


import controller.rural.ExercicioBD;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.rural.Exercicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmTela extends javax.swing.JFrame { 
    private int cont=0;
    private double medida=0;
    List<Exercicio> listaTabela = new ArrayList<>();
    public List<Exercicio> lista;
    List<Exercicio> listaVerifica;
    view.frmTela tu;
        /**
     * Creates new form frmTela
     */
    private ImageIcon icone;
    public frmTela(view.frmTela telaUrbano) {
        tu = telaUrbano;
        icone = new ImageIcon("C:\\prjVenalUrbano\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        limpar();
        buscaExercicios();
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
                    calcular();
               }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas ao calcular");
               }
                    }  
           });       
    }
    
public void limpar(){
    txtMedida.setText("0");
    cbxBairro.setSelectedIndex(0);
    lblResultado.setText(null);
}
   
public String multiplicar(){
        return String.format("%.2f",2000.00*6000.00);
    }

public void calcular(){
    medida=Double.parseDouble(txtMedida.getText().replace(',','.'));
    if(rdbHectare.isSelected()){
        medida=(medida*10000.00)/24200.00;
    }
        int op = cbxBairro.getSelectedIndex();
        switch(op){
            case 1:
               lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getAparecida_salto()));
            break;
            case 2:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getBarreirinho()));
            break;
            case 3:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getCacador()));
            break;
            case 4:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getCerrado()));
            break;
            case 5:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getFurnas()));
            break;
            case 6:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getHerval()));
            break;
            case 7:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getItopava()));
            break;
            case 8:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getQuadro_seda()));
            break;
            case 9:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getLajeado()));
            break;
            case 10:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getMatao()));
            break;
            case 11:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getMorro_chato()));
            break;
            case 12:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getMorro_vermelho()));
            break;
            case 13:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getMorro_azul()));
            break;
            case 14:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getPedra_branca()));
            break;
            case 15:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getPonte_alta()));
            break;
            case 16:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getSta_barbara()));
            break;
            case 17:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getSanta_cruz()));
            break;
            case 18:
                lblResultado.setText( NumberFormat.getCurrencyInstance().format(medida*lista.get(0).getDemais_bairros()));
            break;
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
        lblHectare = new javax.swing.JLabel();
        lblAlqueire = new javax.swing.JLabel();
        rdbAlqueire = new javax.swing.JRadioButton();
        rdbHectare = new javax.swing.JRadioButton();
        lblBairro = new javax.swing.JLabel();
        cbxBairro = new javax.swing.JComboBox();
        lblMedida = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        txtMedida = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblHectare1 = new javax.swing.JLabel();
        cbxExercicios = new javax.swing.JComboBox<Object>();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CALCULAR VALOR VENAL RURAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				tu.setEnabled(true);
				tu.setVisible(true);
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHectare.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHectare.setText("Hectare");

        lblAlqueire.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAlqueire.setText("Alqueire");

        buttonGroup1.add(rdbAlqueire);
        rdbAlqueire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAlqueireActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbHectare);
        rdbHectare.setSelected(true);
        rdbHectare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHectareActionPerformed(evt);
            }
        });

        lblBairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBairro.setText("Bairro:");

        cbxBairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*ESCOLHA O BAIRRO*", "APARECIDA DO SALTO", "BARREIRINHO", "CAÇADOR", "CERRADO", "FURNAS", "HERVAL", "ITOPAVA", "QUADRO/SEDA", "LAJEADO", "MATAO", "MORRO CHATO", "MORRO VERMELHO", "MORRO AZUL", "PEDRA BRANCA", "PONTE ALTA", "STA BARBARA", "SANTA CRUZ", "DEMAIS BAIRROS" }));
        cbxBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBairroActionPerformed(evt);
            }
        });

        lblMedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMedida.setText("Medida:");

        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValor.setText("Valor Venal:");

        lblResultado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtMedida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000000"))));
        txtMedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHectare1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHectare1.setText("Escolher exercicio:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblHectare1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHectare1))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("<--Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMedida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHectare)
                        .addGap(2, 2, 2)
                        .addComponent(rdbHectare)
                        .addGap(18, 18, 18)
                        .addComponent(lblAlqueire)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbAlqueire)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMedida)
                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAlqueire)
                        .addComponent(rdbAlqueire)
                        .addComponent(rdbHectare)
                        .addComponent(lblHectare)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor)
                    .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnLimpar)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

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

    private void rdbHectareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHectareActionPerformed
        calcular();
    }//GEN-LAST:event_rdbHectareActionPerformed

    private void rdbAlqueireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAlqueireActionPerformed
       calcular();
    }//GEN-LAST:event_rdbAlqueireActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcular();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cbxExerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxExerciciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxExerciciosMouseClicked

    private void cbxExerciciosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxExerciciosMouseReleased

    }//GEN-LAST:event_cbxExerciciosMouseReleased

    private void cbxExerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxExerciciosActionPerformed
        buscaTabela();
        calcular();
    }//GEN-LAST:event_cbxExerciciosActionPerformed

    private void cbxBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBairroActionPerformed
        calcular();
    }//GEN-LAST:event_cbxBairroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tu.setEnabled(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    public void buscaExercicios() {
        try {
            List<Exercicio> lista = new ExercicioBD().listaExercicios();
            listaVerifica=lista;
            //DefaultComboBoxModel dcbm = (DefaultComboBoxModel) cbxExercicios.getModel();
            //dcbm.removeAllElements();
            for(Exercicio x:lista){
               //dcbm.addElement(String.valueOf(x.getExercicio()));
               cbxExercicios.addItem(x.getExercicio()); 
            }
        } catch (SQLException ex) {
        }
    }
    public void buscaTabela() {
        if((Integer) cbxExercicios.getSelectedItem()==null){
           
        }else{
            try {
                lista = new ExercicioBD().listaTabela((Integer) cbxExercicios.getSelectedItem());  
            } catch (SQLException ex) {
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxBairro;
    private javax.swing.JComboBox<Object> cbxExercicios;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAlqueire;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblHectare;
    private javax.swing.JLabel lblHectare1;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblValor;
    private javax.swing.JRadioButton rdbAlqueire;
    private javax.swing.JRadioButton rdbHectare;
    private javax.swing.JFormattedTextField txtMedida;
    // End of variables declaration//GEN-END:variables

}

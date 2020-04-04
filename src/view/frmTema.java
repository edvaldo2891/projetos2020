package view;


import controller.UsuarioBD;
import view.frmVenal;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

public final class frmTema extends javax.swing.JFrame {
    /**
     * Creates new form frmTema
     */
    frmTela tela;
    Usuario usAtual;   
    /**
     * Creates new form frmPlantaGenerica
     */
    private ImageIcon icone;
    int contImprimir = 0;
    
    public frmTema(frmTela t) {
        tela = t;
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());
        setLocationRelativeTo(null); 
        retornaTema();
    }
    
    public void retornaTema(){
        usAtual = new Usuario();
     try { 
           List<Usuario> usuario = new UsuarioBD().buscaUsuarios2(tela.us.getId());
           int i = 0;
           for(Usuario us:usuario){
               usAtual.setId(usuario.get(i).getId());
               usAtual.setConfirmaSenha(usuario.get(i).getConfirmaSenha());
               usAtual.setLayout(usuario.get(i).getLayout());
               usAtual.setLogin(usuario.get(i).getLogin());
               usAtual.setNome(usuario.get(i).getNome());
               usAtual.setPermissao(usuario.get(i).getPermissao());
               usAtual.setSenha(usuario.get(i).getSenha());
               i++;
               jLTemaAtual.setText(String.valueOf(ctxTemas.getItemAt(usAtual.getLayout())));
           }
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
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
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLTema = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ctxTemas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLTemaAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONFIGURAR TEMA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				 if(contImprimir==1){
					 try {
						 tela = new frmTela(usAtual, null, 0);
						 tela.setEnabled(true);
						 tela.setVisible(true);
					 } catch (Exception ex) {
						 Logger.getLogger(frmTema.class.getName()).log(Level.SEVERE, null, ex);
					 }
				 }else{
					tela.setEnabled(true);
					 tela.setVisible(true);
				 }
				 formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("<--Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLTema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTema.setText("Temas:");

        ctxTemas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctxTemas.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "Padrão",
            "1-SkyBlue",
            "2-SkyBluer",
            "3-SkyGreen",
            "4-SkyKrupp",
            "5-SkyPink",
            "6-SkyRed",
            "7-ExperienceGreen",
            "8-ExperienceRoyale",
            "9-DesertGreen",
            "10-DesertBluer",
            "11-DesertYellow",
            "12-LightGray",
            "13-Silver",
            "14-amarachthemepack",
            "15-aquathemepack",
            "16-architectBluethemepack",
            "17-architectOlivethemepack",
            "18-b0sumiErgothempack",
            "19-b0sumithemepack",
            "20-bbjthemepack",
            "21-beigeazulthemepack",
            "22-beosthemepack",
            "23-blueMetalthemepack",
            "24-BlueResh_ravenThemepack",
            "25-blueTurquesathemepack",
            "26-cellshadedthemepack",
            "27-chaNinja-Bluethemepack",
            "28-coronaHthemepack",
            "29-cougarthemepack",
            "30-crystal2themepack",
            "31-fatalEthemepack",
            "32-gfxOasisthemepack",
            "33-gorillathemepack",
            "34-hmmXPBluethemepack",
            "35-hmmXPMonoBluethemepack",
            "36-iBarthemepack",
            "37-macosthemepack",
            "38-midnightthemepack",
            "39-mmMagra-Xthemepack",
            "40-modernthemepack",
            "41-oliveGreenLunaXPthemepack",
            "42-opusLunaSilverthemepack",
            "43-opusOSBluethemepack",
            "44-opusOSDeepthemepack",
            "45-opusOSOlivethemepack",
            "46-resh_raventhemepack",
            "47-xplunathemepack",
            "48-roueBluethemepack",
            "49-roueBrownthemepack",
            "50-roueGreenthemepack",
            "51-royalInspiratthemepack",
            "52-silverLunaXPthemepack",
            "53-solunaRthemepack",
            "54-tigerGraphitethemepack",
            "55-tigerthemepack",
            "56-toxicthemepack",
            "57-underlingthemepack",
            "58-whistlerthemepack"
        }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tema atual:");

        jLTemaAtual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLTemaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLTema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ctxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTemaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTema)
                    .addComponent(ctxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ctxTemas.setSelectedItem(tela.us.getLayout());
        Usuario us = new Usuario();
        UsuarioBD uBD = new UsuarioBD();
        us.alterarTema(tela.us.getId(),ctxTemas.getSelectedIndex());
        try {
            uBD.alterarTema(us);
            JOptionPane.showMessageDialog(null,"Tema alterado com sucesso!!!");
            retornaTema();
            tela.setEnabled(true);
            this.dispose();
            tela.dispose();
            
            frmTela mainAntigo = new frmTela(usAtual,null,0);
            mainAntigo.LookAndFeels(usAtual.getLayout());
            mainAntigo.dispose();
            
            frmTela mainAtual = new frmTela(usAtual,null,0);
            mainAtual.LookAndFeels(usAtual.getLayout());
            mainAtual.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmTema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmTema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(contImprimir==1){
             try {
                 tela.setEnabled(true);
                 tela = new frmTela(usAtual, null, 0);
                 this.dispose();
             } catch (Exception ex) {
                 Logger.getLogger(frmVenal.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
           tela.setEnabled(true);
           this.dispose();
         }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox ctxTemas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLTema;
    private javax.swing.JLabel jLTemaAtual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
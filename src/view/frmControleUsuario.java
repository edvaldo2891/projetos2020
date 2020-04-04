/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioBD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmControleUsuario extends javax.swing.JFrame {
    frmTela main;
    int opSalvar = 0 ;
    Color corFundo,corBorda;
    private ImageIcon icone;
    
    public frmControleUsuario(frmTela m) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.BOLD, 12)));
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());    
        tbResultado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
        main = m;
        BuscaUsuarios();
        fechado();
        corTextFields();
        btnImprimir.setEnabled(false);
        setLocationRelativeTo(null); 
    }
    
    public String cripografar(String input, String tipoAlgoritmo) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance(tipoAlgoritmo);
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
    
 public void BuscaUsuarios() {
       try { 
           List<Usuario> usuario = new UsuarioBD().buscaUsuarios(txtPesq.getText());
           DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
           limpaTabela(dtm);
           int i = 0;
           for(Usuario us:usuario){
               dtm.addRow(usuario.get(i).addTable());
               i++;
           }
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    public void limpaTabela(DefaultTableModel dtm){
        dtm.setRowCount(0);        
    }
    
    public void corTextFields(){
        corFundo = new java.awt.Color(212, 208, 200);
        corBorda = new java.awt.Color(13, 153, 17);
        txtConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtConfirmaSenha.setForeground(Color.black); 
        txtConfirmaSenha.setBackground(corFundo);
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtLogin.setForeground(Color.black); 
        txtLogin.setBackground(corFundo);
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtNome.setForeground(Color.black); 
        txtNome.setBackground(corFundo);
        txtPesq.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq.setForeground(Color.black); 
        txtPesq.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtSenha.setForeground(Color.black); 
        txtSenha.setBackground(corFundo);           
    }
    
     public void corNovo(){
        corFundo = new java.awt.Color(255, 255, 255);
        corBorda = new java.awt.Color(13, 153, 17);
        txtConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtConfirmaSenha.setForeground(Color.black); 
        txtConfirmaSenha.setBackground(corFundo);
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtLogin.setForeground(Color.black); 
        txtLogin.setBackground(corFundo);
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtNome.setForeground(Color.black); 
        txtNome.setBackground(corFundo);
        txtPesq.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq.setForeground(Color.black); 
        txtPesq.setBackground(corFundo);
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtSenha.setForeground(Color.black); 
        txtSenha.setBackground(corFundo);           
    }
    
    private void fechado(){
        txtPesq.setEnabled(true);
        txtPesq.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setEnabled(false);
        btnDelete.setEnabled(false);
        txtConfirmaSenha.setEditable(false);
        txtLogin.setEditable(false);
        txtSenha.setEditable(false);
        txtNome.setEditable(false);
        btnSalvar2.setEnabled(false);
        btnSair2.setBackground(new java.awt.Color(204,211,200));
        btnLimpar.setBackground(new java.awt.Color(204,211,200));
        btnNovo.setBackground(new java.awt.Color(204,211,200));   
        rbAdm.setEnabled(false);
        rbEnf.setEnabled(false);
        rbMedico.setEnabled( false);
        rbRecepcao.setEnabled(false);
    }
    private int definePermissao(){
        if(rbAdm.isSelected()){
            return 1;
        }
        else if(rbMedico.isSelected()){
            return 2;
        }
        else if(rbEnf.isSelected()){
            return 3;
        }
        else if(rbRecepcao.isSelected()){
            return 4;
        }
        else{
            return 0;
        }       
    }
    
    private void retornaPermissao(int p){
        if(p==1){
            rbAdm.setSelected(true);
        }
        else if(p==2){
            rbMedico.setSelected(true);
        }
        else if(p==3){
            rbEnf.setSelected(true);
        }
        else if(p==4){
            rbRecepcao.setSelected(true);
        }
        else{
             rbAdm.setSelected(true);
             rbMedico.setSelected(true);
             rbEnf.setSelected(true);
             rbRecepcao.setSelected(true);
        }
    }
    
     private boolean verificaPermissao(){
        if(rbAdm.isSelected() || rbMedico.isSelected() || rbEnf.isSelected() || rbRecepcao.isSelected()){
            return true;
        }
        else{
            return false;
        }       
    }
    
    private void retornaDados(){
        txtNome.setText(" ");
        
        try {
            int indice = tbResultado.getSelectedRow();
            List<Usuario> usuario = new UsuarioBD().buscaUsuarios(txtPesq.getText());
            txtLogin.setText(usuario.get(tbResultado.getSelectedRow()).getLogin());
            txtSenha.setText(usuario.get(tbResultado.getSelectedRow()).getSenha());
            txtConfirmaSenha.setText(usuario.get(tbResultado.getSelectedRow()).getSenha());
            txtNome.setText(usuario.get(tbResultado.getSelectedRow()).getNome());
            retornaPermissao(usuario.get(tbResultado.getSelectedRow()).getPermissao());
            txtSenha.setText("");
            txtConfirmaSenha.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void AbrirBotao(){
        btnAlterar.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSalvar2.setEnabled(false);      
        btnAlterar.setBackground(new java.awt.Color(204,211,200));
        btnDelete.setBackground(new java.awt.Color(204,211,200));
        
       
    }
    private void alterar(){
        txtNome.setEditable(true);
        txtConfirmaSenha.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
        if(main.us.getId()==1){
            rbAdm.setEnabled(true);
            rbEnf.setEnabled(true);
            rbMedico.setEnabled( true);
            rbRecepcao.setEnabled(true);
        }
        
    }
    private void novoCadastro(){
        btnAlterar.setEnabled(false);
        btnDelete.setEnabled(false);     
        txtConfirmaSenha.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);        
        txtNome.setEditable(true);
        btnSalvar2.setEnabled(true);
        btnSalvar2.setBackground(new java.awt.Color(204,211,200));  
        if(main.us.getId()==1){
            rbAdm.setEnabled(true);
            rbEnf.setEnabled(true);
            rbMedico.setEnabled( true);
            rbRecepcao.setEnabled(true);
        }
        limpar();       
    }
    private void limpar(){                    
        txtConfirmaSenha.setText(null);
        txtLogin.setText(null);
        txtSenha.setText(null);     
        txtNome.setText(" ");   
        btgPermissao.clearSelection(); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgPermissao = new javax.swing.ButtonGroup();
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
        jPanel3 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnSair2 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSalvar2 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtConfirmaSenha = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesq = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbAdm = new javax.swing.JRadioButton();
        rbEnf = new javax.swing.JRadioButton();
        rbMedico = new javax.swing.JRadioButton();
        rbRecepcao = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR USUÁRIOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				main.setEnabled(true);
				main.setVisible(true);
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpar.setMnemonic('o');
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed1(evt);
            }
        });
        jPanel3.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 97, 30));

        btnSair2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair2.setMnemonic('o');
        btnSair2.setText("<-- Voltar");
        btnSair2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSair2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 98, 30));

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNovoKeyPressed(evt);
            }
        });
        jPanel3.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 97, 30));

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setMnemonic('o');
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 97, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 97, 30));

        btnSalvar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar2.setMnemonic('o');
        btnSalvar2.setText("Salvar");
        btnSalvar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar2ActionPerformed1(evt);
            }
        });
        jPanel3.add(btnSalvar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 97, 30));

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setMnemonic('o');
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel3.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 97, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 720, 50));

        tbResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbResultado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultado.getTableHeader().setReorderingAllowed(false);
        tbResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbResultadoMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultadoMouseClicked(evt);
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 460, 320));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Login ");

        txtLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Senha");

        txtSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Confirma senha");

        txtConfirmaSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtConfirmaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmaSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addContainerGap(141, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(31, 31, 31))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 140));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nome do usuário");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtNome.setText("                                                                                                   ");
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(76, 76, 76))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 70));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Procurar Usuário");

        txtPesq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqActionPerformed(evt);
            }
        });
        txtPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 265, Short.MAX_VALUE))
                    .addComponent(txtPesq))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 390, 70));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Definir pesrmissão do usuário");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        btgPermissao.add(rbAdm);
        rbAdm.setText("Administrador");
        rbAdm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbAdmKeyPressed(evt);
            }
        });

        btgPermissao.add(rbEnf);
        rbEnf.setText("Usuário grau 3");
        rbEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEnfActionPerformed(evt);
            }
        });

        btgPermissao.add(rbMedico);
        rbMedico.setText("Usuário grau 2");

        btgPermissao.add(rbRecepcao);
        rbRecepcao.setText("Usuário grau 4");
        rbRecepcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecepcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMedico)
                            .addComponent(rbEnf)
                            .addComponent(rbRecepcao)
                            .addComponent(rbAdm))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbEnf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbRecepcao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed1
        limpar();
        txtPesq.setText(null);
        fechado();
        corTextFields();
    }//GEN-LAST:event_btnLimparActionPerformed1

    private void btnSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair2ActionPerformed
        main.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btnSair2ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if(main.us.getPermissao()==1){
            corNovo();
            novoCadastro();
            opSalvar = 1;
        }else{
            JOptionPane.showMessageDialog(null,"Você não tem permissão para este procedimento!", "Atenção!!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
        corNovo();
        opSalvar = 2;
        btnSalvar2.setEnabled(true);
        btnSalvar2.setBackground(new java.awt.Color(204,211,200));
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int op = JOptionPane.showConfirmDialog(null,"Deseja Realmente Excluir?","Atencão",JOptionPane.YES_NO_OPTION);
        if(op == 0){

            try {
                UsuarioBD uBD = new UsuarioBD();
                List<Usuario> usuario = new UsuarioBD().buscaUsuarios(txtPesq.getText());
                if(usuario.get(tbResultado.getSelectedRow()).getPermissao() != 1){
                    uBD.delete(usuario.get(tbResultado.getSelectedRow()).getId());
                    JOptionPane.showMessageDialog(null, "excluido com sucesso");
                    BuscaUsuarios();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario não pode ser excluido", "Erro",  JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Usuario não pode ser excluido\ndependente de outra tabela", "Erro",  JOptionPane.ERROR_MESSAGE);
            }

        } else if(op == 1){
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
        limpar();
        fechado();
        BuscaUsuarios();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSalvar2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar2ActionPerformed1
        Usuario us = new Usuario();
        UsuarioBD uBD = new UsuarioBD();
        if(opSalvar == 1){
            try{
                us.verificarBanco(0, txtNome.getText(), txtLogin.getText());
                if(uBD.verificaNome(us)){
                    us.Cadastrar(txtNome.getText(),txtLogin.getText(),cripografar(String.valueOf(txtSenha.getPassword()),"MD5"),0,definePermissao());
                    if(us.camposVazio(txtNome.getText(),txtLogin.getText(), String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()),verificaPermissao())==true){
                        if(us.verificaSenha(String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()) )== true){
                            uBD.salvar(us);
                            JOptionPane.showMessageDialog(this, "Usuario cadastrado com sucesso!");
                            limpar();
                            fechado();
                            corTextFields();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Senhas incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Campos vazios", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ja contém um usuario\ncom esses dados", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Usuario não pode ser cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(frmControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(opSalvar == 2){
            int op = JOptionPane.showConfirmDialog(null,"Deseja Realmente Salvar alteração?","Atencão",JOptionPane.YES_NO_OPTION);
            if(op == 0){
                try {
                    Usuario u = new Usuario();

                    List<Usuario> usuario = new UsuarioBD().buscaUsuarios(txtPesq.getText());
                    int id = usuario.get(tbResultado.getSelectedRow()).getId();
                    if(main.us.getId() == id || main.us.getPermissao()==1){
                        u.alterar(id,txtNome.getText(), txtLogin.getText(),cripografar(String.valueOf(txtSenha.getPassword()),"MD5"),definePermissao());
                        if(u.camposVazio(txtNome.getText(),txtLogin.getText(), String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()),verificaPermissao())==true){
                            if(u.verificaSenha(String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()) )== true){
                                u.verificarBanco(id, txtNome.getText(), txtLogin.getText());
                                // if(uBD.verificaNome(u)){
                                    uBD.alterar(u);
                                    JOptionPane.showMessageDialog(this, "Usuario alterado com sucesso");
                                    limpar();
                                    fechado();
                                    corTextFields();
                                    //}else{
                                    // JOptionPane.showMessageDialog(null, "Ja contém um usuario\ncom esses dados", "Erro", JOptionPane.ERROR_MESSAGE);
                                    //}
                            }else{
                                JOptionPane.showMessageDialog(null, "Senhas incorretas", "Erro", JOptionPane.ERROR_MESSAGE);
                                limpar();
                                fechado();
                                corTextFields();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Campos vazios", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuário não possui autorização para concluir alteração?","Atencão",JOptionPane.ERROR_MESSAGE);
                        limpar();
                        fechado();
                        corTextFields();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro na alteração", JOptionPane.ERROR_MESSAGE);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(op == 1){
                JOptionPane.showMessageDialog(null, "Alteração cancelada");
            }
        }
        BuscaUsuarios();
    }//GEN-LAST:event_btnSalvar2ActionPerformed1

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tbResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseReleased
        limpar();
        fechado();
        AbrirBotao();
        retornaDados();

    }//GEN-LAST:event_tbResultadoMouseReleased

    private void tbResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseClicked
        retornaDados();
    }//GEN-LAST:event_tbResultadoMouseClicked

    private void tbResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyPressed
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyPressed

    private void tbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyReleased
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyReleased

    private void txtPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqActionPerformed

    }//GEN-LAST:event_txtPesqActionPerformed

    private void txtPesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqKeyPressed

    }//GEN-LAST:event_txtPesqKeyPressed

    private void txtPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqKeyReleased
        limpar();
        fechado();
        BuscaUsuarios();
    }//GEN-LAST:event_txtPesqKeyReleased

    private void rbEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEnfActionPerformed

    private void rbRecepcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecepcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbRecepcaoActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtLogin.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtSenha.requestFocus();
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtConfirmaSenha.requestFocus();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtConfirmaSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmaSenhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            rbAdm.requestFocus();
        }
    }//GEN-LAST:event_txtConfirmaSenhaKeyPressed

    private void rbAdmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbAdmKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            btnSalvar2.requestFocus();
        }
    }//GEN-LAST:event_rbAdmKeyPressed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgPermissao;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair2;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAdm;
    private javax.swing.JRadioButton rbEnf;
    private javax.swing.JRadioButton rbMedico;
    private javax.swing.JRadioButton rbRecepcao;
    private javax.swing.JTable tbResultado;
    private javax.swing.JPasswordField txtConfirmaSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesq;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}

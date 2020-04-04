/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LancamentosBD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import model.Lancamentos;
import model.Usuario;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class frmLancamento extends javax.swing.JFrame {
     
    frmTela main;
    int opSalvar = 0 ;
    Color corFundo,corBorda;
    private ImageIcon icone;
    Usuario us = null;
    private int verificaLanc=0;
    Lancamentos lancTemp= new Lancamentos();
    List<Lancamentos> listLanc = null;
   
    public int getVerificaLanc() {
        return verificaLanc;
    }

    public void setVerificaLanc(int verificaLanc) {
        this.verificaLanc = verificaLanc;
    }
    /**
     * Creates new form frmLancamento
     */
    public frmLancamento(Usuario u,frmTela m) throws Exception {
       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.BOLD, 12)));
        icone = new ImageIcon("C:\\prjValorVenal\\imagens\\House-1-64.png");
        initComponents();
        setIconImage(icone.getImage());    
        tbResultado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
        main = m;
        us = u;
        BuscaLancamentos();
        fechado();
        corTextFields();
        btnImprimir.setEnabled(false);
        setLocationRelativeTo(null);
        btnEnviar.setEnabled(false);
        setResizable(true);
    }
    
    
public void BuscaLancamentos() {
       try { 
           listLanc= new LancamentosBD().buscaLancFiltro(txtPesq01.getText(),txtPesq02.getText(),cbxConsultaLanc01.getSelectedIndex()+1,cbxConsultaLanc02.getSelectedIndex()+1);
           DefaultTableModel dtm = (DefaultTableModel)tbResultado.getModel();
           limpaTabela(dtm);
           int i = 0;
           for(Lancamentos l:listLanc){
               dtm.addRow(listLanc.get(i).addTable());
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
        txtPesq01.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq01.setForeground(Color.black); 
        txtPesq01.setBackground(new java.awt.Color(255, 255, 255)); 
        txtPesq02.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq02.setForeground(Color.black); 
        txtPesq02.setBackground(new java.awt.Color(255, 255, 255)); 
    }
    public void corNovo(){
        corFundo = new java.awt.Color(255, 255, 255);
        corBorda = new java.awt.Color(13, 153, 17);
        txtPesq01.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq01.setForeground(Color.black); 
        txtPesq01.setBackground(corFundo);
        txtPesq02.setBorder(javax.swing.BorderFactory.createLineBorder(corBorda));
        txtPesq02.setForeground(Color.black); 
        txtPesq02.setBackground(corFundo);
                
    }
    
    private void fechado(){
        txtPesq01.setEnabled(true);
        txtPesq01.setBackground(new java.awt.Color(255, 255, 255));
        txtPesq02.setEnabled(true);
        txtPesq02.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSalvar2.setEnabled(false);
        btnSair2.setBackground(new java.awt.Color(204,211,200));
        btnLimpar.setBackground(new java.awt.Color(204,211,200));
        btnNovo.setBackground(new java.awt.Color(204,211,200));   
    }
    
    private void retornaDados(){
           btnEnviar.setEnabled(false);
           btnEnviar.setBackground(new java.awt.Color(204,211,200));
           int indice = tbResultado.getSelectedRow();
           lancTemp.setInscricao(listLanc.get(indice).getInscricao());
           lancTemp.setProprietario(listLanc.get(indice).getProprietario());
           lancTemp.setCpfPro(listLanc.get(indice).getCpfPro());
           lancTemp.setCompromissario(listLanc.get(indice).getCompromissario());
           lancTemp.setCpfCom(listLanc.get(indice).getCpfCom());
           lancTemp.setLogradouro(listLanc.get(indice).getLogradouro());
           lancTemp.setNumero(listLanc.get(indice).getNumero());
           lancTemp.setBairro(listLanc.get(indice).getBairro());
           lancTemp.setCidade(listLanc.get(indice).getCidade());
           lancTemp.setUf(listLanc.get(indice).getUf());
           lancTemp.setCep(listLanc.get(indice).getCep());
           lancTemp.setQuadra(listLanc.get(indice).getQuadra());
           lancTemp.setLote(listLanc.get(indice).getLote());
           lancTemp.setSetor(listLanc.get(indice).getSetor());
           lancTemp.setPadrao(listLanc.get(indice).getPadrao());
           lancTemp.setTipo(listLanc.get(indice).getTipo());
           lancTemp.setTerreno(listLanc.get(indice).getTerreno());
           lancTemp.setConstrucao(listLanc.get(indice).getConstrucao());
           txtInscricao.setText(listLanc.get(indice).getInscricao());
           txtProprietario.setText(listLanc.get(indice).getProprietario());
           btnEnviar.setEnabled(true);
    }
    private void AbrirBotao(){
        btnAlterar.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSalvar2.setEnabled(false);      
        btnAlterar.setBackground(new java.awt.Color(204,211,200));
        btnDelete.setBackground(new java.awt.Color(204,211,200));
        
       
    }
    private void alterar(){
        /*txtNome.setEditable(true);
        txtConfirmaSenha.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);   */
    }
    private void novoCadastro(){
        btnAlterar.setEnabled(false);
        btnDelete.setEnabled(false);     
        btnSalvar2.setEnabled(true);
        btnSalvar2.setBackground(new java.awt.Color(204,211,200));  
        limpar();       
    }
    private void limpar(){                    
        txtPesq01.setText(null);
        txtPesq02.setText(null);
        cbxConsultaLanc01.setSelectedIndex(0);
        cbxConsultaLanc02.setSelectedIndex(0);
        fechado();
        corTextFields();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesq01 = new javax.swing.JTextField();
        cbxConsultaLanc01 = new javax.swing.JComboBox();
        cbxConsultaLanc02 = new javax.swing.JComboBox();
        txtPesq02 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtInscricao = new javax.swing.JLabel();
        txtProprietario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnSair2 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSalvar2 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("LANÇAMENTOS IMOBILIÁRIOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
				main.setEnabled(true);
				main.setVisible(true);
                formWindowClosed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Procurar imovel por:");

        txtPesq01.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPesq01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq01ActionPerformed(evt);
            }
        });
        txtPesq01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesq01KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesq01KeyReleased(evt);
            }
        });

        cbxConsultaLanc01.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cbxConsultaLanc01.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INCRIÇÃO", "PROPRIETÁRIO", "COMPROMISSÁRIO", "CPF", "LOGRADOURO", "NÚMERO" }));
        cbxConsultaLanc01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxConsultaLanc01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxConsultaLanc01ActionPerformed(evt);
            }
        });
        cbxConsultaLanc01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxConsultaLanc01KeyReleased(evt);
            }
        });

        cbxConsultaLanc02.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cbxConsultaLanc02.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INCRIÇÃO", "PROPRIETÁRIO", "COMPROMISSÁRIO", "CPF", "LOGRADOURO", "NÚMERO" }));
        cbxConsultaLanc02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxConsultaLanc02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxConsultaLanc02ActionPerformed(evt);
            }
        });
        cbxConsultaLanc02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxConsultaLanc02KeyReleased(evt);
            }
        });

        txtPesq02.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPesq02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq02ActionPerformed(evt);
            }
        });
        txtPesq02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesq02KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesq02KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPesq02)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbxConsultaLanc02, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPesq01)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxConsultaLanc01, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxConsultaLanc01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(txtPesq01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxConsultaLanc02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtPesq02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Enviar dados para calcular valor venal: -->");

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel3.setText("Incrição:");

        jLabel4.setText("Proprietário:");

        txtInscricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtProprietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnEnviar))
                .addContainerGap())
        );

        tbResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbResultado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Inscricao", "Proprietário", "CPF-Prop", "Compromissário", "CPF-Comp", "Logradouro", "Numero", "Bairro", "Lote", "Quadra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false
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
        if (tbResultado.getColumnModel().getColumnCount() > 0) {
            tbResultado.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbResultado.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbResultado.getColumnModel().getColumn(3).setPreferredWidth(120);
            tbResultado.getColumnModel().getColumn(4).setPreferredWidth(200);
            tbResultado.getColumnModel().getColumn(5).setPreferredWidth(120);
            tbResultado.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbResultado.getColumnModel().getColumn(7).setPreferredWidth(50);
            tbResultado.getColumnModel().getColumn(8).setPreferredWidth(150);
            tbResultado.getColumnModel().getColumn(9).setPreferredWidth(50);
            tbResultado.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

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
        jPanel3.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 97, 30));

        btnSair2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair2.setMnemonic('o');
        btnSair2.setText("<-- Voltar");
        btnSair2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSair2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 98, 30));

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
        jPanel3.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 97, 30));

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setMnemonic('o');
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 97, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 97, 30));

        btnSalvar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar2.setMnemonic('o');
        btnSalvar2.setText("Salvar");
        btnSalvar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar2ActionPerformed1(evt);
            }
        });
        jPanel3.add(btnSalvar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 97, 30));

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setMnemonic('o');
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel3.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 97, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseReleased
        fechado();
        AbrirBotao();
        retornaDados();
    }//GEN-LAST:event_tbResultadoMouseReleased

    private void tbResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoMouseClicked
        if(evt.getClickCount()==2){
           try {
                main.setEnabled(true);
                main.dispose();
                main = new frmTela(us, this, 1);
                main.setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(frmLancamento.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
    }//GEN-LAST:event_tbResultadoMouseClicked

    private void tbResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyPressed
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyPressed

    private void tbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyReleased
        retornaDados();
    }//GEN-LAST:event_tbResultadoKeyReleased

    private void txtPesq01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq01ActionPerformed

    }//GEN-LAST:event_txtPesq01ActionPerformed

    private void txtPesq01KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq01KeyPressed

    }//GEN-LAST:event_txtPesq01KeyPressed

    private void txtPesq01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq01KeyReleased
        fechado();
        BuscaLancamentos();
    }//GEN-LAST:event_txtPesq01KeyReleased

    private void cbxConsultaLanc01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConsultaLanc01ActionPerformed
          BuscaLancamentos();
    }//GEN-LAST:event_cbxConsultaLanc01ActionPerformed

    private void cbxConsultaLanc01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxConsultaLanc01KeyReleased
       
    }//GEN-LAST:event_cbxConsultaLanc01KeyReleased

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    try {
            main.setEnabled(true);
            main.dispose();
            main = new frmTela(us, this, 1);
            main.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(frmLancamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void cbxConsultaLanc02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConsultaLanc02ActionPerformed
        BuscaLancamentos();
    }//GEN-LAST:event_cbxConsultaLanc02ActionPerformed

    private void cbxConsultaLanc02KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxConsultaLanc02KeyReleased
   
    }//GEN-LAST:event_cbxConsultaLanc02KeyReleased

    private void txtPesq02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesq02ActionPerformed

    private void txtPesq02KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq02KeyPressed
        // TODO add your hacbxConsultaLanc01e:
    }//GEN-LAST:event_txtPesq02KeyPressed

    private void txtPesq02KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesq02KeyReleased
        fechado();
        BuscaLancamentos();
    }//GEN-LAST:event_txtPesq02KeyReleased

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalvar2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar2ActionPerformed1
        /*Lancamentos us = new Lancamentos();
        LancamentosBD uBD = new LancamentosBD();
        if(opSalvar == 1){
            try{
                us.verificarBanco(0, txtNome.getText(), txtLogin.getText());
                if(uBD.verificaNome(us)){
                    us.Cadastrar(txtNome.getText(),txtLogin.getText(),cripografar(String.valueOf(txtSenha.getPassword()),"MD5"),0,definePermissao());
                    if(us.camposVazio(txtNome.getText(),txtLogin.getText(), String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()),verificaPermissao())==true){
                        if(us.verificaSenha(String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()) )== true){
                            uBD.salvar(us);
                            JOptionPane.showMessageDialog(this, "Lancamentos cadastrado com sucesso!");
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
                    JOptionPane.showMessageDialog(null, "Ja contém um lancamento\ncom esses dados", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Lancamentos não pode ser cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(frmControleLancamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(opSalvar == 2){
            int op = JOptionPane.showConfirmDialog(null,"Deseja Realmente Salvar alteração?","Atencão",JOptionPane.YES_NO_OPTION);
            if(op == 0){
                try {
                    Lancamentos u = new Lancamentos();

                    List<Lancamentos> lancamento = new LancamentosBD().buscaLancamentoss(txtPesq.getText());
                    int id = lancamento.get(tbResultado.getSelectedRow()).getId();
                    if(main.us.getId() == id || main.us.getPermissao()==1){
                        u.alterar(id,txtNome.getText(), txtLogin.getText(),cripografar(String.valueOf(txtSenha.getPassword()),"MD5"),definePermissao());
                        if(u.camposVazio(txtNome.getText(),txtLogin.getText(), String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()),verificaPermissao())==true){
                            if(u.verificaSenha(String.valueOf(txtSenha.getPassword()),String.valueOf(txtConfirmaSenha.getPassword()) )== true){
                                u.verificarBanco(id, txtNome.getText(), txtLogin.getText());
                                // if(uBD.verificaNome(u)){
                                    uBD.alterar(u);
                                    JOptionPane.showMessageDialog(this, "Lancamentos alterado com sucesso");
                                    limpar();
                                    fechado();
                                    corTextFields();
                                    //}else{
                                    // JOptionPane.showMessageDialog(null, "Ja contém um lancamento\ncom esses dados", "Erro", JOptionPane.ERROR_MESSAGE);
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
                    Logger.getLogger(frmControleLancamentos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(op == 1){
                JOptionPane.showMessageDialog(null, "Alteração cancelada");
            }
        }
        BuscaLancamentoss();*/
    }//GEN-LAST:event_btnSalvar2ActionPerformed1

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int op = JOptionPane.showConfirmDialog(null,"Deseja Realmente Excluir?","Atencão",JOptionPane.YES_NO_OPTION);
        if(op == 0){

            try {
                LancamentosBD uBD = new LancamentosBD();
                List<Lancamentos> lancamento = new LancamentosBD().buscaLancamentos(txtPesq01.getText());
                uBD.delete(lancamento.get(tbResultado.getSelectedRow()).getCod());
                JOptionPane.showMessageDialog(null, "excluido com sucesso");
                BuscaLancamentos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lancamentos não pode ser excluido\ndependente de outra tabela", "Erro",  JOptionPane.ERROR_MESSAGE);
            }

        } else if(op == 1){
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
        limpar();
        fechado();
        BuscaLancamentos();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
        corNovo();
        opSalvar = 2;
        btnSalvar2.setEnabled(true);
        btnSalvar2.setBackground(new java.awt.Color(204,211,200));
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){

            tbResultado.requestFocus();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if(main.us.getPermissao()==1){
            corNovo();
            novoCadastro();
            opSalvar = 1;
        }else{
            JOptionPane.showMessageDialog(null,"Você não tem permissão para este procedimento!", "Atenção!!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair2ActionPerformed
        main.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btnSair2ActionPerformed

    private void btnLimparActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed1
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed1

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair2;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JComboBox cbxConsultaLanc01;
    private javax.swing.JComboBox cbxConsultaLanc02;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultado;
    private javax.swing.JLabel txtInscricao;
    private javax.swing.JTextField txtPesq01;
    private javax.swing.JTextField txtPesq02;
    private javax.swing.JLabel txtProprietario;
    // End of variables declaration//GEN-END:variables
}

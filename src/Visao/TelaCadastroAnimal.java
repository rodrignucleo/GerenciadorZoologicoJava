/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Conexao.ConectaBanco;
import Repositorio.AnimalZooJpaController;
import Repositorio.exceptions.NonexistentEntityException;
import Modelo.AnimalZoo;
import ModeloDeTabela.AnimalModeloTabela;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author joaov
 */
public class TelaCadastroAnimal extends javax.swing.JFrame {
        ConectaBanco conectar = new ConectaBanco();
    /**
     * Creates new form TelaCadastroAnimal
     */
    public TelaCadastroAnimal() {
        initComponents();
        preencherVeterinario();
        preencherJaula();
        conectar.conexao();
        preencherTabela("SELECT * FROM zoologicoadmin_mysql.animalzoo order by ID");
        
        URL url = this.getClass().getResource("/Imagem/pawprint.png"); 
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void preencherVeterinario(){
        conectar.conexao();
        
        conectar.executaSQL("select * from veterinario order by NOMEVETERINARIO");
        
            try {
                conectar.rs.first();
                BoxVeterinario.removeAllItems();
                do{
                    BoxVeterinario.addItem(conectar.rs.getString("NOMEVETERINARIO"));
                }while(conectar.rs.next());
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastrodeVeterinario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void preencherJaula(){
        conectar.conexao();
        
        conectar.executaSQL("select * from jaula order by ID");
        
            try {
                conectar.rs.first();
                BoxJaula.removeAllItems();
                do{
                    BoxJaula.addItem(conectar.rs.getString("ID") + " - " + conectar.rs.getString("ESPECIALIZACAO"));
                }while(conectar.rs.next());
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastrodeVeterinario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FieldNomeAnimal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BoxJaula = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        BoxVeterinario = new javax.swing.JComboBox<>();
        BotaoCadastrarAnimal = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        BotaoAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaAnimal = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        BoxSexo = new javax.swing.JComboBox<>();
        FieldId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cadastro de Animais");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ZOO MEDICITY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(333, 333, 333))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(196, 196, 196))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(23, 23, 23))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Nome");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Sexo");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Jaula");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Veterináro Responsável");

        BotaoCadastrarAnimal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoCadastrarAnimal.setText("Cadastrar");
        BotaoCadastrarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarAnimalActionPerformed(evt);
            }
        });

        BotaoExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        BotaoAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoAlterar.setText("Alterar");
        BotaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlterarActionPerformed(evt);
            }
        });

        TabelaAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sexo", "Jaula", "Veterinário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(TabelaAnimal);
        if (TabelaAnimal.getColumnModel().getColumnCount() > 0) {
            TabelaAnimal.getColumnModel().getColumn(0).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(1).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(2).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(3).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(4).setResizable(false);
        }

        BoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Femea" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Para editar/excluir:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(FieldNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(BoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BoxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxJaula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addContainerGap(287, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(BotaoCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(BotaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(FieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
                            .addComponent(jSeparator4))
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FieldNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BoxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BoxJaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastrarAnimal)
                    .addComponent(BotaoAlterar)
                    .addComponent(BotaoExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(826, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoCadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarAnimalActionPerformed
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aplicazoo_mysql");
        
        AnimalZoo animalzoo = new AnimalZoo();
        
       
        animalzoo.setNomeAnimal(FieldNomeAnimal.getText());
        animalzoo.setSexo((String) BoxSexo.getSelectedItem());
        animalzoo.setVeterinarioResponsavel((String) BoxVeterinario.getSelectedItem());
        animalzoo.setIdJaula((String) BoxJaula.getSelectedItem());
        
        
        AnimalZooJpaController animalzoojpacontroller = new AnimalZooJpaController(entityManagerFactory);
        animalzoojpacontroller.criar(animalzoo);
        
        JOptionPane.showMessageDialog(null, "Animal Cadastrado!!");
        
        preencherTabela("SELECT * FROM zoologicoadmin_mysql.animalzoo order by ID");
    }//GEN-LAST:event_BotaoCadastrarAnimalActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aplicazoo_mysql");
        
        
        AnimalZooJpaController animalzoojpacontroller = new AnimalZooJpaController(entityManagerFactory);
            try {
                animalzoojpacontroller.apagar(Long.parseLong(FieldId.getText()));
            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(null, "Coloque um ID");
            }
        preencherTabela("SELECT * FROM zoologicoadmin_mysql.animalzoo order by ID");
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlterarActionPerformed
        conectar.conexao();
        
        PreparedStatement preparedStatement = null;
        
        String sql = "UPDATE zoologicoadmin_mysql.animalzoo"
                + " SET"
                + " IDJAULA=? ,"
                + " NOMEANIMAL=? ,"
                + " SEXO=? ,"
                + " VETERINARIORESPONSAVEL=?"
                + " WHERE ID=?";
        try {
            preparedStatement = conectar.conn.prepareStatement(sql);
            preparedStatement.setString(1,(String) BoxJaula.getSelectedItem());
            preparedStatement.setString(2, FieldNomeAnimal.getText());
            preparedStatement.setString(3,(String) BoxSexo.getSelectedItem());
            preparedStatement.setString(4,(String) BoxVeterinario.getSelectedItem());
            preparedStatement.setString(5, FieldId.getText());
            
            conectar.executaSQL(sql);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroDeJaula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        preencherTabela("SELECT * FROM zoologicoadmin_mysql.animalzoo order by ID");
    }//GEN-LAST:event_BotaoAlterarActionPerformed

    public void preencherTabela(String SQL){
        ArrayList dados = new ArrayList();
        
        String [] Colunas = new String[]{"ID", "IDJAULA", "NOMEANIMAL", "SEXO", "VETERINARIORESPONSAVEL"};
        

        conectar.executaSQL(SQL);
       
        try {
            conectar.rs.first();
            do{
                dados.add(new Object[]{conectar.rs.getLong("ID"), conectar.rs.getString("IDJAULA"), conectar.rs.getString("NOMEANIMAL"), conectar.rs.getString("SEXO"), conectar.rs.getString("VETERINARIORESPONSAVEL")});
            }while(conectar.rs.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList! \n Erro: " + ex.getMessage());
        }
            AnimalModeloTabela adicionaranimal = new AnimalModeloTabela(dados, Colunas);
            
            TabelaAnimal.setModel(adicionaranimal);
            TabelaAnimal.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabelaAnimal.getColumnModel().getColumn(0).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(1).setPreferredWidth(200);
            TabelaAnimal.getColumnModel().getColumn(1).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaAnimal.getColumnModel().getColumn(2).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(3).setPreferredWidth(100);
            TabelaAnimal.getColumnModel().getColumn(3).setResizable(false);
            TabelaAnimal.getColumnModel().getColumn(4).setPreferredWidth(210);
            TabelaAnimal.getColumnModel().getColumn(4).setResizable(false);
            
            TabelaAnimal.getTableHeader().setReorderingAllowed(false);
            TabelaAnimal.setAutoResizeMode(TabelaAnimal.AUTO_RESIZE_OFF);
            TabelaAnimal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlterar;
    private javax.swing.JButton BotaoCadastrarAnimal;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JComboBox<String> BoxJaula;
    private javax.swing.JComboBox<String> BoxSexo;
    private javax.swing.JComboBox<String> BoxVeterinario;
    private javax.swing.JTextField FieldId;
    private javax.swing.JTextField FieldNomeAnimal;
    private javax.swing.JTable TabelaAnimal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}

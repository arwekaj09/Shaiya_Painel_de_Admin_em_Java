/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import SQL.Conexao;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorgi Luiz Bolonhezi Dias
 */
 
public class Cash extends javax.swing.JFrame {

    /**
     * Creates new form Cash
     */
    public Cash() {
        initComponents();
        setSize(750,309);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jUserUID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cash - Panel");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User UID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 10, 70, 30);
        getContentPane().add(jUserUID);
        jUserUID.setBounds(510, 10, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 40, 70, 30);
        getContentPane().add(jQuantidade);
        jQuantidade.setBounds(510, 40, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Responsible:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 70, 90, 30);
        getContentPane().add(jResponsavel);
        jResponsavel.setBounds(510, 70, 90, 30);

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(680, 10, 59, 23);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(680, 40, 60, 23);

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(680, 70, 60, 23);

        jFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LionNews.jpg"))); // NOI18N
        getContentPane().add(jFundo);
        jFundo.setBounds(0, 0, 744, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                new JBLogin().setVisible(true);
                this.dispose();
                this.setResizable(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            if (jQuantidade.getText() != null) {
                if (jUserUID.getText() != null) {
                    Conexao con = new Conexao();
                    String SQL = "Update PS_UserData.dbo.Users_Master set Point=point+? where UserUID=?";
                    PreparedStatement ps = con.getConexao().prepareStatement(SQL);
                    ps.setString(1, jQuantidade.getText());
                    ps.setString(2, jUserUID.getText());
                    int registros = ps.executeUpdate();
                    if (registros > 0) {
                        String data = "dd/MM/yyyy";
                        String hora = "h:mm - a";
                        String data1, hora1;
                        java.util.Date agora = new java.util.Date();;
                        SimpleDateFormat formata = new SimpleDateFormat(data);
                        data1 = formata.format(agora);
                        formata = new SimpleDateFormat(hora);
                        hora1 = formata.format(agora);
                        Conexao con1 = new Conexao();
                        String SQL1 = "INSERT INTO PS_ActionPerformed.dbo.Action values(?,'AddCash',?,?,?)";
                        PreparedStatement ps1 = con1.getConexao().prepareStatement(SQL1);
                        ps1.setString(1, jResponsavel.getText());
                        ps1.setString(2, data1);
                        ps1.setString(3, hora1);
                        ps1.setString(4, jResponsavel.getText());
                        int registros1 = ps1.executeUpdate();
                        if(registros1>0){
                        jQuantidade.setText("");
                        jUserUID.setText("");
                        jResponsavel.setText("");
                        JOptionPane.showMessageDialog(null, "APs Send Sucessfully.");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Access denied");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid UserUID.");;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Insert UserUID");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Insert Quantity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jQuantidade;
    private javax.swing.JTextField jResponsavel;
    private javax.swing.JTextField jUserUID;
    // End of variables declaration//GEN-END:variables
}
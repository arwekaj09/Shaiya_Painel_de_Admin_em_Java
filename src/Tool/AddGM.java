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
 
public class AddGM extends javax.swing.JFrame {

    /**
     * Creates new form AddGM
     */
    public AddGM() {
        initComponents();
        setSize(750, 310);
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

        jLabel2 = new javax.swing.JLabel();
        CTMToon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create GM Account");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 10, 80, 30);
        getContentPane().add(CTMToon);
        CTMToon.setBounds(490, 10, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Responsible:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 100, 87, 30);
        getContentPane().add(jResponsavel);
        jResponsavel.setBounds(440, 100, 100, 30);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(660, 10, 80, 23);

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(660, 50, 80, 23);

        jFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LionNews.jpg"))); // NOI18N
        getContentPane().add(jFundo);
        jFundo.setBounds(0, 0, 744, 282);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                new JBLogin().setVisible(true);
                this.dispose();
                this.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                        try {
            if (CTMToon.getText() != null) {
                    Conexao con = new Conexao();
                    String SQL = "Update PS_UserData.dbo.Users_Master set Admin = 'True' and AdminLevel=255 and Status=16 and UserType'A' where UserID=?";
                    PreparedStatement ps = con.getConexao().prepareStatement(SQL);
                    ps.setString(1, CTMToon.getText());
                    int registros = ps.executeUpdate();
                    if (registros > 0) {
                        JOptionPane.showMessageDialog(null, "Account Updated Sucessfully.");
                        String data = "dd/MM/yyyy";
                        String hora = "h:mm - a";
                        String data1, hora1;
                        java.util.Date agora = new java.util.Date();;
                        SimpleDateFormat formata = new SimpleDateFormat(data);
                        data1 = formata.format(agora);
                        formata = new SimpleDateFormat(hora);
                        hora1 = formata.format(agora);
                        Conexao con1 = new Conexao();
                        String SQL1 = "INSERT INTO PS_ActionPerformed.dbo.Action values(?,'Create GM Account',?,?,?)";
                        PreparedStatement ps1 = con1.getConexao().prepareStatement(SQL1);
                        ps1.setString(1, jResponsavel.getText());
                        ps1.setString(2, data1);
                        ps1.setString(3, hora1);
                        ps1.setString(4, jResponsavel.getText());
                        int registros1 = ps1.executeUpdate();
                        CTMToon.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid UserID.");;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Insert UserID");
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
            java.util.logging.Logger.getLogger(AddGM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CTMToon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jFundo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jResponsavel;
    // End of variables declaration//GEN-END:variables
}
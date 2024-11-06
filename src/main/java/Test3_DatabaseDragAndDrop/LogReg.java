/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Test3_DatabaseDragAndDrop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raylen
 */
public class LogReg extends javax.swing.JFrame {
    
private static final long serialVersionUID = 1L;
    /**
     * Creates new form LogReg
     */
    public LogReg() {
        initComponents();
        setSize(845, 508);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        btnNewButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Password:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(35, 254, 281, 48);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setText("Log In");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(344, 36, 144, 64);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Username:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 139, 281, 48);

        textField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        getContentPane().add(textField);
        textField.setBounds(230, 150, 462, 50);

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(passwordField);
        passwordField.setBounds(230, 250, 462, 48);

        btnNewButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnNewButton.setText("Log  In");
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewButton);
        btnNewButton.setBounds(130, 360, 260, 70);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 360, 260, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
                       
        
        
        
        
    }//GEN-LAST:event_textFieldActionPerformed

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButtonActionPerformed
     
      String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/logregtest",
                        "root", "1027");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from logg where name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        logPage ah = new logPage();
                       
                        ah.setVisible(true);
                        //JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    }else if(userName.isEmpty()||password.isEmpty()){
    JOptionPane.showMessageDialog(btnNewButton, "Fill up the necessary information please.");
        textField.setText("");
        passwordField.setText("");
    }
                    
                    
                    else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username Or Password");
                        textField.setText("");
        passwordField.setText("");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
        
        
    }//GEN-LAST:event_btnNewButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
                        Register ah = new Register();
                        ah.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LogReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}

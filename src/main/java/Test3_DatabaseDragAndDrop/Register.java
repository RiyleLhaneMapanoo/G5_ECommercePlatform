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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Raylen
 */
public class Register extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;
    /**
     * Creates new form LogReg
     */
    public Register() {
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
        jButton1 = new javax.swing.JButton();
        btnNewButton = new javax.swing.JButton();

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
        jLabel2.setText("Register");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 40, 220, 64);

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setText("Back to Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 10, 270, 60);

        btnNewButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnNewButton.setText("Register");
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewButton);
        btnNewButton.setBounds(300, 350, 260, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
         dispose();
                        LogReg ah = new LogReg();
                        ah.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButtonActionPerformed
    
        String userName = textField.getText();
String password = passwordField.getText();

try {
    Connection connection = (Connection) DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/logregtest", "root", "1027");

    // Query to check for duplicates
    String checkQuery = "SELECT * FROM logg WHERE name = ? AND password = ?";
    PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
    checkStatement.setString(1, userName);
    checkStatement.setString(2, password);

    ResultSet resultSet = checkStatement.executeQuery();

    if (resultSet.next()) {
        // If a match is found, the account already exists
        JOptionPane.showMessageDialog(btnNewButton, "This account already exists.");
        textField.setText("");
        passwordField.setText("");
    } else if (userName.isEmpty()||password.isEmpty()){
    JOptionPane.showMessageDialog(btnNewButton, "Fill up the necessary information please.");
        textField.setText("");
        passwordField.setText("");
    }
    
    
    
    
    else {
        // If no match is found, proceed to insert the new account
        String query = "INSERT INTO logg (name, password) VALUES (?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(query);
        insertStatement.setString(1, userName);
        insertStatement.setString(2, password);

        int x = insertStatement.executeUpdate();
        if (x == 0) {
            JOptionPane.showMessageDialog(btnNewButton, "Error: Account could not be created.");
            //Would pop out pag di sya makagawa ng account(ex: masyado mahaba value or mispelled na value sa database)
        } else {
            JOptionPane.showMessageDialog(btnNewButton, "Welcome, " + userName + "! Your account is successfully created.");
              textField.setText("");
        passwordField.setText("");
        }
    }

    connection.close();
} catch (Exception exception) {
    exception.printStackTrace();
}

        
    }//GEN-LAST:event_btnNewButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}
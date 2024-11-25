/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainloginpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Bering
 */
class classSignupPage extends JFrame implements ActionListener{
     Connection con = null;
     PreparedStatement state = null;
     JLabel titleLbl, welcomeLbl, signupLbl, fullNameLbl, emailLbl,addressLbl, contactLbl, passwordLbl, signInLbl;
     JTextField fullNameTxf, emailTxf, addressTxf, contactTxf, passwordTxf;
     JButton signUpBtn,signInBtn;   
     JPanel backgroundPl;
    classSignupPage(){
        setSize(1385,764);        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome! Please Sign up");
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bering\\Downloads\\Landing Page.png")));
        
        titleLbl = new JLabel("C a s e . j a r");
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD,80));
        titleLbl.setForeground(Color.white);
        titleLbl.setBounds(450, 50, 600, 100);
        add(titleLbl);
        
        welcomeLbl = new JLabel("Welcome");
        welcomeLbl.setFont(new Font("Arial",Font.PLAIN,50));
        welcomeLbl.setForeground(Color.black);
        welcomeLbl.setBounds(555, 200, 600, 100);
        add(welcomeLbl);
        
        signupLbl = new JLabel("Create an account");
        signupLbl.setFont(new Font("Arial", Font.ITALIC,20));
        signupLbl.setForeground(Color.white);
        signupLbl.setBounds(565, 246, 600, 100);
        add(signupLbl);
        
        fullNameLbl = new JLabel("Full Name: ");
        fullNameLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        fullNameLbl.setForeground(Color.black);
        fullNameLbl.setBounds(350, 300, 300, 80);
        add(fullNameLbl);
        
        emailLbl = new JLabel("Email: ");
        emailLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        emailLbl.setForeground(Color.black);
        emailLbl.setBounds(350, 350, 300, 80);
        add(emailLbl);
        
        addressLbl = new JLabel("Address: ");
        addressLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        addressLbl.setForeground(Color.black);
        addressLbl.setBounds(350, 400, 300, 80);        
        add(addressLbl);
        
        contactLbl = new JLabel("Contact No.: ");
        contactLbl.setFont(new Font("Open Sans", Font.PLAIN,30));        
        contactLbl.setForeground(Color.black);
        contactLbl.setBounds(350, 450, 300, 80);        
        add(contactLbl);
          
        passwordLbl = new JLabel("Password: ");
        passwordLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        passwordLbl.setForeground(Color.black);
        passwordLbl.setBounds(350, 500, 300, 80);
        add(passwordLbl);
        
        fullNameTxf = new JTextField();
        fullNameTxf.setFont(new Font("Open Sans",Font.PLAIN,20));
        fullNameTxf.setBounds(590, 325, 300, 30);
        add(fullNameTxf);
        
        emailTxf = new JTextField();
        emailTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        emailTxf.setBounds(590, 375, 300, 30);
        add(emailTxf);
        
        addressTxf = new JTextField();
        addressTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        addressTxf.setBounds(590, 425, 300, 30);
        add(addressTxf);
        
        contactTxf = new JTextField();
        contactTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        contactTxf.setBounds(590, 475, 300, 30);
        add(contactTxf);      
        
        passwordTxf = new JTextField();
        passwordTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        passwordTxf.setBounds(590, 525, 300,30);
        add(passwordTxf);
        
        signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Open Sans",Font.PLAIN,25));
        signUpBtn.setForeground(Color.white);
        signUpBtn.setBackground(new Color(80,32,77));
        signUpBtn.setBounds(590, 558, 300, 35);
        add(signUpBtn);
        
        signInLbl = new JLabel("Already have an account");
        signInLbl.setFont(new Font("Open Sans", Font.ITALIC,15));
        signInLbl.setForeground(Color.white);
        signInLbl.setBounds(640, 587, 600, 30);
        add(signInLbl);
        
        signInBtn = new JButton("Sign In");
        signInBtn.setFont(new Font("Open Sans", Font.ITALIC,25));
        signInBtn.setForeground(Color.white);
        signInBtn.setBackground(new Color(80,32,77));
        signInBtn.setBounds(590, 610, 300, 35);
        add(signInBtn);
        
        backgroundPl = new JPanel();
        backgroundPl.setBackground(new Color(154,96,171));
        backgroundPl.setBounds(225, 200, 850, 450);
        add(backgroundPl);
        
        signInBtn.addActionListener(this);
        signUpBtn.addActionListener(this);

     }
     public void actionPerformed(ActionEvent e){
         if(e.getSource() == signInBtn){
             classLoginPage login = new classLoginPage();
             login.setVisible(true);
             dispose();
         } if(e.getSource() == signUpBtn){
             try{
             String query = "INSERT INTO `user`(`id`, `full_name`, `email`, `password`) VALUES (?, ?, ?, ?)";
             con = DriverManager.getConnection("jdbc:mysql://localhost/user_database","root","12345");
             state = con.prepareStatement(query);
             state.setString(1, fullNameTxf.getText());
             state.setString(2, emailTxf.getText());
             state.setString(3, passwordTxf.getText());
             state.setString(4, fullNameTxf.getText());
             state.executeUpdate();      
             JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY");
             }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
                
             }
             String fullName = fullNameTxf.getText();
             String email = emailTxf.getText();
             String password = passwordTxf.getText();
             if(fullName.isEmpty() && email.isEmpty() && password.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Unable to create an accoount", "Error", JOptionPane.ERROR_MESSAGE);
             }else if(fullName.isEmpty() && email.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Enter a Full Name and Email", "Error", JOptionPane.ERROR_MESSAGE);
             }else if(email.isEmpty() && password.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Enter your Email and Password", "Error", JOptionPane.ERROR_MESSAGE);
             }else if(fullName.isEmpty() && password.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Enter an Full Name and Password", "Error", JOptionPane.ERROR_MESSAGE);
             }else if(fullName.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Enter Full Name ", "Error", JOptionPane.ERROR_MESSAGE);
             } else if(email.isEmpty()){
                 JOptionPane.showMessageDialog(this, "Enter Email", "Unable to create an account", JOptionPane.ERROR_MESSAGE);
             }else{
                 JOptionPane.showMessageDialog(this, "Enter Password", "Unable to create an account", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
}
    


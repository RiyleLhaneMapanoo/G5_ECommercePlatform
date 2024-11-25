/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainloginpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Bering
 */
public class classLoginPage extends JFrame implements ActionListener {
    JLabel lblTitle, lblWelcome, lblSignin, lblEmail, lblPassword, lblSignup;
    JTextField txfEmail;
    JPasswordField pfPassword;
    JButton btnSignin, btnSignup;
    JPanel plBackround;
    
    classLoginPage(){
        setSize(1385,764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome! Please Sign In");
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bering\\Downloads\\Landing Page.png")));
        
        lblTitle = new JLabel("C a s e . j a r");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD,80));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(450, 50, 600, 100);
        add(lblTitle);
        
        lblWelcome = new JLabel("Welcome");
        lblWelcome.setFont(new Font("Arial",Font.PLAIN,50));
        lblWelcome.setForeground(Color.black);
        lblWelcome.setBounds(555, 200, 600, 100);
        add(lblWelcome);
        
        lblSignin = new JLabel("Sign In to your account");
        lblSignin.setFont(new Font("Arial",Font.ITALIC,20));
        lblSignin.setForeground(Color.white);
        lblSignin.setBounds(565, 245, 600, 100);
        add(lblSignin);
        
        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Open Sans", Font.PLAIN,30));
        lblEmail.setForeground(Color.black);
        lblEmail.setBounds(350, 310, 300, 80);
        add(lblEmail);
        
        lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Open Sans", Font.PLAIN,30));
        lblPassword.setForeground(Color.black);
        lblPassword.setBounds(350, 410, 300, 80);
        add(lblPassword);
        
        txfEmail = new JTextField();
        txfEmail.setFont(new Font("Open Sans", Font.PLAIN,20));
        txfEmail.setBounds(590, 335, 300, 30);
        add(txfEmail);
        
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Open Sans", Font.PLAIN,20));
        pfPassword.setBounds(590, 435, 300, 30);
        add(pfPassword);
        
        btnSignin = new JButton("Sign In");
        btnSignin.setFont(new Font("Open Sans", Font.PLAIN,20));
        btnSignin.setForeground(Color.white);
        btnSignin.setBackground(new Color(80,32,77));
        btnSignin.setBounds(590, 480, 300, 40);
        add(btnSignin);
        
        lblSignup = new JLabel("No account yet? Click Sign Up!");
        lblSignup.setFont(new Font("Open Sans",Font.PLAIN,15));
        lblSignup.setForeground(Color.black);
        lblSignup.setBounds(640, 535, 600, 30);
        add(lblSignup);
        
        btnSignup = new JButton("Sign Up");
        btnSignup.setFont(new Font("Open Sans", Font.PLAIN,20));
        btnSignup.setForeground(Color.white);
        btnSignup.setBackground(new Color(80,32,77));
        btnSignup.setBounds(590, 560, 300, 40);
        add(btnSignup);
        
        plBackround = new JPanel();
        plBackround.setBackground(new Color(154,96,171));
        plBackround.setBounds(225, 200, 850, 450);
        add(plBackround);
        
        btnSignup.addActionListener(this);
        btnSignin.addActionListener(this);
               
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSignup){
        classSignupPage signup = new classSignupPage();
        signup.setVisible(true);
        dispose();
        }if(e.getSource() == btnSignin){
            String strEmail = txfEmail.getText();
            String strPassword = new String(pfPassword.getPassword());
            if(strEmail.isEmpty() && strPassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter your Email and Password", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(strPassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter your Password", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Enter your Email", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
            
}

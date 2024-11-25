/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Bering
 */
class BuyerSignupPage extends JFrame implements ActionListener{
   //  Connection con = null;
     //PreparedStatement state = null;
     JLabel titleLbl, welcomeLbl, signupLbl, fullNameLbl, emailLbl, passwordLbl, signInLbl;
     JTextField fullNameTxf, emailTxf, passwordTxf;
     JButton signUpBtn,signInBtn;   
     JPanel backgroundPl;
    BuyerSignupPage(){
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome! Please Sign up");
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setLayout(null);
        setSize(1385,764);
        setLocationRelativeTo(null);
        setResizable(false);
        
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
        fullNameLbl.setBounds(350, 310, 300, 80);
        add(fullNameLbl);
        
        emailLbl = new JLabel("Email: ");
        emailLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        emailLbl.setForeground(Color.black);
        emailLbl.setBounds(350, 370, 300, 80);
        add(emailLbl);
        
        passwordLbl = new JLabel("Password: ");
        passwordLbl.setFont(new Font("Open Sans", Font.PLAIN,30));
        passwordLbl.setForeground(Color.black);
        passwordLbl.setBounds(350, 430, 300, 80);
        add(passwordLbl);
        
        fullNameTxf = new JTextField();
        fullNameTxf.setFont(new Font("Open Sans",Font.PLAIN,20));
        fullNameTxf.setBounds(590, 335, 300, 30);
        add(fullNameTxf);
        
        emailTxf = new JTextField();
        emailTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        emailTxf.setBounds(590, 395, 300, 30);
        add(emailTxf);
        
        passwordTxf = new JTextField();
        passwordTxf.setFont(new Font("Open Sans", Font.PLAIN,20));
        passwordTxf.setBounds(590, 455, 300, 30);
        add(passwordTxf);
        
        signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Open Sans",Font.PLAIN,25));
        signUpBtn.setForeground(Color.white);
        signUpBtn.setBackground(new Color(80,32,77));
        signUpBtn.setBounds(590, 510, 300, 40);
        add(signUpBtn);
        
        signInLbl = new JLabel("Already have an account");
        signInLbl.setFont(new Font("Open Sans", Font.ITALIC,15));
        signInLbl.setForeground(Color.white);
        signInLbl.setBounds(640, 565, 600, 30);
        add(signInLbl);
        
        signInBtn = new JButton("Sign In");
        signInBtn.setFont(new Font("Open Sans", Font.ITALIC,25));
        signInBtn.setForeground(Color.white);
        signInBtn.setBackground(new Color(80,32,77));
        signInBtn.setBounds(590, 600, 300, 40);
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
             LoginPage login = new LoginPage();
             login.setVisible(true);
             dispose();
         } if(e.getSource() == signUpBtn){
             
               String fullName = fullNameTxf.getText();
             String emailUser = emailTxf.getText();
             String password = passwordTxf.getText();
             
             try{
             String checkExisitingValueQuery = "SELECT * FROM usertable WHERE email = ?";
             Connection checkExisitingValueCon = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","1027");
             PreparedStatement checkExisitingValueState = checkExisitingValueCon.prepareStatement(checkExisitingValueQuery);         
             checkExisitingValueState.setString(1, emailTxf.getText());
                 
                ResultSet resultSet = checkExisitingValueState.executeQuery();
                
                
                if(resultSet.next()){
                
                String existingEmail = resultSet.getString("email");
                //Nested if
                if(emailUser.equals(existingEmail)){
                
                 JOptionPane.showMessageDialog(this, "Email already used in an exisiting account", "Error", JOptionPane.ERROR_MESSAGE);
                 fullNameTxf.setText("");
                emailTxf.setText("");
                passwordTxf.setText("");
                
                
                }
                
                }else{
           
              if(fullName.isEmpty() || emailUser.isEmpty() || password.isEmpty()){
                       
                JOptionPane.showMessageDialog(signUpBtn, "Fill out all the necessary info.");
                 fullNameTxf.setText("");
                emailTxf.setText("");
                passwordTxf.setText("");
            //Would pop out pag di sya makagawa ng account(ex: masyado mahaba value or mispelled na value sa database)
            
               }else{
                        String query = "INSERT INTO `usertable`(`full_name`, `email`, `password`) VALUES ( ?, ?, ?)";
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","1027");
             PreparedStatement state = con.prepareStatement(query);
             state.setString(1, fullNameTxf.getText());
             state.setString(2, emailTxf.getText());
             state.setString(3, passwordTxf.getText());
                 
                 JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY");
                fullNameTxf.setText("");
                emailTxf.setText("");
                passwordTxf.setText("");
             state.executeUpdate();
                   
               }
             }
             
             }catch(Exception ex){
                    //    System.out.println(ex);   
             JOptionPane.showMessageDialog(null,"An error has occured. ");
                 fullNameTxf.setText("");
                emailTxf.setText("");
                passwordTxf.setText("");
             }
           
             
         }
     }
}
    


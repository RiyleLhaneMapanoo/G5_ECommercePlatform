/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;


//import Test3_DatabaseDragAndDrop.logPage;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Bering
 */
public class LoginPage extends JFrame implements ActionListener {
    JLabel lblTitle, lblWelcome, lblSignin, lblEmail, lblPassword, lblSignup;
    JTextField txfEmail;
    JPasswordField pfPassword;
    JButton btnSignin, btnSignup;
    JPanel plBackround;
    
    LoginPage(){
        
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome! Please Sign In");
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setLayout(null);
        setSize(1385,764);
        setLocationRelativeTo(null);
        
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
        lblPassword.setBounds(350, 400, 300, 80);
        add(lblPassword);
        
        txfEmail = new JTextField();
        txfEmail.setFont(new Font("Open Sans", Font.PLAIN,20));
        txfEmail.setBounds(590, 335, 300, 30);
        add(txfEmail);
        
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Open Sans", Font.PLAIN,20));
        pfPassword.setBounds(590, 425, 300, 30);
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
        BuyerSignupPage signup = new BuyerSignupPage();
        signup.setVisible(true);
        dispose();
        
        
        }if(e.getSource() == btnSignin){
            
            String strEmail = txfEmail.getText();
            String strPassword = new String(pfPassword.getPassword());
            
            
            if(strEmail.equals("Seller") && strPassword.equals("adminSeller")){
                  dispose();
                        eComPageSeller ah = new eComPageSeller();
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as Seller");
                
            }else{
            
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testecom1",
                        "root", "1027");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select email, password from usertable where BINARY email=? and BINARY password=?");
                    //BINARY is pra mging case sensitive ung tinatanggap n credentials s log in. 
                    //for some reason di mabago s mismong database column ung Binary

                    st.setString(1, strEmail);
                    st.setString(2, strPassword);
                    ResultSet rs = st.executeQuery();
                    
                    
                    if (rs.next()) {
                 
                        dispose();
                        eComPageUser ah = new eComPageUser();
                       
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                    }
                    
                    else if(strEmail.isEmpty() || strPassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Fill the necessary details please", "Error", JOptionPane.ERROR_MESSAGE);
                txfEmail.setText("");
                pfPassword.setText("");
              }else{
                JOptionPane.showMessageDialog(this, "Wrong Password or Email", "Error", JOptionPane.ERROR_MESSAGE);
                txfEmail.setText("");
                pfPassword.setText("");
              }
        }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
        }
        
        
        
    }
}

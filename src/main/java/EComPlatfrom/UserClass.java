/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Raylen
 */
public class UserClass {
    
//    private JTextField subTxtEmail;
//    private JPasswordField subTxtPass;

    public UserClass(){
     //may add the connectTodatabase() method after debugging later on
     
    }
    
     
    
    public void loginMethod(JFrame frame,String email, String password, JTextField txtEmail, JPasswordField txtPassword){
    
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testecom1","root", "12345");


                     PreparedStatement stSeller = connection.prepareStatement("SELECT email, password FROM usertable WHERE BINARY email=? AND BINARY password=? AND id=1");
                       stSeller.setString(1, email);
                       stSeller.setString(2, password);
                         ResultSet rsSeller = stSeller.executeQuery();
                    if(rsSeller.next()){
                    
                        frame.dispose();
                        eComPageSeller ah = new eComPageSeller();
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as Seller");
                
                    }else{
                    
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select id,email, password from usertable where BINARY email=? and BINARY password=?");
                   
                    st.setString(1, email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    
                    
                    if (rs.next()) {
                        
                       
                        
                        frame.dispose();
                        eComPageUser ah = new eComPageUser();
                       
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as User");
                    }
                    
                      else if(email.isEmpty() || password.isEmpty()){
                      JOptionPane.showMessageDialog(null, "Fill the necessary details please", "Error", JOptionPane.ERROR_MESSAGE);
                       txtEmail.setText("");
                       txtPassword.setText("");
                      }else{
                JOptionPane.showMessageDialog(null, "Wrong Password or Email", "Error", JOptionPane.ERROR_MESSAGE);
                txtEmail.setText("");
                txtPassword.setText("");
              }
        }
               
    } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    
    
    public void registerMethod(JFrame frame,JButton but,String email, String password,String fullName,String contacts,String house ,JTextField txtContact,JTextField txtHouse,JTextField txtEmail, JTextField txtPassword,JTextField txtName){
     try{
             String checkExisitingValueQuery = "SELECT * FROM usertable WHERE email = ?";
 Connection checkExisitingValueCon = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","12345");
             PreparedStatement checkExisitingValueState = checkExisitingValueCon.prepareStatement(checkExisitingValueQuery);         
             checkExisitingValueState.setString(1, txtEmail.getText());
                 
                ResultSet resultSet = checkExisitingValueState.executeQuery();
                
                
                if(resultSet.next()){
                
                String existingEmail = resultSet.getString("email");
                //Nested if
                if(email.equals(existingEmail)){
                
                 JOptionPane.showMessageDialog(null, "Email already used in an exisiting account", "Error", JOptionPane.ERROR_MESSAGE);
                 txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtHouse.setText("");
                txtContact.setText("");
                
                }
                
                }else{
           
              if(fullName.isEmpty() || email.isEmpty() || password.isEmpty()|| contacts.isEmpty()|| house.isEmpty()){
                       
                JOptionPane.showMessageDialog(but, "Fill out all the necessary info.");
                  txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtHouse.setText("");
                txtContact.setText("");
            //UPDATE: would pop if empty nlng sila
            
               }else{
                        String query = "INSERT INTO `usertable`(`full_name`, `email`, `password`,`address`,`contactnum`) VALUES (?,?,?,?,?)";
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","12345");
             PreparedStatement state = con.prepareStatement(query);
             state.setString(1, txtName.getText());
             state.setString(2, txtEmail.getText());
             state.setString(3, txtPassword.getText());
              state.setString(4, txtHouse.getText());
             state.setString(5, txtContact.getText());
                 
                 JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY");
                txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtHouse.setText("");
                txtContact.setText("");
             state.executeUpdate();
                   
               }
             }
             
             }catch(Exception ex){
                    //    System.out.println(ex);   
             JOptionPane.showMessageDialog(null,"An error has occured. ");
                 txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtHouse.setText("");
                txtContact.setText("");
             }
    
    }
    
   

    }


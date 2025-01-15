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

    HashMap<String,Object> userSession;
    Connection conn;
    
    public UserClass(){
     //may add the connectTodatabase() method after debugging later on
     connectToDatabase();
     userSession = new HashMap<>();
     
    }
    
public HashMap<String, Object> getUserSession() {
        return userSession;
    }
    
     private void connectToDatabase() {
       
        try {

            String url = "jdbc:mysql://localhost:3306/testecom1";
            String user = "root2";
            String password = "12345";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void loginMethod(JFrame frame,String email, String password, JTextField txtEmail, JPasswordField txtPassword){
    
                try  {
                        connectToDatabase();
                    Connection connection = conn;


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
                      int userId = rs.getInt("id");
                        
                        
                        userSession.put("userId", userId);
                    userSession.put("role", "User");
                  

                        
                        System.out.println("Debug: userSession populated -> " + userSession);
                        
                       
                        frame.dispose();
                        eComPageUser ah = new eComPageUser(this);
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in as User "+userId);
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
             connectToDatabase();
             String checkExisitingValueQuery = "SELECT * FROM usertable WHERE email = ?";
 Connection checkExisitingValueCon = conn;
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
                   Connection con = conn;
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


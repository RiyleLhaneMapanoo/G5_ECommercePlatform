/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;


import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.*;
import javax.swing.*;

import javax.swing.border.BevelBorder;



/**
 *
 * @author Raylen
 */
public class ProductClass  {
   
  private UserClass userClass;
    public int panelCount = 0;  
   
    private Connection conn; 
  
  
 
  OrderClass orderClass = new OrderClass();
   
    public ProductClass(UserClass userClass){
          this.userClass = userClass;
       connectToDatabase();
         
    }
 private void connectToDatabase() {
       
        try {
            
            String url = "jdbc:mysql://localhost:3306/testecom1";
            String user = "root";
            String password = "12345";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    
   
   
    
     
    public JPanel createProductPanelforBuyer(String category) {
        try {
             
            String query = "Select productId,productName,price,ratings from example_product WHERE category = ? limit 1 offset "+panelCount;
            
            PreparedStatement pst = conn.prepareStatement(query);
             pst.setString(1, category); 
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int productIdenti = rs.getInt("productid");
                String productTag = rs.getString("productName");
                double price = rs.getDouble("price");
                int rates = rs.getInt("ratings");
                
            
                JPanel panel = new JPanel();
                panel.setBackground(new Color(236, 239, 241));
                panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                panel.setLayout(null);
                
              
              
                int xPosition = 90 + (panelCount % 3) * 430; 
                int yPosition = 20 + (panelCount / 3) * 350; 
                panel.setBounds(xPosition, yPosition, 230, 300);  
                 
          
             
                JLabel pImage = new JLabel();
                pImage.setBounds(40, 10, 150, 150);
                pImage.setBorder(BorderFactory.createLineBorder(Color.darkGray));   
                
                
                
                panel.add(pImage);

                JLabel pName = new JLabel (productTag);
                pName.setBounds(20,170,80,20);
                pName.setFont(new Font("Arial", Font.BOLD,12));
               
                
                JLabel pPrice = new JLabel (String.valueOf(price));
                pPrice.setBounds(20, 200, 80, 20);
               pPrice.setFont(new Font("Arial", Font.PLAIN, 12));
               pPrice.setForeground(Color.red);
              

                JLabel pRating= new JLabel(String.valueOf(rates));
                pRating.setBounds(20, 230, 90, 20);
                pRating.setFont(new Font ("Arial", Font.PLAIN, 12));
                pRating.setForeground(Color.GRAY);
              

               JButton addB = new JButton ("Add to Cart");
               addB.setBounds(100, 255, 100, 30);
                
          
            addB.addActionListener(e -> {
    try {
     
        if (userClass.getUserSession() == null || !userClass.getUserSession().containsKey("userId")) {
            JOptionPane.showMessageDialog(panel, "User session is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

      int userId = (int) userClass.getUserSession().get("userId");
        int quantity = 1; 

       
        System.out.println("Adding product to cart for userId: " + userId);

     
      
        orderClass.addToCart(productIdenti, userId, quantity);

       
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(panel, "Invalid userId format.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(panel, "An error occurred while adding the product to the cart.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});


                panel.add(addB);
                 panel.add(pName);
                panel.add(pPrice);
               panel.add(pRating);
                panel.add(addB);
                
               
            
                panelCount++;

//                  
                return panel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return null;
    }
    
  
    public void resetPanelCount() {
    panelCount = 0;
}
    
    public int getTotalProductCount(String category) {
    int totalCount = 0;
    try {
        String query = "SELECT count(*) FROM example_product where category = ?"; 
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, category);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalCount = rs.getInt(1);  
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return totalCount;
}
  
    
   public void addProduct(JButton but,String prName, double prPrice, int origStock, int rating,String prCat,JTextField pName,JTextField pPrice,JTextField origAvail,JComboBox prRate, JComboBox pCat){
     try{
        
             
         
             String checkExisitingValueQuery = "SELECT * FROM example_product WHERE productName = ?";
 Connection checkExisitingValueCon = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","12345");
             PreparedStatement checkExisitingValueState = checkExisitingValueCon.prepareStatement(checkExisitingValueQuery);         
             
             checkExisitingValueState.setString(1, pName.getText());
          
                ResultSet resultSet = checkExisitingValueState.executeQuery();
                
                
                if(resultSet.next()){
                
                String existingPro = resultSet.getString("productName");
                //Nested if
                if(prName.equals(existingPro)){
                
                 JOptionPane.showMessageDialog(null, "Product Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
                 pName.setText("");
               
                
                }
                
                }else{
           
                  
              if(prName.isEmpty() || prPrice <= 0 || origStock <= 0){
                       
                JOptionPane.showMessageDialog(but, "Fill out all the necessary info.");
                pName.setText("");
                pPrice.setText("");
                origAvail.setText("");
                prRate.setSelectedIndex(0);
               pCat.setSelectedIndex(0);
         
            
               }else{
                  
                 
                        String query = "INSERT INTO `example_product`(`productName`, `price`, `category`,`ratings`,`productOriginalStock`) VALUES (?,?,?,?,?)";
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testecom1","root","12345");
             PreparedStatement state = con.prepareStatement(query);
             state.setString(1, pName.getText());
             state.setString(2, pPrice.getText());
            state.setString(3, (String) pCat.getSelectedItem());
             state.setString(4, (String) prRate.getSelectedItem());
            state.setString(5, (String) prRate.getSelectedItem());
                 
                 JOptionPane.showMessageDialog(null, "Added Successfully");
                pName.setText("");
                pPrice.setText("");
                origAvail.setText("");
                prRate.setSelectedIndex(0);
               pCat.setSelectedIndex(0);
             state.executeUpdate();
         }
               }
             
             
             }catch(Exception ex){
                       System.out.println(ex);   

             }
     
    }
     
   
      
    
    
    
}

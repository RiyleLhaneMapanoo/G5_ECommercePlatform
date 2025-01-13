/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Raylen
 */
public class OrderClass {
    
   
      private int panelCount = 0;  
     private DefaultListModel<String> productListModel;  
    private JList<String> productList;
    
    
      public OrderClass(){
         
            
      productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
       
        
    }
       // Method to get the JList
    public JList<String> getProductList() {
        return productList;
    }
    
    
    public void addToCart(int productId, int userId, int quantity) {
    try {
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testecom1", "root", "12345");

     
        String checkQuery = "SELECT quantity FROM orders WHERE uzerId = ? AND itemId = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
        checkStmt.setInt(1, userId);
        checkStmt.setInt(2, productId);

        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            
            int currentQuantity = rs.getInt("quantity");
            int newQuantity = currentQuantity + quantity;

            String updateQuery = "UPDATE orders SET quantity = ? WHERE uzerId = ? AND itemId = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, userId);
            updateStmt.setInt(3, productId);

            int updateResult = updateStmt.executeUpdate();
            if (updateResult > 0) {
                JOptionPane.showMessageDialog(null, "Product quantity updated in cart!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update product quantity.");
            }
        } else {
           
            String insertQuery = "INSERT INTO orders (uzerId, itemId, quantity) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setInt(1, userId);
            insertStmt.setInt(2, productId);
            insertStmt.setInt(3, quantity);

            int result = insertStmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Product added to cart!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add product to cart.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
 public JPanel itemsInCart(int userId) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testecom1", "root", "12345");

        String query = "SELECT p.productId, p.productName, p.price, o.quantity FROM orders o " +
                       "JOIN example_product p ON o.itemId = p.productId WHERE o.uzerId = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(null);  
        cartPanel.setBackground(new Color(51, 0, 51));

        int yPosition = 20;  

      
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("productName");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");

            JPanel panel = new JPanel();
            panel.setBackground(new Color(236, 239, 241));
            panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            panel.setLayout(null);

           
            int xPosition = 30;  
            panel.setBounds(xPosition, yPosition, 1250, 200);  

            JLabel pName = new JLabel(productName);
            pName.setBounds(20, 20, 100, 20);
            pName.setFont(new Font("Arial", Font.BOLD, 16));

            JLabel pPrice = new JLabel("Price: " + String.valueOf(price));
            pPrice.setBounds(20, 50, 100, 20);
            pPrice.setFont(new Font("Arial", Font.PLAIN, 12));
            pPrice.setForeground(Color.red);

            JLabel pQuantity = new JLabel("Quantity: " + quantity);
            pQuantity.setBounds(20, 80, 100, 20);
            pQuantity.setFont(new Font("Arial", Font.PLAIN, 12));

            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(20, 110, 100, 50);
            removeButton.addActionListener(e -> {
                try {
                   // removeFromCart(productId, userId);
                    JOptionPane.showMessageDialog(panel, "Product removed from cart!");
                    panel.setVisible(false);  
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "An error occurred while removing the product from the cart.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

         
            panel.add(pName);
            panel.add(pPrice);
            panel.add(pQuantity);
            panel.add(removeButton);

          
            cartPanel.add(panel);

           
            yPosition += 230;  
        }

     
        return cartPanel;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    //add here
    
  public int getTotalItemsInCart(int userId) {
    int totalItems = 0;
    try {
       
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testecom1", "root", "12345");

     
        String query = "SELECT SUM(quantity) FROM orders WHERE uzerId = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, userId);  

       
        ResultSet rs = pst.executeQuery();

       
        if (rs.next()) {
            totalItems = rs.getInt(1);  
        }

        
        rs.close();
        pst.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalItems;
}

  

   
 }        
         


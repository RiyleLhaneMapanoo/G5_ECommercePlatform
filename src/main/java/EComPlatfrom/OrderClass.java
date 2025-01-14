/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       
      LinkedList<String> pNames = new LinkedList<>();  
          LinkedList<String> orderIds = new LinkedList<>();       
           LinkedList<String> quan = new LinkedList<>();       
           LinkedList<String> prodPrice = new LinkedList<>();  
           LinkedList<String> itemId = new LinkedList<>();
           
       private Connection conn; 
      public OrderClass(){
         
            
      productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
         connectToDatabase();
        
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
        
       // Method to get the JList
    public JList<String> getProductList() {
        return productList;
    }
    
    
    public void addToCart(int productId, int userId, int quantity) {
    try {
        Connection connection =  conn;
 
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
    

   
     LinkedList< LinkedList<String> > OrderDetail = new LinkedList<>();
     
      public LinkedList< LinkedList<String>> getOrderDetails() {
    
        return OrderDetail;
    }
      
    
public JPanel itemsInCart(int userId, UserClass userclass) {
    try {
        Connection conn =  this.conn;
        String query = "SELECT p.productId, p.productName, p.price, o.quantity ,o.orderID FROM orders o " +
                      "JOIN example_product p ON o.itemId = p.productId WHERE o.uzerId = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);  
        mainPanel.setBackground(new Color(51, 0, 51));
        int yOffset = 20;  
           
           OrderDetail.add(pNames);
         OrderDetail.add(orderIds);
         OrderDetail.add(quan);
         OrderDetail.add(prodPrice);
         OrderDetail.add(itemId);
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("productName");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            int orderId = rs.getInt("orderID");
            JPanel panel = new JPanel();
            panel.setBackground(new Color(236, 239, 241));
            panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            panel.setLayout(null);
            panel.setBounds(30, yOffset, 1250, 200);  
           
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

            JCheckBox addBox = new JCheckBox("ADD");
            addBox.setBounds(530, 150, 120, 50);

            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(20, 110, 100, 50);
            // Add components to panel
            panel.add(pName);
            panel.add(pPrice);
            panel.add(pQuantity);
            panel.add(removeButton);
            panel.add(addBox);

            mainPanel.add(panel);
            
              
            
       
            
            
            addBox.addActionListener(e -> {
                
                if(addBox.isSelected()){
                    System.out.println("checked");

            
           
                       pNames.add(productName);
                     orderIds.add(String.valueOf(orderId));
                      quan.add(String.valueOf(quantity));
                     prodPrice.add(String.valueOf(price));
                      itemId.add(String.valueOf(productId));
                      
                     
                   
                  
                } else {
                    System.out.println("NOT CHECKED");
                  pNames.remove(productName);
                     orderIds.remove(String.valueOf(orderId));
                      quan.remove(String.valueOf(quantity));
                     prodPrice.remove(String.valueOf(price));
                      itemId.remove(String.valueOf(productId));
                }
            });

            removeButton.addActionListener(e -> {
                try {
                    int k =  removeFromCart(productId, userId);
                    if (k!=1) {
                       JOptionPane.showMessageDialog(panel, "failed to remove product from cart!");
             
            } else {
                         
                    JOptionPane.showMessageDialog(panel, "Product removed from cart!");
                    panel.setVisible(false);  
                    mainPanel.remove(panel);
                    mainPanel.revalidate();
                    mainPanel.repaint();  
                 
            }
                 
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "An error occurred while removing the product from the cart.", 
                                               "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            yOffset += 220;  
        }
       
        mainPanel.setPreferredSize(new Dimension(1300, yOffset + 30));

        return mainPanel;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}



  public int removeFromCart(int productId, int userId) {
        int result = 0;

    try {
       
        Connection connection =  conn;

        String query = "DELETE FROM orders WHERE itemId = ? AND uzerId = ?";
     
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, productId);  
        pst.setInt(2, userId);   

      

      result = pst.executeUpdate();

       


    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while removing the product from the cart.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return result;

}
    
 public int getTotalItemsInCart(int userId) {
    int totalItems = 0;
    try {
       
        Connection connection = conn;

     
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


public JPanel itemsInCheckout(int orderId) {  
    try {   
        JPanel checkOutPanel = new JPanel(); 
        Connection conn = this.conn;
        String query = "SELECT p.productId, p.productName, p.price, o.quantity ,o.orderID FROM orders o " + 
                      "JOIN example_product p ON o.itemId = p.productId WHERE o.orderID=?"; 
        
        PreparedStatement pst = conn.prepareStatement(query); 
        pst.setInt(1, orderId); 
        ResultSet rs = pst.executeQuery(); 

        checkOutPanel.setLayout(null);   
        checkOutPanel.setBackground(new Color(51, 0, 51)); 

        while (rs.next()) {
            String productName = rs.getString("productName"); 
            double prodPrice = rs.getDouble("price");
            int prodQuantity = rs.getInt("quantity");
            double priceTotal = prodPrice*prodQuantity;
            
     
            JPanel panel = new JPanel(); 
            panel.setBackground(new Color(236, 239, 241)); 
            panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); 
            panel.setLayout(null); 
            panel.setBounds(80, 20, 950, 250);   // y-position will be adjusted in the calling code
            
            JLabel proNameDisp = new JLabel("Product Name: "); 
            proNameDisp.setFont(new Font("Arial", Font.PLAIN, 25)); 
            proNameDisp.setForeground(Color.BLACK); 
            proNameDisp.setBounds(20, 40, 200, 25); 
             panel.add(proNameDisp); 
             
             JLabel proPriceDisp = new JLabel("Product Price: ");
         proPriceDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceDisp.setForeground(Color.BLACK);
        proPriceDisp.setBounds(20,80,200,25);
           panel.add(proPriceDisp);
             
          JLabel proQuanDisp = new JLabel("Product Quantity: ");
         proQuanDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proQuanDisp.setForeground(Color.BLACK);
        proQuanDisp.setBounds(20,120,300,25);
            panel.add(proQuanDisp);
         
         JLabel proPriceTotalDisp = new JLabel("Product Price Total: ");
         proPriceTotalDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceTotalDisp.setForeground(Color.BLACK);
        proPriceTotalDisp.setBounds(20,160,300,25);
     panel.add(proPriceTotalDisp);
 
     
            JLabel pName = new JLabel(productName); 
            pName.setBounds(300, 40, 300, 25); 
            pName.setFont(new Font("Arial", Font.PLAIN, 25)); 
            panel.add(pName); 
            
            
            JLabel proPrice = new JLabel(String.valueOf(prodPrice));
         proPrice.setFont(new Font("Arial",Font.PLAIN,25));
        proPrice.setForeground(Color.BLACK);
        proPrice.setBounds(300,80,200,25);
        panel.add(proPrice);
         
          JLabel proQuan = new JLabel(String.valueOf(prodQuantity));
         proQuan.setFont(new Font("Arial",Font.PLAIN,25));
        proQuan.setForeground(Color.BLACK);
        proQuan.setBounds(300,120,300,25);
        panel.add(proQuan);
         
         JLabel proPriceTotal = new JLabel(String.valueOf(priceTotal));
         proPriceTotal.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceTotal.setForeground(Color.BLACK);
        proPriceTotal.setBounds(300,160,300,25);
             panel.add(proPriceTotal);
 
            
            checkOutPanel.add(panel); 
        }
        
        return checkOutPanel;
        
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
    return null; 
}

public String[] getUserDetails(int userId){
    String[] arr = new String[5];
          try {
              Connection conn =  this.conn;
              PreparedStatement pst = conn.prepareStatement("SELECT  full_name, email, address, contactnum FROM  usertable  WHERE id = ? ");
              pst.setInt(1, userId);
              
              ResultSet  rs= pst.executeQuery();
              while(rs.next()){
                  arr[0] = rs.getString("full_name");
                  arr[1] = rs.getString("email");
                  arr[2] = rs.getString("address");
                    arr[3] = rs.getString("contactnum");
              }
              
              
          } catch (SQLException ex) {
              Logger.getLogger(OrderClass.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          return arr;
}


public  void orderCheckOut(JFrame frame, int userId, 
                                LinkedList<Integer> itemId, LinkedList<Integer> quan,
                                LinkedList<Double> prodPrice, LinkedList<Double> priceTotal) {
    try {
        Connection conn =  this.conn;
        conn.setAutoCommit(false);
        try {
           
            String getMaxOrderId = "SELECT COALESCE(MAX(orderHistoryId) + 1, 1) FROM user_order_history WHERE usherId = ?";
            PreparedStatement maxOrderStmt = conn.prepareStatement(getMaxOrderId);
            maxOrderStmt.setInt(1, userId);
            ResultSet maxOrderRs = maxOrderStmt.executeQuery();
            
            int nextOrderId = 1;
            if (maxOrderRs.next()) {
                nextOrderId = maxOrderRs.getInt(1);
            }

            double totalAmount = priceTotal.stream().mapToDouble(Double::doubleValue).sum();
            
           
            String insertOrderHistory = "INSERT INTO user_order_history (orderHistoryId, usherId, totalAmount) VALUES (?, ?, ?)";
            PreparedStatement orderHistoryStmt = conn.prepareStatement(insertOrderHistory);
            orderHistoryStmt.setInt(1, nextOrderId);
            orderHistoryStmt.setInt(2, userId);
            orderHistoryStmt.setDouble(3, totalAmount);
            orderHistoryStmt.executeUpdate();

           
            String insertOrderDetails = "INSERT INTO user_order_details (orderHistoryId, usherId, itemId, quantity, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement orderDetailsStmt = conn.prepareStatement(insertOrderDetails);
            
            for (int i = 0; i < itemId.size(); i++) {
                orderDetailsStmt.setInt(1, nextOrderId);
                orderDetailsStmt.setInt(2, userId);
                orderDetailsStmt.setInt(3, itemId.get(i));
                orderDetailsStmt.setInt(4, quan.get(i));
                orderDetailsStmt.setDouble(5, prodPrice.get(i));
                orderDetailsStmt.executeUpdate();
                
                
                removeFromCart(itemId.get(i),  userId);
            }

            conn.commit();
            JOptionPane.showMessageDialog(frame, "Order Purchased Successfully!!! ");
           
            
        } catch (SQLException e) {
            conn.rollback();
            System.err.println("Error during order insertion: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    } catch (SQLException e) {
        System.err.println("Database connection error: " + e.getMessage());
        e.printStackTrace();
    }
}





    // Method to fetch data from the database

public  String[][] fetchOrderDetails() {
    String query = """
            SELECT uod.orderHistoryId,  ep.productName,  uod.quantity,  ep.price,    ep.category, (uod.quantity * ep.price) AS totalPriceFROM 
            user_order_details uod JOIN example_product ep ON uod.itemId = ep.productID;
            """;

    String[][] data = null;

    try (Connection conn = this.conn;
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs = stmt.executeQuery(query)) {

          rs.last(); 
        int rowCount = rs.getRow();
        rs.beforeFirst();

        data = new String[rowCount][6];

        // Populate the array with data from database
        int rowIndex = 0;
        while (rs.next()) {
            data[rowIndex][0] = String.valueOf(rs.getInt("orderHistoryId"));
            data[rowIndex][1] = rs.getString("productName");
            data[rowIndex][2] = String.valueOf(rs.getInt("quantity"));
            data[rowIndex][3] = String.valueOf(rs.getBigDecimal("price"));
            data[rowIndex][4] = rs.getString("category");
            data[rowIndex][5] = String.valueOf(rs.getBigDecimal("totalPrice"));
            rowIndex++;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data;
}


 }        
         




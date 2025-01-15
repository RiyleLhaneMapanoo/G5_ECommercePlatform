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
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Raylen
 */
public class ProductClass  {
   
  private UserClass userClass;
    public int panelCount = 0;  
   
    private Connection conn; 
  
  
 
  OrderClass orderClass = new OrderClass(userClass);
   
    public ProductClass(UserClass userClass){
          this.userClass = userClass;
  
         
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
  
    
   public void ImageSetupJLabel(String imgNme, JLabel lb,int wid, int hei){
       
   ImageIcon lbcon = new ImageIcon("src\\main\\java\\Images\\"+imgNme);
    Image scaledIcon = lbcon.getImage().getScaledInstance(wid, hei, Image.SCALE_SMOOTH);
     lb.setIcon(new ImageIcon(scaledIcon));

   }
   
    public void ImageSetupJButt(String imgNme, JButton jBut,int wid, int hei){
       
   ImageIcon lbcon = new ImageIcon("src\\main\\java\\Images\\"+imgNme);
    Image scaledIcon = lbcon.getImage().getScaledInstance(wid, hei, Image.SCALE_SMOOTH);
     jBut.setIcon(new ImageIcon(scaledIcon));

   }
    
    
   private String[] getSortedProductNames(String category) {
    ArrayList<String> productNames = new ArrayList<>();
    try {
        connectToDatabase();
        String query = "SELECT productName FROM example_product WHERE category = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, category);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            productNames.add(rs.getString("productName"));
        }
        
        String[] sortedNames = productNames.toArray(new String[0]);
        Arrays.sort(sortedNames);
        return sortedNames;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return new String[0];
    }
}


public void createProductPanelforBuyer(String category, JScrollPane scrollPane, JPanel catPanel,String selectedRating, String selectedPrice, String searchName) {
    try {
        connectToDatabase();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int panelCount = 0;
        
        StringBuilder queryBuilder = new StringBuilder("SELECT productId, productName, price, ratings FROM example_product WHERE category = ?");
        
      
       if (!searchName.trim().isEmpty()) {
    String[] sortedNames = getSortedProductNames(category);
    
    String searchNameLower = searchName.toLowerCase();
    
   
    String[] lowerSortedNames = Arrays.stream(sortedNames)
                                     .map(String::toLowerCase)
                                     .toArray(String[]::new);
    
    int searchIndex = Arrays.binarySearch(lowerSortedNames, searchNameLower);
    
    if (searchIndex >= 0) {
        
        queryBuilder.append(" AND LOWER(productName) = LOWER(?)");
    } else {
        catPanel.removeAll();
        catPanel.revalidate();
        catPanel.repaint();
        scrollPane.setViewportView(catPanel);
        return;
    }
}
        
        if (!selectedRating.equals("All")) {
            queryBuilder.append(" AND ratings = ?");
        }
        
        if (!selectedPrice.equals("All")) {
            switch (selectedPrice) {
                case "~50":
                    queryBuilder.append(" AND price <= 50");
                    break;
                case "51-100":
                    queryBuilder.append(" AND price BETWEEN 51 AND 100");
                    break;
                case "101-300":
                    queryBuilder.append(" AND price BETWEEN 101 AND 300");
                    break;
                case "301-600":
                    queryBuilder.append(" AND price BETWEEN 301 AND 600");
                    break;
                case "601-900":
                    queryBuilder.append(" AND price BETWEEN 601 AND 900");
                    break;
                case "901~":
                    queryBuilder.append(" AND price >= 901");
                    break;
            }
        }
        
        pst = conn.prepareStatement(queryBuilder.toString());
        
        int paramIndex = 1;
        pst.setString(paramIndex++, category);
        
        if (!searchName.trim().isEmpty()) {
            pst.setString(paramIndex++, searchName);
        }
        
        if (!selectedRating.equals("All")) {
            pst.setInt(paramIndex, Integer.valueOf(selectedRating));
        }
        
        rs = pst.executeQuery();
        
        catPanel.removeAll();
        
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("productName");
            double price = rs.getDouble("price");
            int ratings = rs.getInt("ratings");

            JPanel panel = new JPanel();
            panel.setBackground(new Color(236, 239, 241));
            panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            panel.setLayout(null);

            int xPosition = 90 + (panelCount % 3) * 430;
            int yPosition = 20 + (panelCount / 3) * 350;
            panel.setBounds(xPosition, yPosition, 230, 300);

            JLabel pImage = new JLabel();
            ImageSetupJLabel("swr.png", pImage, 150, 150);
            pImage.setBounds(40, 10, 150, 150);
            pImage.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            panel.add(pImage);

            JLabel pName = new JLabel(productName);
            pName.setBounds(20, 170, 80, 20);
            pName.setFont(new Font("Arial", Font.BOLD, 12));
            panel.add(pName);

            JLabel pPrice = new JLabel(String.valueOf(price));
            pPrice.setBounds(20, 200, 80, 20);
            pPrice.setFont(new Font("Arial", Font.PLAIN, 12));
            pPrice.setForeground(Color.red);
            panel.add(pPrice);

            JLabel pRating = new JLabel("Rating: " + ratings);
            pRating.setBounds(20, 230, 90, 20);
            pRating.setFont(new Font("Arial", Font.PLAIN, 12));
            pRating.setForeground(Color.GRAY);
            panel.add(pRating);

            JButton addB = new JButton("Add to Cart");
            addB.setBounds(100, 255, 100, 30);
            panel.add(addB);

            addB.addActionListener(e -> {
                try {
                    if (userClass.getUserSession() == null || !userClass.getUserSession().containsKey("userId")) {
                        JOptionPane.showMessageDialog(panel, "User session is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int userId = (int) userClass.getUserSession().get("userId");
                    int quantity = 1;

                    orderClass.productListCart(productId, userId, quantity);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "An error occurred while adding the product to the cart.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            catPanel.add(panel);
            panelCount++;
        }

        int totalProductCount = getTotalProductCount(category);
        catPanel.setPreferredSize(new Dimension(1200, 350 * (int) Math.ceil((double) totalProductCount / 3)));

        catPanel.revalidate();
        catPanel.repaint();

        scrollPane.setViewportView(catPanel);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
 
    
    
    public void resetPanelCount() {
    panelCount = 0;
}
    
    public int getTotalProductCount(String category) {
    int totalCount = 0;
    try {    connectToDatabase();
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
            connectToDatabase();
             String checkExisitingValueQuery = "SELECT * FROM example_product WHERE productName = ?";

 Connection checkExisitingValueCon = conn;
             PreparedStatement checkExisitingValueState = checkExisitingValueCon.prepareStatement(checkExisitingValueQuery);         

             
             checkExisitingValueState.setString(1, pName.getText());
          
                ResultSet resultSet = checkExisitingValueState.executeQuery();
                
                
                if(resultSet.next()){
                
                String existingPro = resultSet.getString("productName");
            
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

                   Connection con = conn;
             PreparedStatement state = con.prepareStatement(query);

             state.setString(1, pName.getText());
             state.setString(2, pPrice.getText());
            state.setString(3, (String) pCat.getSelectedItem());
             state.setString(4, (String) prRate.getSelectedItem());
            state.setString(5,origAvail.getText());
                 
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
     
   public JTable invTable(JTable table,DefaultTableModel model,JScrollPane SPtable,JFrame fr) {
        
        String[] invColumn = {"Product ID", "Product", "Price", "Category", "Original Quantity", "Stock Bought", "Current Stocks"};
        model = new DefaultTableModel(invColumn, 0);
      table = new JTable(model);
      table.getTableHeader().setReorderingAllowed(false);
      table.setDefaultEditor(Object.class, null);
      SPtable = new JScrollPane(table);
      
      
    SPtable.setBounds(150, 100, 1100, 500);
    
      fr.add(SPtable);
   
        String query = "SELECT productID, productName, price, category, productOriginalStock, productQuantityBought, productStockQuantityLeft FROM example_product";
    connectToDatabase();
        try (
               
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] invData = {
                    rs.getInt("productID"),
                    rs.getString("productName"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("productOriginalStock"),
                    rs.getInt("productQuantityBought"),
                    rs.getInt("productStockQuantityLeft")
                };
                model.addRow(invData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return table;
    }
      
 
  
    
    
}

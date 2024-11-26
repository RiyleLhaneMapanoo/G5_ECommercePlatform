/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addCartFunctionTest;


import EComPlatfrom.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


/**
 *
 * @author Raylen
 */
public class ProductClass  {
   
    private DefaultListModel<String> productListModel;  // For JList/ product list storage
    private JList<String> productList;
    private JPanel[] productPanels;  // Array to store panels
    private int panelCount = 0;  // To keep track of the panels added
    private Connection conn;  // Database connection
    int panelheight = 300;
   
    public ProductClass(){
        productPanels = new JPanel[50]; // number ng panel n pede ma-add. 
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        connectToDatabase();
         
    }

    private void connectToDatabase() {
        try {
            
            String url = "jdbc:mysql://localhost:3306/testecom1";
            String user = "root";
            String password = "1027";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    
    
     
    public JPanel createProductPanel(String category) {
        try {
            
            String query = "Select productId,productName,price,ratings from example_product WHERE category = ? limit 1 offset " + panelCount; // Get product by category rather
            
            PreparedStatement pst = conn.prepareStatement(query);
             pst.setString(1, category); 
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int productIdenti = rs.getInt("productid");
                String productTag = rs.getString("productName");
                double price = rs.getDouble("price");
                int rates = rs.getInt("ratings");

                // Create and customize the new JPanel
                JPanel panel = new JPanel();
                panel.setBackground(new Color(236, 239, 241));
                panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                
              
                // Set dynamic position based on panelCount
                int xPosition = 90 + (panelCount % 3) * 430;  // means three panels per ROW
                int yPosition = 20 + (panelCount / 3) * 350;  // adjust vertical spacing OF EACH panel
                panel.setBounds(xPosition, yPosition, 230, panelheight);  // Adjust size and position
 
               
                //DITO LAGAY YUNG NSA LOOB NG PRODUCT PANELS (ex, Name, Jlabel for photo, price, add to cart button etc)
                // Add product information from database
               // JLabel nameLabel = new JLabel(productTag);
               // JLabel priceLabel = new JLabel("$" + price);

                //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
              //  panel.add(nameLabel);
               // panel.add(priceLabel);

                // Add to product panels array and list
                productPanels[panelCount] = panel;
                productListModel.addElement("Product " + productIdenti + ": " + productTag);
                panelCount++;

                  
                return panel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
   // Method to get all panels
    public JPanel[] getPanel() {
        return productPanels;
    }
    
    
    // Method to get the JList
    public JList<String> getProductList() {
        return productList;
    }

   // Method to get panel count
    public int getPanelCount() {
        return panelCount;
    }
    
    //to reset panel count(for display ng product panels on their corresponding tab category)
    //pag wala kasi toh, di nya finifilter yung product panels sa corresponding tabs niya, regardless whether inadd mo n sila sa tab pane panel
    public void resetPanelCount() {
    panelCount = 0;
}
    
    public int getTotalProductCount(String category) {
    int totalCount = 0;
    try {
        String query = "SELECT count(*) FROM example_product where category = ?"; // Query to get the total count ng kung ilang products yung nsa category n yun
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, category);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalCount = rs.getInt(1);  // Get the count from the result set meaning 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return totalCount;
}
    

    
    
    //FOR MEMBERS: 
    // createProductPanel method is nagcrecreate ng JPanel based sa kung ilang product yung meron sa category na yun
    
    //getTotalProductCount method is yung nagbibilang ng kung ilang product yung meron na yun/ necessary pra maenable yung auto adjusting ng size ng
    // makeupPanel ntin which pinaglalagyan ng productPanel, so whenever maglagay tayo ng bagong product nagaadjust siya in accordance kung ilang product panel yung 
    //meron tayo. 
    //this line of code sa main page ntin "1200,350 * (int) Math.ceil((double) productClass.getTotalProductCount("Makeup") / 3)" is yung nageenable ng auto adjusment in which
    //productClass.getTotalProductCount("Makeup") / 3 is kinukuha kung ilang products yung meron sa category na yon tas dinidivide yun into 3 which is kung ilang panel 
    //yung meron dapat sa isang row. we use math.ceil para ma make sure na kahit hindi DIVISIBLE ng 3 yung products is magkakaroon prin sya ng row ksi nirouround up ng
    //math ceil and isang double into an integer. 
    //for example meron tayong 3 Products sa makeup category. ididivide sya sa 3 so and result ay 1 which means 1 row. page kunwari 4 products naman and magiging
    //result nya is 1.33, using Math.ceil will be 2 which means 2 rows.
}
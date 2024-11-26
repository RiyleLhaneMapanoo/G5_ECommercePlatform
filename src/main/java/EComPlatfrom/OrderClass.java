/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import javax.swing.*;

/**
 *
 * @author Raylen
 */
public class OrderClass {
    
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
}

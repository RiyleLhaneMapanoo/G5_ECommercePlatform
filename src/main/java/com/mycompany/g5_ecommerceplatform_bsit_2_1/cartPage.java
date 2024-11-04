
package com.mycompany.g5_ecommerceplatform_bsit_2_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class cartPage extends JFrame implements ActionListener {

    
    private JPanel panel, 
            imagePanel;
    private JLabel products;
    JScrollPane scrollPane;
   
    private JCheckBox cboxes[];
    
    private String images[] = {"product1.jpg","product2.jpg","product3.jpg","product4.jpg"};
    private JLabel pImages;
    
    private String names[] = {"Product1", "Product2", "Product3","Product4"};
    private JLabel pNames;
    
    private String prices[] = {"500", "500", "2000", "1500"};
    private JLabel pPrices;
    
    
    cartPage() {
       
        setTitle("Cart Page");
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        cboxes = new JCheckBox[images.length]; 
        
       
        
        for(int i = 0; i < images.length; i++) {
            
            ImageIcon pImageIcon = new ImageIcon(images[i]);
            ImageIcon productImages = new ImageIcon(pImageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            
    
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // set the position to the "LEFT", since the default pos is "CENTER"
            
            cboxes[i] = new JCheckBox();
            productPanel.add(cboxes[i]);
            
            pImages = new JLabel(productImages);
            productPanel.add(pImages);
            
            // creating another JPanel for the Information(to make the components horizontally aligned)
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            
            
            
            pNames = new JLabel("Name : "+names[i]);
            infoPanel.add(pNames);
            
            pPrices = new JLabel("Price : "+ Integer.valueOf(prices[i]));
            infoPanel.add(pPrices);
            
            // add JPanel for the Quantity
            JPanel qPanel = new JPanel();
            qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS));
            
            
            JButton btnMinus = new JButton("-");
            btnMinus.setFocusable(false);
         
            qPanel.add(btnMinus);
            
            qPanel.add(Box.createHorizontalStrut(10));
            
            JLabel pQuantity = new JLabel("1");
            qPanel.add(pQuantity);
            
            qPanel.add(Box.createHorizontalStrut(10)); // 10px spacing b/w "1" and "+"
            
            JButton btnAdd = new JButton("+");
            btnAdd.setFocusable(false);
        
            qPanel.add(btnAdd);
            
            qPanel.add(Box.createHorizontalStrut(10));  // 10px spacing b/w "+" and "Delete"
            
            ImageIcon deleteIcon = new ImageIcon("deleteIcon.png");
            ImageIcon deleteImage = new ImageIcon(deleteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            JButton btnDelete = new JButton(deleteImage);
            btnDelete.setBackground(Color.red);
            btnDelete.setFocusable(false);
            
            qPanel.add(btnDelete);
            
            JPanel productDetails = new JPanel();
            productDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
            productDetails.add(infoPanel);
            productDetails.add(qPanel);
            
            productPanel.add(productDetails);
            panel.add(productPanel);
        }
        
            scrollPane = new JScrollPane(panel);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 200);
        setLocationRelativeTo(null);
        setVisible(true);
       
        
  
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    
}
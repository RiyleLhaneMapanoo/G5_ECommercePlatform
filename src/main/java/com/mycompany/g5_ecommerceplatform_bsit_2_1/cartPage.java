
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
    
    private JButton btnMinus, btnAdd, btnDelete;
    private JLabel pQuantity;
    
    
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
            
            //Minus Button
            btnMinus = new JButton("-");
            btnMinus.setFocusable(false);
            qPanel.add(btnMinus);
            
            qPanel.add(Box.createHorizontalStrut(10));
            
            pQuantity = new JLabel("1");
            qPanel.add(pQuantity);
            
            qPanel.add(Box.createHorizontalStrut(10)); // 10px spacing b/w "1" and "+"
            
            //Add Button
            btnAdd = new JButton("+");
            btnAdd.setFocusable(false);
        
            qPanel.add(btnAdd);
            
            qPanel.add(Box.createHorizontalStrut(10));  // 10px spacing b/w "+" and "Delete"
            
            
            //Delete Button
            ImageIcon deleteIcon = new ImageIcon("deleteIcon.png");
            ImageIcon deleteImage = new ImageIcon(deleteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            btnDelete = new JButton(deleteImage);
            btnDelete.setBackground(Color.red);
            btnDelete.setFocusable(false);
            
            qPanel.add(btnDelete);
            
            JPanel productDetails = new JPanel();
            productDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
            productDetails.add(infoPanel);
            productDetails.add(qPanel);
            
            
            // Panel for subtotal
//            JPanel subTotalPanel = new JPanel();
//            subTotalPanel.setBackground(Color.CYAN);
//            panel.add(subTotalPanel);
            
            
            
            productPanel.add(productDetails);
            panel.add(productPanel);
        }
        
            JPanel subTotalPanel = new JPanel();
            
            
            JLabel lblsubTotal = new JLabel("Subtotal : ");
            subTotalPanel.add(lblsubTotal);
            
            JLabel subTotal = new JLabel("0");
            subTotalPanel.add(subTotal);
          
            scrollPane = new JScrollPane(panel);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            getContentPane().add(subTotalPanel, BorderLayout.SOUTH);
            
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
    }

    
}

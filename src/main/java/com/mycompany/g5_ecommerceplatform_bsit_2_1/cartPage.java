
package com.mycompany.g5_ecommerceplatform_bsit_2_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class cartPage extends JFrame implements ActionListener {

    
    private JPanel panel, 
            imagePanel;
    
    private JPanel[] imgProductPanel;
    
    private JLabel products;
    JScrollPane scrollPane;
   
    private JCheckBox cboxes[];
    
    private String images[] = {"product1.jpg","product2.jpg","product3.jpg","product4.jpg"};
    private JLabel pImages;
    
    private String names[] = {"Product1", "Product2", "Product3","Product4"};
    private JLabel pNames;
    
    private String prices[] = {"500", "500", "2000", "1500"};
    private JLabel pPrices;
    
    private JButton[] btnMinus, btnAdd, btnDelete;
    private int[] defaultQuantity;
    private JLabel[] pQuantity;
    
    private JLabel subTotal;
    
    private int total = 0;
    private int pQuantityCount = 0;
    cartPage() {
       
        setTitle("Cart Page");
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        imgProductPanel = new JPanel[images.length];
        cboxes = new JCheckBox[images.length]; 
        btnMinus = new JButton[images.length];
        btnAdd = new JButton[images.length];
        btnDelete = new JButton[images.length];
        defaultQuantity = new int[images.length];
        pQuantity = new JLabel[images.length];
        
        
        
       
        
        for(int i = 0; i < images.length; i++) {
            
            ImageIcon pImageIcon = new ImageIcon(images[i]);
            ImageIcon productImages = new ImageIcon(pImageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            
            
            // Panel for the checkboxes and product images
            imgProductPanel[i] = new JPanel();
            imgProductPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT)); // set the position to the "LEFT", since the default pos is "CENTER"
            
            cboxes[i] = new JCheckBox(); 
            imgProductPanel[i].add(cboxes[i]);
            
            pImages = new JLabel(productImages);
            imgProductPanel[i].add(pImages);
            
            
            // creating another JPanel for the Information(specifically name and price) to make the components vertically aligned
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            

            pNames = new JLabel("Name : "+names[i]);
            infoPanel.add(pNames);
            
            pPrices = new JLabel("Price : "+ Integer.valueOf(prices[i]));
            infoPanel.add(pPrices);
            
            
            // add JPanel for the Quantity to make the buttons and label horizontally aligned
            JPanel qPanel = new JPanel();
            qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS));
            
                   
            //Minus Button
            btnMinus[i] = new JButton("-");
            btnMinus[i].setFocusable(false);
            qPanel.add(btnMinus[i]);
            
            qPanel.add(Box.createHorizontalStrut(10)); // 10px spacing b/w "1" and "+"
            
            defaultQuantity[i] = 1; // default quantity
            
            pQuantity[i] = new JLabel("1");
            qPanel.add(pQuantity[i]);
            
            qPanel.add(Box.createHorizontalStrut(10)); // 10px spacing b/w "1" and "+"
            
            //Add Button
            btnAdd[i] = new JButton("+");
            btnAdd[i].setFocusable(false);
            qPanel.add(btnAdd[i]);
            
            qPanel.add(Box.createHorizontalStrut(10));  // 10px spacing b/w "+" and "Delete"
            
            
            //Delete Button
            ImageIcon deleteIcon = new ImageIcon("deleteIcon.png");
            ImageIcon deleteImage = new ImageIcon(deleteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            btnDelete[i] = new JButton(deleteImage);
            btnDelete[i].setBackground(Color.red);
            btnDelete[i].setFocusable(false);
            
            qPanel.add(btnDelete[i]);
            
            JPanel productDetails = new JPanel();
            productDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
            productDetails.add(infoPanel);
            productDetails.add(qPanel);
            
            imgProductPanel[i].add(productDetails);
            panel.add(imgProductPanel[i]);
            
            // Adding ActionListener
            cboxes[i].addActionListener(this);
            btnAdd[i].addActionListener(this);
            btnMinus[i].addActionListener(this);
            btnDelete[i].addActionListener(this);
        }
        
        
        
         // Panel for Back button, Subtotal and Checkout button
        
            JPanel botPanel = new JPanel();
            botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
        
            
            
                     
        // Back Button
        
            ImageIcon icon = new ImageIcon("back.png");
            ImageIcon backIcon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton btnBack = new JButton(backIcon);
            btnBack.setBackground(Color.PINK);
            
            botPanel.add(btnBack);
            
            
        // Subtotal
        
            JPanel subTotalPanel = new JPanel();
        
            JLabel lblSubTotal = new JLabel("Subtotal : ");
            subTotalPanel.add(lblSubTotal);
            subTotal = new JLabel("0");
            subTotalPanel.add(subTotal);
            
            botPanel.add(subTotalPanel);
            
            
        // Checkout
        
            JButton btnCheckOut = new JButton("Checkout");
            btnCheckOut.setBackground(Color.PINK);
            btnCheckOut.setFocusable(false);
            
            botPanel.add(btnCheckOut);
            
   
            
        
       
          
            scrollPane = new JScrollPane(panel);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            getContentPane().add(botPanel, BorderLayout.SOUTH);
            
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        total = 0; // reset total
        
        for(int i = 0; i < cboxes.length; i++) {
       
            if(e.getSource() == btnAdd[i]) {
                defaultQuantity[i]++;
                pQuantity[i].setText(String.valueOf(defaultQuantity[i]));
            }
            else if(e.getSource() == btnMinus[i]) {
                if(defaultQuantity[i] > 1) {
                    defaultQuantity[i]--;
                    pQuantity[i].setText(String.valueOf(defaultQuantity[i]));
                }
            }
            else if(e.getSource() == btnDelete[i]) {
                
                imgProductPanel[i].setVisible(false);
                cboxes[i].setSelected(false);
            }
            
             if(cboxes[i].isSelected()) {
                total+= Integer.parseInt(prices[i])* defaultQuantity[i];   
            }
        }
        
        subTotal.setText(String.valueOf(total));
        
    }

    
}

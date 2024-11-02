/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g5_ecommerceplatform_bsit_2_1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Raylen
 */
public class InventoryGUI extends JFrame {
     private JLabel bgLabel;
    private JPanel main;
    
    
    public InventoryGUI(){
    
  
   
    
        setTitle("ECommercePlatform");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
       
       main = new JPanel(); // Create the main JPanel
      
        main.setBackground(Color.WHITE); // Set a background color if needed
        main.setLayout(null);
         main.setBounds(0, 0, getWidth(), getHeight());
        add(main); // Add the panel to
        
    
    
    }
    
    
}

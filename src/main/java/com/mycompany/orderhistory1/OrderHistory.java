
package com.mycompany.orderhistory1;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.*;
import java.util.*;

public class OrderHistory extends JFrame{

   private  JTextArea txaHistory;
   private JLabel bgLabel, lblHistory, lblIcon;
   private JButton btnBAgain, btnReview, btnBack;
   private JScrollPane scrollPane;
 
            
    OrderHistory(){
        
        setTitle("Order History");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
     
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\user\\Pictures\\DSA GUI Layout\\mpbg.jpg");
        bgLabel = new JLabel(bgIcon);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        Image scaledImage = bgIcon.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH);
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(1385, 764, screenSize.width, screenSize.height);
        add(bgLabel);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(356, 242, 818, 431);
        bgLabel.add(scrollPane);
        
        btnBAgain =  new JButton("Buy Again");
        btnBAgain.setBounds(100, 509, 144, 38);
        btnBAgain.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnBAgain);
        
        btnReview =  new JButton("Review Order");
        btnReview.setBounds(100, 594, 144, 37);
        btnReview.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnReview);
        
        btnBack =  new JButton("Back");
        btnBack.setBounds(10, 10, 68, 22);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        bgLabel.add(btnBack);
        
    }
}
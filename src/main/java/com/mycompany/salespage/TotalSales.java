/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salespage;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class TotalSales extends JFrame {
    

    private JLabel lblBg,lblTotalSales , lblProductSold;
    private JPanel pnlist;
    private JTextArea jtTotalPrice;
    private JButton btnNext;
    TotalSales() {
        
       
      
        
        setTitle("Seller Sales Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setBackground(Color.green);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
         
     
         ImageIcon path = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\SalesPage\\src\\main\\java\\Image\\background.png");
       
          Image Img = path.getImage();
        Image newImg = Img.getScaledInstance(2500, 2500, Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImg);
    
        
         lblBg = new JLabel(image1);    
         lblBg.setBounds(0, 250, 2500, 2500);

         add(lblBg);

//        
//       
       
       
       
       pnlist = new JPanel();
        pnlist.setLayout(null);
        
       pnlist.setBounds(40, 110, 1225, 250);
       pnlist.setBackground(Color.red);
        
        
        
        String[] names = {"Names", "Address", "Category", "Product", "Quantity", "Price"};
        Object[][] data = {
            {" ", " ", "Clothes", "Polo", " ", " "},
            {" ", " ", " School Supplies", "Pencil ", " ", " "},
            {" ", " ", "Clothes", "Short", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},};

        DefaultTableModel model = new DefaultTableModel(data, names);
        JTable table = new JTable(model);
         table.setDefaultEditor(Object.class,  null);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(15, 10, 1200, 230);
        
        pnlist.add(scroll);
        
      lblBg.add(pnlist);
        add(lblBg);
        
      lblTotalSales = new JLabel("TOTAL SALES");
      lblTotalSales.setForeground(Color.WHITE); // text color
        lblTotalSales.setFont(new Font("Arial", Font.BOLD, 24)); // text font/style
        lblTotalSales.setBounds(50, 410, 500, 50);
        lblBg.add(lblTotalSales);
        
         lblProductSold = new JLabel("Product Sold");
      lblProductSold.setForeground(Color.WHITE); // text color
        lblProductSold.setFont(new Font("Arial", Font.BOLD, 24)); // font/style
        lblProductSold.setBounds(50, 30, 500, 50);
        lblBg.add(lblProductSold);
        
        jtTotalPrice = new JTextArea();
        jtTotalPrice.setBounds(50, 480, 500, 100);
        lblBg.add(jtTotalPrice);
        
        btnNext = new JButton("Next");
        btnNext.setBounds(1100, 550, 100, 50);
        lblBg.add(btnNext);
    }
}

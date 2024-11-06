/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salespage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class TotalSales extends JFrame implements ActionListener {
    

    private JLabel lblBg,lblTotalSales , lblProductSold;
    private JPanel pnlist;
    private JTextArea jtTotalPrice;
    private JButton btnNext,btnBack,btnShow;
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
        
       pnlist.setBounds(40, 110, 1225, 480);
       pnlist.setBackground(Color.red);
        
        
        
        String[] names = {"Names", "Address", "Category", "Product", "Quantity", "Price"};
        Object[][] data = {
            {" ", " ", "", "", " ", " "},
            {" ", " ", "  ", " ", " ", " "},
            {" ", " ", "", "", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},};

        DefaultTableModel model = new DefaultTableModel(data, names);
        JTable table = new JTable(model);
         table.setDefaultEditor(Object.class,  null);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(15, 10, 1200, 460);
        
        pnlist.add(scroll);
        
      lblBg.add(pnlist);
        add(lblBg);
        
     
        
         lblProductSold = new JLabel("Total Sales");
      lblProductSold.setForeground(Color.WHITE); // text color
        lblProductSold.setFont(new Font("Arial", Font.BOLD, 24)); // font/style
        lblProductSold.setBounds(50, 30, 500, 50);
        lblBg.add(lblProductSold);
        
       
        
        btnNext = new JButton("VIew Inventory");
        btnNext.setBounds(1100, 630, 200, 50);
        lblBg.add(btnNext);
    
        btnBack = new JButton("Back");
        btnBack.setBounds(980, 630,100, 50);
        lblBg.add(btnBack);
        
          btnShow = new JButton("Show");
        btnShow.setBounds(890, 630, 100, 50);
        lblBg.add(btnShow);
        
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
        
        
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNext){
            dispose();
        }
        
        
    }
}

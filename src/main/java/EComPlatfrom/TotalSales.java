/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class TotalSales extends JFrame implements ActionListener {
    

    private JLabel lblBg,lblTotalSales , lblProductSold;
    private JPanel pnlist;
    private JTextArea jtTotalPrice;
    private JButton btnBack,btnShow;
    private JTable table;
       UserClass us;
    TotalSales() {
        
       us = new UserClass();
      
        
        setTitle("Seller Sales Page");
         setSize(1385,764);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\sellerBackground.png")));
     setResizable(false);
     setLocationRelativeTo(null);
         
     
         ImageIcon path = new ImageIcon("src\\main\\java\\Images\\sellerBackground.png");
       
          Image Img = path.getImage();
        Image newImg = Img.getScaledInstance(1385, 764, Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImg);
    
        
         lblBg = new JLabel(image1);    
         lblBg.setBounds(0, 250, 2500, 2500);

         add(lblBg);


       
       
       
       pnlist = new JPanel();
        pnlist.setLayout(null);
        
       pnlist.setBounds(40, 110, 1225, 480);
       
        
     
        String[] names = {"productID", "user name", "Address","Email ","Category", "Product Name","Product Price", "Quantity", "Total Price"};
        String[][] saleData = us.fetchOrderDetails();
        DefaultTableModel model = new DefaultTableModel(saleData, names);
         table = new JTable(model);
         table.setDefaultEditor(Object.class,  null);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(15, 10, 1200, 460);
        
        pnlist.add(scroll);
        
      lblBg.add(pnlist);
        add(lblBg);
        
     
        
         lblProductSold = new JLabel("Total Sales");
      lblProductSold.setForeground(Color.WHITE); 
        lblProductSold.setFont(new Font("Arial", Font.BOLD, 24));
        lblProductSold.setBounds(50, 30, 500, 50);
        lblBg.add(lblProductSold);
        
       
        
//        btnNext = new JButton("VIew Inventory");
//        btnNext.setBounds(1100, 630, 200, 50);
//        lblBg.add(btnNext);
    
        btnBack = new JButton("Back");
        btnBack.setBounds(980, 630,100, 50);
        lblBg.add(btnBack);
        
       //ImageIcon refresh = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\SalesPage1\\src\\main\\java\\Image\\refresh.png");
        
        
        btnShow = new JButton("Refresh");
        btnShow.setBounds(860, 630, 100, 50);
        lblBg.add(btnShow);
        
       // btnNext.addActionListener(this);
        btnBack.addActionListener(this);
        btnShow.addActionListener(this);
            
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnShow){
              
              ImageIcon icon = new ImageIcon("src\\main\\java\\Images\\updated.png");
              
             
          Image Img2 = icon.getImage();
        Image newImg2 = Img2.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon image2 = new ImageIcon(newImg2);
              
              JOptionPane.showMessageDialog(null, "UPDATED", "UPDATE", JOptionPane.INFORMATION_MESSAGE, image2);
        }else if(e.getSource()==btnBack){
        
         eComPageSeller page = new eComPageSeller();
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
        }
        
    }
}


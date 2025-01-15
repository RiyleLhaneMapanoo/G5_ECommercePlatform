/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class TotalSales extends JFrame implements ActionListener {
    

    private JLabel lblBg,lblTotalSales , lblProductSold;
    private JPanel pnlist;
    private JTextArea jtTotalPrice;
    private JButton btnBack;
    private JTable table;
       OrderClass ord;
       
        private UserClass userClass;
    TotalSales() {
        this.userClass = userClass;
       ord = new OrderClass(userClass);
      
        
      setTitle("ECP-Platform");
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
         lblBg.setBounds(0, 100, 2500, 2500);

         add(lblBg);


       
       pnlist = new JPanel();
 
        
       pnlist.setBounds(40, 0, 1225, 480);
              pnlist.setLayout(null);
     
        String[] names = {"productID", "user name", "Address","Email ","Category", "Product Name","Product Price", "Quantity", "Total Price"};
        String[][] saleData = ord.fetchUserOrders();
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
        add(lblProductSold);
        
    
        btnBack = new JButton("Back");
        btnBack.setBounds(980, 630,100, 50);
      add(btnBack);
        
   
    
        btnBack.addActionListener(this);
      
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource()==btnBack){
        
         eComPageSeller page = new eComPageSeller();
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
        }
        
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Raylen
 */
public class checkoutPage extends JFrame implements ActionListener{
    
    private JLabel chckoutT,nameDisp,addDisp,emDisp,cpDisp,orderDisp;
    //for display of values from mysql database:
    private JLabel customerName,customerAdd,customerEm,customerCP,customerOrdID;
    private JPanel infoPan;
    
    //for product list panel panes
    private JScrollPane productPane;
    private JPanel productPanePanel,productPanels[];
    
    //jlabels inside productPanels
    private JLabel proNameDisp,proPriceDisp,proQuanDisp,proPriceTotalDisp;
    //jlabels for values of products
    private JLabel proName,proPrice,proQuan,proPriceTotal;
    private JButton bckbtn,purchasebtn;
    //subtotal value
    private JLabel subTotalDisp,subTotal;
    int subT = 0;
     private UserClass userClass;
    
    //for product class
    ProductClass pro = new ProductClass(userClass);
    //new update test
    checkoutPage(){
      setTitle("ECP-Platform");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setResizable(false);
        setLocationRelativeTo(null);
        
     chckoutT = new JLabel("Checkout");
    chckoutT.setFont(new Font("Arial",Font.PLAIN,50));
        chckoutT.setForeground(Color.WHITE);
        chckoutT.setBounds(550,20,300,55);
         add(chckoutT);
        
        infoPan = new JPanel();
        infoPan.setBackground(Color.WHITE);
        infoPan.setLayout(null);
        infoPan.setBounds(90, 90, 1200, 130);
        add(infoPan);
        
        nameDisp = new JLabel("Name: ");
         nameDisp.setFont(new Font("Arial",Font.PLAIN,25));
        nameDisp.setForeground(Color.BLACK);
        nameDisp.setBounds(20,20,100,25);
         infoPan.add(nameDisp);
         
          addDisp = new JLabel("Address: ");
         addDisp.setFont(new Font("Arial",Font.PLAIN,25));
        addDisp.setForeground(Color.BLACK);
        addDisp.setBounds(20,50,150,25);
         infoPan.add(addDisp);
         
            emDisp = new JLabel("Email: ");
         emDisp.setFont(new Font("Arial",Font.PLAIN,25));
        emDisp.setForeground(Color.BLACK);
        emDisp.setBounds(20,80,150,25);
         infoPan.add(emDisp);
         
        cpDisp = new JLabel("CP#: ");
        cpDisp.setFont(new Font("Arial",Font.PLAIN,25));
        cpDisp.setForeground(Color.BLACK);
        cpDisp.setBounds(600,20,150,25);
         infoPan.add(cpDisp);
         
           orderDisp = new JLabel("Order ID: ");
         orderDisp.setFont(new Font("Arial",Font.PLAIN,25));
        orderDisp.setForeground(Color.BLACK);
        orderDisp.setBounds(600,50,150,25);
         infoPan.add(orderDisp);
         
         //for value jlabelsss
         customerName = new JLabel("*customer name here*");
         customerName.setFont(new Font("Arial",Font.PLAIN,25));
        customerName.setForeground(Color.BLACK);
        customerName.setBounds(100,20,300,25);
         infoPan.add(customerName);
         
          customerAdd = new JLabel("*customer address here*");
         customerAdd.setFont(new Font("Arial",Font.PLAIN,25));
        customerAdd.setForeground(Color.BLACK);
        customerAdd.setBounds(120,50,300,25);
         infoPan.add(customerAdd);
         
             customerEm = new JLabel("*customer email here*");
         customerEm.setFont(new Font("Arial",Font.PLAIN,25));
        customerEm.setForeground(Color.BLACK);
        customerEm.setBounds(100,80,300,25);
         infoPan.add(customerEm);
         
            
        customerCP = new JLabel("*customer cp here*");
        customerCP.setFont(new Font("Arial",Font.PLAIN,25));
        customerCP.setForeground(Color.BLACK);
        customerCP.setBounds(660,20,300,25);
         infoPan.add(customerCP);
         
         customerOrdID = new JLabel("*customer cp here*");
         customerOrdID.setFont(new Font("Arial",Font.PLAIN,25));
        customerOrdID.setForeground(Color.BLACK);
        customerOrdID.setBounds(700,50,300,25);
         infoPan.add(customerOrdID);
        
         productPane = new JScrollPane();
         productPane.setBackground(Color.WHITE);
         productPane.setBounds(90, 240, 1200, 380);
         add(productPane);
         
         productPanePanel = new JPanel();
         productPanePanel.setBackground(Color.WHITE);
         productPanePanel.setPreferredSize(new Dimension(700,800));
         productPanePanel.setLayout(null);
       
         
         productPanels = new JPanel[3];
          for (int i = 0; i < 3; i++) {  
           productPanels[i] = new JPanel();
           productPanels[i].setBackground(Color.LIGHT_GRAY);
           productPanels[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           productPanels[i].setLayout(null);
          
          int yPosition = 20 + i * (300 + 30); 
           productPanels[i].setBounds(30, yPosition, 1100, 300);
           
           proNameDisp = new JLabel("Product Name: ");
         proNameDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proNameDisp.setForeground(Color.BLACK);
        proNameDisp.setBounds(20,40,200,25);
         productPanels[i].add(proNameDisp);
         
         proPriceDisp = new JLabel("Product Price: ");
         proPriceDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceDisp.setForeground(Color.BLACK);
        proPriceDisp.setBounds(20,80,200,25);
         productPanels[i].add(proPriceDisp);
         
          proQuanDisp = new JLabel("Product Quantity: ");
         proQuanDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proQuanDisp.setForeground(Color.BLACK);
        proQuanDisp.setBounds(20,120,300,25);
         productPanels[i].add(proQuanDisp);
         
         proPriceTotalDisp = new JLabel("Product Price Total: ");
         proPriceTotalDisp.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceTotalDisp.setForeground(Color.BLACK);
        proPriceTotalDisp.setBounds(20,160,300,25);
         productPanels[i].add(proPriceTotalDisp);
                 
         //jlabel for product value from database
         proName = new JLabel("*product name here*");
         proName.setFont(new Font("Arial",Font.PLAIN,25));
        proName.setForeground(Color.BLACK);
        proName.setBounds(190,40,300,25);
         productPanels[i].add(proName);
         
         proPrice = new JLabel("*product price here*");
         proPrice.setFont(new Font("Arial",Font.PLAIN,25));
        proPrice.setForeground(Color.BLACK);
        proPrice.setBounds(190,80,200,25);
         productPanels[i].add(proPrice);
         
          proQuan = new JLabel("*product quantity here*");
         proQuan.setFont(new Font("Arial",Font.PLAIN,25));
        proQuan.setForeground(Color.BLACK);
        proQuan.setBounds(220,120,300,25);
         productPanels[i].add(proQuan);
         
         proPriceTotal = new JLabel("*product price total here*");
         proPriceTotal.setFont(new Font("Arial",Font.PLAIN,25));
        proPriceTotal.setForeground(Color.BLACK);
        proPriceTotal.setBounds(250,160,300,25);
         productPanels[i].add(proPriceTotal);
                 
         
             productPanePanel.add(productPanels[i]);
             productPanePanel.revalidate();
             productPanePanel.repaint();
        }
         
         
      
        productPane.setViewportView(productPanePanel);
        
        bckbtn = new JButton("Back");
        bckbtn.setBounds(30, 660, 70, 50);
        add(bckbtn);
        
        purchasebtn = new JButton("Purchase");
         purchasebtn.setBounds(1200, 660, 100, 50);
        add(purchasebtn);
        
        subTotalDisp = new JLabel("Subtotal:");
        subTotalDisp.setFont(new Font("Arial",Font.PLAIN,50));
        subTotalDisp.setForeground(Color.WHITE);
        subTotalDisp.setBounds(520, 660, 400, 50);
        add(subTotalDisp);
        
        subTotal= new JLabel(String.valueOf(subT));
        subTotal.setFont(new Font("Arial",Font.PLAIN,50));
        subTotal.setForeground(Color.WHITE);
        subTotal.setBounds(730, 660, 400, 50);
        add(subTotal);
        
        bckbtn.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bckbtn){
        cartPage cart = new cartPage(userClass);
    cart.setVisible(true);
    cart.setSize(1385,764);
    cart.setLocationRelativeTo(null);
     dispose();
        }
        
    }
}

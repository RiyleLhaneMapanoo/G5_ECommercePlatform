/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
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
    private JPanel productPanePanel,productPanels, panel;
    
    //jlabels inside productPanels
    private JLabel proNameDisp,proPriceDisp,proQuanDisp,proPriceTotalDisp;
    //jlabels for values of products
    private JLabel proName,proPrice,proQuan,proPriceTotal;
    private JButton bckbtn,purchasebtn;
    private JScrollPane scrollPane;
    //subtotal value
    private JLabel subTotalDisp,subTotal;
    int userId;
    int subT = 0;
    
       LinkedList<String> pNames = new LinkedList<>();  
          LinkedList<Integer> orderIds = new LinkedList<>();       
           LinkedList<Integer> quan = new LinkedList<>();       
           LinkedList<Double> prodPrice = new LinkedList<>();  
           LinkedList<Integer> itemId = new LinkedList<>();
                    LinkedList<Double> priceTotal = new LinkedList<>();  
           LinkedList<LinkedList<String>> orderDetails = new LinkedList();
    
        
    
     private UserClass userClass;
      OrderClass ord = new OrderClass(userClass);
    int subtotal = 0;
    //for product class
    ProductClass pro = new ProductClass(userClass);
    //new update test
    checkoutPage(UserClass userClass, LinkedList<LinkedList<String>> order_details){
        
      this.userClass  = userClass;
      
      setTitle("ECP-Platform");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setResizable(false);
        setLocationRelativeTo(null);
          userId = -1;
    if (userClass != null) {
   
    if (userClass.getUserSession() != null && userClass.getUserSession().containsKey("userId")) {
        userId = (int) userClass.getUserSession().get("userId");
    } else {
     
        System.out.println("User session is null or does not contain 'userId'. Session: " + userClass.getUserSession()); //debugging purposes, dont remove just yet guys
        JOptionPane.showMessageDialog(panel, "User session is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  
    }
    } else {
    System.out.println("userClass is null! Check initialization.");//debugging purposes, dont remove just yet guys
    JOptionPane.showMessageDialog(panel, "User class is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
    return;  
    }
    
 
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
         
//           orderDisp = new JLabel("Order ID: ");
//         orderDisp.setFont(new Font("Arial",Font.PLAIN,25));
//        orderDisp.setForeground(Color.BLACK);
//        orderDisp.setBounds(600,50,150,25);
//         infoPan.add(orderDisp);
         
         //for value jlabelsss
            String[] userDetails =  ord.getUserDetails(userId);
     
         customerName = new JLabel(userDetails[0]);
         customerName.setFont(new Font("Arial",Font.PLAIN,25));
        customerName.setForeground(Color.BLACK);
        customerName.setBounds(110,20,300,25);
         infoPan.add(customerName);
         
             customerEm = new JLabel(userDetails[1]);
         customerEm.setFont(new Font("Arial",Font.PLAIN,25));
        customerEm.setForeground(Color.BLACK);
        customerEm.setBounds(110,80,300,25);
         infoPan.add(customerEm);
         
          customerAdd = new JLabel(userDetails[2]);
         customerAdd.setFont(new Font("Arial",Font.PLAIN,25));
        customerAdd.setForeground(Color.BLACK);
        customerAdd.setBounds(130,50,300,25);
         infoPan.add(customerAdd);
         
         
         
            
        customerCP = new JLabel(userDetails[3]);
        customerCP.setFont(new Font("Arial",Font.PLAIN,25));
        customerCP.setForeground(Color.BLACK);
        customerCP.setBounds(660,20,300,25);
         infoPan.add(customerCP);
         
//         customerOrdID = new JLabel("*customer cp here*");
//         customerOrdID.setFont(new Font("Arial",Font.PLAIN,25));
//        customerOrdID.setForeground(Color.BLACK);
//        customerOrdID.setBounds(700,50,300,25);
//         infoPan.add(customerOrdID);
        
         
         productPane = new JScrollPane();
         productPane.setBackground(Color.BLACK);
         productPane.setBounds(90, 240, 1200, 380);
         add(productPane);
         

         

productPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
productPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

productPanels = new JPanel();
productPanels.setLayout(null);
productPanels.setBackground(new Color(51, 0, 51));



//get product details from 2d linkedlistt


    orderDetails = order_details;
     pNames.clear();
        orderIds.clear();
        quan.clear();
        prodPrice.clear();
        itemId.clear();

        // Check if OrderDetail has the expected structure
        if (orderDetails.size() >= 5) {
            // Get each list from OrderDetail
            LinkedList<String> names = orderDetails.get(0);
            
            LinkedList<String> orders_ID =    orderDetails.get(1);
            LinkedList<String> quantities = orderDetails.get(2);
            LinkedList<String> prices = orderDetails.get(3);
            LinkedList<String> item_ID = orderDetails.get(4);
           
          LinkedList<Integer> order_Ids = new LinkedList<>();       
           LinkedList<Integer> quantity = new LinkedList<>();       
           LinkedList<Double> prod_Price = new LinkedList<>();  
           LinkedList<Integer> item_Id = new LinkedList<>();


                for(int i =0; i <orders_ID.size(); i++){
                    order_Ids.add(Integer.valueOf(orders_ID.get(i)));
                   
                    prod_Price.add(Double.valueOf(prices.get(i)));
                     quantity.add(Integer.valueOf(quantities.get(i)));
                    item_Id.add(Integer.valueOf(item_ID.get(i)));
                }   
            
              pNames.addAll(names);
              orderIds.addAll(order_Ids);
              quan.addAll(quantity);
              prodPrice.addAll(prod_Price);
              itemId.addAll(item_Id);
        }
        
        
        
    //            for (int i = 0; i < pNames.size(); i++) {
//            System.out.println("\nItem " + (i + 1) + ":");
    //            System.out.println("Product Name: " + pNames.get(i));
//           System.out.println("Order ID: " + orderIds.get(i));
//            System.out.println("Quantity: " + quan.get(i));
//            System.out.println("Price: " + prodPrice.get(i));
//            System.out.println("Product ID: " + itemId.get(i));
//        }
            
            
            
int totalItemsInCheckout = orderIds.size();
int heightPerPanel = 300; 

int totalHeight = orderIds.size() * 305; 
productPanels.setPreferredSize(new Dimension(1100, totalHeight));

int yOffset = 30;



for(int i = 0; i < orderIds.size(); i++) {
    
    Double total = prodPrice.get(i) *quan.get(i);
    //put indibidual item in panel
    priceTotal.add(total);
    
    ///calculate subtotal
   
    subtotal +=total;
    
    
    JPanel orderPanel = ord.itemsInCheckout(Integer.valueOf(orderIds.get(i)));
    if(orderPanel != null) {
        // Get the components from orderPanel and add them to mainPanel
        Component[] components = orderPanel.getComponents();
        for(Component comp : components) {
            if(comp instanceof JPanel) {
                JPanel productPanel = (JPanel)comp;
                // Adjust the y-position based on current offset
                productPanel.setLocation(productPanel.getX(), yOffset);
                productPanels.add(productPanel);
                yOffset +=305; 
            }
        }
    }
}


        
        


productPane.setViewportView(productPanels);
          

        subTotalDisp = new JLabel("Subtotal:");
        subTotalDisp.setFont(new Font("Arial",Font.PLAIN,50));
        subTotalDisp.setForeground(Color.WHITE);
        subTotalDisp.setBounds(520, 660, 400, 50);
        add(subTotalDisp);
        bckbtn = new JButton("Back");
        bckbtn.setBounds(30, 660, 70, 50);
        add(bckbtn);
        
        purchasebtn = new JButton("Purchase");
         purchasebtn.setBounds(1200, 660, 100, 50);
         purchasebtn.addActionListener(this);
        add(purchasebtn);
        
        
        
        subTotal= new JLabel(String.valueOf(subtotal));
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
        }else if(e.getSource()==purchasebtn){
            
            ord.orderCheckOut( this,userId,  itemId,quan, prodPrice,  priceTotal );
            
            eComPageUser cp = new eComPageUser(userClass);
            cp.setVisible(true);
            dispose();
        }
        
    }
}

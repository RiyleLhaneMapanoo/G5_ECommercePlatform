
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author Raylen
 */
public class cartPage  extends JFrame implements ActionListener{
    
         private JButton btnBack,btnCheckOut;
           private JLabel subTotal;
         private JPanel  botPanel,panel,productPanel,cartPanel, cartLoc;
         private JScrollPane scrollPane;
          String imageSource = "src\\main\\java\\Images\\";

         OrderClass ord = new OrderClass();
           private UserClass userClass;
        ProductClass pro = new ProductClass(userClass);
 
         int userId ;
       public cartPage(UserClass userClass){
          
           this.userClass = userClass;
           
       setTitle("Cart Page");
         setSize(1200, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setResizable(true);
        setLocationRelativeTo(null);
        
      
        
     userId = -1;
    if (userClass != null) {
   
    if (userClass.getUserSession() != null && userClass.getUserSession().containsKey("userId")) {
        userId = (int) userClass.getUserSession().get("userId");
    } else {
     
     
        JOptionPane.showMessageDialog(panel, "User session is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  
    }
    } else {

    JOptionPane.showMessageDialog(panel, "User class is not initialized. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
    return;  
    }
 

 scrollPane = new JScrollPane();
scrollPane.setBounds(20, 20, 1330, 650);
scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


cartPanel = new JPanel();
cartPanel.setLayout(null); 
cartPanel.setBackground(new Color(51, 0, 51));


cartPanel = ord.itemsInCart(userId,userClass);  


if (cartPanel != null) {
   
    int totalItemsInCart = ord.getTotalItemsInCart(userId); 
    cartPanel.setPreferredSize(new Dimension(1200, 200 * totalItemsInCart + 30));

    
    scrollPane.setViewportView(cartPanel);

   
    add(scrollPane);

  
    revalidate();
    repaint();
} else {
 
    JOptionPane.showMessageDialog(this, "No items in the cart.");
}


       
       // Panel for Back button, Subtotal and Checkout button
        
          botPanel = new JPanel();
        botPanel.setBackground(Color.WHITE);
        botPanel.setLayout(null);
        botPanel.setBounds(0, 695, 1385, 30);
         botPanel.setOpaque(false);
        add(botPanel);
        
        // Back Button
        
            ImageIcon icon = new ImageIcon(imageSource+"back.png");
            ImageIcon backIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
             btnBack = new JButton(backIcon);
            btnBack.setBackground(Color.PINK);
          btnBack.setBounds(0, 0, 100, 30);
            botPanel.add(btnBack);
            btnBack.addActionListener(this);
            
           // Subtotal
          
            JLabel lblSubTotal = new JLabel("Subtotal: ");
            lblSubTotal.setFont(new Font(null,Font.BOLD, 25));
            lblSubTotal.setForeground(Color.WHITE);
            lblSubTotal.setBounds(600, 0, 150, 30);
            botPanel.add(lblSubTotal);
            
            subTotal = new JLabel("0");
            subTotal.setForeground(Color.WHITE);
            subTotal.setFont(new Font(null,Font.BOLD, 25));
            subTotal.setBounds(710, 0, 150, 30);
            botPanel.add(subTotal);
            
           
            
            
        // Checkout 
            ImageIcon coIcon = new ImageIcon(imageSource+"checkout-icon.png");
           ImageIcon coImage = new ImageIcon(coIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
            btnCheckOut = new JButton("Checkout");
            btnCheckOut.setBackground(Color.PINK);
             btnCheckOut.setForeground(Color.WHITE);
           btnCheckOut.setFont(new Font(null, Font.BOLD,20));
             btnCheckOut.setIcon(coImage);
            btnCheckOut.setHorizontalTextPosition(JButton.LEFT);
            btnCheckOut.setFocusable(false);
            btnCheckOut.setBounds(1180, 0, 200, 30);
             btnCheckOut.addActionListener(this);
            botPanel.add(btnCheckOut);
            
            
            
       
        
            
        
        
       }
       
      

 
  
       public static void main(String[]args){
           UserClass us = new UserClass();
           
                cartPage p  = new cartPage(us);
                JTextField t = new JTextField();
                   JPasswordField a = new JPasswordField();
               us.loginMethod(p,"s", "s", t, a);
       }
       

    @Override
    public void actionPerformed(ActionEvent e) {  
        
          if(e.getSource()==btnBack){
   eComPageUser page = new eComPageUser(userClass);
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
        
        }else if(e.getSource()==btnCheckOut){
            
           
            LinkedList<LinkedList<String>> orderDetails = ord.getOrderDetails();
               if(orderDetails.get(0).isEmpty()){
                   JOptionPane.showMessageDialog(this, " Please add items before check out ", "ERROR", JOptionPane.ERROR_MESSAGE );
               }else{
         checkoutPage page = new checkoutPage(userClass,orderDetails);
        page.setVisible(true);
        page.setSize(1385,764);
         page.setLocationRelativeTo(null);
         dispose(); 
         
               }
        }
    
    
}}

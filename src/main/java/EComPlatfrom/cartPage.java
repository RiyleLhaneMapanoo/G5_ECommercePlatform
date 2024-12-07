
package EComPlatfrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author Raylen
 */
public class cartPage  extends JFrame implements ActionListener{
    
         private JButton btnBack,btnCheckOut;
           private JLabel subTotal;
         private JPanel  botPanel,panel,productPanel;
         private JScrollPane scrollPane;
          String imageSource = "src\\main\\java\\Images\\";
         ProductClass pro = new ProductClass();
          
       cartPage(){
       setTitle("Cart Page");
         setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setResizable(false);
        setLocationRelativeTo(null);
        
        Border panelBorder = LineBorder.createBlackLineBorder();
        
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 20, 1330, 650);
         add(scrollPane);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1200,690));
        
        pro.cartItems(panel,3);
         
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
       scrollPane.setViewportView(panel);
          
       
        
       
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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    
}

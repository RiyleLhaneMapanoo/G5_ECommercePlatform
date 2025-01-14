

package EComPlatfrom;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author June-PC
 * @author Raylen
 */
public class eComPageSeller extends JFrame implements ActionListener {
//public class eco extends JFrame{
    private UserClass userClass;
   
   
   //from products class
   //from product class
     ProductClass productClass = new ProductClass(userClass);
     
    JButton productsButton, inventoryButton, salesButton, logoutButton;
    
    eComPageSeller(){

     setTitle("Seller's Profile");
     setSize(1385,764);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\sellerBackground.png")));
     setResizable(false);
     setLocationRelativeTo(null);
     
     

    JLabel title = new JLabel("SELLER'S PROFILE");
    title.setBounds(560, 50, 350, 300);
    title.setFont(new Font("Arial", Font.BOLD, 30));
    add(title);
    
    productsButton = new JButton("Add Products");
    productsButton.setBounds(520, 250, 350, 60);
    add(productsButton);

    inventoryButton = new JButton("Inventory");
    inventoryButton.setBounds(520, 350, 350, 60); 
    add(inventoryButton);

    salesButton = new JButton("Sales");
    salesButton.setBounds(520, 450, 350, 60);
    add(salesButton);

    logoutButton = new JButton("Logout");
    logoutButton.setBounds(520, 550, 350, 60); 
    add(logoutButton);

    productsButton.addActionListener(this);
    inventoryButton.addActionListener(this);
    salesButton.addActionListener(this);
    logoutButton.addActionListener(this);

      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == salesButton) {
        TotalSales page = new TotalSales();
        page.setVisible(true);
      
        page.setLocationRelativeTo(null);
        dispose();
    } else if (e.getSource() == inventoryButton) {
        inventoryPage page = new inventoryPage();
        page.setVisible(true);
      
        page.setLocationRelativeTo(null);
        dispose();
    } else if (e.getSource() == logoutButton) {
        LoginPage page = new LoginPage();
        page.setVisible(true);
      
        page.setLocationRelativeTo(null);
        dispose();
    } else if (e.getSource() == productsButton) {
        addProduct page = new addProduct();
        page.setVisible(true);
     
        page.setLocationRelativeTo(null);
        dispose();
    }

    }
}

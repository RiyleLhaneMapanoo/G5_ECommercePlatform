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
     
 //private ProductClass productClass;
    
    eComPageSeller(){

     setTitle("ECP-Platform");
     setSize(1385,764);
      setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\sellerBackground.png")));
    setResizable(false);
     setLocationRelativeTo(null);

     
     
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    

       
        
    }
}

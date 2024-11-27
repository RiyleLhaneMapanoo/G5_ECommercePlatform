
package EComPlatfrom;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class OrderHistory extends JFrame implements ActionListener{
    private int userId; 
   private  JTextArea txaHistory;
   private JLabel bgLabel, lblHistory, lblIcon;
   private JButton btnBAgain, btnReview, btnBack;
   private JScrollPane scrollPane;
   private JTable ohtable;
 
    UserClass userClass = new UserClass();
        
   String column;
    OrderHistory(){
        
        setTitle("Order History");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1385,764);
        setLayout(null);
        setResizable(false);
     
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Images\\mpbg.jpg");
        bgLabel = new JLabel(bgIcon);

       // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        Image scaledImage = bgIcon.getImage().getScaledInstance(1385,764, Image.SCALE_SMOOTH);
        
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(0, 0, 1385, 764);
        add(bgLabel);
        
        ohtable = new JTable(10, 4);
        ohtable.setBounds(350, 222, 825, 431);
        bgLabel.add(ohtable);
        
        btnBAgain =  new JButton("Buy Again");
        btnBAgain.setBounds(100, 509, 144, 38);
        btnBAgain.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnBAgain);
        
        btnReview =  new JButton("Review Order");
        btnReview.setBounds(100, 594, 144, 37);
        btnReview.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnReview);
        
        btnBack =  new JButton("Back");
        btnBack.setBounds(20, 20, 68, 22);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        bgLabel.add(btnBack);
        
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            
             eComPageUser page = new eComPageUser();
             page.setVisible(true);
             page.setSize(1385,764);
             page.setLocationRelativeTo(null);
             dispose();
        }
        
    }
}
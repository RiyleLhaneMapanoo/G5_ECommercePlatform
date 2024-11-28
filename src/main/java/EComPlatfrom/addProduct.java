package EComPlatfrom;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class addProduct extends JFrame implements ActionListener{
  
   private int userId; 
   private JTextArea txaHistory;
   private JLabel bgLabel, lblHistory, lblIcon;
   private JScrollPane spTable;
   private JTable ohtable;
   private JPanel plist;
   private JButton btnBAgain,btnupPht,btnBack;
   private String[] ohtableColumn;
   private Object[][] ohtableData;
   private DefaultTableModel ohtableMod;
 
    UserClass userClass = new UserClass();
        
    addProduct(){
        
        setTitle("Add Product");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1385,764);
        setLayout(null);
        setResizable(false);plist = new JPanel();
        
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Images\\addprdbgi.png");
        bgLabel = new JLabel(bgIcon);

       // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        Image scaledImage = bgIcon.getImage().getScaledInstance(1385,764, Image.SCALE_SMOOTH);
        
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(0, 0, 1385, 764);
        add(bgLabel);
        
        btnBAgain =  new JButton("Add Product");
        btnBAgain.setBounds(100, 509, 144, 38);
        btnBAgain.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnBAgain);
        
        btnupPht =  new JButton("Upload Photo");
        btnupPht.setBounds(100, 594, 144, 37);
        btnupPht.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(btnupPht);
        
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

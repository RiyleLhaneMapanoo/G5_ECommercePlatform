
package EComPlatfrom;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class OrderHistory extends JFrame implements ActionListener{
  
   private int userId; 
   private JTextArea txaHistory;
   private JLabel bgLabel, lblHistory;
   private JScrollPane spTable;
   private JTable ohtable;
   private JPanel plist;
   private JButton btnBack;
   private String[] ohtableColumn;
   private Object[][] ohtableData;
   private DefaultTableModel ohtableMod;
 
   private UserClass userClass;
   OrderClass ord;
        
    OrderHistory(UserClass userClass){
        this.userClass = userClass;
        ord = new OrderClass(userClass);
        setTitle("ECP-Platform");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Images\\mpbg.jpg");
        bgLabel = new JLabel(bgIcon);

      
        Image scaledImage = bgIcon.getImage().getScaledInstance(1385,764, Image.SCALE_SMOOTH);
        
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(0, 0, 1385, 764);
        add(bgLabel);
        
        ohtableColumn = new String[]{"Order ID", "Product Name", "Product Quantity","Product Price","Category","Total Price"}; 
   String[][] ohtableData = ord.fetchOrderDetails();

    
      
    
    ohtableMod  = new DefaultTableModel(ohtableData,ohtableColumn); 
  
    ohtable = new JTable(ohtableMod) {
     @Override
     public boolean isCellEditable(int row, int column) {
        return false; 
    }
    
    };
   
    ohtable.getTableHeader().setReorderingAllowed(false);
    spTable = new JScrollPane(ohtable);
    spTable.setBounds(350, 222, 825, 431);
    bgLabel.add(spTable);
        

        
        btnBack =  new JButton("Back");
        btnBack.setBounds(20, 20, 68, 22);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        bgLabel.add(btnBack);
        
        btnBack.addActionListener(this);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            
             eComPageUser page = new eComPageUser(userClass);
             page.setVisible(true);
             page.setSize(1385,764);
             page.setLocationRelativeTo(null);
             dispose();
             
        }
        
    }
   }

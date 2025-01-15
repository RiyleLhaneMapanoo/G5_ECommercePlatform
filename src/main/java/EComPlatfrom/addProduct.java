package EComPlatfrom;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.filechooser.*;

public class addProduct extends JFrame implements ActionListener{
  
     private UserClass userClass;
   private int userId; 
   private JTextArea txaHistory;
   private JLabel lblHistory, lblIcon, lblTitle, lblup, lblPname, lblPprice, lblPrating, lblPcategory, lblSA, bgLabel;
   private JScrollPane spTable;
   private JTable ohtable;
   private JPanel plist;
   private JButton btnBack, btnup, btnAddP;
   private String[] ohtableColumn;
   private Object[][] ohtableData;
   private DefaultTableModel ohtableMod;
   private JFileChooser fcupPht;
   private JTextField txfPname, txfPprice, txfSA;
   private JComboBox txfPcategory, txfPrating;
   String[] Pcategory = {"Makeup", "Clothes", "Kitchen", "School Supplies"};
   String[] PR = {"1", "2", "3", "4", "5"};
 
   ProductClass pr = new ProductClass(userClass);
   // UserClass userClass = new UserClass();
        
    addProduct(){
         
        setTitle("Add Product");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\sellerBackground.png")));
        
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Images\\addprdbgi.png");
        bgLabel = new JLabel(bgIcon);

        Image scaledImage = bgIcon.getImage().getScaledInstance(1385,764, Image.SCALE_SMOOTH);
        
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(0, 0, 1385, 764);
        add(bgLabel);
        
        lblTitle = new JLabel("ADD PRODUCT");
        lblTitle.setBounds(535, 20, 350, 50);
        lblTitle.setFont(new Font("Arial",Font.BOLD,45));
        bgLabel.add(lblTitle);
        
        lblPname = new JLabel("PRODUCT NAME:");
        lblPname.setBounds(80, 150, 250, 40);
        lblPname.setFont(new Font("Arial",Font.BOLD,18));
        bgLabel.add(lblPname);
        
        txfPname = new JTextField();
        txfPname.setBounds(255, 155, 250, 30);
        txfPname.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(txfPname);
          
        lblPprice = new JLabel("PRODUCT PRICE:");
        lblPprice.setBounds(80, 230, 250, 40);
        lblPprice.setFont(new Font("Arial",Font.BOLD,18));
        bgLabel.add(lblPprice);
        
        txfPprice = new JTextField();
        txfPprice.setBounds(255, 235, 250, 30);
        txfPprice.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(txfPprice);
        
        lblPcategory = new JLabel("PRODUCT CATEGORY:");
        lblPcategory.setBounds(80, 310, 250, 40);
        lblPcategory.setFont(new Font("Arial",Font.BOLD,18));
        bgLabel.add(lblPcategory);
        
        txfPcategory = new JComboBox(Pcategory);
        txfPcategory.setBounds(280, 315, 250, 30);
        lblPcategory.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(txfPcategory);
        
        lblPrating = new JLabel("PRODUCT RATING:");
        lblPrating.setBounds(80, 390, 250, 40);
        lblPrating.setFont(new Font("Arial",Font.BOLD,18));
        bgLabel.add(lblPrating);
        
        txfPrating = new JComboBox(PR);
        txfPrating.setBounds(275, 395, 250, 30);
        txfPrating.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(txfPrating);
        
        lblSA = new JLabel("STOCK AVAILABLE:");
        lblSA.setBounds(80, 470, 270, 50);
        lblSA.setFont(new Font("Arial",Font.BOLD,18));
        bgLabel.add(lblSA);
        
        txfSA = new JTextField();
        txfSA.setBounds(285, 475, 250, 30);
        txfSA.setFont(new Font("Arial",Font.BOLD,16));
        bgLabel.add(txfSA);
        
        btnBack =  new JButton("Back");
        btnBack.setBounds(780, 150, 144, 55);
        btnBack.setFont(new Font("Arial",Font.BOLD,17));
        bgLabel.add(btnBack);                                    
        
        btnAddP =  new JButton("Add Product");
        btnAddP.setBounds(780, 250, 155, 55);
        btnAddP.setFont(new Font("Arial",Font.BOLD,17));
        bgLabel.add(btnAddP);
        
        btnBack.addActionListener(this);
btnAddP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            
             eComPageSeller page = new eComPageSeller();
             page.setVisible(true);
             page.setSize(1385,764);
             page.setLocationRelativeTo(null);
             dispose();
   
        
       }else if(e.getSource()==btnAddP){
           try{
           
        String productName = txfPname.getText();
        double productPrice = Double.parseDouble(txfPprice.getText()); 
        int stockAvail = Integer.parseInt(txfSA.getText());
        int prRating = Integer.parseInt((String) txfPrating.getSelectedItem()); 
        String prCategory = (String) txfPcategory.getSelectedItem(); 
         
         //ctto stack overflow
         
            
        pr.addProduct(btnAddP,productName,productPrice,stockAvail,prRating,prCategory,txfPname,txfPprice,txfSA,txfPrating, txfPcategory);
           }catch(NumberFormatException ex){
           
           JOptionPane.showMessageDialog(this, "You have entered wrong values in the wrong text fields.");
             txfPname.setText("");
                txfPprice.setText("");
                txfSA.setText("");
                txfPrating.setSelectedIndex(0);
               txfPcategory.setSelectedIndex(0);
           }
    
       
       }
    }
}

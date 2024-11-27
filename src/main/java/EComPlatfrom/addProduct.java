package EComPlatfrom;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class addProduct extends JFrame implements ActionListener{
  
   private int userId; 
   private JTextArea txaHistory;
   private JLabel bgLabel, lblHistory, lblIcon, lblTitle, lblup, lblPname, lblPprice, lblPrating, lblPcategory, lblSA;
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
 
   ProductClass pr = new ProductClass();
   // UserClass userClass = new UserClass();
        
    addProduct(){
        
        setTitle("Add Product");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Images\\sellerBackground.png");
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
        txfPcategory.setBounds(300, 315, 250, 30);
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
        btnBack.setBounds(780, 570, 144, 40);
        btnBack.setFont(new Font("Arial",Font.BOLD,17));
        bgLabel.add(btnBack);
        
        btnup =  new JButton ("Upload Photo");
        btnup.setBounds(970, 570, 155, 40);
        btnup.setFont(new Font("Arial",Font.BOLD,17));
        lblup =  new JLabel ("************Picture************");
        lblup.setBounds(970, 580, 155, 37);
        lblup.setFont(new Font("Arial",Font.BOLD,12));
        bgLabel.add(btnup);
        bgLabel.add(lblup);
        
        btnAddP =  new JButton("Add Product");
        btnAddP.setBounds(870, 650, 155, 40);
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
           
           
        String productName = txfPname.getText();
        double productPrice = Double.parseDouble(txfPprice.getText()); 
        int stockAvail = Integer.parseInt(txfSA.getText());
        int prRating = Integer.parseInt((String) txfPrating.getSelectedItem()); 
        String prCategory = (String) txfPcategory.getSelectedItem(); 
         
         //ctto stack overflow
         
            
        pr.addToCart(btnAddP,productName,productPrice,stockAvail,prRating,prCategory,txfPname,txfPprice,txfSA,txfPrating, txfPcategory);
            
    
       
       }
    }
}

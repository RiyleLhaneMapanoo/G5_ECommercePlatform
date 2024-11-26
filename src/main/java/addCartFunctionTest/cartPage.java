
package addCartFunctionTest;

import EComPlatfrom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class cartPage extends JFrame implements ActionListener {

    
    private JPanel panel, 
            imagePanel;
    
    private JPanel[] imgProductPanel;
    
    private JLabel products;
    JScrollPane scrollPane;
   
    private JCheckBox cboxes[];
    
    private String images[] = {"product1.png","product2.png","product3.png","product4.png"};
    private JLabel pImages;
    
    private String names[] = {"Product1", "Product2", "Product3","Product4"};
    private JLabel pNames;
    
    private String prices[] = {"500", "500", "2000", "1500"};
    private JLabel pPrices;
    
    private JButton[] btnMinus, btnAdd, btnDelete;
    private JButton btnBack;
    private int[] defaultQuantity;
    private JLabel[] pQuantity;
    
    private JLabel subTotal;
    
    private int total = 0;
    private int pQuantityCount = 0;
    
    String imageSource = "src\\main\\java\\Images\\";
    
    cartPage() {
       
        setTitle("Cart Page");
        setResizable(false);
        
        ImageIcon bgIcon = new ImageIcon(imageSource+"background.png");
        ImageIcon bgImage = new ImageIcon(bgIcon.getImage().getScaledInstance(1385,764, Image.SCALE_SMOOTH));
        JLabel bgLbl = new JLabel(bgImage);
        bgLbl.setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        
        imgProductPanel = new JPanel[images.length];
        cboxes = new JCheckBox[images.length]; 
        btnMinus = new JButton[images.length];
        btnAdd = new JButton[images.length];
        btnDelete = new JButton[images.length];
        defaultQuantity = new int[images.length];
        pQuantity = new JLabel[images.length];
        
        
        
       
        
        for(int i = 0; i < images.length; i++) {
            
            ImageIcon pImageIcon = new ImageIcon(imageSource+images[i]);
            ImageIcon productImages = new ImageIcon(pImageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            
            
            // Panel for the checkboxes and product images
            imgProductPanel[i] = new JPanel();
            imgProductPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT)); // set the position to the "LEFT", since the default pos is "CENTER"
            imgProductPanel[i].setOpaque(false);
            
            cboxes[i] = new JCheckBox(); 
            cboxes[i].setOpaque(false);
            imgProductPanel[i].add(cboxes[i]);
            
            
            pImages = new JLabel(productImages);
            imgProductPanel[i].add(pImages);
            
            
            // creating another JPanel for the Information(specifically name and price) to make the components vertically aligned
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(true);
            

            pNames = new JLabel("Name : "+names[i]);
            pNames.setForeground(Color.WHITE);
            pNames.setFont(new Font(null,Font.BOLD, 25));
            infoPanel.add(pNames);
            
            pPrices = new JLabel("Price : "+ Integer.valueOf(prices[i]));
            pPrices.setForeground(Color.WHITE);
            pPrices.setFont(new Font(null,Font.BOLD, 25));
            infoPanel.add(pPrices);
            
            
            
            
            // add JPanel for the Quantity to make the buttons and label horizontally aligned
            JPanel qPanel = new JPanel();
            qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS));
            qPanel.setOpaque(false);
            
            qPanel.add(Box.createHorizontalStrut(80));
            
            //Minus Button
            ImageIcon minusIcon = new ImageIcon(imageSource+"minus-button.png");
            ImageIcon minusImage = new ImageIcon(minusIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            btnMinus[i] = new JButton(minusImage);
            btnMinus[i].setFocusable(false);
            btnMinus[i].setBorderPainted(false); // border : none
            btnMinus[i].setBackground(Color.PINK);
            qPanel.add(btnMinus[i]);
            
            qPanel.add(Box.createHorizontalStrut(20)); // 20px spacing b/w "1" and "-"
            
            defaultQuantity[i] = 1; // default quantity
            
            pQuantity[i] = new JLabel("1");
            pQuantity[i].setForeground(Color.WHITE);
            pQuantity[i].setFont(new Font(null,Font.BOLD, 25));
            qPanel.add(pQuantity[i]);
            
            qPanel.add(Box.createHorizontalStrut(20)); // 20px spacing b/w "1" and "+"
            
            //Add Button
            ImageIcon plusIcon = new ImageIcon(imageSource+"add-button.png");
            ImageIcon plusImage = new ImageIcon(plusIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            btnAdd[i] = new JButton(plusImage);
            btnAdd[i].setFocusable(false);
            btnAdd[i].setBackground(Color.PINK);
            btnAdd[i].setBorderPainted(false);
            qPanel.add(btnAdd[i]);
            
            qPanel.add(Box.createHorizontalStrut(30));  // 10px spacing b/w "+" and "Delete Button"
            
            
            //Delete Button
            ImageIcon deleteIcon = new ImageIcon(imageSource+"deleteIcon.png");
            ImageIcon deleteImage = new ImageIcon(deleteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            btnDelete[i] = new JButton(deleteImage);
            btnDelete[i].setBackground(Color.red);
            btnDelete[i].setFocusable(false);
            btnDelete[i].setBorderPainted(false);
            
            qPanel.add(btnDelete[i]);
            
            JPanel productDetails = new JPanel();
            productDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
            productDetails.setOpaque(false);
            productDetails.add(infoPanel);
            productDetails.add(qPanel);
            
            imgProductPanel[i].add(productDetails);
            imgProductPanel[i].setOpaque(false);
            panel.add(imgProductPanel[i]);
            
            // Adding ActionListener
            cboxes[i].addActionListener(this);
            btnAdd[i].addActionListener(this);
            btnMinus[i].addActionListener(this);
            btnDelete[i].addActionListener(this);
        }
        
            
            scrollPane = new JScrollPane(panel);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            
        
        
        
         // Panel for Back button, Subtotal and Checkout button
        
            JPanel botPanel = new JPanel();
            botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
            botPanel.setOpaque(false);
        
            
            
                     
        // Back Button
        
            ImageIcon icon = new ImageIcon(imageSource+"back.png");
            ImageIcon backIcon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
             btnBack = new JButton(backIcon);
            btnBack.setBackground(Color.PINK);
            btnBack.setBorderPainted(false);
            botPanel.add(btnBack);
            btnBack.addActionListener(this);
            
        // Subtotal
        
            JPanel subTotalPanel = new JPanel();
            subTotalPanel.setOpaque(false);
        
            JLabel lblSubTotal = new JLabel("Subtotal : ");
            lblSubTotal.setFont(new Font(null,Font.BOLD, 25));
            lblSubTotal.setForeground(Color.WHITE);
            subTotalPanel.add(lblSubTotal);
            
            subTotal = new JLabel("0");
            subTotal.setForeground(Color.WHITE);
            subTotal.setFont(new Font(null,Font.BOLD, 25));
            subTotalPanel.add(subTotal);
            
            botPanel.add(subTotalPanel);
            
            
        // Checkout
            ImageIcon coIcon = new ImageIcon(imageSource+"checkout-icon.png");
            ImageIcon coImage = new ImageIcon(coIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
            JButton btnCheckOut = new JButton("Checkout");
            btnCheckOut.setBackground(Color.PINK);
            btnCheckOut.setForeground(Color.WHITE);
            btnCheckOut.setFont(new Font(null, Font.BOLD,20));
            btnCheckOut.setIcon(coImage);
            btnCheckOut.setHorizontalTextPosition(JButton.LEFT);
            btnCheckOut.setFocusable(false);
            btnCheckOut.setBorderPainted(false); // border : none
            botPanel.add(btnCheckOut);
            
   
            
        
       
          bgLbl.add(scrollPane, BorderLayout.CENTER);
          bgLbl.add(botPanel, BorderLayout.SOUTH);
            
          add(bgLbl);
            
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
          
        pack();
        setLocationRelativeTo(null);
        
      
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
        
        total = 0; // reset total
        
        for(int i = 0; i < cboxes.length; i++) {
       
            if(e.getSource() == btnAdd[i]) {
                defaultQuantity[i]++;
                pQuantity[i].setText(String.valueOf(defaultQuantity[i]));
            }
            else if(e.getSource() == btnMinus[i]) {
                if(defaultQuantity[i] > 1) {
                    defaultQuantity[i]--;
                    pQuantity[i].setText(String.valueOf(defaultQuantity[i]));
                }
            }
            else if(e.getSource() == btnDelete[i]) {
                
                imgProductPanel[i].setVisible(false);
                cboxes[i].setSelected(false);
            }
            
             if(cboxes[i].isSelected()) {
                total+= Integer.parseInt(prices[i])* defaultQuantity[i];   
            }
        }
        
        subTotal.setText(String.valueOf(total));
        
       
        
        
    }

    
}

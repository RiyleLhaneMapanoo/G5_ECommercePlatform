/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

import EComPlatfrom.eComPageSeller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raylen
 */
public class inventoryPage extends JFrame implements ActionListener{
    
    
    private JScrollPane SPtable;
    private JTable inv;
    private String[] invColumn;
    private Object[][] invData;
    private DefaultTableModel invMod;
    
    private JButton backBut;
    private JLabel invDisp;
    
      private UserClass userClass;
   
    inventoryPage(){
        setTitle("ECP-Platform");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\sellerBackground.png")));
        setResizable(false);
        setLocationRelativeTo(null);
       
        ProductClass productClass = new ProductClass(userClass);
        
        invDisp = new JLabel("Inventory");
        invDisp.setFont(new Font("Arial",Font.PLAIN,50));
        invDisp.setForeground(Color.WHITE);
        invDisp.setBounds(550,20,300,55);
         add(invDisp);
        
    
    
        
    productClass.invTable(inv, invMod,SPtable,this);
    
    
    backBut = new JButton("Back");
    backBut.setBounds(1150, 600, 100, 50);
    add(backBut);
    
   
    
    
    backBut.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==backBut){
        
           eComPageSeller page = new eComPageSeller();
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
        }
    }
}

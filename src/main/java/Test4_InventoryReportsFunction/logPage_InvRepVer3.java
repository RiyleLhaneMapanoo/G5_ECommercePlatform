/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test4_InventoryReportsFunction;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Raylen
 */
public class logPage_InvRepVer3 extends JFrame {
    
    private JButton addProds[],minusProds[],buyPro,addAvailProds[],updateQuan;
    private JLabel title,productlbl,pricelbl,priLabel1,priLabel2,priLabel3,quantitylbl,quanPro1,quanPro2,quanPro3,quantLeft,prod1QL,prod2QL,prod3QL;
    //Product update stock
    private JComboBox proCat,selectPro;

    //table
    private JScrollPane SPtable;
    private JTable inv;
    private String[] invColumn;
    private Object[][] invData;
    private DefaultTableModel invMod;
    
    //product
    private JCheckBox cpCheckBox,eyeCheckBox,noteCheckBox;
    private JTabbedPane productTab;
    
    //list
    private JList<String> checkedValues;
    
    //
    private JTextField inputStock;
    
    //ints
    private int intproduct1Count = 0;
    private int intproduct2Count = 0;
    private int intproduct3Count = 0;
    
    private int intproduct1StockAvail = 0;
    private int intproduct2StockAvail = 0;
    private int intproduct3StockAvail = 0;
    
    public logPage_InvRepVer3(){
    
     setSize(700,700);
    setLayout(null);
    setTitle("Inventory Report Function Test");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
   
    
    title = new JLabel("Inventory Reports");
    title.setBounds(250, 20, 150, 20);
    add(title);
    
    
    
    
    //Code for Table
    invColumn = new String[]{"Product ID","Product","Category","Original Quantity","Stock Bought","Current Stocks"}; //columns
    invData = new Object[][]{//row; where table data is
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
    };
    
    invMod  = new DefaultTableModel(invData,invColumn); //the model where u arrange the column and row
  
    inv = new JTable(invMod){
     @Override
     public boolean isCellEditable(int row, int column) {
        return false; 
    }//to make cells uneditable
    
    };//the table itself
    //inv.setFillsViewportHeight(true);//fills the entire table with bg color
    inv.getTableHeader().setReorderingAllowed(false);//so that table would not move
    SPtable = new JScrollPane(inv);//insert the table here to make it scroll-able
    SPtable.setBounds(20, 50, 600, 200);
    add(SPtable);
    
    
    
    //Products
    productlbl = new JLabel("Product");
    productlbl.setBounds(20, 400, 50, 20);
    add(productlbl);
   
    
    productTab = new JTabbedPane();
    productTab.setBounds(20, 425, 120, 180);
    
    
    JPanel gadget = new JPanel();
    cpCheckBox = new JCheckBox("Cellphone");
    gadget.add((cpCheckBox));
    
    JPanel makeup = new JPanel();
    eyeCheckBox = new JCheckBox("Eyeshadow");
    makeup.add(eyeCheckBox);
    
    JPanel schoolsup = new JPanel();
    noteCheckBox = new JCheckBox("Notebook");
    schoolsup.add(noteCheckBox);
    
    productTab.addTab("Gadget", gadget);
    productTab.addTab("Makeup", makeup);
    productTab.addTab("School Supplies", schoolsup);
    
    add(productTab);
    
    
    
    
    
    //Price
    pricelbl = new JLabel("Price");
    pricelbl.setBounds(150, 400, 50, 20);
    add(pricelbl);
    
    priLabel1 = new JLabel("P 1,000");
    priLabel1.setBounds(150, 450, 50, 20);
    add(priLabel1);
    
     priLabel2 = new JLabel("P 500");
    priLabel2.setBounds(150, 480, 50, 20);
    add(priLabel2);
    
     priLabel3 = new JLabel("P 100");
    priLabel3.setBounds(150, 510, 50, 20);
    add(priLabel3);
    
    
    
    //Quantity
     quantitylbl = new JLabel("Quantity");
    quantitylbl.setBounds(250, 400, 50, 20);
    add(quantitylbl);
    
   
   //(Quantity Prod 1)
    quanPro1 = new JLabel("0");
    quanPro1.setBounds(273, 450, 50, 20);
    add(quanPro1);
    
   
    //(Quantity Prod 2)
    quanPro2 = new JLabel("0");
    quanPro2.setBounds(273, 480, 50, 20);
    add(quanPro2);
    
    
    //(Quantity Prod 3)
    quanPro3 = new JLabel("0");
    quanPro3.setBounds(273, 510, 50, 20);
    add(quanPro3);
      
    
    addProds = new JButton[] {
    new JButton("+"),
    new JButton("+"),
    new JButton("+")
   };
    for (int i = 0; i < addProds.length; i++) {
            addProds[i].setFont(new Font("Segoe UI",Font.PLAIN,12));
            addProds[i].setBounds(220, 450 + (i * 30), 42, 23); // Positioning checkboxes vertically; basically what this does is automatically add and position newly created check boxes by adding a gap of 30 each
           
            
            add(addProds[i]); // Add each checkbox to the frame
        }
    
    addProds[0].addActionListener(e ->{
            intproduct1Count++;
              quanPro1.setText(String.valueOf(intproduct1Count));
    });//this is a lamba expression? google said that its a short way to implement a funcional interface; how does it work? i do not know also. why did i use it? recommended.
    addProds[1].addActionListener(e ->{
            intproduct2Count++;
              quanPro2.setText(String.valueOf(intproduct2Count));
    });
    addProds[2].addActionListener(e ->{
            intproduct3Count++;
              quanPro3.setText(String.valueOf(intproduct3Count));
    });
    
    
    minusProds = new JButton[] {
    new JButton("-"),
    new JButton("-"),
    new JButton("-")
   };
    for (int i = 0; i < minusProds.length; i++) {
            minusProds[i].setFont(new Font("Segoe UI",Font.PLAIN,12));
            minusProds[i].setBounds(290, 450 + (i * 30), 42, 23); // Positioning checkboxes vertically; basically what this does is automatically add and position newly created check boxes by adding a gap of 30 each
            add(minusProds[i]); // Add each checkbox to the frame
        }
    minusProds[0].addActionListener(e ->{
         if(intproduct1Count <= 0){
        JOptionPane.showMessageDialog(this, "Please add first", "ERROR: Product Quantity is 0", JOptionPane.ERROR_MESSAGE);
        }  else{
         intproduct1Count--;
              quanPro1.setText(String.valueOf(intproduct1Count));
         }
    });
    minusProds[1].addActionListener(e ->{
           if(intproduct2Count <= 0){
        JOptionPane.showMessageDialog(this, "Please add first", "ERROR: Product Quantity is 0", JOptionPane.ERROR_MESSAGE);
        }  else{
         intproduct2Count--;
              quanPro2.setText(String.valueOf(intproduct2Count));
         }
    });
    minusProds[2].addActionListener(e ->{
         if(intproduct3Count <= 0){
        JOptionPane.showMessageDialog(this, "Please add first", "ERROR: Product Quantity is 0", JOptionPane.ERROR_MESSAGE);
        }  else{
         intproduct3Count--;
              quanPro3.setText(String.valueOf(intproduct3Count));
         }
    });
    
    
    //Quantity Left
    quantLeft = new JLabel("Quantity Available");
    quantLeft.setBounds(350, 400, 120, 20);
    add(quantLeft);
    
    prod1QL = new JLabel("0");
    prod1QL.setBounds(380, 450, 50, 20);
    add(prod1QL);
    
    prod2QL = new JLabel("0");
    prod2QL.setBounds(380, 480, 50, 20);
    add(prod2QL);
    
    prod3QL = new JLabel("0");
    prod3QL.setBounds(380, 510, 50, 20);
    add(prod3QL);
    
    
    //For buttons to manually add product; erased due to function inefficiency
    /*addAvailProds = new JButton[] {
    new JButton("+"),
    new JButton("+"),
    new JButton("+")
   };
    for (int i = 0; i < addAvailProds.length; i++) {
            addAvailProds[i].setBounds(400, 450 + (i * 30), 50, 20); // Positioning checkboxes vertically; basically what this does is automatically add and position newly created check boxes by adding a gap of 30 each
            add(addAvailProds[i]); // Add each checkbox to the frame
        }*/
    
    
    
    //Purchase Butt
    buyPro = new JButton("Purchase");
    buyPro.setBounds(380, 560, 100, 30);
    add(buyPro);
    
    
    buyPro.addActionListener(e -> {
    // Map to store categories and their associated checkboxes
    Map<String, JCheckBox[]> categoryMap = new HashMap<>();
    
    // Populate the map with categories and corresponding checkboxes
    categoryMap.put("Gadget", new JCheckBox[]{cpCheckBox});
    categoryMap.put("Makeup", new JCheckBox[]{eyeCheckBox});
    categoryMap.put("School Supplies", new JCheckBox[]{noteCheckBox});
    // Add more categories and checkboxes here as needed

    
    try {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/logregtest", "root", "1027");

        String query = "INSERT INTO inventorytesttable1 (Product, Category) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Loop through each category and its checkboxes
        for (Map.Entry<String, JCheckBox[]> entry : categoryMap.entrySet()) {
            String category = entry.getKey();
            JCheckBox[] checkBoxes = entry.getValue();

            // Insert selected items in the current category
            for (JCheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    preparedStatement.setString(1, checkBox.getText());
                    preparedStatement.setString(2, category);
                    preparedStatement.executeUpdate();
                }
            }
        }

        connection.close();
    } catch (Exception exception) {
        exception.printStackTrace();
    }
});

    

    
    
    
    
    //Update Stock Quantity
    updateQuan = new JButton("Update Stock Quantity");
    updateQuan.setBounds(500, 560, 160, 30);
    add(updateQuan);
    
    
    JLabel updateStocklbl = new JLabel("Update Stock Quantity: ");    
    updateStocklbl.setBounds(500, 400, 250, 20);
    add(updateStocklbl);
    
    inputStock = new JTextField();
    inputStock.setBounds(500,  430, 50, 20);
    add(inputStock);
    
    JLabel updateStocklbl1 = new JLabel("Select Product Category");
    updateStocklbl1.setBounds(500,  450, 250, 20);
    add(updateStocklbl1);
    
    proCat = new JComboBox();
    proCat.setBounds(500,  470, 120, 20);
    proCat.addItem("Test");
    proCat.addItem("test");
    add(proCat); 
    
    JLabel updateStocklbl2 = new JLabel("Select Product");
    updateStocklbl2.setBounds(500,  490, 120, 20);
    add(updateStocklbl2);
    
    selectPro = new JComboBox();
    selectPro.setBounds(500,  520, 120, 20);
    add(selectPro); 
    
    }
  
    
    
    
    public static void main(String[] args){
    
    logPage_InvRepVer3 l = new logPage_InvRepVer3();
    l.setVisible(true);
    l.setLocationRelativeTo(null);
    }
}

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
//SIRS ACTION PERFORMED METHOD
/**
 *
 * @author Raylen
 */
public class logPage_InvRepVer5 extends JFrame implements ActionListener{
    
    private JButton addProds[],minusProds[],buyPro,addAvailProds[],updateQuan;
    private JLabel title,productlbl,pricelbl,priLabel1,priLabel2,priLabel3,quantitylbl,quanPro[],quantLeft,prodQL[];
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
    
   private int origStockValue;
    
    public logPage_InvRepVer5(){
    
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
    
   quanPro = new JLabel[] {
    new JLabel("0"),
    new JLabel("0"),
    new JLabel("0")
   };
    for (int i = 0; i < quanPro.length; i++) {
            quanPro[i].setFont(new Font("Segoe UI",Font.PLAIN,12));
            quanPro[i].setBounds(273, 450 + (i * 30), 50, 20); // Positioning checkboxes vertically; basically what this does is automatically add and position newly created check boxes by adding a gap of 30 each
            add(quanPro[i]); // Add each checkbox to the frame
   }
      
    
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
              quanPro[0].setText(String.valueOf(intproduct1Count));
    });//this is a lamba expression? google said that its a short way to implement a funcional interface; how does it work? i do not know also. why did i use it? recommended.
    addProds[1].addActionListener(e ->{
            intproduct2Count++;
              quanPro[1].setText(String.valueOf(intproduct2Count));
    });
    addProds[2].addActionListener(e ->{
            intproduct3Count++;
             quanPro[2].setText(String.valueOf(intproduct3Count));
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
             quanPro[0].setText(String.valueOf(intproduct1Count));
         }
    });
    
    minusProds[1].addActionListener(e ->{
           if(intproduct2Count <= 0){
        JOptionPane.showMessageDialog(this, "Please add first", "ERROR: Product Quantity is 0", JOptionPane.ERROR_MESSAGE);
        }  else{
         intproduct2Count--;
              quanPro[1].setText(String.valueOf(intproduct2Count));
         }
    });
    minusProds[2].addActionListener(e ->{
         if(intproduct3Count <= 0){
        JOptionPane.showMessageDialog(this, "Please add first", "ERROR: Product Quantity is 0", JOptionPane.ERROR_MESSAGE);
        }  else{
         intproduct3Count--;
              quanPro[2].setText(String.valueOf(intproduct3Count));
         }
    });
    
    
    
    //Quantity Left
    quantLeft = new JLabel("Quantity Available");
    quantLeft.setBounds(350, 400, 120, 20);
    add(quantLeft);
    
    
    
    prodQL = new JLabel[] {
    new JLabel("0"),
    new JLabel("0"),
    new JLabel("0")
   };
    for (int i = 0; i < prodQL.length; i++) {
            prodQL[i].setFont(new Font("Segoe UI",Font.PLAIN,12));
            prodQL[i].setBounds(380, 450 + (i * 30), 50, 20); // Positioning checkboxes vertically; basically what this does is automatically add and position newly created check boxes by adding a gap of 30 each
            add(prodQL[i]); // Add each checkbox to the frame
   }
    
    
    
    
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
   
    proCat.addItem("Gadget");
    proCat.addItem("Makeup");
    proCat.addItem("School Supplies");
    proCat.addActionListener(this);
    add(proCat); 
    
    
    
    
    JLabel updateStocklbl2 = new JLabel("Select Product");
    updateStocklbl2.setBounds(500,  490, 120, 20);
    add(updateStocklbl2);
    
    selectPro = new JComboBox();
    selectPro.setBounds(500,  520, 120, 20);
    selectPro.addItem(cpCheckBox.getText());
    add(selectPro); 
    
    
    //Action Listeners
    buyPro.addActionListener(this);
    updateQuan.addActionListener(this);
    
    
    
    
    }
  
    public void actionPerformed(ActionEvent e){
   
    if(e.getSource()==updateQuan){
           updateOrigStock(selectPro,proCat,origStockValue);
     }else if(e.getSource()==buyPro){
    // Map to store categories and their associated checkboxes
    Map<String, Object[]> categoryMap = new HashMap<>();
    
    // Populate the map with categories and corresponding checkboxes
    categoryMap.put("Gadget", new Object[]{new JCheckBox[]{cpCheckBox}, new JLabel[]{quanPro[0]},new JLabel[]{prodQL[0]}});
    categoryMap.put("Makeup", new Object[]{new JCheckBox[]{eyeCheckBox}, new JLabel[]{quanPro[1]},new JLabel[]{prodQL[1]}});
    categoryMap.put("School Supplies",new Object[]{ new JCheckBox[]{noteCheckBox}, new JLabel[]{quanPro[2]},new JLabel[]{prodQL[2]}});
    // Add more categories and checkboxes here as needed

    
            
    try {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/logregtest", "root", "1027");

        String query = "INSERT INTO inventorytesttable1 (Product, Category,originalQuan,stockBought,currentAvail) VALUES (?, ?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Loop through each category and its checkboxes
        for (Map.Entry<String, Object[]> entry : categoryMap.entrySet()) {
            String category = entry.getKey();
            Object[] values = entry.getValue();
            JCheckBox[] productCB = (JCheckBox[]) values[0];
            JLabel[] prodStockBought = (JLabel[]) values[1];
            JLabel[] prodStockAvail = (JLabel[]) values[2];
            
             for (int i = 0; i < productCB.length; i++) {
                JCheckBox checkBox = productCB[i];
                JLabel prodSB = prodStockBought[i];
                JLabel prodSA = prodStockAvail[i];

                if (checkBox.isSelected()) {
                    try {
                        // Parse the text of the JLabel to an int
                        int prodSBValue = Integer.parseInt(prodSB.getText());
                         int prodSAValue = Integer.parseInt(prodSA.getText());
                         
                       // int originalStock = 
                         
                         
                         prodSAValue = origStockValue - prodSBValue;
                        

                        // Set the values to the prepared statement
                        preparedStatement.setString(1, checkBox.getText()); // Product name
                        preparedStatement.setString(2, category); // Category name
                          preparedStatement.setInt(3,origStockValue); // Category name
                        preparedStatement.setInt(4, prodSBValue); // Int value from JLabel
                        preparedStatement.setInt(5, prodSAValue); // Int value from JLabel

                        // Execute the insert statement
                        preparedStatement.executeUpdate();
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid integer value in JLabel: " + prodSB.getText());
                    }
                }
            }
        }

        connection.close();
    } catch (Exception exception) {
        exception.printStackTrace();
    }
    
    
    }
    
    
     proCat.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
    
        if(e.getStateChange()==ItemEvent.SELECTED){
        updateProductComboBoxes();
        }
    }
    
    });
     updateProductComboBoxes();
     
     
    
     
    }
    
    public void updateProductComboBoxes(){
    String selectedCat = (String) proCat.getSelectedItem();
     String productNames[] = {cpCheckBox.getText(),eyeCheckBox.getText(),noteCheckBox.getText()};
     
       selectPro.removeAllItems();
     if("Gadget".equals(selectedCat)){
     selectPro.addItem(productNames[0]);
     
     }else if("Makeup".equals(selectedCat)){
      selectPro.addItem(productNames[1]);
     }else if("School Supplies".equals(selectedCat)){
      selectPro.addItem(productNames[2]);
     }
    
    }
    public void updateOrigStock(JComboBox productItem,JComboBox categoryItem,int stockVal){
    
       String itemSelected = (String) productItem.getSelectedItem();
       String catSelected = (String) categoryItem.getSelectedItem();
        String stock = inputStock.getText();
        origStockValue = Integer.parseInt(stock);
        
        System.out.println("The original stock of: "+itemSelected+" in "+catSelected+" is "+origStockValue);
          
    
    }
    
    public static void main(String[] args){
    
    logPage_InvRepVer5 l = new logPage_InvRepVer5();
    l.setVisible(true);
    l.setLocationRelativeTo(null);
    }
}

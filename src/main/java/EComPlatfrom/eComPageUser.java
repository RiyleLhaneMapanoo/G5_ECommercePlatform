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
public class eComPageUser extends JFrame implements ActionListener {
    private int userId;
    private JPanel MainPanel,makeups,makeupPanel,clothes,clothespanel,
                kitchen,kitchenpanel,supplies,suppliespanel;
    

    private  JLabel platformname;
    private  JTextField searchBar;
    private  JButton btnSearch, btncart;
    private JComboBox filterRatings,filterPrice;;
    private JScrollPane MakeUpjScrollPane,clothesScrolpane,kitchenScrolpane,suppliesScrolpane;
    private JTabbedPane products;
    private GroupLayout makeuptab1Layout,clothesTab2Layout,kitchenLayout1,suppliesLayout1;
   
    private  JMenuBar MenuBar;
    private  JMenu Menu; 
   private  JMenuItem  jmenuOrderHistory, jmenuLogout;
   
    private UserClass userClass;
   ProductClass productClass;
    
    public eComPageUser(UserClass userClass){
     this.userClass = userClass;
     
     setTitle("ECP-Platform");
     setSize(1385,764);
      setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
    setResizable(false);
     setLocationRelativeTo(null);

       //from product class
     productClass = new ProductClass(userClass);
     

     
    MainPanel = new JPanel();
    MainPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    MainPanel.setBackground(new Color(93, 66, 90));
    MainPanel.setLayout(new BorderLayout());

        
     platformname= new JLabel ();
    platformname.setBounds(115,55, 100, 90);
    productClass.ImageSetupJLabel("lblicon_1.png", platformname,80,85);
   
    platformname.setBackground(new Color(255, 102, 204));
    platformname.setPreferredSize(new Dimension(100, 25));
    add(platformname);
    
    searchBar = new JTextField("Search");
    searchBar.setToolTipText("");
    searchBar.setBounds(200,83,900,40);
    add(searchBar);
    
    filterRatings= new JComboBox<>();
    filterRatings.setBounds(1200, 83, 70, 40);
    filterRatings.setBackground(new Color(89, 0, 54));
    filterRatings.setFont(new Font("Segoe UI Black", 0, 12)); 
    filterRatings.setForeground(new Color(236, 239, 241));
    filterRatings.setModel(new DefaultComboBoxModel<>(new String [] {"All","1", "2","3","4","5"}));
    add(filterRatings);
    
     filterPrice= new JComboBox<>();
    filterPrice.setBounds(1280, 83, 70, 40);
    filterPrice.setBackground(new Color(89, 0, 54));
    filterPrice.setFont(new Font("Segoe UI Black", 0, 12)); 
    filterPrice.setForeground(new Color(236, 239, 241));
    filterPrice.setModel(new DefaultComboBoxModel<>(new String[] {"All","~50", "51-100","101-300","301-600","601-900","901-1000~"}));
    add(filterPrice);
    
    btnSearch=new JButton("Search");
    btnSearch.setBackground(new Color(204, 102, 255));
    btnSearch.setFont(new Font("Sitka Display", 1, 14));
    btnSearch.setBounds(1115,83,75,40);
    add(btnSearch);

    loadTabbedPane();
    
    btncart = new JButton();
    productClass.ImageSetupJButt("checkout-icon.png", btncart,30,30);
    btncart.setBackground(new Color(204, 204, 255));
    btncart.setBounds(1250, 30, 65, 30);
    add(btncart);
    
    MenuBar = new JMenuBar();
    MenuBar.setBackground(new Color(153, 102, 255));
    MenuBar.setBorder(BorderFactory.createEtchedBorder());

    Menu = new JMenu();
    Menu.setText("Profile");

   

    jmenuOrderHistory = new JMenuItem();
    jmenuOrderHistory.setText("Order History");
    Menu.add(jmenuOrderHistory);

    jmenuLogout= new JMenuItem();
    jmenuLogout.setText("Log out");
    Menu.add(jmenuLogout);

    MenuBar.add(Menu);
    setJMenuBar(MenuBar);

    
 
 
btncart.addActionListener(this);
    jmenuLogout.addActionListener(this);
    jmenuOrderHistory.addActionListener(this);
    filterRatings.addActionListener(this);
    }
    
public void loadTabbedPane(){
    
        String selectedRating = (String) filterRatings.getSelectedItem();
        System.out.println("selected rating is " + selectedRating);
    products = new JTabbedPane();
    
        products.setBackground(new Color(204, 204, 204));
        products.setBounds(30, 160, 1300, 500);
        add(products);

        makeups = new JPanel();
        makeups.setBackground(new Color(225, 190, 231));
      

    
        MakeUpjScrollPane = new JScrollPane();
      

        makeupPanel = new JPanel();
        makeupPanel.setBackground(new Color(51, 0, 51));
        makeupPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        makeupPanel.setLayout(null);
        productClass.createProductPanelforBuyer("Makeup", MakeUpjScrollPane,makeupPanel,selectedRating);
        makeuptab1Layout = new GroupLayout(makeups);
        makeups.setLayout(makeuptab1Layout);

        makeuptab1Layout.setHorizontalGroup(makeuptab1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(makeuptab1Layout.createSequentialGroup().addContainerGap().addComponent(MakeUpjScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addContainerGap()) );

        makeuptab1Layout.setVerticalGroup(makeuptab1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(makeuptab1Layout.createSequentialGroup().addContainerGap().addComponent(MakeUpjScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE).addContainerGap()));

        products.addTab("COSMETICS", makeups);
        add(products);
    
//clothes

        clothes = new JPanel();
        clothes.setBackground(new Color(225, 190, 231));
    
        clothesScrolpane = new JScrollPane();
       

        clothespanel = new JPanel();
        clothespanel.setBackground(new Color(51, 0, 51));
        clothespanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
       
        clothespanel.setLayout(null);

        productClass.createProductPanelforBuyer("Clothes", clothesScrolpane,clothespanel,selectedRating);

        clothesTab2Layout = new GroupLayout(clothes);
        clothes.setLayout(clothesTab2Layout);

        clothesTab2Layout.setHorizontalGroup(clothesTab2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(clothesTab2Layout.createSequentialGroup().addContainerGap().addComponent(clothesScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addContainerGap()) );

        clothesTab2Layout.setVerticalGroup(clothesTab2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(clothesTab2Layout.createSequentialGroup().addContainerGap().addComponent(clothesScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE).addContainerGap()));


    products.addTab("CLOTHES", clothes);

//KITCHEN

        kitchen = new JPanel();
        kitchen.setBackground(new Color(225, 190, 231));
     

        kitchenScrolpane = new JScrollPane();
     

        kitchenpanel = new JPanel();
        kitchenpanel.setBackground(new Color(51, 0, 51));
        kitchenpanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      
        kitchenpanel.setLayout(null);
  productClass.createProductPanelforBuyer("Kitchen", kitchenScrolpane,kitchenpanel,selectedRating);
 
        kitchenLayout1 = new GroupLayout(kitchen);
        kitchen.setLayout(kitchenLayout1);

      kitchenLayout1.setHorizontalGroup(kitchenLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(kitchenLayout1.createSequentialGroup().addContainerGap().addComponent(kitchenScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addContainerGap()) );

        kitchenLayout1.setVerticalGroup(kitchenLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(kitchenLayout1.createSequentialGroup().addContainerGap().addComponent(kitchenScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE).addContainerGap()));


    products.addTab("UTENSILS", kitchen);

//school supplies   
 
        supplies = new JPanel();
        supplies.setBackground(new Color(225, 190, 231));
    
        suppliesScrolpane = new JScrollPane();
       

        suppliespanel = new JPanel();
        suppliespanel.setBackground(new Color(51, 0, 51));
        suppliespanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        suppliespanel.setLayout(null);
        productClass.createProductPanelforBuyer("School Supplies", suppliesScrolpane,suppliespanel,selectedRating);

        suppliesLayout1 = new GroupLayout(supplies);
        supplies.setLayout(suppliesLayout1);

      suppliesLayout1.setHorizontalGroup(suppliesLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(suppliesLayout1.createSequentialGroup().addContainerGap().addComponent(suppliesScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addContainerGap()) );

        suppliesLayout1.setVerticalGroup(suppliesLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(suppliesLayout1.createSequentialGroup().addContainerGap().addComponent(suppliesScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE).addContainerGap()));

   
    
    products.addTab("SCHOOL SUPPLIES", supplies);
    products.setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==btncart){
        
    cartPage cart = new cartPage(userClass);
    cart.setVisible(true);
    cart.setSize(1385,764);
    cart.setLocationRelativeTo(null);
     dispose();
    //cart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //dispose();
    }else if(e.getSource()==jmenuLogout){
    
    LoginPage page = new LoginPage();
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
    
    }else if(e.getSource()==jmenuOrderHistory){
    
    OrderHistory page = new OrderHistory();
    page.setVisible(true);
    page.setSize(1385,764);
    page.setLocationRelativeTo(null);
     dispose();
    
    }else if(e.getSource()== filterRatings){
        
  
     String selectedRating = (String) filterRatings.getSelectedItem();
     System.out.print(selectedRating);
     products.setVisible(false);
     loadTabbedPane();
     revalidate();
     repaint();
     
     
    
    }
        
        
    }
}

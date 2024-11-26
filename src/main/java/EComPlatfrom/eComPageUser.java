package EComPlatfrom;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author June-PC
 */
public class eComPageUser extends JFrame implements ActionListener {
    private int userId;
    private final JPanel MainPanel, makeups, makeupPanel, clothes, clothespanel, panelImages, 
                         kitchen, kitchenpanel, supplies, suppliespanel, designpanel, designpanel2, 
                         desgnpanel3;
    private final JLabel platformname, DL1, DL2, DL3, DL4, DL5,DL6, DL7, DL8, DL9, DL10, DL11, DL12;
    private final JTextField searchBar;
    private final JButton btnSearch, btncart;
    private final JComboBox filter;
    private final JScrollPane MakeUpjScrollPane, clothesScrolpane, kitchenScrolpane,suppliesScrolpane, designimages1, 
                            desgnimages2, desgnimages3;
    private final JTabbedPane products;
    private final GroupLayout  makeuptab1Layout,  clothesTab2Layout, 
                   kitchenLayout1, suppliesLayout1,design1Layout,desgn2Layout,desgn3Layout, 
                panelImagesLayout, layout;
    private final JMenuBar MenuBar;
    private final JMenu Menu; 
   private final  JMenuItem  jmenuOrderHistory, jmenuLogout;
    
    eComPageUser(){
    
     
     setTitle("ECP-Platform");
     setSize(1385,764);
      setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
    setResizable(false);
     setLocationRelativeTo(null);

       //from product class
     ProductClass productClass = new ProductClass();
     

     
    MainPanel = new JPanel();
    MainPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    MainPanel.setBackground(new Color(93, 66, 90));
    MainPanel.setLayout(new BorderLayout());


    ImageIcon lbcon = new ImageIcon("src\\main\\java\\Images\\lblicon.png");
    Image scaledIcon = lbcon.getImage().getScaledInstance(80, 85, Image.SCALE_SMOOTH);

     platformname= new JLabel ();
    platformname.setBounds(115,55, 100, 90);
    platformname.setIcon(new ImageIcon(scaledIcon));
    platformname.setBackground(new Color(255, 102, 204));
    platformname.setPreferredSize(new Dimension(100, 25));
    add(platformname);
    
    searchBar = new JTextField("Search");
    searchBar.setToolTipText("");
    searchBar.setBounds(200,83,900,40);
    add(searchBar);
    
    filter= new JComboBox<>();
    filter.setBounds(1200, 83, 70, 40);
    filter.setBackground(new Color(255, 102, 255));
    filter.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
    filter.setModel(new DefaultComboBoxModel<>(new String[] {"price", "ratings"}));
    filter.setToolTipText("");
    add(filter);
    
    btnSearch=new JButton("Search");
    btnSearch.setBackground(new Color(204, 102, 255));
    btnSearch.setFont(new Font("Sitka Display", 1, 14));
    btnSearch.setBounds(1115,83,75,40);
//    btnSearch.addActionListener(this);
    add(btnSearch);

    ImageIcon coIcon = new ImageIcon("src\\main\\java\\Images\\checkout-icon.png");
    ImageIcon coImage = new ImageIcon(coIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
    btncart = new JButton(coImage);
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

    
    panelImages= new JPanel ();
    panelImages.setBackground(new Color(51, 0, 51));
    panelImages.setBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255), null));
    panelImages.setBounds(200,155,1000,180);
    add(panelImages);
    
    designimages1 = new JScrollPane();
    add(designimages1);

    designpanel = new JPanel();
    designpanel.setBackground(new Color(225, 190, 231));
    designpanel.setBorder(BorderFactory.createEtchedBorder());
    add(designpanel);
    
    DL1 = new JLabel();
    //DL1.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); 
    DL1.setText("image");
    DL1.setBorder(BorderFactory.createEtchedBorder());
    add(DL1);
    
    DL2 = new JLabel();
    //DL2.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); 
    DL2.setText("image");
    DL2.setBorder(BorderFactory.createEtchedBorder());
    add(DL2);
    
    DL3 = new JLabel ();
    DL3.setText ("image");
    DL3.setBorder(BorderFactory.createEtchedBorder());
    add(DL3);
    
    DL4 = new JLabel ();
    DL4.setText("images");
    DL4.setBorder(BorderFactory.createEtchedBorder());
    add(DL4);
   
    design1Layout = new GroupLayout( designpanel);
    designpanel.setLayout(design1Layout);
    
    design1Layout.setHorizontalGroup(design1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(design1Layout.createSequentialGroup()
    .addGap(19, 19, 19)
        .addComponent(DL1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(DL4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(19, 19, 19)));

    
    design1Layout.setVerticalGroup(design1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(design1Layout.createSequentialGroup()
    .addGap(10, 10, 10)
    .addGroup(design1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(DL1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
    .addContainerGap(10, Short.MAX_VALUE)));

    designimages1.setViewportView(designpanel);
    
    desgnimages2 = new JScrollPane();
    add(desgnimages2);

    designpanel2 = new JPanel();
    designpanel2.setBackground(new Color(225, 190, 231));
    designpanel2.setBorder(BorderFactory.createEtchedBorder());
    add(designpanel2);

    DL5 = new JLabel();
//    DL5.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); // NOI18N
    DL5.setText("image");
    DL5.setBorder(BorderFactory.createEtchedBorder());
    add(DL5);

    DL6 = new JLabel();
//    DL6.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); // NOI18N
    DL6.setText("image");
    DL6.setBorder(BorderFactory.createEtchedBorder());
    add(DL6);
    
    DL7 = new JLabel();
    DL7.setText("image");
    DL7.setBorder(BorderFactory.createEtchedBorder());
    add(DL7);
    
    DL8 =new JLabel();
    DL8. setText("iamges");
    DL8.setBorder(BorderFactory.createEtchedBorder());
    add(DL8);
    
    desgn2Layout = new GroupLayout(designpanel2);
    designpanel2.setLayout(desgn2Layout);
    
    desgn2Layout.setHorizontalGroup(desgn2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(desgn2Layout.createSequentialGroup()
    .addGap(19, 19, 19)
        .addComponent(DL5, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL6, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL7, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(DL8, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(19, 19, 19)));
        
     desgn2Layout.setVerticalGroup(desgn2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(desgn2Layout.createSequentialGroup()
    .addGap(10, 10, 10)
    .addGroup(desgn2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(DL5, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL7, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL8, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
    .addContainerGap(10, Short.MAX_VALUE)));
    
    desgnimages2.setViewportView(designpanel2);

    desgnimages3 = new JScrollPane();
    add(desgnimages3);

    desgnpanel3 = new JPanel();
    desgnpanel3.setBackground(new Color(225, 190, 231));
    desgnpanel3.setBorder(BorderFactory.createEtchedBorder());
    add(desgnpanel3);
    
    DL9 = new JLabel();
//    DL9.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); // NOI18N
    DL9.setText("image");
    DL9.setBorder(BorderFactory.createEtchedBorder());
    add(DL9);

    DL10 = new JLabel();
//    DL10.setIcon(new ImageIcon(getClass().getResource("/EComPlatfrom/2bcc05929ada6c77c193a5ee48812f8e (1).jpg"))); // NOI18N
    DL10.setText("image");
    DL10.setBorder(BorderFactory.createEtchedBorder());
    add(DL10);
    
    DL11 =new JLabel();
    DL11.setText("iamges");
    DL11.setBorder(BorderFactory.createEtchedBorder());
    add(DL11);
    
    DL12 = new JLabel();
    DL12.setText("iamges");
    DL12.setBorder(BorderFactory.createEtchedBorder());
    add(DL12);

    desgn3Layout = new GroupLayout(desgnpanel3);
    desgnpanel3.setLayout(desgn3Layout);
    
    desgn3Layout.setHorizontalGroup(desgn3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(desgn3Layout.createSequentialGroup()
     .addGap(19, 19, 19)
     .addComponent(DL9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
     .addComponent(DL10, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL11, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(43, 43, 43)
        .addComponent(DL12, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
    .addGap(19, 19, 19)));
       
    desgn3Layout.setVerticalGroup(desgn3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(desgn3Layout.createSequentialGroup()
    .addGap(10, 10, 10)
    .addGroup(desgn3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(DL9, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL10, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL11, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(DL12, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
    .addContainerGap(10, Short.MAX_VALUE)));

    desgnimages3.setViewportView(desgnpanel3);

    panelImagesLayout = new GroupLayout(panelImages);
    panelImages.setLayout(panelImagesLayout);
    
    panelImagesLayout.setHorizontalGroup(panelImagesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(panelImagesLayout.createSequentialGroup()
    .addGap(24, 24, 24)
    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(designimages1, GroupLayout.PREFERRED_SIZE, 305,GroupLayout.PREFERRED_SIZE)
    .addGap(15, 15, 15)
        .addComponent(desgnimages2, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
    .addGap(15, 15, 15)
        .addComponent(desgnimages3, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
    .addGap(24, 24, 24)));
        
    panelImagesLayout.setVerticalGroup(panelImagesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(GroupLayout.Alignment.TRAILING, panelImagesLayout.createSequentialGroup()
    .addContainerGap()
    .addGroup(panelImagesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(designimages1)
        .addComponent(desgnimages2)
        .addComponent(desgnimages3,GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
    .addGap(8, 8, 8)));
    
 
        products = new JTabbedPane();
        products.setBackground(new Color(204, 204, 204));
        products.setBounds(30, 350, 1300, 300);
        add(products);

        makeups = new JPanel();
        makeups.setBackground(new Color(225, 190, 231));
        makeups.setBorder(BorderFactory.createEtchedBorder());

        MakeUpjScrollPane = new JScrollPane();
        MakeUpjScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        MakeUpjScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        makeupPanel = new JPanel();
        makeupPanel.setBackground(new Color(51, 0, 51));
        makeupPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        makeupPanel.setPreferredSize(new Dimension(1200,350 * (int) Math.ceil((double) productClass.getTotalProductCount("Makeup") / 3))); 
        makeupPanel.setLayout(null);
        
       
      //updated color
     // product panels for makeup stat: transferred into product class
        int totalProductCountMakeup = productClass.getTotalProductCount("Makeup");
        productClass.resetPanelCount(); 
        for (int i = 0; i < totalProductCountMakeup; i++) {  
            JPanel newPanel = productClass.createProductPanelforBuyer("Makeup");
           
            if (newPanel != null) {
                makeupPanel.add(newPanel);  
                makeupPanel.revalidate();
                makeupPanel.repaint();
                
            }
        }
      
        
        MakeUpjScrollPane.setViewportView(makeupPanel);

        makeuptab1Layout = new GroupLayout(makeups);
        makeups.setLayout(makeuptab1Layout);

        makeuptab1Layout.setHorizontalGroup(
            makeuptab1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(makeuptab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MakeUpjScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap()) );

        makeuptab1Layout.setVerticalGroup(
            makeuptab1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(makeuptab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MakeUpjScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap()));

        products.addTab("COSMETICS", makeups);
        add(products);
    
//clothes

        clothes = new JPanel();
        clothes.setBackground(new Color(225, 190, 231));
        clothes.setBorder(BorderFactory.createEtchedBorder());

        clothesScrolpane = new JScrollPane();
        clothesScrolpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        clothesScrolpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        clothespanel = new JPanel();
        clothespanel.setBackground(new Color(51, 0, 51));
        clothespanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        clothespanel.setPreferredSize(new Dimension(1200,350 * (int) Math.ceil((double) productClass.getTotalProductCount("Clothes") / 3))); 
        clothespanel.setLayout(null);

        
        //product panel for clothes
        int totalProductCountClothes = productClass.getTotalProductCount("Clothes");
        productClass.resetPanelCount(); 
        for (int i = 0; i < totalProductCountClothes; i++) {  
            JPanel newPanel = productClass.createProductPanelforBuyer("Clothes");
            if (newPanel != null) {
                clothespanel.add(newPanel);  
                clothespanel.revalidate();
                clothespanel.repaint();
                
            }
        }
        
        clothesScrolpane.setViewportView(clothespanel);

        clothesTab2Layout = new GroupLayout(clothes);
        clothes.setLayout(clothesTab2Layout);

        clothesTab2Layout.setHorizontalGroup(
            clothesTab2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(clothesTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clothesScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap()) );

        clothesTab2Layout.setVerticalGroup(
            clothesTab2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(clothesTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clothesScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap()));


    products.addTab("CLOTHES", clothes);

//KITCHEN

        kitchen = new JPanel();
        kitchen.setBackground(new Color(225, 190, 231));
        kitchen.setBorder(BorderFactory.createEtchedBorder());

        kitchenScrolpane = new JScrollPane();
        kitchenScrolpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        kitchenScrolpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        kitchenpanel = new JPanel();
        kitchenpanel.setBackground(new Color(51, 0, 51));
        kitchenpanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        kitchenpanel.setPreferredSize(new Dimension(1200,350 * (int) Math.ceil((double) productClass.getTotalProductCount("Kitchen") / 3)));  
        kitchenpanel.setLayout(null);

        //product panels for kitchen things
         int totalProductCountKitchen = productClass.getTotalProductCount("Kitchen");
          productClass.resetPanelCount(); 
        for (int i = 0; i < totalProductCountKitchen; i++) {  
            JPanel newPanel = productClass.createProductPanelforBuyer("Kitchen");
            if (newPanel != null) {
                kitchenpanel.add(newPanel);  
                kitchenpanel.revalidate();
                kitchenpanel.repaint();
                
            }
        }
        
        kitchenScrolpane.setViewportView(kitchenpanel);

        kitchenLayout1 = new GroupLayout(kitchen);
        kitchen.setLayout(kitchenLayout1);

      kitchenLayout1.setHorizontalGroup(
            kitchenLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(kitchenLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(kitchenScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap()) );

        kitchenLayout1.setVerticalGroup(
        kitchenLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(kitchenLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(kitchenScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap()));


    products.addTab("UTENSILS", kitchen);

//school supplies   
 
        supplies = new JPanel();
        supplies.setBackground(new Color(225, 190, 231));
        supplies.setBorder(BorderFactory.createEtchedBorder());

        suppliesScrolpane = new JScrollPane();
        suppliesScrolpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        suppliesScrolpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        suppliespanel = new JPanel();
        suppliespanel.setBackground(new Color(51, 0, 51));
        suppliespanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        suppliespanel.setPreferredSize(new Dimension(1200,350 * (int) Math.ceil((double) productClass.getTotalProductCount("School Supplies") / 3))); 
        suppliespanel.setLayout(null);

       //product panel for school supplies
       
         int totalProductCountSS = productClass.getTotalProductCount("School Supplies");
          productClass.resetPanelCount(); 
        for (int i = 0; i < totalProductCountSS; i++) {  
            JPanel newPanel = productClass.createProductPanelforBuyer("School Supplies");
            if (newPanel != null) {
                suppliespanel.add(newPanel);  
                suppliespanel.revalidate();
                suppliespanel.repaint();
                
            }
        }
        
        suppliesScrolpane.setViewportView(suppliespanel);

        suppliesLayout1 = new GroupLayout(supplies);
        supplies.setLayout(suppliesLayout1);

      suppliesLayout1.setHorizontalGroup(
            suppliesLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(suppliesLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppliesScrolpane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap()) );

        suppliesLayout1.setVerticalGroup(
            suppliesLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(suppliesLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppliesScrolpane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap()));

   
    
    products.addTab("SCHOOL SUPPLIES", supplies);
        
    
    layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addComponent(MainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
    .addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    .addGap(0, 0, Short.MAX_VALUE)));

    
btncart.addActionListener(this);
    jmenuLogout.addActionListener(this);
    jmenuOrderHistory.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==btncart){
        
    cartPage cart = new cartPage();
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
    
    }
        
        
    }
}
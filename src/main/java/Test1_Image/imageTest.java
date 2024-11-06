/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test1_Image;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;



/**
 *
 * @author Raylen
 */
public class imageTest extends JFrame{
  private JLabel bgLabel;
  
    
    public imageTest() {
        
        setTitle("ECommercePlatform");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
     
        //for picture
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Test1_Image\\bg.png");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        bgLabel = new JLabel(bgIcon);
        bgLabel.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        bgLabel.setBounds(0, 0, bgLabel.getPreferredSize().width, bgLabel.getPreferredSize().height);
        add(bgLabel);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test1_Image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;



/**
 *
 * @author Raylen
 */
public class imageTest1 extends JFrame{
  private JLabel bgLabel;
  
    
    public imageTest1() {
        //WORKS
        setTitle("ECommercePlatform");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
     
        //for picture
        ImageIcon bgIcon = new ImageIcon("src\\main\\java\\Test1_Image\\bg.png");
        bgLabel = new JLabel(bgIcon);

        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Exists to shorten the code, Para di na umulit ulit yung Toolkit.getDefaultToolkit().getScreenSize() everytime lalo na sa may scaledImage
        Image scaledImage = bgIcon.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH);
        bgLabel.setIcon(new ImageIcon(scaledImage));
        bgLabel.setBounds(0, 0, screenSize.width, screenSize.height);
       //  bgLabel.setOpaque(true); // OPTIONAL! Is said na makapagpatransparent ng jlabel and makita yung photo. Reason why this exist: Just incase mangyari uli yung error na di nalabas yung photo
        add(bgLabel); // Add the label to the JFrame

     

       

        
    }
    
}

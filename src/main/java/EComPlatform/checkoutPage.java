/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Raylen
 */
public class checkoutPage extends JFrame implements ActionListener{
    checkoutPage(){
      setTitle("ECP-Platform");
        setSize(1385, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\Images\\background.png")));
        setResizable(false);
        setLocationRelativeTo(null);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
}

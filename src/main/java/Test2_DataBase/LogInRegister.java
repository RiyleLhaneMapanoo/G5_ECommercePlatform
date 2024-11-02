/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test2_DataBase;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Raylen
 */
public class LogInRegister extends JFrame {
    private JLabel log,p,u;
    private JTextField user,pass;
  //  private Font f;
    
public LogInRegister(){
    
    setSize(500,500);
    setLayout(null);
    setTitle("Log In/Register Database");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    //For font dec
   // f = (new Font("Times New Roman", Font.PLAIN, 30));
    
    log = new JLabel();
    log.setText("Log In");
    log.setForeground(Color.BLACK);
    log.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    log.setBounds(200, 30, 100, 32);
    add(log);
    
    u = new JLabel();
    u.setText("Username: ");
    u.setForeground(Color.BLACK);
    u.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    u.setBounds(50, 60, 100, 32);
    add(u);
    
    
}
    





public static class Reg extends JFrame{

}
    
}


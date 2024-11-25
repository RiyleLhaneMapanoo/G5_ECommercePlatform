/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test5_DatabaseWithDifferentClass;

import javax.swing.JCheckBox;

/**
 *
 * @author Raylen
 */
public class Product {
       private JCheckBox cpCheckBox,eyeCheckBox,noteCheckBox;
       
       //Item Checkbox Declaration
        public JCheckBox[] getAllCheckBoxes() {
            
        return new JCheckBox[] { cpCheckBox, eyeCheckBox, noteCheckBox };
    }
        
        
}

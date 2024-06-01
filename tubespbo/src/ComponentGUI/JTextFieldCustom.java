/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentGUI;

import java.awt.Insets;

/**
 *
 * @author Lenovo
 */
public class JTextFieldCustom extends javax.swing.JTextField{

    public JTextFieldCustom() {
        Insets inset = getInsets();
        inset.left += 10;
        setMargin(inset);
    }
    
}

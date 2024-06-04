/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentGUI;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lenovo
 */
public class HeaderTableDaftarDokter extends JLabel {
    public HeaderTableDaftarDokter (String text) {
        super(text);
        setOpaque(true);
        setBackground(Color.white);
        setFont(new Font("sanserif", 1, 16));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10,5,10,5));
        
    }
}

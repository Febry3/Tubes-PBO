/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ASUS
 */
public class TableHeader extends JLabel{

    public TableHeader(String Text) {
        super(Text);
        setOpaque(false);

       
        //GradientPaint g = new GradientPaint(0,0,Color.decode("#4CB8C4"),0, getHeight(),Color.decode("#3CD3AD"));
        setBackground(Color.BLACK);
        setFont(new Font("Tahoma", 1, 12));
        setForeground(new Color(102,102,102));
        setBorder(new EmptyBorder(10,5,10,5));
        //setBorder( BorderFactory.createLineBorder(Color.black));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230,230,230));
        grphcs.drawLine(0, getHeight() -1, getWidth(), getHeight() -1);
    }
}

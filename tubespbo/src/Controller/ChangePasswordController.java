/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import static Controller.CurrentUser.getCurrentUsername;
import Model.Admin;
import Model.Apoteker;
import Model.Dokter;
import Model.Pasien;
import Model.Pengguna;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.View;

/**
 *
 * @author ASUS
 */
public class ChangePasswordController implements ActionListener {

    private JTextFieldCustom oldPass = new JTextFieldCustom();
    private JTextFieldCustom newPass = new JTextFieldCustom();
    private JTextFieldCustom confirmNewPass = new JTextFieldCustom();
    private String role;

    public ChangePasswordController(JTextFieldCustom oldPass, JTextFieldCustom newPass, JTextFieldCustom confirmNewPass, String role) {
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.confirmNewPass = confirmNewPass;
        this.role = role;
    }

    public ChangePasswordController() {
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (role.equals("Dokter")) {
                Dokter dokter = new Dokter();
                dokter.change_password(getCurrentUsername(), newPass.getText());
                JOptionPane.showMessageDialog(null, "Password Berhasil Diganti");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

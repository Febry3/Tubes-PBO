/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import Model.Dokter;
import Model.Pasien;
import Model.Pengguna;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.View;

/**
 *
 * @author ASUS
 */
public class ChangePasswordController implements ActionListener {

    private JTextFieldCustom oldPass = new JTextFieldCustom();
    private JTextFieldCustom newPass = new JTextFieldCustom();
    private JTextFieldCustom confirmNewPass = new JTextFieldCustom();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    private void load_users(String username, String password) {
//        try {
//            Database db = new Database();
//            ResultSet rs;
//            if (role.equals("Pasien")){
//                Pasien pasien = new Pasien(username, password);
//                rs = pasien.Login(username, password);
//            } else {
//                Dokter dokter = new Dokter(username, password);
//                rs = dokter.Login(username, password);
//            }
//      
//            while (rs.next()) {
//                Pengguna user = new Pengguna(rs.getString("username"), "") {
//                    @Override
//                    public void change_password() {
//                    }
//                };
//                tabel_user.add(user);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}

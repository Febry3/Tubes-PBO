/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import static Controller.CurrentUser.getCurrentRole;
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
    private ArrayList<Pengguna> tabel_user = new ArrayList();

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
        if (blankInput(oldPass.getText(), newPass.getText(), confirmNewPass.getText())) {
            JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
        } else if (newPassConfirmed(newPass.getText(),confirmNewPass.getText()) && oldPassConfirmed(oldPass.getText())) {  
            try {
                if (role.equals("Dokter")) {
                Dokter dokter = new Dokter();
                dokter.change_password(getCurrentUsername(), newPass.getText());
                JOptionPane.showMessageDialog(null, "Password Berhasil Diganti");
                resetAll();
            }
            } catch (SQLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } else if (!oldPassConfirmed(oldPass.getText())){
            JOptionPane.showMessageDialog(null, "Password salah");
            resetAll();
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan konfirmasi kembali password baru anda");
            confirmPassReset();
        }
        
    }
    
    public boolean newPassConfirmed(String newPass, String confirmNewPass) {
        return (newPass.equals(confirmNewPass) && !newPass.isEmpty() && !confirmNewPass.isEmpty());
    }
    
    public boolean blankInput(String oldPass, String newPass, String confirmNewPass) {
        return (oldPass.isEmpty() && newPass.isEmpty() && confirmNewPass.isEmpty());
    }
    
    public boolean passwordBlankInput(String newPass, String confirmNewPass) {
        return (newPass.isEmpty() && confirmNewPass.isEmpty());
    }
    
    public void confirmPassReset() {
        newPass.setText("");
        confirmNewPass.setText("");
    }
    
    public void resetAll() {
        oldPass.setText("");
        newPass.setText("");
        confirmNewPass.setText("");
    }
    
    public boolean oldPassConfirmed(String oldPassword) {
        boolean hasil = true;
        try {
            Admin admin = new Admin(getCurrentUsername(), oldPass.getText());
            Apoteker apoteker = new Apoteker(getCurrentUsername(), oldPass.getText());
            Database db = new Database();
            ResultSet rs = null;
            if (getCurrentRole().equals("Pasien")) {
                Pasien pasien = new Pasien(getCurrentUsername(), oldPass.getText());
                rs = pasien.checkOldPassword(getCurrentUsername(), oldPass.getText());
            } else if (getCurrentRole().equals("Dokter")) {
                Dokter dokter = new Dokter(getCurrentUsername(), oldPass.getText());
                rs = dokter.checkOldPassword(getCurrentUsername(), oldPass.getText());
            } else if (getCurrentRole().equals("Apoteker")) {
                rs = apoteker.checkOldPassword(getCurrentUsername(), oldPass.getText());
            } else {

                if (apoteker.checkOldPassword(getCurrentUsername(), oldPass.getText()).next()) {
                    this.role = "Apoteker";
                    rs = apoteker.checkOldPassword(getCurrentUsername(), oldPass.getText());;

                } else {
                    this.role = "Admin";
                    rs = admin.checkOldPassword(getCurrentUsername(), oldPass.getText());;
                }
            }
            while (rs.next()) {
                Pengguna user = new Pengguna("",rs.getString("password")) {
                    @Override
                    public void change_password(String oldPass, String newPass) {

                    }

                    @Override
                    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
                        ResultSet rs = null;
                        return rs;
                    }

                };
                tabel_user.add(user);
                System.out.println("tbl user nama pengguna : " + tabel_user.get(0).getNama_pengguna());
                System.out.println("tbl user pass pengguna : " + tabel_user.get(0).getPassword_pengguna());
                System.out.println(getCurrentUsername());
                System.out.println("pass db : " + user.getPassword_pengguna());
                String sql = "select password as password from Dokter"
                + " where"
                + " nama_dokter = '" + "tes" + "';";
                System.out.println(sql);
            }
            
            if (!tabel_user.get(0).getPassword_pengguna().equals(oldPassword)) {
                hasil = false;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
}

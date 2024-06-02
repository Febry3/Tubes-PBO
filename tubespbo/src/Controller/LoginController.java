/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import GUI.DoctorForm.MainDoctor;
import GUI.UserForms.MainUser;
import Model.Pengguna;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.View;

public class LoginController implements ActionListener {

    private JTextFieldCustom username = new JTextFieldCustom();
    private JTextFieldCustom password = new JTextFieldCustom();
    private JFrame loginPage = new JFrame();
    private ArrayList<Pengguna> tabel_user = new ArrayList();
    private String role;
    private Pengguna user;

    public LoginController(JTextFieldCustom username, JTextFieldCustom password, String role, JFrame loginPage) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        load_users(username.getText(), password.getText());
        if (tabel_user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gagal");
        } else {
            JOptionPane.showMessageDialog(null, "Berhasil");
            tabel_user.clear();
            loginPage.dispose();
            if (role.equals("Dokter")) {
                MainDoctor main = new MainDoctor();
                main.setVisible(true);
            } else {
                MainUser mainUser = new MainUser();
                mainUser.setVisible(true);
            }

        }
        resetText();
    }

    private void load_users(String username, String password) {
        try {
            Database db = new Database();
            String sql = "select Pasien.nama_pasien as username "
                    + "from `Pasien` "
                    + "where"
                    + " Pasien.nama_pasien = '" + username + "' "
                    + " AND"
                    + " Pasien.password = '" + password + "'"
                    + " UNION"
                    + " select Dokter.nama_dokter from Dokter "
                    + " where"
                    + " Dokter.nama_dokter = '" + username + "' ";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                Pengguna user = new Pengguna(rs.getString("username"), "") {
                    @Override
                    public void change_password() {
                    }
                };
                tabel_user.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetText() {
        username.setText("");
        password.setText("");
    }

}

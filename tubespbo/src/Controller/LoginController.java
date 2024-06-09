/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import static Controller.CurrentUser.getCurrentRole;
import static Controller.CurrentUser.getCurrentUsername;
import GUI.AdminForms.MainAdmin;
import GUI.DoctorForm.MainDoctor;
import GUI.PharmacistForm.MainPharmacist;
import GUI.UserForms.MainUser;
import Model.Admin;
import Model.Apoteker;
import Model.Dokter;
import Model.Pasien;
import Model.Pengguna;
import Model.Staff;
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

    public LoginController(JTextFieldCustom username, JTextFieldCustom password, JFrame loginPage) {
        this.username = username;
        this.password = password;
        this.loginPage = loginPage;
        role = "";
    }


    public LoginController() { }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean check = load_users(username.getText(), password.getText());
        
        if (!check) {
            JOptionPane.showMessageDialog(null, "Gagal");
        } else {
            JOptionPane.showMessageDialog(null, "Berhasil");
            tabel_user.clear();
            loginPage.dispose();
            if (role.equals("Dokter")) {
                MainDoctor main = new MainDoctor();
                main.setVisible(true);
            } else if (role.equals("Pasien")) {
                MainUser mainUser = new MainUser();
                mainUser.setVisible(true);
            } else if (role.equals("Admin")) {
                MainAdmin mainAdmin = new MainAdmin();
                mainAdmin.setVisible(true);
            } else if (role.equals("Apoteker")) {
                MainPharmacist mainApoteker = new MainPharmacist();
                mainApoteker.setVisible(true);
            }

        }
        resetText();
    }

    public ArrayList<Pengguna> getTabel_user() {
        return tabel_user;
    }

    public void setTabel_user(ArrayList<Pengguna> tabel_user) {
        this.tabel_user = tabel_user;
    }
    
    

    private boolean load_users(String username, String password) {
        boolean hasil = false;

        try {
            Admin admin = new Admin(username, password);
            Apoteker apoteker = new Apoteker(username, password);
            Database db = new Database();
            ResultSet rs = null;
            if (role.equals("Pasien")) {
                Pasien pasien = new Pasien(username, password);
                rs = pasien.Login(username, password);
            } else if (role.equals("Dokter")) {
                Dokter dokter = new Dokter(username, password);
                rs = dokter.Login(username, password);
            } else if (role.equalsIgnoreCase("Apoteker")) {
                rs = apoteker.Login(username, password);
            } else {

                if (apoteker.Login(username, password).next()) {
                    this.role = "Apoteker";
                    rs = apoteker.Login(username, password);

                } else {
                    this.role = "Admin";
                    rs = admin.Login(username, password);
                }
            }
            
            CurrentUser cu = new CurrentUser(username,this.role);
            
            if (rs.next()) {
                Pengguna user = new Pengguna(rs.getString("username"), rs.getString("password")) {
                    @Override
                    public void change_password(String oldPass, String newPass) {

                    }

                    @Override
                    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
                        ResultSet rs = null;
                        return rs;
                    }
                };
                if (user.getNama_pengguna().equals(username) && user.getPassword_pengguna().equals(password)) {
                    hasil = true;
                }
                System.out.println("user db : " + user.getNama_pengguna());
                System.out.println("user field : " + username);
                System.out.println("pass db : " + user.getPassword_pengguna());
                System.out.println("pass field : " + user.getPassword_pengguna());
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public void resetText() {
        username.setText("");
        password.setText("");
    }

}

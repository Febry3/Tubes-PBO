/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import GUI.UserForms.MainUser;
import Model.Pasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo
 */
public class RegisterController implements ActionListener {
    private JTextFieldCustom nama = new JTextFieldCustom();
    private JTextFieldCustom noHp = new JTextFieldCustom();
    private JTextFieldCustom alamat = new JTextFieldCustom();
    private JTextFieldCustom password = new JTextFieldCustom();
    private JTextFieldCustom confirmPassword = new JTextFieldCustom();
    private JLabel message = new JLabel();
    private JFrame registerPage = new JFrame();
    

    public RegisterController(JTextFieldCustom nama, JTextFieldCustom noHp, JTextFieldCustom alamat, JTextFieldCustom password, JTextFieldCustom confirmPassword, JLabel message, JFrame registerPage) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.message = message;
        this.registerPage = registerPage;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (confirmPassword.getText().equals(password.getText())) {
            Pasien pasien = new Pasien(alamat.getText(), nama.getText(), noHp.getText(), password.getText());
            try {
                pasien.register_akun();
                resetText();
                
                MainUser mainUser = new MainUser();
                mainUser.setVisible(true);
                
                registerPage.dispose();
                
            } catch (SQLException err) {
                System.out.println("Error Register: " + err.getMessage());
            }
        } else {
            
            message.setText("Password konfirmasi tidak sama dengan password yang diinputkan");
        }
    }
    
    public void resetText(){
        nama.setText("");
        noHp.setText("");
        alamat.setText("");
        password.setText("");
        confirmPassword.setText("");
        message.setText("");
    }
    
}

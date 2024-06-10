/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import ComponentGUI.Table;
import Model.Obat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class EditObatController implements ActionListener {
    private String namaObat = "";
    private JDialog dialogEdit;
    private JTextFieldCustom hargaTF;
    private JTextFieldCustom stockTF;
    
    public EditObatController(String namaObat, JDialog dialogEdit, JTextFieldCustom hargaTF, JTextFieldCustom stockTF){
        this.namaObat = namaObat;
        this.dialogEdit = dialogEdit;
        this.hargaTF = hargaTF;
        this.stockTF = stockTF;
        System.out.println(namaObat);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Obat obat = new Obat(namaObat, Integer.parseInt(hargaTF.getText()), Integer.parseInt(stockTF.getText()));
        try {
            obat.updateObat();
            JOptionPane.showMessageDialog(null, "Obat berhasil diedit");
            hargaTF.setText("");
            stockTF.setText("");
            dialogEdit.setVisible(false);
            
        } catch (SQLException er) {
            System.out.println("Err Update Obat: " + er.getMessage());
        }
    }
    
}

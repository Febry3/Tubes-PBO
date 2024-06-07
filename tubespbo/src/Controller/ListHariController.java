/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Lenovo
 */
public class ListHariController implements ActionListener{
    JComboBox listDokter;
    JComboBox listHari;
    JComboBox listJam;
    
    public ListHariController(JComboBox listDokter, JComboBox listHari, JComboBox listJam) {
        this.listDokter = listDokter;
        this.listHari = listHari;
        this.listJam = listJam;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Database db = new Database();
        db.connect();
        String nama = (String) listDokter.getSelectedItem();
        String hari = (String) listHari.getSelectedItem();
        String sqlQuery = "select jam from Dokter join JadwalPraktek using (id_dokter) where nama_dokter = '" + nama + "' and hari = '" + hari + "'";
        System.out.println(sqlQuery);
        listJam.removeAllItems();
        try {
            ResultSet rs = db.getData(sqlQuery);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                listJam.addItem(rs.getString(1));
            }
        } catch  (SQLException er){
            System.out.println("Err Load List Jam: " + er.getMessage());
        }
        db.disconnect();
    }
    
}

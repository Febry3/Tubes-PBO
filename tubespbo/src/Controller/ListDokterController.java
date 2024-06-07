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
public class ListDokterController implements ActionListener{
    private JComboBox listDokter;
    private JComboBox listHari;
    private JComboBox listJam;
    
    
    public ListDokterController(JComboBox listDokter, JComboBox listHari, JComboBox listJam){
        this.listDokter = listDokter;
        this.listHari = listHari;
        this.listJam = listJam;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Database db = new Database();
        String namaDokter = (String) listDokter.getSelectedItem();
        String sqlQuery = "select hari from Dokter join JadwalPraktek using (id_dokter) where nama_dokter = '" + namaDokter + "'";
        System.out.println(sqlQuery);
        
        db.connect();
        
        try {
            ResultSet rs = db.getData(sqlQuery);
        
            while (rs.next()) {
                listHari.addItem(rs.getString(1));
            }
        } catch (SQLException er) {
            System.out.println("Err Load List Hari: " + er.getMessage() );
        }
        db.disconnect();
      
    }
    
}

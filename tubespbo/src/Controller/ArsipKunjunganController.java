/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.Table;
import Model.HasilPengecekan;
import Utility.Database;
import Utility.StringUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ArsipKunjunganController {
    private Table tableArsip;
        
    public ArsipKunjunganController(Table tableArsip){
        this.tableArsip = tableArsip;
    }    
    
    public void loadData(){
        ArrayList<String> daftarObat = new ArrayList<>();
        HasilPengecekan arsipKunjungan = new HasilPengecekan(CurrentUser.username);
        DefaultTableModel tableModel = (DefaultTableModel) tableArsip.getModel();
        try {
            Database db = new Database();
            db.connect();
            ResultSet rs = arsipKunjungan.getDaftarPengecekkan();
            
            while (rs.next()){
                String sqlQuery = "select nama_obat from ObatPasien join Obat using (id_obat) where id_hasil_pengecekan = " + rs.getInt(1);
                Database dbO = new Database();
                dbO.connect();
                ResultSet rsObat = dbO.getData(sqlQuery);
                while (rsObat.next()){          
                    daftarObat.add(rsObat.getString(1));
                }
                String rowData[] = {rs.getString("nama_pasien"), rs.getString("nama_dokter"), rs.getString("nama_penyakit"), StringUtilities.convertArrayToString(daftarObat), rs.getString("tanggal_reservasi"), rs.getString("catatan")};
                tableModel.addRow(rowData);
                dbO.disconnect();
            }
            db.disconnect();
        } catch (SQLException er) {
            System.out.println("Err Load Arsip: " + er.getMessage());
        }
    }
}

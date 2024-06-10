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
        String sqlQuery = "select id_hasil_pengecekan, nama_penyakit, catatan, nama_pasien, nama_dokter, tanggal_reservasi, nama_obat from HasilPengecekan join Dokter using (id_dokter) join Pasien using (id_pasien) join Reservasi using (id_reservasi) join ObatPasien using (id_hasil_pengecekan) join Obat using (id_obat) where nama_pasien = '" + CurrentUser.username + "'";
        System.out.println(sqlQuery);
        try {
            Database db = new Database();
            db.connect();
            ResultSet rs = db.getData(sqlQuery);
            
            while (rs.next()){
                System.out.println(rs.getString("nama_pasien"));
                String rowData[] = {rs.getString("nama_pasien"), rs.getString("nama_dokter"), rs.getString("nama_penyakit"), rs.getString("nama_obat"), rs.getString("tanggal_reservasi"), rs.getString("catatan")};
                tableModel.addRow(rowData);
              
            }
            
        } catch (SQLException er) {
            System.out.println("Err Load Arsip: " + er.getMessage());
        }
    }
}

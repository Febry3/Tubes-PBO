/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.Table;
import Model.Dokter;
import Utility.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class TableDokterController {
    private final Table dokterTable;
    public TableDokterController(Table dokterTable) {
        this.dokterTable = dokterTable;
    }
    
    public void loadData() {
        Database db = new Database();
        db.connect();
        String sqlQuery = "select nama_dokter, spesialisasi, hari, jam from Dokter join JadwalPraktek using (id_dokter)";
        System.out.println(sqlQuery);
        DefaultTableModel tableModel = (DefaultTableModel) dokterTable.getModel();
        
        try {
            ResultSet rs = db.getData(sqlQuery);
        
            while (rs.next()) {
                String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)}; 
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println("Err Load Data Dokter: " + e.getMessage());
        }
    }
}

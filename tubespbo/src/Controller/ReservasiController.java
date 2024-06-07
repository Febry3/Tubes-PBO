/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.Table;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ReservasiController implements ActionListener{
    private Table dokterTable;
    private JComboBox listDokter;
    
    public ReservasiController(Table dokterTable, JComboBox listDokter) {
        this.dokterTable = dokterTable;
        this.listDokter = listDokter;
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
                listDokter.addItem((String) rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Err Load Data Dokter: " + e.getMessage());
        }
        db.disconnect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}

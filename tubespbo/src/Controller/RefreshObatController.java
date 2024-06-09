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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class RefreshObatController implements ActionListener {

    private Table TableObat;

    public RefreshObatController(Table TableObat) {
        this.TableObat = TableObat;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        loadData();
    }
    
     public void loadData() {
        String sql = "select nama_obat, no_registrasi, stock, harga from Obat";
        DefaultTableModel table = (DefaultTableModel) TableObat.getModel();

        try {
            Database db = new Database();
            db.connect();
            ResultSet rs = db.getData(sql);
            table.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {rs.getString("nama_obat"), rs.getString("no_registrasi"), rs.getInt("stock"), rs.getInt("harga")};
                table.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Err Load Data Obat: " + ex.getMessage());
        }

    }
    
}

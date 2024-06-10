/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.Table;
import static Controller.CurrentUser.getCurrentUsername;
import GUI.DoctorForm.RequestJadwalForm;
import Model.JadwalPraktek;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hafid
 */
public class jadwalAccController {

    private Table tabelJadwal = new Table();

    public jadwalAccController(Table tabelJadwal) {
        this.tabelJadwal = tabelJadwal;
    }

    public jadwalAccController() {

    }

    public void showJadwalAcc() {
        DefaultTableModel tableModel = (DefaultTableModel) tabelJadwal.getModel();
        try {
            Database db = new Database();
            db.connect();

            String sql = "select nama_dokter, hari, jam, status from JadwalPraktek join Dokter using (id_dokter) where status = 'accepted' and nama_dokter = '" + getCurrentUsername() + "'";
            ResultSet resultset = db.getData(sql);
            tableModel.setRowCount(0);

            while (resultset.next()) {
                String data[] = {resultset.getString("hari"), resultset.getString("jam"), resultset.getString("status")};
                tableModel.addRow(data);

            }

        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}

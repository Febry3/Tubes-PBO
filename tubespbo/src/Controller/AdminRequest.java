/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.DoctorForm.RequestJadwalForm;
import Model.JadwalPraktek;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alfat
 */
public class AdminRequest implements ItemListener {

    private JList requestList = new JList();
    private ArrayList<JadwalPraktek> tabel_JadwalPraktek;
    private ArrayList<String> ArrayJam;
    private DefaultListModel tabel_nama;
    private JadwalPraktek jadwal;

    public AdminRequest(JList requestList) {
        this.requestList = requestList;
        tabel_JadwalPraktek = new ArrayList();
        ArrayJam = new ArrayList();
        tabel_nama = new DefaultListModel();
        showTable();
    }

    private void showTable() {
        try {
            Database db = new Database();
            String sql = "select * from JadwalPraktek";
            ResultSet resultset = db.getData(sql);
            while (resultset.next()) {
                JadwalPraktek jadwal = new JadwalPraktek(resultset.getString("ruangan"), resultset.getString("hari"), resultset.getString("jam"), resultset.getString("Status"), resultset.getInt("id_jadwal_praktek"),resultset.getInt("id_dokter"));
                if (jadwal.getStatus().equals("pending")) {
                    tabel_JadwalPraktek.add(jadwal);
                    tabel_nama.addElement("Ruangan : " + jadwal.getRuangan() + " /Hari : " + jadwal.getHari() + " /Jam : " + jadwal.getJam() + " /Status : " + jadwal.getStatus());
                }
            }
            requestList.setModel(tabel_nama);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

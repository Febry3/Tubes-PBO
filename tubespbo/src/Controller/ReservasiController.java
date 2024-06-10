/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import ComponentGUI.Table;
import Model.Pasien;
import Model.Reservasi;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ReservasiController implements ActionListener{
    private Table dokterTable;
    private JComboBox listDokter;
    private JComboBox listHari;
    private JComboBox listJam;
    private JTextFieldCustom nama;
    private JTextFieldCustom noHp;
    
    public ReservasiController(Table dokterTable, JComboBox listDokter, JComboBox listHari, JComboBox listJam, JTextFieldCustom nama, JTextFieldCustom noHp) {
        this.dokterTable = dokterTable;
        this.listDokter = listDokter;
        this.listHari = listHari;
        this.listJam = listJam;
        this.nama = nama;
        this.noHp = noHp;
    }
    
    public void loadData() {

        String sqlQueryTableDokter = "select nama_dokter, spesialisasi, hari, jam, ruangan from Dokter join JadwalPraktek using (id_dokter) where status = 'accepted'";
        String sqlQueryListDokter = "select nama_dokter from Dokter";
     
        DefaultTableModel tableModel = (DefaultTableModel) dokterTable.getModel();
        
        try {
            Database db = new Database();
            db.connect();
            ResultSet rs = db.getData(sqlQueryTableDokter);            
            while (rs.next()) {
                String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)}; 
                tableModel.addRow(data);
                
            }
            rs = db.getData(sqlQueryListDokter);
            while (rs.next()) {
                listDokter.addItem((String) rs.getString(1));            
            }
            db.disconnect();
        } catch (SQLException e) {
            System.out.println("Err Load Data Dokter: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String namaPasien = nama.getText();
        String noHpPasien = noHp.getText();
        String jam = (String) listJam.getSelectedItem();
        String hari = (String) listHari.getSelectedItem();
        String namaDokter = (String) listDokter.getSelectedItem();
        Pasien pasien = new Pasien(CurrentUser.username);
        
        Reservasi reservasi = new Reservasi(namaPasien, namaDokter, noHpPasien, hari, jam);
        try {
            if (CurrentUser.username.equals(namaPasien)) {
                pasien.create_reservation(reservasi);
                resetText();
                JOptionPane.showMessageDialog(null, "Reservasi berhasil Diajukan");
            } else {
                resetText();
                JOptionPane.showMessageDialog(null, "Username tidak terdaftar");
            }
            
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, "Reservasi tidak berhasil");
        }
    }
    
    private void resetText(){
        listDokter.setSelectedIndex(-1);
        listHari.setSelectedIndex(-1);
        listJam.setSelectedIndex(-1);
        nama.setText("");
        noHp.setText("");
    }
}

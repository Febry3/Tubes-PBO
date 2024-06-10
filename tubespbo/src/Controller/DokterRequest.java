package Controller;

import GUI.DoctorForm.RequestJadwalForm;
import Model.JadwalPraktek;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DokterRequest implements ListSelectionListener, ActionListener {

    private JList requestList;
    private JList listJadwal;
    private JLabel namaDokter;
    private JLabel jadwalDokter;
    private ButtonGroup statusGroup;
    private JButton submit;
    private int index;
    private ArrayList<JadwalPraktek> tabel_Request = new ArrayList<>();
    private ArrayList<JadwalPraktek> tabel_Jadwal = new ArrayList<>();
    private DefaultListModel tabel_nama = new DefaultListModel();
    private DefaultListModel listModelJadwal = new DefaultListModel();

    public DokterRequest(JList requestList, JList listJadwal, JLabel namaDokter, JLabel jadwalDokter, JButton submit, ButtonGroup status) {
        this.requestList = requestList;
        this.statusGroup = status;
        this.namaDokter = namaDokter;
        this.jadwalDokter = jadwalDokter;
        this.listJadwal = listJadwal;
        this.submit = submit;
        this.requestList.addListSelectionListener(this);
        this.submit.addActionListener(this);
        showTable();
    }

    private void showTable() {
        try {
            Database db = new Database();
            String sql = "select * from JadwalPraktek";
            ResultSet resultset = db.getData(sql);
            tabel_Request.clear();
            tabel_nama.clear();
            while (resultset.next()) {
                JadwalPraktek jadwal = new JadwalPraktek(resultset.getString("ruangan"),
                        resultset.getString("hari"), resultset.getString("jam"),
                        resultset.getString("Status"), resultset.getInt("id_jadwal_praktek"),
                        resultset.getInt("id_dokter"));
                if (jadwal.getStatus().equals("pending")) {
                    tabel_Request.add(jadwal);
                    tabel_nama.addElement("Ruangan : " + jadwal.getRuangan() + " /Hari : "
                            + jadwal.getHari() + " /Jam : " + jadwal.getJam() + " /Status : "
                            + jadwal.getStatus());
                }
            }
            requestList.setModel(tabel_nama);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadDokter() {
        JadwalPraktek selectedJadwal = tabel_Request.get(index);
        int idDokter = selectedJadwal.getId_dokter();
        int jadwal = 0;
        try {
            Database db = new Database();
            String sql = "select * from JadwalPraktek natural join Dokter where id_dokter = " + idDokter;
            ResultSet resultset = db.getData(sql);
            while (resultset.next()) {
                namaDokter.setText("Nama Dokter : " + resultset.getString("nama_dokter"));
                jadwal++;
            }
            jadwalDokter.setText("Jadwal Dokter : " + jadwal);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            index = requestList.getSelectedIndex();
            if (index != -1) {
                JadwalPraktek selectedJadwal = tabel_Request.get(index);
                int idDokter = selectedJadwal.getId_dokter();
                tabel_Jadwal.clear();
                listModelJadwal.clear();
                try {
                    Database db = new Database();
                    String sql = "select * from JadwalPraktek where id_dokter = " + idDokter;
                    ResultSet resultset = db.getData(sql);
                    while (resultset.next()) {
                        JadwalPraktek jadwal = new JadwalPraktek(resultset.getString("ruangan"),
                                resultset.getString("hari"), resultset.getString("jam"),
                                resultset.getString("Status"), resultset.getInt("id_jadwal_praktek"),
                                resultset.getInt("id_dokter"));

                        tabel_Jadwal.add(jadwal);
                        listModelJadwal.addElement("Ruangan : " + jadwal.getRuangan() + " /Hari : "
                                + jadwal.getHari() + " /Jam : " + jadwal.getJam() + " /Status : "
                                + jadwal.getStatus());
                    }
                    listJadwal.setModel(listModelJadwal);
                    loadDokter();
                } catch (SQLException er) {
                    Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, er);
                }
            } else {
                System.out.println("No selection or invalid index");
                listModelJadwal.clear();
                listJadwal.setModel(listModelJadwal);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = listJadwal.getSelectedIndex();
        if (index != -1 && index < tabel_Jadwal.size()) {
            JadwalPraktek selectedJadwal = tabel_Jadwal.get(index);  // Change here to use tabel_Jadwal
            try {
                if (selectedJadwal.getStatus().equals("pending")) {
                    String status = statusGroup.getSelection().getActionCommand();
                    int idDokter = selectedJadwal.getId_dokter();

                    JadwalPraktek jadwal = new JadwalPraktek();
                    if (status.equals("accepted")) {
                        jadwal.penerimaanJadwal("accepted", selectedJadwal.getId_jadwal_praktek(), idDokter);
                        JOptionPane.showMessageDialog(null, "Jadwal diterima");
                    } else {
                        jadwal.penerimaanJadwal("available", selectedJadwal.getId_jadwal_praktek(), idDokter);
                        JOptionPane.showMessageDialog(null, "Jadwal ditolak");
                    }
                    updateJadwalList();
                } else {
                    JOptionPane.showMessageDialog(null, "Jadwal tidak sedang diajukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid");
        }
    }

    private void updateJadwalList() {
        tabel_Jadwal.clear();
        listModelJadwal.clear();
        statusGroup.clearSelection();
        showTable();
        listJadwal.setModel(listModelJadwal);
    }
}

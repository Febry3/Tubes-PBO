package Controller;

import GUI.DoctorForm.RequestJadwalForm;
import Model.Reservasi;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PasienRequest implements ListSelectionListener, ActionListener {

    private JList requestList;
    private JList listJadwal;
    private JLabel namaDokter;
    private JLabel jumlahPasien;
    private JLabel tanggal;
    private ButtonGroup statusGroup;
    private JButton submit;
    private int index;
    private ArrayList<Reservasi> tabel_Request = new ArrayList<>();
    private ArrayList<Reservasi> tabel_Jadwal = new ArrayList<>();
    private DefaultListModel tabel_nama = new DefaultListModel();
    private DefaultListModel listModelJadwal = new DefaultListModel();

    public PasienRequest(JList requestList, JList listJadwal, JLabel namaDokter, JLabel tanggal, JLabel jumlahPasien, JButton submit, ButtonGroup status) {
        this.requestList = requestList;
        this.statusGroup = status;
        this.namaDokter = namaDokter;
        this.tanggal = tanggal;
        this.jumlahPasien = jumlahPasien;
        this.listJadwal = listJadwal;
        this.submit = submit;
        this.requestList.addListSelectionListener(this);
        this.submit.addActionListener(this);
        this.listJadwal.addListSelectionListener(new AnotherListSelectionListener());
        showTable();
    }

    private void showTable() {
        try {
            Database db = new Database();
            String sql = "select id_reservasi, id_pasien, id_dokter, nama_pasien, nama_dokter, "
                    + "hari_reservasi, jam_reservasi, status from Reservasi "
                    + "join Pasien using (id_pasien) "
                    + "join Dokter using (id_dokter)";
            ResultSet rs = db.getData(sql);
            tabel_Request.clear();
            tabel_nama.clear();
            while (rs.next()) {
                Reservasi reserve = new Reservasi(rs.getInt("id_reservasi"), rs.getInt("id_pasien"),
                        rs.getInt("id_dokter"), rs.getString("nama_pasien"), rs.getString("nama_dokter"),
                        rs.getString("hari_reservasi"), rs.getString("jam_reservasi"), rs.getString("status"));
                if (reserve.getStatus().equals("Pending")) {
                    tabel_Request.add(reserve);
                    tabel_nama.addElement("Tanggal : " + reserve.getHari_reservasi() + ", " + reserve.getTanggal_reservasi()
                            + "  //  Jam : " + reserve.getJam_reservasi() + "  //  Status : "
                            + reserve.getStatus());
                }
            }
            requestList.setModel(tabel_nama);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadDokter() {
        Reservasi selectedJadwal = tabel_Request.get(index);
        int idDokter = selectedJadwal.getId_dokter();
        int pasien = 0;
        try {
            Database db = new Database();
            String sql = "select * from Reservasi natural join Dokter where id_dokter = " + idDokter;
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                namaDokter.setText("Nama Dokter : " + rs.getString("nama_dokter"));
                pasien++;
            }
            jumlahPasien.setText("Jumlah Pasien : " + pasien);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            index = requestList.getSelectedIndex();
            if (index != -1) {
                Reservasi selectedJadwal = tabel_Request.get(index);
                int idDokter = selectedJadwal.getId_dokter();
                tabel_Jadwal.clear();
                listModelJadwal.clear();
                try {
                    Database db = new Database();
                    String sql = "select id_reservasi, id_pasien, id_dokter, nama_pasien, nama_dokter, "
                            + "hari_reservasi, jam_reservasi, status from Reservasi "
                            + "join Pasien using (id_pasien) "
                            + "join Dokter using (id_dokter) where id_dokter = " + idDokter;
                    ResultSet rs = db.getData(sql);
                    while (rs.next()) {
                        Reservasi reserve = new Reservasi(rs.getInt("id_reservasi"), rs.getInt("id_pasien"),
                                rs.getInt("id_dokter"), rs.getString("nama_pasien"), rs.getString("nama_dokter"),
                                rs.getString("hari_reservasi"), rs.getString("jam_reservasi"), rs.getString("status"));

                        tabel_Jadwal.add(reserve);
                        listModelJadwal.addElement("Tanggal : " + reserve.getHari_reservasi() + ", " + reserve.getTanggal_reservasi()
                                + "  //  Jam : " + reserve.getJam_reservasi() + "  //  Status : "
                                + reserve.getStatus());
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
            Reservasi selectedJadwal = tabel_Jadwal.get(index);  // Change here to use tabel_Jadwal
            try {
                System.out.println("Selected Jadwal ID: " + selectedJadwal.getId_reservasi());
                System.out.println("Selected Jadwal Status: " + selectedJadwal.getStatus());
                System.out.println("Selected Jadwal Pasien ID: " + selectedJadwal.getId_pasien());

                if (selectedJadwal.getStatus().equals("Pending")) {
                    String status = statusGroup.getSelection().getActionCommand();
                    Integer idPasien = selectedJadwal.getId_pasien();

                    if (idPasien == null) {
                        System.out.println("idPasien is null. Something went wrong.");
                        return;  // Early return if idPasien is null
                    }

                    Reservasi jadwal = new Reservasi();
                    if (status.equals("accepted")) {
                        jadwal.penerimaanJadwal("accepted", selectedJadwal.getId_reservasi(), idPasien);
                        JOptionPane.showMessageDialog(null, "Jadwal diterima");
                    } else {
                        jadwal.penerimaanJadwal("available", selectedJadwal.getId_reservasi(), idPasien);
                        JOptionPane.showMessageDialog(null, "Jadwal ditolak");
                    }
                    updateJadwalList();
                } else {
                    JOptionPane.showMessageDialog(null, "Reservasi tidak sedang diajukan");
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
        namaDokter.setText("Nama Dokter : ");
        tanggal.setText("Tanggal : ");
        jumlahPasien.setText("Jumlah Pasien : ");
        showTable();
        listJadwal.setModel(listModelJadwal);
    }

    private class AnotherListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            Reservasi reserve = null;
            if (!e.getValueIsAdjusting()) {
                index = listJadwal.getSelectedIndex();
                if (index != -1) {
                    Reservasi selectedJadwal = tabel_Jadwal.get(index);
                    int idReservasi = selectedJadwal.getId_reservasi();
                    try {
                        Database db = new Database();
                        String sql = "select id_reservasi, id_pasien, id_dokter, nama_pasien, nama_dokter, "
                                + "hari_reservasi, jam_reservasi, status from Reservasi "
                                + "join Pasien using (id_pasien) "
                                + "join Dokter using (id_dokter) where id_reservasi = " + idReservasi;
                        ResultSet rs = db.getData(sql);
                        while (rs.next()) {
                            reserve = new Reservasi(rs.getInt("id_reservasi"), rs.getInt("id_pasien"),
                                    rs.getInt("id_dokter"), rs.getString("nama_pasien"), rs.getString("nama_dokter"),
                                    rs.getString("hari_reservasi"), rs.getString("jam_reservasi"), rs.getString("status"));
                        }
                        tanggal.setText("Tanggal : " + reserve.getTanggal_reservasi());
                        System.out.println(reserve.getTanggal_reservasi());
                        System.out.println(reserve.getId_reservasi());

                    } catch (SQLException er) {
                        Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, er);
                    }
                } else {
                    System.out.println("No selection or invalid index");
                }
            }
        }
    }
}

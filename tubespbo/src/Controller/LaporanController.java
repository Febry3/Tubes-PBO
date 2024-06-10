package Controller;

import ComponentGUI.JTextFieldCustom;
import static Controller.CurrentUser.getCurrentUsername;
import Model.HasilPengecekan;
import Model.Obat;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LaporanController implements ActionListener {

    private JTextFieldCustom namaPasien = new JTextFieldCustom();
    private JTextFieldCustom tanggalCheckUp = new JTextFieldCustom();
    private JTextArea penyakit = new JTextArea();
    private JTextArea catatan = new JTextArea();
    private JTextArea daftarObat = new JTextArea();
    private ArrayList<HasilPengecekan> tabel_checkUp = new ArrayList();
    ArrayList<Obat> infoObat = new ArrayList();
    String[] listObat = daftarObat.getText().split(",\\s*");
    ResultSet rs;
    HasilPengecekan checkUp = new HasilPengecekan();
    Obat obat = new Obat();

    public LaporanController(JTextFieldCustom namaPasien, JTextFieldCustom tanggalCheckUp, JTextArea penyakit, JTextArea catatan, JTextArea daftarObat) {
        this.namaPasien = namaPasien;
        this.tanggalCheckUp = tanggalCheckUp;
        this.penyakit = penyakit;
        this.catatan = catatan;
        this.daftarObat = daftarObat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Database db = new Database();
        db.connect();
        try {

            if (load_Obat(daftarObat.getText())) {

                load_checkUp(namaPasien.getText(), tanggalCheckUp.getText());
                store_checkUp(namaPasien.getText(), penyakit.getText(), catatan.getText());
                store_obatPasien(infoObat.get(0).getNama_obat(), tabel_checkUp.get(0).getId_dokter(), tabel_checkUp.get(0).getId_pasien());

                System.out.println("id_pasien : " + tabel_checkUp.get(0).getId_pasien());
                JOptionPane.showMessageDialog(null, "Data check Up berhasil di inputkan");
            } else {
                JOptionPane.showMessageDialog(null, "obat tidak dtemukan");
            }

        } catch (ParseException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resetText();
    }

    public void load_checkUp(String nama, String tanggal) throws ParseException {

        Database db = new Database();
        try {
            rs = checkUp.showCheckUp(nama, tanggal, getCurrentUsername());
            while (rs.next()) {
                checkUp = new HasilPengecekan(rs.getInt("id_reservasi"), rs.getInt("id_pasien"), rs.getInt("id_dokter"), rs.getString("tanggal_reservasi"));
                tabel_checkUp.add(checkUp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void store_checkUp(String tanggal, String penyakit, String catatan) throws ParseException {
        try {
            checkUp.input_checkUp(penyakit, catatan, tabel_checkUp.get(0).getId_pasien(), tabel_checkUp.get(0).getId_dokter(), tabel_checkUp.get(0).getId_reservasi());
            resetText();
        } catch (SQLException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resetText();

    }

    public boolean load_Obat(String nama_obat) throws ParseException {
        boolean hasil = false;
        try {
            rs = obat.showObat(nama_obat);
            if (rs.next()) {
                obat = new Obat(rs.getString("nama_obat"));
                infoObat.add(obat);
                hasil = true;
            } else {
                daftarObat.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "obat tidak dtemukan");

        }
        return hasil;
    }

    public void store_obatPasien(String namaObat, int id_dokter, int id_pasien) throws SQLException {
        Database db = new Database();
        String sql = "INSERT INTO `ObatPasien`(`id_obat`, `id_hasil_pengecekan`) VALUES ((select id_obat from Obat where nama_obat = '" 
                + namaObat + "'), (select id_hasil_pengecekan from HasilPengecekan "
                + "where id_dokter = " + id_dokter + " and id_pasien = " + id_pasien  + "))";
        System.out.println(sql);
        db.query(sql);

    }

    private void resetText() {
        penyakit.setText("");
        catatan.setText("");
        daftarObat.setText("");
    }

}

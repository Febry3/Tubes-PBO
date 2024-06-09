package Controller;

import ComponentGUI.JTextFieldCustom;
import static Controller.CurrentUser.getCurrentUsername;
import Model.HasilPengecekan;
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
    ArrayList<String> infoObat = new ArrayList();
    String[] listObat = daftarObat.getText().split(",\\s*");
    ResultSet rs;
    HasilPengecekan checkUp = new HasilPengecekan();

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
            load_checkUp(namaPasien.getText(), tanggalCheckUp.getText());
            JOptionPane.showMessageDialog(null,  tabel_checkUp.get(0).getId_dokter());
            store_checkUp(namaPasien.getText(),penyakit.getText(), catatan.getText());
//          
//            if (!tabel_checkUp.isEmpty()) {
//               
//                JOptionPane.showMessageDialog(null, getCurrentUsername());
//            }
        } catch (ParseException ex) {
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
            }
            tabel_checkUp.add(checkUp);
        } catch (SQLException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void store_checkUp(String tanggal, String penyakit, String catatan) throws ParseException {
        try {
            checkUp.input_checkUp(penyakit, tabel_checkUp.get(0).getTanggal_pengecekan(), catatan, tabel_checkUp.get(0).getId_reservasi(), tabel_checkUp.get(0).getId_pasien(), tabel_checkUp.get(0).getId_dokter());
            resetText();
        } catch (SQLException ex) {
            Logger.getLogger(LaporanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    private void resetText() {
        penyakit.setText("");
        catatan.setText("");
    }

}

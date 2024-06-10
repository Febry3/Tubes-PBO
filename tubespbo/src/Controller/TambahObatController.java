/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ComponentGUI.JTextFieldCustom;
import ComponentGUI.Table;
import Model.Obat;
import Utility.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class TambahObatController implements ActionListener {

    private JTextFieldCustom namaObatField = new JTextFieldCustom();
    private JTextFieldCustom dosisField = new JTextFieldCustom();
    private JTextFieldCustom kegunaanField = new JTextFieldCustom();
    private JTextFieldCustom komposisiField = new JTextFieldCustom();
    private JTextFieldCustom noRegistrasiField = new JTextFieldCustom();
    private JTextFieldCustom kadaluarsaField = new JTextFieldCustom();
    private JTextFieldCustom aturanPakaiField = new JTextFieldCustom();
    private JTextFieldCustom petunjukPenyimpananField = new JTextFieldCustom();
    private JTextFieldCustom hargaField = new JTextFieldCustom();
    private JTextFieldCustom stockField = new JTextFieldCustom();
    

   
    public TambahObatController(JTextFieldCustom namaObatField, JTextFieldCustom dosisField, JTextFieldCustom kegunaanField, JTextFieldCustom komposisiField, JTextFieldCustom noRegistrasiField, JTextFieldCustom kadaluarsaField, JTextFieldCustom aturanPakaiField, JTextFieldCustom petunjukPenyimpananField, JTextFieldCustom hargaField, JTextFieldCustom stockField) {
        this.namaObatField = namaObatField;
        this.dosisField = dosisField;
        this.kegunaanField = kegunaanField;
        this.komposisiField = komposisiField;
        this.noRegistrasiField = noRegistrasiField;
        this.kadaluarsaField = kadaluarsaField;
        this.aturanPakaiField = aturanPakaiField;
        this.petunjukPenyimpananField = petunjukPenyimpananField;
        this.hargaField = hargaField;
        this.stockField = stockField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String namaObat = namaObatField.getText();
            String dosis = dosisField.getText();
            String kegunaan = kegunaanField.getText();
            String komposisi = komposisiField.getText();
            String noRegistrasi = noRegistrasiField.getText();
            String kadaluarsaStr = kadaluarsaField.getText();
            String aturanPakai = aturanPakaiField.getText();
            String petunjukPenyimpanan = petunjukPenyimpananField.getText();
            int harga = Integer.parseInt(hargaField.getText());
            int stock = Integer.parseInt(stockField.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date kadaluarsa = new Date(dateFormat.parse(kadaluarsaStr).getTime());

            Obat obat = new Obat(namaObat, dosis, kegunaan, komposisi, noRegistrasi, kadaluarsa, aturanPakai, petunjukPenyimpanan, harga, stock);
            obat.tambah_obat(namaObat, dosis, kegunaan, komposisi, noRegistrasi, kadaluarsa, aturanPakai, petunjukPenyimpanan, harga, stock);

            JOptionPane.showMessageDialog(null, "Obat berhasil ditambahkan!");
            resetText();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Harga dan Stock harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Format tanggal tidak valid. Gunakan format dd-MM-yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menambahkan obat ke database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   

    private void resetText() {
        namaObatField.setText("");
        dosisField.setText("");
        kegunaanField.setText("");
        komposisiField.setText("");
        noRegistrasiField.setText("");
        kadaluarsaField.setText("");
        aturanPakaiField.setText("");
        petunjukPenyimpananField.setText("");
        hargaField.setText("");
        stockField.setText("");
    }

}

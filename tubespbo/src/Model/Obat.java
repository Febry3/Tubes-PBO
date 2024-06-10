/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Obat {

    private String nama_obat;
    private String dosis;
    private String kegunaan;
    private String komposisi;
    private String no_registrasi;
    private Date kadaluarsa;
    private String aturan_pakai;
    private String petunjuk_penyimpanan;
    private int harga;
    private int stock;

    public Obat(String nama_obat, String no_registrasi, int harga, int stock) {
        this.nama_obat = nama_obat;
        this.no_registrasi = no_registrasi;
        this.harga = harga;
        this.stock = stock;
    }


    public Obat(String nama) {
        this.nama_obat = nama;
    }
    

    public Obat(String nama_obat, String dosis, String kegunaan, String komposisi, String no_registrasi, Date kadaluarsa, String aturan_pakai, String petunjuk_penyimpanan, int harga, int stock) {
        this.nama_obat = nama_obat;
        this.dosis = dosis;
        this.kegunaan = kegunaan;
        this.komposisi = komposisi;
        this.no_registrasi = no_registrasi;
        this.kadaluarsa = kadaluarsa;
        this.aturan_pakai = aturan_pakai;
        this.petunjuk_penyimpanan = petunjuk_penyimpanan;
        this.harga = harga;
        this.stock = stock;
    }

    public Obat() {

    }


    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan = kegunaan;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    public String getNo_registrasi() {
        return no_registrasi;
    }

    public void setNo_registrasi(String no_registrasi) {
        this.no_registrasi = no_registrasi;
    }

    public Date getKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(Date kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public String getAturan_pakai() {
        return aturan_pakai;
    }

    public void setAturan_pakai(String aturan_pakai) {
        this.aturan_pakai = aturan_pakai;
    }

    public String getPetunjuk_penyimpanan() {
        return petunjuk_penyimpanan;
    }

    public void setPetunjuk_penyimpanan(String petunjuk_penyimpanan) {
        this.petunjuk_penyimpanan = petunjuk_penyimpanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ResultSet showObat(String obat) throws SQLException {
        Database db = new Database();
        String sql = "select nama_obat "
                + "from Obat"
                + " where "
                + " nama_obat = '" + obat + "' ";
        return db.getData(sql);
    }


    public void tambah_obat(String nama_obat, String dosis, String kegunaan, String komposisi, String no_registrasi, Date kadaluarsa, String aturan_pakai, String petunjuk_penyimpanan, int harga, int stock) throws SQLException {
        Database db = new Database();
        String sql = "insert into Obat (nama_obat, dosis, kegunaan, komposisi, no_registrasi, kadaluarsa, aturan_pakai, petunjuk_penyimpanan, harga, stock) "
                + " values ('" + nama_obat + "', '" + dosis + "', '" + kegunaan + "', '" + komposisi 
                + "', '" + no_registrasi + "', '" + kadaluarsa + "', '" + aturan_pakai + "', '" + petunjuk_penyimpanan 
                + "', " + harga + "," + stock + ")";
        db.query(sql);
    }
    
    public ResultSet showAllObat() throws SQLException {
        Database db = new Database();
        String sql = "SELECT * FROM Obat";
        return db.getData(sql);
    }
    
    public void deleteObat(String nama) throws SQLException {
        Database db = new Database();
        db.connect();
        String sql = "DELETE from Obat where nama_obat = '" + nama + "'; ";
        db.query(sql);
        db.disconnect();
    }
    
    public Obat (String namaObat, int harga, int stock) {
        this.nama_obat = namaObat;
        this.harga = harga;
        this.stock = stock;
    }
    
    public void updateObat() throws SQLException{
        String sqlQuery = "update Obat set harga = " + harga + ", stock = " + stock + " where nama_obat = '" + nama_obat + "'";
        System.out.println(sqlQuery);
        Database db = new Database();
        db.connect();
        db.query(sqlQuery);
        db.disconnect();
    }
}

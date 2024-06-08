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
public class Obat  {
    private String nama_obat;
    private String dosis;
    private String[] kegunaan;
    private String[] komposisi;
    private String no_registrasi;
    private Date kadaluarsa;
    private String aturan_pakai;
    private String petunjuk_penyimpanan;
    private int harga;
    private int stock;

    
    public Obat(){ 
       
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

    public String[] getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String[] kegunaan) {
        this.kegunaan = kegunaan;
    }

    public String[] getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String[] komposisi) {
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
                + " namaObat = '" + obat + "' ";
        return db.getData(sql);
    }
    
}

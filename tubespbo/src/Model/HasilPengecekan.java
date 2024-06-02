/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class HasilPengecekan  {
    private String nama_pasien;
    private String no_telepon;
    private String[] nama_penyakit;
    private Obat[] daftar_obat;
    private Date tanggal_pengecekan;
    private String catatan;

    public HasilPengecekan(String nama_pasien, String no_telepon, String[] nama_penyakit, Obat[] daftar_obat, Date tanggal_pengecekan, String catatan) {
        this.nama_pasien = nama_pasien;
        this.no_telepon = no_telepon;
        this.nama_penyakit = nama_penyakit;
        this.daftar_obat = daftar_obat;
        this.tanggal_pengecekan = tanggal_pengecekan;
        this.catatan = catatan;
    }
    
    

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String[] getNama_penyakit() {
        return nama_penyakit;
    }

    public void setNama_penyakit(String[] nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }

    public Obat[] getDaftar_obat() {
        return daftar_obat;
    }

    public void setDaftar_obat(Obat[] daftar_obat) {
        this.daftar_obat = daftar_obat;
    }

    public Date getTanggal_pengecekan() {
        return tanggal_pengecekan;
    }

    public void setTanggal_pengecekan(Date tanggal_pengecekan) {
        this.tanggal_pengecekan = tanggal_pengecekan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

  
    
}

        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author hafid
 */
public class Reservasi {
    private String nama_pasien;
    private String nama_dokter;
    private String nomor_telepon;
    private Date tanggal_reservasi;
    private Date waktu_reservasi;
    private String status;

    public Reservasi(String nama_pasien, String nama_dokter, String nomor_telepon, Date tanggal_reservasi, Date waktu_reservasi, String status) {
        this.nama_pasien = nama_pasien;
        this.nama_dokter = nama_dokter;
        this.nomor_telepon = nomor_telepon;
        this.tanggal_reservasi = tanggal_reservasi;
        this.waktu_reservasi = waktu_reservasi;
        this.status = status;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public Date getTannggal_reservasi() {
        return tanggal_reservasi;
    }

    public void setTannggal_reservasi(Date tannggal_reservasi) {
        this.tanggal_reservasi = tannggal_reservasi;
    }

    public Date getWaktu_reservasi() {
        return waktu_reservasi;
    }

    public void setWaktu_reservasi(Date waktu_reservasi) {
        this.waktu_reservasi = waktu_reservasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

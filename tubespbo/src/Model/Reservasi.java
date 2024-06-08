        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.DateUtilities;
import java.sql.Date;

/**
 *
 * @author hafid
 */
public class Reservasi {
    private int id_reservasi;
    private String nama_pasien;
    private String nama_dokter;
    private String nomor_telepon;
    private String tanggal_reservasi;
    private String hari_reservasi;
    private String jam_reservasi;
    private String status = "Pending";

    public Reservasi(String nama_pasien, String nama_dokter, String nomor_telepon, String hari_reservasi, String jam_reservasi) {
        this.nama_pasien = nama_pasien;
        this.nama_dokter = nama_dokter;
        this.nomor_telepon = nomor_telepon;
        this.hari_reservasi = hari_reservasi;
        this.jam_reservasi = jam_reservasi;
        this.tanggal_reservasi = DateUtilities.dateAdditionFromNow(hari_reservasi);
    }
    
    public Reservasi(int id){
        this.id_reservasi = id;
    }
    
    public Reservasi(){
        
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

    public String getTanggal_reservasi() {
        return tanggal_reservasi;
    }

    public void setTanggal_reservasi(String tanggal_reservasi) {
        this.tanggal_reservasi = tanggal_reservasi;
    }

    public String getHari_reservasi() {
        return hari_reservasi;
    }

    public void setHari_reservasi(String hari_reservasi) {
        this.hari_reservasi = hari_reservasi;
    }

    public String getJam_reservasi() {
        return jam_reservasi;
    }

    public void setJam_reservasi(String jam_reservasi) {
        this.jam_reservasi = jam_reservasi;
    }
   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_reservasi() {
        return id_reservasi;
    }

    public void setId_reservasi(int id_reservasi) {
        this.id_reservasi = id_reservasi;
    }
    
    
}

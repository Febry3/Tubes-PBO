
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hafid
 */
public class Dokter extends Staff {

    //dokterr
    private String spesialisasi;
    private JadwalPraktek[] jadwal_praktik;

    public Dokter(String spesialisasi, JadwalPraktek[] jadwal_praktik, String department, String fullname, String nama_pengguna, String no_telepon, String password) {
        super(department, fullname, nama_pengguna, no_telepon, password);
        this.spesialisasi = spesialisasi;
        this.jadwal_praktik = jadwal_praktik;
    }
    
    public Dokter(String username, String password){
        super(username, password);
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public JadwalPraktek[] getJadwal_praktik() {
        return jadwal_praktik;
    }

    public void setJadwal_praktik(JadwalPraktek[] jadwal_praktik) {
        this.jadwal_praktik = jadwal_praktik;
    }

    public void edit_jadwal_praktek() {

    }

    public void hapus_jadwal_praktek() {

    }

    public void tambah_jadwal_praktek() {

    }

    public void cek_pasien() {

    }

    public ResultSet Login(String username, String password) throws SQLException {
        Database db = new Database();
        String sql = "select nama_dokter as username from Dokter"
                + " where"
                + " nama_dokter = '" + username + "'";
        return db.getData(sql);
    }
}

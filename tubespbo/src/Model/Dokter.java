
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Controller.CurrentUser.getCurrentRole;
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

    public Dokter(String spesialisasi, String department, String nama_pengguna, String no_telepon, String password, String role) {
        super(department, nama_pengguna, no_telepon, password, role);
        this.spesialisasi = spesialisasi;
    }
    
    
    public Dokter(String username, String password){
        super(username, password);
    }

    public Dokter() {
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
         String sql = "select nama_dokter as username, password as password"
                + " from `Dokter`"
                + " where "
                + " nama_dokter = '" + username + "' "
                + " AND"
                + " password = '" + password + "'";
        return db.getData(sql);
    } 

    @Override
    public void change_password(String username, String newPass) throws SQLException {
        Database db = new Database();
        db.connect();
        String sql = "update " + getCurrentRole() 
                + " set password  = '" + newPass + "' "
                + " where nama_dokter = '" + username + "';";
        System.out.println(sql);
        db.query(sql);
        db.disconnect();
    } 

    @Override
    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "select password as password from Dokter"
                + " where"
                + " nama_dokter = '" + username + "';";
        return db.getData(sql);
    }
    
    
}

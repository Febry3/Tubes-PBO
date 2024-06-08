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
 * @author ASUS
 */
public class Pasien extends Pengguna {

    private String alamat;
    private HasilPengecekan[] riwayat_pemeriksaan;

    public Pasien(String alamat, String nama_pengguna, String no_telepon, String password, String role) {
        super(nama_pengguna, no_telepon, password, role);
        this.alamat = alamat;
    }
    
    public Pasien(String nama_pengguna, String password){
        super(nama_pengguna, password);
    }

    public Pasien() {
    }
    
    

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public HasilPengecekan[] getRiwayat_pemeriksaan() {
        return riwayat_pemeriksaan;
    }

    public void setRiwayat_pemeriksaan(HasilPengecekan[] riwayat_pemeriksaan) {
        this.riwayat_pemeriksaan = riwayat_pemeriksaan;
    }

    public void register_akun() throws SQLException {
        Database db = new Database();
        db.connect();
        String sqlQuery = "insert into Pasien (nama_pasien, no_telepon, alamat, password)"
                + " values ('" + super.getNama_pengguna() + "', '" + super.getNo_telepon() + "', '" + alamat
                + "', '" + super.getPassword_pengguna() + "')";
        System.out.println(sqlQuery);
        db.query(sqlQuery);
    }

    public void create_reservation() {

    }

    public void check_up() {

    }

    public void view_check_up_history() {

    }

    public void search_schedule() {
        // fungsi atau procedure ?????
    }

    public void view_schedule() {

    }

    public boolean is_med_available(Obat obat) {
        return true;
    }

    public ResultSet Login(String username, String password) throws SQLException {
        Database db = new Database();
        String sql = "select nama_pasien as username "
                + "from `Pasien`"
                + " where "
                + " nama_pasien = '" + username + "' "
                + " AND"
                + " password = '" + password + "'";
        return db.getData(sql);
    }

    @Override
    public void change_password(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "update " + super.getRole() 
                + " set password  = '" + newPass + "' "
                + " where password = '" + username + "';";
        db.query(sql);
    }

    @Override
    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "select password as password from Pasien"
                + " where"
                + " nama_pasien = '" + username + "';";
        return db.getData(sql);
    }



}

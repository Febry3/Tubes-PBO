
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
public class JadwalPraktek {

    //jadwalpraktekk
    private String ruangan;
    private String hari;
    private String jam;
    private String Status;
    private int id_jadwal_praktek;
     private int id_dokter;


    public JadwalPraktek(String ruangan, String hari, String jam, String Status, int id_jadwal_praktek, int id_dokter) {
        this.ruangan = ruangan;
        this.hari = hari;
        this.jam = jam;
        this.Status = Status;
        this.id_jadwal_praktek = id_jadwal_praktek;
        this.id_dokter = id_dokter;
    }

    public JadwalPraktek() {
    }

    
    public int getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public int getId_jadwal_praktek() {
        return id_jadwal_praktek;
    }

    public void setId_jadwal_praktek(int id_jadwal_praktek) {
        this.id_jadwal_praktek = id_jadwal_praktek;
    }

    public void pengajuanJadwal(String ubahstatus, int idJadwal,String nama) throws SQLException {
        Database db = new Database();
        String sql = "update JadwalPraktek set Status  ='" + ubahstatus + "', id_dokter = "  + "(select id_dokter from Dokter where nama_dokter = '" + nama + "')"  
                + " where id_jadwal_praktek =" + idJadwal + "";
        System.out.println(sql);
        db.query(sql);
    }

    public void penerimaanJadwal(String ubahstatus, int idJadwal, Integer id_dokter) throws SQLException {
        Database db = new Database();
        String sql = "";
        if (ubahstatus.equals("accepted")) {
            sql = "update JadwalPraktek set Status  ='" + ubahstatus
                    + "'where id_jadwal_praktek ='" + idJadwal + "'";
        } else {
            sql = "update JadwalPraktek set Status  ='" + ubahstatus
                    + "', id_dokter = null"
                    + " where id_jadwal_praktek ='" + idJadwal + "'";
        }
        db.query(sql);
    }

    public void listJadwalDokter(String ubahstatus, int idJadwal) throws SQLException {
        Database db = new Database();
        String sql = "select id_jadwal_praktek, id_dokter";
        db.query(sql);
    }

}

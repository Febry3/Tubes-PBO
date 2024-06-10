/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Database;
import Utility.DateUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HasilPengecekan extends Reservasi {

    private String nama_pasien;
    private String no_telepon;
    private String[] nama_penyakit;
    private String penyakit;
    private Obat[] daftar_obat;
    private String tanggal_pengecekan;
    private String catatan;
    private int id_pasien;
    private int id_dokter;

    public HasilPengecekan(String nama_pasien, String no_telepon, String[] nama_penyakit, Obat[] daftar_obat, String hari_reservasi, String catatan) {
        this.nama_pasien = nama_pasien;
        this.no_telepon = no_telepon;
        this.nama_penyakit = nama_penyakit;
        this.daftar_obat = daftar_obat;
        this.tanggal_pengecekan = DateUtilities.dateAdditionFromNow(hari_reservasi);;
        this.catatan = catatan;
    }

    public HasilPengecekan(String namaPasien, String penyakit, String catatan, int id_reservasi, int id_pasien, int id_dokter) {
        super(id_reservasi);
        this.nama_pasien = namaPasien;
        this.penyakit = penyakit;
        this.catatan = catatan;
        this.id_dokter = id_dokter;
        this.id_pasien = id_pasien;
    }

    public HasilPengecekan(int id_reservasi, int id_pasien, int id_dokter, String hari_reservasi) {
        super(id_reservasi);
        this.id_dokter = id_dokter;
        this.id_pasien = id_pasien;
        this.tanggal_pengecekan = DateUtilities.dateFormatYYMMDD(hari_reservasi);;
    }
    
    public HasilPengecekan(String nama_pasien){
        this.nama_pasien = nama_pasien;
    }

    public HasilPengecekan() {

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

    public String getTanggal_pengecekan() {
        return tanggal_pengecekan;
    }

    public void setTanggal_pengecekan(String tanggal_pengecekan) {
        this.tanggal_pengecekan = tanggal_pengecekan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public int getId_dokter() {
        return id_dokter;
    }

    public void input_checkUp(String nama_penyakit, String catatan, int idPasien, int idDokter, int idReservasi) throws SQLException {
        Database db = new Database();
        String sql = "insert into HasilPengecekan "
                + "(nama_penyakit, catatan,id_pasien, id_dokter, id_reservasi) "
                + " values "
                + "('" + nama_penyakit
                + "', '" + catatan
                + "'," + idPasien + ","
                + idDokter + ","
                + idReservasi + ")";
        System.out.println(sql);
        db.query(sql);
    }

    public ResultSet showCheckUp(String nama, String tanggal, String nama_dokter) throws SQLException {
        Database db = new Database();
        String sql = "select id_reservasi, id_pasien, id_dokter, tanggal_reservasi"
                + " from Reservasi"
                + " join Pasien using (id_pasien)"
                + " join Dokter using (id_dokter)"
                + " where"
                + " nama_pasien = '" + nama + "' "
                + " AND"
                + " nama_dokter = '" + nama_dokter + "' "
                + " AND"
                + " tanggal_reservasi = '" + tanggal + "' ";
        System.out.println(sql);
        return db.getData(sql);

    }
    
    public ResultSet getDaftarPengecekkan() {
        String sqlQuery = "select id_hasil_pengecekan, nama_penyakit, catatan, nama_pasien, nama_dokter, tanggal_reservasi from HasilPengecekan join Dokter using (id_dokter) join Pasien using (id_pasien) join Reservasi using (id_reservasi) where nama_pasien = '" + nama_pasien + "'";
        Database db = new Database();
        return db.getData(sqlQuery);
    }
}

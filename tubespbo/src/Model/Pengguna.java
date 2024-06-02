package Model;

import Utility.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Pengguna {
    private static int id_pengguna;
    private String nama_pengguna;
    private String password_pengguna;
    private String no_telepon;

    public Pengguna(String nama_pengguna, String no_telepon, String password_pengguna) {
        this.nama_pengguna = nama_pengguna;
        this.password_pengguna = password_pengguna;
        this.no_telepon = no_telepon;
    }

    public Pengguna(String nama_pengguna, String password_pengguna) {
        this.nama_pengguna = nama_pengguna;
        this.password_pengguna = password_pengguna;
    }
    
    public String getPassword_pengguna() {
        return password_pengguna;
    }

    public void setPassword_pengguna(String password_pengguna) {
        this.password_pengguna = password_pengguna;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_pengguna() {
        return nama_pengguna;
    }

    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void Logout() {

    }

    public ResultSet Login(String username, String password) throws SQLException {
        //SELECT Pasien.nama_pasien as username
        //FROM Pasien
        //UNION
        //select Dokter.nama_dokter from Dokter;
        Database db = new Database();
        String sql = "select Pasien.nama_pasien as username "
                + "from `Pasien`"
                + "where "
                + "Pasien.nama_pasien = '" + username + "' "
                + " AND"
                + "Pasien.password = '" + password + "'"
                + "UNION"
                + "select Dokter.nama_dokter "
                + "where"
                + "Dokter.nama_dokter = '" + username + "' ";
        return db.getData(sql);
    }

//    public void Register() throws SQLException {
//        Database db = new Database();
//        String sql = "insert into users (fullname_user, username, telp_user, password_user)"
//                + "values ('" + this.getFullname_pengguna() + "','" + this.getNama_pengguna()
//                + "','" + this.getNo_telepon() + "','" + this.getPassword_pengguna() + "')";
//        db.query(sql);
//    }

    public abstract void change_password();

}

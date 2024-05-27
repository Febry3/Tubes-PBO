/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public abstract class Pengguna {
    private String id_pengguna;
    private String nama_pengguna;
    private String no_telepon;

    public Pengguna(String id_pengguna, String nama_pengguna, String no_telepon) {
        this.id_pengguna = id_pengguna;
        this.nama_pengguna = nama_pengguna;
        this.no_telepon = no_telepon;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
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
    
    public void Login() {
        
    }
    
    public abstract void change_password();
    
}

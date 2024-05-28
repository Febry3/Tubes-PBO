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
public class Pasien extends Pengguna{
    private String alamat;
    private HasilPengecekan[] riwayat_pemeriksaan;

    public Pasien(String alamat, HasilPengecekan[] riwayat_pemeriksaan, String fullname, String nama_pengguna, String no_telepon, String password) {
        super(fullname, nama_pengguna, no_telepon, password);
        this.alamat = alamat;
        this.riwayat_pemeriksaan = riwayat_pemeriksaan;
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
    
    public void register_akun() {
        
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
    
    @Override
    public void change_password() {
        
    }
    
}

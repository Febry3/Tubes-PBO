/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hafid
 */
public class Schedule{
    private Reservasi[] daftar_jadwal;

    public Schedule(Reservasi[] daftar_jadwal) {
        this.daftar_jadwal = daftar_jadwal;
    }
    
    
    public Reservasi[] getDaftar_jadwal() {
        return daftar_jadwal;
    }

    public void setDaftar_jadwal(Reservasi[] daftar_jadwal) {
        this.daftar_jadwal = daftar_jadwal;
    }
    
    
}

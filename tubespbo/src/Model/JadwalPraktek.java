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
public class JadwalPraktek {
    //jadwalpraktekk
    private String hari;
    private String[] jam;

    public JadwalPraktek(String hari, String[] jam) {
        this.hari = hari;
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String[] getJam() {
        return jam;
    }

    public void setJam(String[] jam) {
        this.jam = jam;
    }
 
}

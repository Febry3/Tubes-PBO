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
public class Apoteker extends Staff{
    private String shift;

    public Apoteker(String shift, String department, String nama_pengguna, String no_telepon, String password) {
        super(department, nama_pengguna, no_telepon, password);
        this.shift = shift;
    }

    
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    public void edit_inventory() {
        
    }
    
    public void add_inventory() {
        
    }
    
    public void remove_inventory() {
        
    }
    
    public void update_inventory() {
        
    }
    
    public void search_inventory() {
    
    }
}

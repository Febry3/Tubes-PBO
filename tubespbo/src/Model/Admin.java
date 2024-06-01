
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
public class Admin extends Staff{
    //adminn
    private String shift;

    public Admin(String shift, String department, String fullname, String nama_pengguna, String no_telepon, String password) {
        super(department, fullname, nama_pengguna, no_telepon, password);
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    public void edit_schedule(){
        
    }
    public void add_schedule(){
         
    }   
    public void remove_schedule(){
         
    }   
    public void edit_reservation(){
        
    }
    public void remove_reservation(){
        
    }
    public void create_reservation(){
        
    }
    public void manage_reservation(){
        
    }
}
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
public class Staff extends Pengguna{
    //staff
    private String department;

    public Staff(String department, String id_pengguna, String nama_pengguna, String no_telepon) {
        super(id_pengguna, nama_pengguna, no_telepon);
        this.department = department;
    }

    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void viewSchedule(){
        
    }
    @Override
    public void change_password() {
       
    }
    
    
}

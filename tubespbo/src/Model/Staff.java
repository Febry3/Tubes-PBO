/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hafid
 */
public class Staff extends Pengguna{
    //staff
    private String department;

    public Staff(String department, String fullname, String nama_pengguna, String no_telepon, String password) {
        super(nama_pengguna, no_telepon, password);
        this.department = department;
    }
    
    public Staff(String username, String password){
        super(username, password);
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

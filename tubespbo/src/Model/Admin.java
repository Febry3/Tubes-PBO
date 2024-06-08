
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hafid
 */
public class Admin extends Staff{
    //adminn
    private String shift;

    public Admin(String shift, String department, String nama_pengguna, String no_telepon, String password, String role) {
        super(department, nama_pengguna, no_telepon, password, role);
        this.shift = shift;
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
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
    public ResultSet Login(String username, String password) throws SQLException {
        Database db = new Database();
        String sql = "select nama_admin as username from Admin"
                + " where"
                + " nama_admin = '" + username + "'";
        return db.getData(sql);
    }

    @Override
    public void change_password(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "update " + super.getRole() 
                + " set password  = '" + newPass + "' "
                + " where password = '" + username + "';";
        db.query(sql);
    }

    @Override
    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "select password as password from Admin"
                + " where"
                + " nama_admin = '" + username + "';";
        return db.getData(sql);
    }
    
    
    
    
}
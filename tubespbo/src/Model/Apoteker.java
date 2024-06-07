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
 * @author ASUS
 */
public class Apoteker extends Staff{
    private String shift;

    public Apoteker(String shift, String department, String nama_pengguna, String no_telepon, String password, String role) {
        super(department, nama_pengguna, no_telepon, password, role);
        this.shift = shift;
    }

    public Apoteker(String username, String password) {
        super(username,password);
    }

    public Apoteker() {
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
    
    public ResultSet Login(String username, String password) throws SQLException {
        Database db = new Database();
        String sql = "select nama_apoteker as username from Apoteker"
                + " where"
                + " nama_apoteker = '" + username + "'";
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
    
}

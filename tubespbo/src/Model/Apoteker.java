/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Controller.CurrentUser.getCurrentRole;
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
         String sql = "select nama_apoteker as username, password as password"
                + " from `Apoteker`"
                + " where "
                + " nama_apoteker = '" + username + "' "
                + " AND"
                + " password = '" + password + "'";
        return db.getData(sql);
    }

    @Override
    public void change_password(String username, String newPass) throws SQLException {
       Database db = new Database();
        db.connect();
        String sql = "update " + getCurrentRole() 
                + " set password  = '" + newPass + "' "
                + " where nama_apoteker = '" + username + "';";
        System.out.println(sql);
        db.query(sql);
        db.disconnect();
    }

    @Override
    public ResultSet checkOldPassword(String username, String newPass) throws SQLException {
        Database db = new Database();
        String sql = "select password as password from Apoteker"
                + " where"
                + " nama_apoteker = '" + username + "';";
        return db.getData(sql);
    }
    
    
}

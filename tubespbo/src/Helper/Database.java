/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Database {
    static final String DB_URL = "jdbc:mysql://localhost/dbtubes"; 
    static final String DB_USER = "root"; 
    static final String DB_PASS = "none"; 
    static Connection conn; 
    static Statement stmt; 
    static ResultSet rs; 
    
    public Database() {

    }
    
    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error Connection");
        }
    }
    
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error Disconnect");
        }
    }
    
    public ResultSet getData(String SQLString) {
        try {
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE); 
        }
        return rs;
    }
    
    public void query(String SQLString) throws SQLException {
        try {
            stmt.executeUpdate(SQLString);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}

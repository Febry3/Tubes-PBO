/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author hafid
 */
public class CurrentUser {
    static String username = "";
    static String role;
    
    public CurrentUser(String user,String role) {
        this.username = user;
        this.role =role;
    }

    public static String getCurrentUsername() {
        return username;
    }

    public static String getCurrentRole() {
        return role;
    }
    
}

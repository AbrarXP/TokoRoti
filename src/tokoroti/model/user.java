/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.model;

import java.sql.*;
import javax.swing.JOptionPane;
import tokoroti.controller.connector;

/**
 *
 * @author LENOVO
 */
public class user {
    private int ID;
    private String username;
    private String password;
    private String profilePicture;
    private String role;
    
    private connector db;

    public user(int ID, String username, String password, String role, String profilePicture) throws SQLException {
        db = new connector();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
    }
    
    public user login(String tryUser, String tryPass) throws SQLException{
        user p;
        String query = "SELECT * FROM users WHERE user = '"+tryUser+"' AND pass = '"+tryPass+"'";
        ResultSet rs = db.st.executeQuery(query);
        if(rs.next()){
            p = new user(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
            JOptionPane.showMessageDialog(null,"Berhasil Login !", "Login Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            p = null;
            JOptionPane.showMessageDialog(null,"Gagal Login !", "Login Gagal", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }

    public String getRole() {
        return role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUsername() {
        return username;
    }
    
    
    
    
}

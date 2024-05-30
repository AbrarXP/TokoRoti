/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.controller;
import java.sql.*;

public class connector {
    Connection cn;
    public Statement st;
    
    String url = "jdbc:mysql://localhost:3306/toko";

    public connector() throws SQLException {
        this.cn = DriverManager.getConnection(url,"root","");
        st = cn.createStatement();
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import model.User;

/**
 *
 * @author Asus
 */
public class User_service {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public User login(String user, String pass) {
        sql = "SELECT username, password FROM Users WHERE username = ? AND password = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, user);
            ps.setObject(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUser(rs.getString("username"));
                u.setPass(rs.getString("password"));
                return u; // Username and password found in the database, return the User object
            } else {
                return null; // Username and password not found in the database
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ hoặc ghi lỗi tại đây
            e.printStackTrace();
            return null;
        }
    }
}

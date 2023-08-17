/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.User;

/**
 *
 * @author dungn
 */
public class UserService {
        public boolean checkLogin(String username, String password){
    
            String sql = "SELECT * FROM NguoiDung WHERE UserName = ? AND PassWord = ?";

            try {
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, username); 
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
            }

    
}

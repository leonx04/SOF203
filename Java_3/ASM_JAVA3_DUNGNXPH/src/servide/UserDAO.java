/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servide;

import java.sql.Connection;
import java.util.ArrayList;
import model.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import view.LoginJFrame;

/**
 *
 * @author DELL
 */
public class UserDAO {

    public static ArrayList<User> viewAll() {
        ArrayList<User> list = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT * From Users";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String un = rs.getString(1);
                String pwd = rs.getString(2);
                String role = rs.getString(3);
                User user = new User(un, pwd, role);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
   
    public static boolean checkLogin(String username, String password) {
        int row = 0;
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            String sql = "select username,password,roles from Users where username = '"+username+"' and password='"+ password+"'";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                row = 1;
                String un = rs.getString(1);
                String pwd = rs.getString(2);
                String roles = rs.getString(3);
                LoginJFrame.User = new User(un,pwd,roles);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return (row>0);
    }

}

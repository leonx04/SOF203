/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servide;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Student;
import model.User;
import view.LoginJFrame;
/**
 *
 * @author DELL
 */
public class StudentDAO {
    public static ArrayList<Student> viewAll() {
       ArrayList<Student> list = new ArrayList<>();
       try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            String sql = "select * From Students";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){             
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                int sdt = rs.getInt(4);
                boolean gioitinh = rs.getBoolean(5);
                String diachi = rs.getString(6);
                String hinhanh = rs.getString(7);
                Student student = new Student(masv, hoten, email, sdt, gioitinh, diachi, hinhanh);
                list.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;
    }
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    public int addSV(Student sv){
        sql="insert into Students(Masv,TenSV,Email,Sdt,gioitinh,diachi,hinhanh) values(?,?,?,?,?,?,?)";
        try {
            con = DbConnection.getConnection();
            ps =con.prepareStatement(sql);
            ps.setObject(1, sv.getMasv());
            ps.setObject(2, sv.getHoten());
            ps.setObject(3, sv.getEmail());
            ps.setObject(4, sv.getSodt());
            ps.setObject(5, sv.getGioitinh());
            ps.setObject(6, sv.getDiachi());
            ps.setObject(7, sv.getHinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int update(Student sv,String ma){
        sql= "update Students set TenSV =? ,Email =?, Sdt=?,gioitinh=?,diachi=?,hinhanh=? where MaSV like ?";
        try {
            con =DbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getHoten());
            ps.setObject(2, sv.getEmail());
            ps.setObject(3, sv.getSodt());
            ps.setObject(4, sv.getGioitinh());
            ps.setObject(5, sv.getDiachi());
            ps.setObject(6, sv.getHinh());
            ps.setObject(7, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int delete(String ma){
        sql="delete from Students where MaSV = ?";
        try {
            con =DbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
/**
 *
 * @author Asus
 */
public class QLSV_service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    public List<SinhVien> getAll(){
        sql ="SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM Students";
        List<SinhVien> listSV=new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {                
                SinhVien sv = new SinhVien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int addSinhVien(SinhVien sv){
        sql ="INSERT INTO Students (MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh)VALUES (?,?,?,?,?,?,?)";
        try {
             con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getMasv());
            ps.setObject(2, sv.getTenSV());
            ps.setObject(3, sv.getEmail());
            ps.setObject(4, sv.getSdt());
            ps.setObject(5, sv.isGioitinh());
            ps.setObject(6, sv.getDiachi());
            ps.setObject(7, sv.getHinhanh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public SinhVien getSinhVien(String maSV){
        sql ="SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM Students where MaSV = ?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            rs= ps.executeQuery();
            while (rs.next()) {                
               sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7));
               
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

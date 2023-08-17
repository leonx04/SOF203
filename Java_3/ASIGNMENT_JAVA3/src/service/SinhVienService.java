/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SinhVien;

/**
 *
 * @author dungn
 */
public class SinhVienService {
    Connection con = DBconnect.getConnection();
    PreparedStatement ps =  null;
    ResultSet rs = null;
    String  sql = null;
    String sqlDeleteDiem = null;

    public List<SinhVien> getAll(){
        sql ="SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM SinhVien";
        List<SinhVien> listSV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                SinhVien sv = new SinhVien( 
                    rs.getString(1),
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
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public int addSinhVien(SinhVien sv){
        sql = "INSERT INTO SinhVien(MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh)VALUES (?,?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, sv.getMaSV());
            ps.setObject(2, sv.getHoTen());
            ps.setObject(3, sv.getEmail());
            ps.setObject(4, sv.getSDT());
            ps.setObject(5, sv.isGioiTinh());
            ps.setObject(6, sv.getDiaChi());
            ps.setObject(7, sv.getHinhAnh());
            return ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }
    
    public SinhVien getSinhVien(String MaSV){
        sql="SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM SinhVien  where MaSV = ?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaSV);
            rs = ps.executeQuery();
            while(rs.next()){
                sv = new SinhVien( 
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getBoolean(5),
                    rs.getString(6),
                    rs.getString(7)   
                );
            }
            return sv;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public int deleteSinhVien(String MaSV){
        try {
            con =  DBconnect.getConnection();
            sqlDeleteDiem = "DELETE FROM DIEM WHERE MaSV = ?";
            ps = con.prepareStatement(sqlDeleteDiem);
            ps.setString(1, MaSV);
            ps.executeUpdate();

            sql ="DELETE FROM SinhVien WHERE MaSV = ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaSV);
            int a = ps.executeUpdate();
            return  a;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
            }
        }
        
    public int updateSinhVien(SinhVien sv) {
            String sql = "UPDATE SinhVien SET HoTen=?, Email=?, SDT=?, GioiTinh=?, DiaChi=? WHERE MaSV=?";
            try {
                con = DBconnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, sv.getHoTen());
                ps.setString(2, sv.getEmail());
                ps.setString(3, sv.getSDT());
                ps.setBoolean(4, sv.isGioiTinh());
                ps.setString(5, sv.getDiaChi());
                ps.setString(6, sv.getMaSV());
                return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        
    
}
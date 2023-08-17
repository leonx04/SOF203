/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungn
 */

import model.Diem;
import model.SinhVien;
public class DiemService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Diem> getAll(){
        sql = "SELECT  TOP 3      SinhVien.MaSV, SinhVien.HoTen, DIEM.TiengAnh, DIEM.TinHoc, DIEM.GDTC, ( DIEM.TiengAnh + DIEM.TinHoc + DIEM.GDTC)/3 AS DIEMTB \n" +
                "FROM SinhVien INNER JOIN\n" +
                " DIEM ON SinhVien.MaSV = DIEM.MaSV\n" +
                " ORDER BY DIEMTB DESC";
        
        List<Diem> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                String MaSV = rs.getString(1);
                String HoTen = rs.getString(2);
                int TiengAnh = rs.getInt(3);
                int TinHoc = rs.getInt(4);
                int GDTC = rs.getInt(5);
                double DiemTB = rs.getDouble(6);
                SinhVien sv = new SinhVien(MaSV, HoTen, null, null , false, null, null);
                Diem diem = new Diem(sv, TiengAnh, TinHoc, GDTC, DiemTB);
                list.add(diem);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // TODO: handle exception
        }
    }
    
    

    public List<Diem> searchByMaSV(String maSV){
         sql = "SELECT SinhVien.MaSV, SinhVien.HoTen, DIEM.TiengAnh, DIEM.TinHoc, DIEM.GDTC, (DIEM.TiengAnh + DIEM.TinHoc + DIEM.GDTC)/3 AS DIEMTB\n" +
          "FROM SinhVien INNER JOIN DIEM ON SinhVien.MaSV = DIEM.MaSV\n" +
          "WHERE SinhVien.MaSV = ?\n" + // Thêm địa chỉ cho tham số maSV
          "ORDER BY DIEMTB DESC";
        List<Diem> listMa = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
           ps.setString(1, maSV);
            rs = ps.executeQuery();
            while(rs.next()){
                String MaSV = rs.getString(1);
                String HoTen = rs.getString(2);
                int TiengAnh = rs.getInt(3);
                int TinHoc = rs.getInt(4);
                int GDTC = rs.getInt(5);
                double DiemTB = rs.getDouble(6);
                SinhVien sv = new SinhVien(MaSV, HoTen, null, null , false, null, null);
                Diem diem = new Diem(sv, TiengAnh, TinHoc, GDTC, DiemTB);
                listMa.add(diem);
            }
            return listMa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public int addDiem(Diem diem){
        sql="INSERT INTO DIEM(MaSV, TiengAnh, TinHoc, GDTC)\n" +
            "VALUES (?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, diem.getMaSV());
            ps.setObject(2, diem.getTiengAnh());
            ps.setObject(3, diem.getTinHoc());
            ps.setObject(4, diem.getGDTC());
            return ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }

    
}

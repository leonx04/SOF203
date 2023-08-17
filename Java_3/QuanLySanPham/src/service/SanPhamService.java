/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import SanPhamInF.InF_SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;


/**
 *
 * @author dungn
 */
public class SanPhamService implements InF_SanPham{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<SanPham> getAll(){
       List<SanPham>listSP = new ArrayList<>();
       sql="select Ma, Ten, NgaySX,GiaBan, SoLuong, TrangThai from SanPham";
       try{
           con = DBconnect.getConnection();
           ps = con.prepareStatement(sql);
           rs= ps.executeQuery();
           while(rs.next()){
               SanPham sp = new SanPham(
                       rs.getString(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getDouble(4),
                       rs.getInt(5),
                       rs.getInt(6)
               ); 
               listSP.add(sp);
           }
           return listSP;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
    }
    
    public  SanPham checkTrung(String  ma){
        SanPham s = null;
        sql="select Ma, Ten, NgaySX,GiaBan, SoLuong, TrangThai from SanPham where ma = ?";
       try{
           con = DBconnect.getConnection();
           ps = con.prepareStatement(sql);
           ps.setObject(1, ma);
           rs= ps.executeQuery();
           while(rs.next()){
               s = new SanPham(
                       rs.getString(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getDouble(4),
                       rs.getInt(5),
                       rs.getInt(6)
               ); 
           }
           return s;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
    }
    @Override
    public int addSP(SanPham sp) {
        sql="insert into SanPham(Ma, Ten, NgaySX,GiaBan, SoLuong, TrangThai )values(?,?,?,?,?,?)";
        try{
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.getNgaySX());
            ps.setObject(4, sp.getGiaBan());
            ps.setObject(5, sp.getSoLuong());
            ps.setObject(6, sp.getTrangThai());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public int deleteSP(String ma) {
        sql ="delete SanPham where ma =?";
        try{
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int updateSP(SanPham sp, String ma) {
        sql="update SanPham SET Ten = ?, NgaySX = ?, GiaBan = ?, SoLuong =?, TrangThai =? WHERE ma=? ";
        try{
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, sp.getTen());
            ps.setObject(2, sp.getNgaySX());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getTrangThai());
            ps.setObject(6, ma);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}

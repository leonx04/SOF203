/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import interfaceXe.XeMayInf;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;

/**
 *
 * @author KHOA
 */
public class XeMayService implements XeMayInf{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<XeMay> getAll(){
        List<XeMay> listX = new ArrayList<>();
        sql = "select MA, TEN, GiaNhap, GiaBan, SoLuong, TrangThai from XeMay";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                XeMay x = new XeMay(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)
                );
                listX.add(x);
            }
            return listX;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addXe(XeMay x) {
        sql = "insert into XeMay(Ma, Ten, GiaNhap, GiaBan, SoLuong, TrangThai) values (?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, x.getMa());
            ps.setObject(2, x.getTen());
            ps.setObject(3, x.getNhap());
            ps.setObject(4, x.getBan());
            ps.setObject(5, x.getSoLuong());
            ps.setObject(6, x.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteXe(String ma) {
        sql ="delete XeMay where Ma = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateXe(XeMay x, String ma) {
        sql = "update XeMay set Ten = ?, GiaNhap = ?, GiaBan = ?, SoLuong = ?, TrangThai = ? where Ma = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setObject(1, x.getTen());
            ps.setObject(2, x.getNhap());
            ps.setObject(3, x.getBan());
            ps.setObject(4, x.getSoLuong());
            ps.setObject(5, x.getTrangThai());
            ps.setObject(6, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public XeMay checkTrung(String ma){
        XeMay x = null;
        sql = "select MA, TEN, GiaNhap, GiaBan, SoLuong, TrangThai from XeMay where Ma = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while(rs.next()){
                x = new XeMay(rs.getString(1), 
                        rs.getString(2),
                        rs.getDouble(3), 
                        rs.getDouble(4), 
                        rs.getInt(5), 
                        rs.getInt(6));
            }
            return x;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

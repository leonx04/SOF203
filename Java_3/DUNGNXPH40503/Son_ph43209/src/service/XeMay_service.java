/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import XeMay.XeMay;
import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import servise.DBconnect;

/**
 *
 * @author Asus
 */
public class XeMay_service {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<XeMay> getAll() {
        sql = "select MaKhungXe,TenXeMay,SoPhanKhoi,MauXe,GiaBan from XeMay";
        List<XeMay> listXM = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XeMay xm = new XeMay(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getFloat(5)
                );
                listXM.add(xm);
               
            }
            return listXM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int addXeMay(XeMay sm){
        sql = "insert into XeMay(MaKhungXe,TenXeMay,SoPhanKhoi,MauXe,GiaBan) values (?,?,?,?,?)";
        try {
           con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, sm.getMaKhungXe());
            ps.setObject(2, sm.getTenXeMay());
            ps.setObject(3, sm.getSoPhanKhoi());
            ps.setObject(4, sm.getMauXe());
            ps.setObject(5, sm.getGiaBan());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

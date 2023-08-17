/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
/**
 *
 * @author dungn
 */

import model.XeMay;
public class XeMayService {
    Connection con = null;
    PreparedStatement ps= null;
    String sql = null;
    ResultSet rs = null;

    public List<XeMay> getAll() {
        sql ="SELECT MaKhungXe, TenLoaiXe,SoPhanKhoi, GiaBan,MauXe FROM XeMay ";
        List<XeMay> list = new ArrayList<>();
        try {
            con=DBconnect.getConnection();
            ps=con.prepareCall(sql);
            rs=ps.executeQuery();

            while (rs.next()){
                XeMay xm = new XeMay(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getFloat(4),
                    rs.getString(5)
                );
                list.add(xm);
            }
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}

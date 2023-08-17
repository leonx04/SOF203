/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import  java.util.ArrayList;
import java.util.List;

import model.QLDSClass;
import view.QLDS;

import java.sql.*;

/**
 *
 * @author dungn
 */
public class QLDS_Service {
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<QLDSClass> getAll(){
        sql = "SELECT MaDD, Ten, DIACHI, TUOI, CONGVIEC, GIOITINH FROM QLDS";
        List <QLDSClass> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                QLDSClass qlds = new QLDSClass(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getBoolean(6)
                );
                list.add(qlds);
            }
            return list ;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return  null;
        } 
    }
}

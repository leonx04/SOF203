/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import IntF.XeMayInF;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;

/**
 *
 * @author dungn
 */
public class XeMayService implements XeMayInF{
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<XeMay>  getAll(){
        List<XeMay> listXm = new ArrayList<>();
        sql = "Select ma, ten, trangthai, gianhap, giaban, soluong from XeMay";
        try {
            con = DBconnect.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                XeMay xm = new XeMay(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6)
                ); listXm.add(xm);
            } return listXm;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }   
    public XeMay checkMaTrung(String ma){
        XeMay xm = null;
        sql = "Select ma, ten, trangthai, gianhap, giaban, soluong from XeMay where ma = ?";
        try {
            con = DBconnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while(rs.next()){
                 xm = new XeMay(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6)
                ); 
            } return xm;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int addXe(XeMay x) {
        sql="insert into XeMay(ma,ten,trangthai,gianhap,giaban,soluong)values (?,?,?,?,?,?)";
        try{
                con = DBconnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setObject(1, x.getMa());
                ps.setObject(2, x.getTen());
                ps.setObject(3, x.getTrangthai());
                ps.setObject(4, x.getGiaban());
                ps.setObject(5, x.getGianhap());
                ps.setObject(6, x.getSoluong());
                return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteXe(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateXe(XeMay x, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

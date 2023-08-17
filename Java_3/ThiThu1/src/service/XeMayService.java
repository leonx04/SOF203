/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;
/**
 *
 * @author dungn
 */
public class XeMayService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<XeMay> getAll(){
        sql ="SELECT ID,Ma, Ten, TrangThai, GiaNhap, GiaBan, SoLuong \n" +
               "FROM XeMay";
        
        List <XeMay> listXM = new ArrayList<>();
        try{
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                XeMay xm = new XeMay(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getInt(6)
                ); 
                listXM.add(xm);
            }return listXM;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}

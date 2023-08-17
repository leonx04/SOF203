/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servide;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
/**
 *
 * @author DELL
 */
public class GradeDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs =null;
    
    public List<Grade> getALL(){
        sql= "select id,MaSV,TinHoc,GDTC,tienganh from Grade";
        List<Grade> listsv = new ArrayList<>();
        try {
        con =DbConnection.getConnection();
        ps= con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {            
            Grade sv = new Grade(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4),rs.getDouble(5));
            listsv.add(sv);
        }
        return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }      
    }
    public int addsv(Grade sv){
        sql="insert into Grade(MaSV,TinHoc,GDTC,tienganh) values(?,?,?,?)";
        try {
            con =DbConnection.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setObject(1, sv.getMasv());
            ps.setObject(2, sv.getTinhoc());
            ps.setObject(3, sv.getGDTC());
            ps.setObject(4, sv.getTienganh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int delete (String ma){
        sql="delete from Grade where MaSV = ? ";
        try {
            con = DbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int  update(Grade sv, String ma){
        sql="update Grade set TinHoc = ?, GDTC=?,tienganh=? where MaSV like ?";
        try {
           con = DbConnection.getConnection();
            ps =con.prepareStatement(sql);
            ps.setObject(1, sv.getTinhoc());
            ps.setObject(2, sv.getGDTC()); 
            ps.setObject(3, sv.getTienganh()); 
            ps.setObject(4, ma); 
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        
    }
    public List<Grade> findMA(String masv){
        sql="select MaSV,TinHoc,GDTC,tienganh from Grade where MaSV like ?";
        List<Grade> Listsv = new ArrayList<>();
        try {
            con=DbConnection.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, masv);
            rs = ps.executeQuery();
            while(rs.next()){
                Grade sv = new Grade(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                Listsv.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return Listsv;
    }
}

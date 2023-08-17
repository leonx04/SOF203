/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.STUDENT;


/**
 *
 * @author dungn
 */
public class STUDENT_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null ;
    
    
    public List <STUDENT> getAll(){
        sql = "SELECT ID, GIOITINH, DIACHI, PHONE, EMAIL FROM STUDEN";
        List <STUDENT> listSV = new ArrayList<>();
        try{
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                STUDENT sv = new STUDENT(
                  rs.getInt(1),
                  rs.getBoolean(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ); listSV.add(sv);
            }
            return listSV;
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int addSV(STUDENT sv){
        sql = " INSERT INTO STUDEN (ID, GIOITINH, DIACHI, PHONE, EMAIL) VALUES (?,?,?,?,?)";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, sv.getID());
            ps.setObject(2, sv.isGIOITINH());
            ps.setObject(3, sv.getDIACHI());
            ps.setObject(4, sv.getPHONE());
            ps.setObject(5, sv.getEMAIL());
            return ps.executeUpdate();
            
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }
}

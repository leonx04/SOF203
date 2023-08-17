/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import model.grade;

/**
 *
 * @author Asus
 */
public class SinhVien_service {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<grade> getAll() {
        sql = "SELECT top 3\n"
                + "  Students.MaSV, Students.HoTen,\n"
                + "  grade.TiengAnh, grade.TinHoc, grade.GDTC, \n"
                + "  (grade.TiengAnh+grade.TinHoc+grade.GDTC)/3 as diemTB  \n"
                + "FROM grade\n"
                + "INNER JOIN Students ON grade.MaSV = Students.MaSV\n"
                + "ORDER BY diemTB desc ";
        List<grade> listSV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSV = rs.getString(1);
                String tenSV = rs.getString(2);
                int tiengAnh = rs.getInt(3);
                int tinHoc = rs.getInt(4);
                int gdtc = rs.getInt(5);
                double diemTB = rs.getDouble(6);
                SinhVien sv = new SinhVien(maSV, tenSV, null, null, false, null, null); 
                grade gr = new grade(sv, tiengAnh, tinHoc, gdtc, diemTB);
            listSV.add(gr);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
public List<grade> getGradesByMaSV(String maSV) {
    sql = "SELECT top 3\n"
            + "  Students.MaSV, Students.HoTen,\n"
            + "  grade.TiengAnh, grade.TinHoc, grade.GDTC, \n"
            + "  (grade.TiengAnh+grade.TinHoc+grade.GDTC)/3 as diemTB  \n"
            + "FROM grade\n"
            + "INNER JOIN Students ON grade.MaSV = Students.MaSV\n"
            + "WHERE Students.MaSV = ?\n"  // Thêm điều kiện truy vấn mã sinh viên
            + "ORDER BY diemTB desc ";

    List<grade> listSV = new ArrayList<>();
    try {
        con = DBconnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, maSV);  // Thiết lập tham số cho điều kiện mã sinh viên
        rs = ps.executeQuery();
        while (rs.next()) {
            int tiengAnh = rs.getInt(3);
            int tinHoc = rs.getInt(4);
            int gdtc = rs.getInt(5);
            double diemTB = rs.getInt(6);
            String tenSV = rs.getString(2);  // Lấy tên của sinh viên từ kết quả trả về".
            SinhVien sv = new SinhVien(maSV, tenSV, null, null, false, null, null); 
            grade gr = new grade(sv, tiengAnh, tinHoc, gdtc, diemTB);
            listSV.add(gr);
        }
        return listSV;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}

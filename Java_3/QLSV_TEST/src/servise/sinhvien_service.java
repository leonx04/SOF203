/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servise;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import mode.SinhVien;

/**
 *
 * @author Asus
 */
public class sinhvien_service {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<SinhVien> getAll() {
        sql = "SELECT id, ma_sinh_vien, ten_sinh_vien, tuoi, ky_hoc, nganh_hoc, diem_trung_binh, gioi_tinh FROM sinh_vien";
        List<SinhVien> listSV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7),
                        rs.getBoolean(8)
                );
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSinhVien(SinhVien sv) {
        sql = "insert into sinh_vien(ma_sinh_vien, ten_sinh_vien, tuoi, ky_hoc, nganh_hoc, diem_trung_binh, gioi_tinh) values (?,?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, sv.getMaSinhVien());
            ps.setObject(2, sv.getTenSinhVien());
            ps.setObject(3, sv.getTuoi());
            ps.setObject(4, sv.getHocKy());
            ps.setObject(5, sv.getNganhHoc());
            ps.setObject(6, sv.getDiemTrungBinh());
            ps.setObject(7, sv.isGioitinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public SinhVien getSinhVien(String masv) {
        sql = "SELECT  ma_sinh_vien, ten_sinh_vien, tuoi, ky_hoc, nganh_hoc, diem_trung_binh, gioi_tinh FROM sinh_vien where ma_sinh_vien like ?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, masv);
            rs = ps.executeQuery();
            while (rs.next()) {
                sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getBoolean(7));

            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int upDateSV(SinhVien sv, String maSinhVien) {

        sql = "UPDATE sinh_vien SET ten_sinh_vien = ?, tuoi = ?, ky_hoc = ?, nganh_hoc = ?, diem_trung_binh = ?, gioi_tinh = ? WHERE ma_sinh_vien = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getTenSinhVien());
            ps.setObject(2, sv.getTuoi());
            ps.setObject(3, sv.getHocKy());
            ps.setObject(4, sv.getNganhHoc());
            ps.setObject(5, sv.getDiemTrungBinh());
            ps.setObject(6, sv.isGioitinh());
            ps.setObject(7, sv.getMaSinhVien());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSV(String maSinhVien) {
        sql = "delete from sinh_vien where ma_sinh_vien = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maSinhVien);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;
import model.SanPham;
/**
 *
 * @author dungn
 */
public class SanPhamService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPham> getAll(){
        sql= "SELECT MASANPHAM, TENSANPHAM, LOAISANPHAM.MALOAI,TENLOAI \n" +
            "FROM SANPHAM JOIN LOAISANPHAM ON SANPHAM.MALOAI=LOAISANPHAM.MALOAI";
        
        List<SanPham> listSP = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);

                LoaiSanPham lsp = new LoaiSanPham(
                    rs.getString(3),
                    rs.getString(4)
                );
                SanPham sp = new SanPham(maSP, tenSP,lsp);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }
    
    public List<SanPham> getSPBYMaLoai(String maloai){
        sql = "SELECT MASANPHAM , TENSANPHAM ,LOAISANPHAM.MALOAI ,TENLOAI\n"
                + "FROM SANPHAM JOIN LOAISANPHAM ON SANPHAM.MALOAI = LOAISANPHAM.MALOAI WHERE LOAISANPHAM.MALOAI = ?";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
//                public SanPham(String maSP, String tenSP, String maLoai, LoaiSanPham loai)
                LoaiSanPham lsp = new LoaiSanPham(
                        rs.getString(3),
                        rs.getString(4));
                SanPham sp = new SanPham(maSP, tenSP, lsp);
                listsp.add(sp);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

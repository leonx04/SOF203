/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;
import model.SanPham;


public class LoaiSanPhamService {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<LoaiSanPham> getAll() {
        sql = "SELECT MALOAI ,TENLOAI FROM LOAISANPHAM ";
        List<LoaiSanPham> listlsp = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(
                        rs.getString(1),
                        rs.getString(2));
                listlsp.add(lsp);
            }
            return listlsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

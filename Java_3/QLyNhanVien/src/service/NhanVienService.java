package service;
import java.sql.*;
import Int_NhanVien.NhanVienINF;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author dungn
 */
public class NhanVienService implements NhanVienINF{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<NhanVien> getAll(){
        List<NhanVien> listNV = new ArrayList<>();
        sql="Select Ma, MatKhau, Ten, GioiTinh, NgaySinh, DiaChi,TrangThai From NhanVien ";
        try{
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );listNV.add(nv);
            }return listNV;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
   
    public NhanVien checkTrung(String ma){
        NhanVien nv = null;
        sql="Select Ma, MatKhau, Ten, GioiTinh, NgaySinh, DiaChi,TrangThai From NhanVien where ma=?";
        try{
            con= DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs=ps.executeQuery();
            while(rs.next()){
            nv = new NhanVien(
                    rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
            );
        }return nv;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int addNhanVien(NhanVien nv) {
        sql=" insert into NhanVien(Ma, MatKhau, Ten, GioiTinh, NgaySinh, DiaChi,TrangThai)values(?,?,?,?,?,?,?)";
        try{
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getMatkhau());
            ps.setObject(3, nv.getTen());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getTrangThai());
            return ps.executeUpdate();
        }catch( Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteNV(String Ma) {
        sql="delete NhanVien WHERE Ma= ?";
        try{
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, Ma);
            return ps.executeUpdate();
        }catch( Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    @Override
    public int updateNV(NhanVien nv, String ma) {
        sql="UPDATE NhanVien \n" +
                "SET  MatKhau=?, Ten=?, GioiTinh=?, NgaySinh=?, DiaChi=?, TrangThai=? \n" +
                "WHERE Ma=?;";
        try{
            con = DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, nv.getMatkhau());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getTrangThai());
            ps.setObject(7, ma);
            return ps.executeUpdate();
        }catch( Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
}

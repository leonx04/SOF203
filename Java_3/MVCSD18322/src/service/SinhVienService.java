/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*; // lấy hết thư viện của sql
import java.util.ArrayList;
import java.util.List;

import model.SinhVien;
/**
 *
 * @author dungn
 */
public class SinhVienService { // chức năng
    Connection con=null; // biến để kết nối
    PreparedStatement ps= null; // thực thi kết nối
    String sql = null;
    ResultSet rs = null; // kết quả của select
    public List<SinhVien> getAll(){ //lấy hết dữ liệu từ databases 
        sql ="SELECT ID,NAME FROM SinhVien";
        List<SinhVien> listSV = new ArrayList();
        try { // lấy được dữ liệu
            con=DBconnect.getConnection(); // kết nối với database
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            // KẾT QUẢ CỦA SELECT  LÀ: ResultSet
            while(rs.next()){ // đọc từng dòng dữ liệu đến hết rs thì dừng
                SinhVien sv = new SinhVien(rs.getInt(1),rs.getString(2));
                listSV.add(sv);
                
            }
            return listSV;
        } catch (Exception e) { // k lấy dc dữ liệu
            e.printStackTrace();
            return null;
        }
    }
    public int addSinhVien(SinhVien sv){
        sql="INSERT INTO SinhVien(ID,NAME) values(?,?)";
        try {//thêm được
                con=DBconnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setObject(1, sv.getID()); // dấu ? thứ 1
                ps.setObject(2, sv.getName());
                return ps.executeUpdate();
        } catch (Exception e) { // không thêm được
            e.printStackTrace();
            return 0;
        }
      
    }
    public int deleteSinhVien (int ID){
        // ĐỐI SỐ TRUYỀN VÀO LÀ KHÓA CHÍNH
        sql="DELETE FROM SinhVien WHERE ID =?";
        try {
            con =DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, ID); // ? thu nhat: 1
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0;
        }
    }
    public int updateSinhVien (int id , SinhVien sv){
        sql="UPDATE SinhVien set NAME=? WHERE id=?";
        try {
            con=DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, sv.getName()); //dau?thu nhat 
            ps.setObject(2,id); //dau ?thu hai
            return ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }
    public SinhVien getSinhVien(int id){ 
        //tìm sinh vien theo khóa chính
        sql="select ID,NAME FROM SinhVien where id=?";
        SinhVien sv = null;

        try {
            con=DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1,id); //số ?thu nhat
            rs=ps.executeQuery();
            while (rs.next()) {
                sv=new SinhVien(rs.getInt(1),rs.getString(2));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // TODO: handle exception
        }
    }
    public List<SinhVien> findName (String name){
        sql = "SELECT ID, NAME FROM SinhVien WHERE NAME LIKE ?";
        List<SinhVien> listSV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2)); // get lấy tên cột or cột getString(name)
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<SinhVien> SortName(){
        sql= "SELECT ID, NAME FORM SinhVien ODER BY NAME DESC";
        List<SinhVien> List = new ArrayList();
        try {
            con= DBconnect.getConnection();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                            SinhVien  sv=new SinhVien(rs.getInt(1),rs.getString(2));
                            List.add(sv);
                        }
                        return List;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}

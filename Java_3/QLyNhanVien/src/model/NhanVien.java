/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class NhanVien {
    private String ma;
    private String matkhau;
    private String ten;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private int TrangThai;

    public NhanVien() {
    }

    public NhanVien(String ma, String matkhau, String ten, String GioiTinh, String NgaySinh, String DiaChi, int TrangThai) {
        this.ma = ma;
        this.matkhau = matkhau;
        this.ten = ten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }
    
    public String getMa() {
        return ma;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public Object[] toData(){
        return new Object[] {
            this.ma,
            this.matkhau,
            this.ten,
            this.GioiTinh,
            this.NgaySinh,
            this.DiaChi,
            this.TrangThai
        };
    }
}

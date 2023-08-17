/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class SinhVien {
    private String MaSV;
    private String HoTen;
    private String Email;
    private String SDT;
    private boolean  GioiTinh;
    private String DiaChi;
    private String HinhAnh;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String Email, String SDT, boolean GioiTinh, String DiaChi, String HinhAnh) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.HinhAnh = HinhAnh;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public String getSDT() {
        return SDT;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
    public Object[] toDataRow(){
        return new Object[] {this.MaSV, this.HoTen , this.Email,this.SDT , this.GioiTinh, this.DiaChi, this.HinhAnh};

    }
    
}

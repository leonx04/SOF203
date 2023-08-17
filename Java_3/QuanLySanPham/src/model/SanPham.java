/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class SanPham {
    private String ma;
    private String ten;
    private String ngaySX;
    private double giaBan;
    private int soLuong;
    private int TrangThai;

    public SanPham() {
    }

    public SanPham(String ma, String ten, String ngaySX, double giaBan, int soLuong, int TrangThai) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySX = ngaySX;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.TrangThai = TrangThai;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySX() {
        return ngaySX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public Object[]toData(){
        return new Object[]{this.ma,
            this.ten,
            this.ngaySX,
            this.giaBan,
            this.soLuong,
            this.TrangThai};
    }
}

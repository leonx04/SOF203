/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author KHOA
 */
public class XeMay {
    private String ma, ten;
    private double nhap, ban;
    private int soLuong, trangThai;

    public XeMay() {
    }

    public XeMay(String ma, String ten, double nhap, double ban, int soLuong, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.nhap = nhap;
        this.ban = ban;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getNhap() {
        return nhap;
    }

    public void setNhap(double nhap) {
        this.nhap = nhap;
    }

    public double getBan() {
        return ban;
    }

    public void setBan(double ban) {
        this.ban = ban;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toData(){
        return new Object[]{
            this.ma,
            this.ten,
            this.nhap,
            this.ban,
            this.soLuong,
            this.trangThai
        };
    }
}

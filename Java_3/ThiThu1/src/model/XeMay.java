/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;

/**
 *
 * @author dungn
 */
public class XeMay {
    private String  id;
    private String Ma;
    private String Ten;
    private int TrangThai;
    private double  GiaNhap;
    private double GiaBan;
    private int SoLuong;

    public XeMay() {
    }

    public XeMay(String id, String Ma, String Ten, int TrangThai, double GiaNhap, double GiaBan, int SoLuong) {
        this.id = id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.TrangThai = TrangThai;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    public String getId() {
        return id;
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public Object[] toDataRow(){
        return new Object[] {this.id, this.Ma, this.Ten, this.TrangThai, this.GiaNhap, this.GiaBan, this.SoLuong};
    }

}

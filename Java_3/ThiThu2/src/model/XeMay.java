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
    private String ma;
    private String ten;
    private int trangthai;
    private double gianhap;
    private double giaban;
    private int soluong;

    public XeMay() {
    }

    public XeMay(String ma, String ten, int trangthai, double gianhap, double giaban, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.trangthai = trangthai;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.soluong = soluong;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public double getGianhap() {
        return gianhap;
    }

    public double getGiaban() {
        return giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.ma, 
            this.ten,
            this.trangthai,
            this.gianhap,
            this.giaban,
            this.soluong
        };
    }

}

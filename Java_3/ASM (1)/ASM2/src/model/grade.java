/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class grade {
    
    private SinhVien maSV;
    private int ta;
    private int tin;
    private int gdtc;
    private double diemtb;

    public grade() {
    }

    public grade(SinhVien maSV, int ta, int tin, int gdtc, double diemtb) {
        this.maSV = maSV;
        this.ta = ta;
        this.tin = tin;
        this.gdtc = gdtc;
        this.diemtb = diemtb;
    }

    public SinhVien getMaSV() {
        return maSV;
    }

    public void setMaSV(SinhVien maSV) {
        this.maSV = maSV;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public int getTin() {
        return tin;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    public double getDiemtb() {
        return (this.ta+this.gdtc+this.tin)/3.0;
    }

    public void setDiemtb(double diemtb) {
        this.diemtb = diemtb;
    }
    public Object[] todataRow(){
        return new Object[]{this.maSV.getMasv(),this.maSV.getTenSV(),this.ta,this.tin,this.gdtc,this.diemtb};
    }
   
}

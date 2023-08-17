/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Grade {
    private int id;
    private String masv;
    private double tinhoc;
    private double GDTC;
    private double tienganh;

    public Grade() {
    }

    public Grade(int id, String masv, double tinhoc, double GDTC, double tienganh) {
        this.id = id;
        this.masv = masv;
        this.tinhoc = tinhoc;
        this.GDTC = GDTC;
        this.tienganh = tienganh;
    }
    public Grade(String masv, double tinhoc, double GDTC, double tienganh) {
        this.masv = masv;
        this.tinhoc = tinhoc;
        this.GDTC = GDTC;
        this.tienganh = tienganh;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public double getTinhoc() {
        return tinhoc;
    }

    public void setTinhoc(double tinhoc) {
        this.tinhoc = tinhoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public double getTienganh() {
        return tienganh;
    }

    public void setTienganh(double tienganh) {
        this.tienganh = tienganh;
    }
    public double diemtrungbinh(){
        return (tinhoc+GDTC+tienganh)/3;
    }
    
    public Object[] todatarow(){
        return new Object[]{this.masv,this.tinhoc,this.GDTC,this.tienganh,this.diemtrungbinh()};
    }
}

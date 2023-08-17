/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class XeMay {
    String MaKhungXe ;
    String TenLoaiXe;
    int SoPhanKhoi;
    float GiaBan;
    String MauXe;

    public XeMay(String MaKhungXe, String TenLoaiXe, int SoPhanKhoi, float GiaBan, String MauXe) {
        this.MaKhungXe = MaKhungXe;
        this.TenLoaiXe = TenLoaiXe;
        this.SoPhanKhoi = SoPhanKhoi;
        this.GiaBan = GiaBan;
        this.MauXe = MauXe;
    }

    public String getMaKhungXe() {
        return MaKhungXe;
    }

    public String getTenLoaiXe() {
        return TenLoaiXe;
    }

    public int getSoPhanKhoi() {
        return SoPhanKhoi;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public String getMauXe() {
        return MauXe;
    }

    public void setMaKhungXe(String MaKhungXe) {
        this.MaKhungXe = MaKhungXe;
    }

    public void setTenLoaiXe(String TenLoaiXe) {
        this.TenLoaiXe = TenLoaiXe;
    }

    public void setSoPhanKhoi(int SoPhanKhoi) {
        this.SoPhanKhoi = SoPhanKhoi;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setMauXe(String MauXe) {
        this.MauXe = MauXe;
    }
    @Override
    public String toString(){
        return "XeMay{" + "MaKhungXe=" + MaKhungXe 
                + ", TenLoatXe=" + TenLoaiXe 
                + ", SoPhanKhoi=" + SoPhanKhoi 
                + ", GiaBan=" + GiaBan 
                + ", MauXe=" + MauXe + '}';
    }
    
    public Object[] toData(){
        return new Object[]{this.MaKhungXe,this.TenLoaiXe,this.SoPhanKhoi,this.GiaBan,this.MauXe};
    }
    
}

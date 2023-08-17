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
    private String maSP;
    private String tenSP;
    private LoaiSanPham loai;
    // lấy dữ liệu của bảng 1  sang bảng n

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, LoaiSanPham loai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loai = loai;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public LoaiSanPham getLoai() {
        return loai;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setLoai(LoaiSanPham loai) {
        this.loai = loai;
    }
    
    public Object[] toDataRow(){
        return  new Object[]{this.maSP, this.tenSP};
    }
}

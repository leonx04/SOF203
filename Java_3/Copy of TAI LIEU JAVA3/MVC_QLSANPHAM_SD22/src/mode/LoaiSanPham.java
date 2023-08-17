/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mode;

/**
 *
 * @author Manhdepzai
 */
public class LoaiSanPham {

    String maLoai;
    String tenloai;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String maLoai, String tenloai) {
        this.maLoai = maLoai;
        this.tenloai = tenloai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

}

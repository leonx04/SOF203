/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mode;

/**
 *
 * @author Asus
 */
//helo
public class SinhVien {
   private int id;
   private String maSinhVien;
   private String tenSinhVien;
   private int tuoi;
   private int hocKy;
   private String nganhHoc;
   private float diemTrungBinh;
   private boolean gioitinh;

    public SinhVien() {
    }

    public SinhVien(int id, String maSinhVien, String tenSinhVien, int tuoi, int hocKy, String nganhHoc, float diemTrungBinh, boolean gioitinh) {
        this.id=id;
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.tuoi = tuoi;
        this.hocKy = hocKy;
        this.nganhHoc = nganhHoc;
        this.diemTrungBinh = diemTrungBinh;
        this.gioitinh = gioitinh;
    }

    public SinhVien(String maSinhVien, String tenSinhVien, int tuoi, int hocKy, String nganhHoc, float diemTrungBinh, boolean gioitinh) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.tuoi = tuoi;
        this.hocKy = hocKy;
        this.nganhHoc = nganhHoc;
        this.diemTrungBinh = diemTrungBinh;
        this.gioitinh = gioitinh;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", tuoi=" + tuoi + ", hocKy=" + hocKy + ", nganhHoc=" + nganhHoc + ", diemTrungBinh=" + diemTrungBinh + ", gioitinh=" + gioitinh + '}';
    }
   public Object[] toData(){
       return new Object[]{this.id,this.maSinhVien,this.tenSinhVien,this.tuoi,this.hocKy,this.nganhHoc,this.diemTrungBinh,this.gioitinh};
   }
}

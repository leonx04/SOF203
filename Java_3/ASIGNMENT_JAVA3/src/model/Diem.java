/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class Diem {
    private SinhVien MaSV;
    private  int TiengAnh;
    private  int TinHoc;
    private  int GDTC;
    private double DiemTB;

    public Diem() {
    }

    public Diem(SinhVien MaSV, int TiengAnh, int TinHoc, int GDTC, double DiemTB) {
        this.MaSV = MaSV;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
        this.DiemTB = DiemTB;
    }

    public SinhVien getMaSV() {
        return MaSV;
    }

    public int getTiengAnh() {
        return TiengAnh;
    }

    public int getTinHoc() {
        return TinHoc;
    }

    public int getGDTC() {
        return GDTC;
    }

    public double getDiemTB() {
        return DiemTB;
    }

    public void setMaSV(SinhVien MaSV) {
        this.MaSV = MaSV;
    }

    public void setTiengAnh(int TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public void setTinHoc(int TinHoc) {
        this.TinHoc = TinHoc;
    }

    public void setGDTC(int GDTC) {
        this.GDTC = GDTC;
    }
    
    public void setDiemTB(double  diemtb){
        this.DiemTB = diemtb;
    }
    public Object[] toDataRow(){
        return new Object[] {
            this.MaSV.getMaSV(), 
    
            this.MaSV.getHoTen(), 
            
            this.TiengAnh, 
            
            Integer.valueOf(this.TinHoc),
            
            Integer.valueOf(this.GDTC),
            
            Double.valueOf(this.DiemTB)};
    }
}

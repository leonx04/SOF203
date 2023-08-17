/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XeMay;

/**
 *
 * @author Asus
 */
public class XeMay {
    private String maKhungXe;
    private String tenXeMay;
    private int soPhanKhoi;
    private String mauXe;
    private float giaBan;

    public XeMay() {
    }

    public XeMay(String maKhungXe, String tenXeMay, int soPhanKhoi, String mauXe, float giaBan) {
        this.maKhungXe = maKhungXe;
        this.tenXeMay = tenXeMay;
        this.soPhanKhoi = soPhanKhoi;
        this.mauXe = mauXe;
        this.giaBan = giaBan;
    }

    public String getMaKhungXe() {
        return maKhungXe;
    }

    public void setMaKhungXe(String maKhungXe) {
        this.maKhungXe = maKhungXe;
    }

    public String getTenXeMay() {
        return tenXeMay;
    }

    public void setTenXeMay(String tenXeMay) {
        this.tenXeMay = tenXeMay;
    }

    public int getSoPhanKhoi() {
        return soPhanKhoi;
    }

    public void setSoPhanKhoi(int soPhanKhoi) {
        this.soPhanKhoi = soPhanKhoi;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "XeMay{" + "maKhungXe=" + maKhungXe + ", tenXeMay=" + tenXeMay + ", soPhanKhoi=" + soPhanKhoi + ", mauXe=" + mauXe + ", giaBan=" + giaBan + '}';
    }
    public Object[] todata(){
        return new Object[]{this.maKhungXe,this.tenXeMay,this.soPhanKhoi,this.mauXe,this.giaBan};
    }
}

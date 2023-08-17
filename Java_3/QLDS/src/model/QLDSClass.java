/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class QLDSClass {
    private int ID ;
    private String MaDD ;
    private String Ten;
    private String DIACHI;
    private int TUOI;
    private boolean GIOITINH; 

    public QLDSClass(int ID, String MaDD, String Ten, String DIACHI, int TUOI, boolean GIOITINH) {
        this.ID = ID;
        this.MaDD = MaDD;
        this.Ten = Ten;
        this.DIACHI = DIACHI;
        this.TUOI = TUOI;
        this.GIOITINH = GIOITINH;
    }

    public int getID() {
        return ID;
    }

    public String getMaDD() {
        return MaDD;
    }

    public String getTen() {
        return Ten;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public int getTUOI() {
        return TUOI;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public void setTUOI(int TUOI) {
        this.TUOI = TUOI;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }
    
    @Override
    public String toString() {
        return "QLDSClass{" + "ID=" + ID + ", MaDD=" + MaDD + ", Ten=" + Ten + ", DIACHI=" + DIACHI + ", TUOI=" + TUOI + ", GIOITINH=" + GIOITINH + '}';
    }

    public Object[] toData() {
        return new Object[]{this.ID, this.MaDD, this.Ten, this.DIACHI, this.TUOI, this.GIOITINH};
    }
}

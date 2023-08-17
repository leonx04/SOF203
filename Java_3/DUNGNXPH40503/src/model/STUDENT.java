/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungn
 */
public class STUDENT {
    private int ID ;
    private boolean GIOITINH;
    private String DIACHI;
    private String PHONE;
    private String EMAIL;

    public STUDENT() {
    }

    public STUDENT(int ID, boolean GIOITINH, String DIACHI, String PHONE, String EMAIL) {
        this.ID = ID;
        this.GIOITINH = GIOITINH;
        this.DIACHI = DIACHI;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
    }

    public int getID() {
        return ID;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    
    public Object[] toDataRow(){
        return new Object[] {this.ID, this.GIOITINH, this.DIACHI, this.PHONE, this.EMAIL};
    }
}

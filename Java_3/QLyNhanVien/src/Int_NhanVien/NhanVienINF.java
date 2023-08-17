/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Int_NhanVien;

import model.NhanVien;

/**
 *
 * @author dungn
 */
public interface NhanVienINF {
    public int addNhanVien( NhanVien nv);
    public int deleteNV(String Ma);
    public int updateNV( NhanVien nv, String  Ma);
}

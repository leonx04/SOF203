/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SanPhamInF;

import model.SanPham;

/**
 *
 * @author dungn
 */
public interface InF_SanPham {
    public int addSP(SanPham sp);
    public int deleteSP(String ma);
    public int updateSP(SanPham  sp, String ma);
    
}

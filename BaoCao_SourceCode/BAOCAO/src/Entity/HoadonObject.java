/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Admin
 */
public class HoadonObject {
    private int mahd;
    private String mahgd;
    private String mach;
    private float tiendien;
    private float tiennuoc;
    private float tiendv;
    private String ngay;
    private  String manv;

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
    private float tongtien;

    public HoadonObject() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getMahgd() {
        return mahgd;
    }

    public void setMahgd(String mahgd) {
        this.mahgd = mahgd;
    }

    public String getMach() {
        return mach;
    }

    public void setMach(String mach) {
        this.mach = mach;
    }

    public float getTiendien() {
        return tiendien;
    }

    public void setTiendien(float tiendien) {
        this.tiendien = tiendien;
    }

    public float getTiennuoc() {
        return tiennuoc;
    }

    public void setTiennuoc(float tiennuoc) {
        this.tiennuoc = tiennuoc;
    }

    public float getTiendv() {
        return tiendv;
    }

    public void setTiendv(float tiendv) {
        this.tiendv = tiendv;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
    
}

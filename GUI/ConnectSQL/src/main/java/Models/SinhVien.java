/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class SinhVien {

    private String MaSV;
    private String HoTenSV;
    private String Lop;
    private int GioiTinh;

    public SinhVien(String MaSV, String HoTenSV, String Lop, int GioiTinh) {
        this.MaSV = MaSV;
        this.HoTenSV = HoTenSV;
        this.Lop = Lop;
        this.GioiTinh = GioiTinh;
    }

    public SinhVien() {
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTenSV() {
        return HoTenSV;
    }

    public void setHoTenSV(String HoTenSV) {
        this.HoTenSV = HoTenSV;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    @Override
    public String toString() {
        return MaSV;
    }
}

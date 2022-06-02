/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ddom6
 */
public class Phong {

    private String MaPH;
    private String TenPH;
    private String DienTich;
    private String GiaPhong;

    public Phong(String MaPH, String TenPH, String DienTich, String GiaPhong) {
        this.MaPH = MaPH;
        this.TenPH = TenPH;
        this.DienTich = DienTich;
        this.GiaPhong = GiaPhong;
    }

    public Phong() {
    }

    public String getMaPH() {
        return MaPH;
    }

    public void setMaPH(String MaPH) {
        this.MaPH = MaPH;
    }

    public String getTenPH() {
        return TenPH;
    }

    public void setTenPH(String TenPH) {
        this.TenPH = TenPH;
    }

    public String getDienTich() {
        return DienTich;
    }

    public void setDienTich(String DienTich) {
        this.DienTich = DienTich;
    }

    public String getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(String GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

}

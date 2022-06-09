/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Phong {

    private String MaPhong;
    private String TenPhong;
    private String DienTich;
    private String TienNghi;
    private double Gia;
    private String TrangThai;

    public Phong() {
    }

    public Phong(String MaPhong, String TenPhong, String DienTich, String TienNghi, double Gia, String TrangThai) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.DienTich = DienTich;
        this.TienNghi = TienNghi;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getDienTich() {
        return DienTich;
    }

    public void setDienTich(String DienTich) {
        this.DienTich = DienTich;
    }

    public String getTienNghi() {
        return TienNghi;
    }

    public void setTienNghi(String TienNghi) {
        this.TienNghi = TienNghi;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

}

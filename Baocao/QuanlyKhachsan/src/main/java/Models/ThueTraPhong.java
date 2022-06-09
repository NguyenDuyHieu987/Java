/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class ThueTraPhong {

    private String MaThue;
    private String MaPhong;
    private String TenPhong;
    private String MaKH;
    private String TenKH;
    private String NgayBD;
    private String NgayKT;
    private double TongTien;
    private String TrangThai;

    public ThueTraPhong() {
    }

    public ThueTraPhong(String MaThue, String MaPhong, String TenPhong, String MaKH, String TenKH, String NgayBD, String NgayKT, double TongTien, String TrangThai) {
        this.MaThue = MaThue;
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaThue() {
        return MaThue;
    }

    public void setMaThue(String MaThue) {
        this.MaThue = MaThue;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

}

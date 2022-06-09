/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class DoDungMatHong {

    private String MaThue;
    private String TenDo;
    private double TongTien;
    private int SoLuong;

    public DoDungMatHong() {
    }

    public DoDungMatHong(String TenDo, int SoLuong) {
        this.TenDo = TenDo;
        this.SoLuong = SoLuong;
    }

    public String getTenDo() {
        return TenDo;
    }

    public void setTenDo(String TenDo) {
        this.TenDo = TenDo;
    }

    public String getMaThue() {
        return MaThue;
    }

    public void setMaThue(String MaThue) {
        this.MaThue = MaThue;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}

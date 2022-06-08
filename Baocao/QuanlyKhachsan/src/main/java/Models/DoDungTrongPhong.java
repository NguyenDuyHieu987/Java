/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class DoDungTrongPhong {

    private String TenDo;
    private double DonGia;
    private int SoLuong;

    public DoDungTrongPhong() {
    }

    public DoDungTrongPhong(String TenDo, double DonGia, int SoLuong) {
        this.TenDo = TenDo;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public String getTenDo() {
        return TenDo;
    }

    public void setTenDo(String TenDo) {
        this.TenDo = TenDo;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}

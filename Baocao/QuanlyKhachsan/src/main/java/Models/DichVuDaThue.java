/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class DichVuDaThue {

    private String MaThue;
    private String TenDichVu;
    private int SoGio;
    private double TongTien;

    public DichVuDaThue() {
    }

    public DichVuDaThue(String TenDichVu, int SoGio) {
        this.TenDichVu = TenDichVu;
        this.SoGio = SoGio;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaThue() {
        return MaThue;
    }

    public void setMaThue(String MaThue) {
        this.MaThue = MaThue;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public int getSoGio() {
        return SoGio;
    }

    public void setSoGio(int SoGio) {
        this.SoGio = SoGio;
    }

}

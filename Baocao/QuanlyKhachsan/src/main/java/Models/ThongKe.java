/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class ThongKe {

    private String MaThongKe;
    private String TenThongKe;
    private String GhiChu;
    private float DoanhThu;

    public ThongKe() {
    }

    public ThongKe(String MaThongKe, String TenThongKe, String GhiChu, float DoanhThu) {
        this.MaThongKe = MaThongKe;
        this.TenThongKe = TenThongKe;
        this.GhiChu = GhiChu;
        this.DoanhThu = DoanhThu;
    }

    public String getMaThongKe() {
        return MaThongKe;
    }

    public void setMaThongKe(String MaThongKe) {
        this.MaThongKe = MaThongKe;
    }

    public String getTenThongKe() {
        return TenThongKe;
    }

    public void setTenThongKe(String TenThonKe) {
        this.TenThongKe = TenThonKe;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public float getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

}

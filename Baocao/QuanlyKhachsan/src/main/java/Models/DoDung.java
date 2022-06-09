/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class DoDung {

    private String TenDo;
    private double DonGia;

    public DoDung() {
    }

    public DoDung(String TenDo, double DonGia) {
        this.TenDo = TenDo;
        this.DonGia = DonGia;
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

}

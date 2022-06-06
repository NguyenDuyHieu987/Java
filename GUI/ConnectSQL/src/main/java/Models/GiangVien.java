/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class GiangVien {

    private String MaGV;
    private String HoTenGV;

    public GiangVien(String MaGV, String HoTenGV) {
        this.MaGV = MaGV;
        this.HoTenGV = HoTenGV;
    }

    public GiangVien() {
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getHoTenGV() {
        return HoTenGV;
    }

    public void setHoTenGV(String HoTenGV) {
        this.HoTenGV = HoTenGV;
    }

    @Override
    public String toString() {
        return MaGV;
    }
}

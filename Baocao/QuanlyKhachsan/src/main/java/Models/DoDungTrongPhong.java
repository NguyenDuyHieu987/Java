/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class DoDungTrongPhong {

    private int ID;
    private String MaPhong;
    private String TenPhong;
    private String TenDo;
    private int SoLuong;

    public DoDungTrongPhong() {
    }

    public DoDungTrongPhong(int ID, String MaPhong, String TenPhong, String TenDo, int SoLuong) {
        this.ID = ID;
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.TenDo = TenDo;
        this.SoLuong = SoLuong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenDo() {
        return TenDo;
    }

    public void setTenDo(String TenDo) {
        this.TenDo = TenDo;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class canhoOject {
    private String ma_can_ho;
    private String ma_khu;
    private float gia;
    private String ghi_chu;
    private String ma_loai_can_ho;
    private String loai_can_ho;
    private String trang_thai;
    
    public canhoOject(){}

    public canhoOject(String ma_can_ho, String ma_khu, float gia, String ghi_chu, String ma_loai_can_ho, String loai_can_ho, String trang_thai) {
        this.ma_can_ho = ma_can_ho;
        this.ma_khu = ma_khu;
        this.gia = gia;
        this.ghi_chu = ghi_chu;
        this.ma_loai_can_ho = ma_loai_can_ho;
        this.loai_can_ho = loai_can_ho;
        this.trang_thai = trang_thai;
    }
    
    public String getMa_can_ho() {
        return ma_can_ho;
    }

    public void setMa_can_ho(String ma_can_ho) {
        this.ma_can_ho = ma_can_ho;
    }

    public String getMa_khu() {
        return ma_khu;
    }

    public void setMa_khu(String ma_khu) {
        this.ma_khu = ma_khu;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public String getMa_loai_can_ho() {
        return ma_loai_can_ho;
    }

    public void setMa_loai_can_ho(String ma_loai_can_ho) {
        this.ma_loai_can_ho = ma_loai_can_ho;
    }

    public String getLoai_can_ho() {
        return loai_can_ho;
    }

    public void setLoai_can_ho(String loai_can_ho) {
        this.loai_can_ho = loai_can_ho;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}

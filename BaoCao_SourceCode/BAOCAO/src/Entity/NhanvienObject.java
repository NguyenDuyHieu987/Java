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
public class NhanvienObject {
    String manv;
    String tennv;
    String sdt;
    String gioitinh;
    String diachi;
    String ngaysinh;
    String Email;
    String socmnd;

    public NhanvienObject() {
    }

    public NhanvienObject(String manv, String tennv, String sdt, String gioitinh, String diachi, String ngaysinh, String Email, String socmnd) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.Email = Email;
        this.socmnd = socmnd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSocmnd() {
        return socmnd;
    }

    public void setSocmnd(String socmnd) {
        this.socmnd = socmnd;
    }
    
    
}

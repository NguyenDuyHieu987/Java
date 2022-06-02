/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThanhvienObject {
    String matv;
    String tentv;
    String sdt;
    String mahgd;
    String Socmnd;
    String email;
    String  ngaysinh;
    String gioitinh;

    public ThanhvienObject() {
    }

    public ThanhvienObject(String matv, String tentv, String sdt, String mahgd, String Socmnd, String email, String ngaysinh, String gioitinh) {
        this.matv = matv;
        this.tentv = tentv;
        this.sdt = sdt;
        this.mahgd = mahgd;
        this.Socmnd = Socmnd;
        this.email = email;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
    }

    public String getMatv() {
        return matv;
    }

    public void setMatv(String matv) {
        this.matv = matv;
    }

    public String getTentv() {
        return tentv;
    }

    public void setTentv(String tentv) {
        this.tentv = tentv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMahgd() {
        return mahgd;
    }

    public void setMahgd(String mahgd) {
        this.mahgd = mahgd;
    }

    public String getSocmnd() {
        return Socmnd;
    }

    public void setSocmnd(String Socmnd) {
        this.Socmnd = Socmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
}

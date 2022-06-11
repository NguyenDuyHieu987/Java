/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class DichVu {

    private String TenDichVu;
    private Double GiaTrenGio;

    public DichVu() {
    }

    public DichVu(String TenDichVu, Double GiaTrenGio) {
        this.TenDichVu = TenDichVu;
        this.GiaTrenGio = GiaTrenGio;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public Double getGiaTrenGio() {
        return GiaTrenGio;
    }

    public void setGiaTrenGio(Double GiaTrenGio) {
        this.GiaTrenGio = GiaTrenGio;
    }

}

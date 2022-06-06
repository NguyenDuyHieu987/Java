/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nguyenduyhieu;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class NhanVien {

    private String MaNV;
    private int soSP;

    public NhanVien(String MaNV, int soSP) {
        this.MaNV = MaNV;
        this.soSP = soSP;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getSoSP() {
        return soSP;
    }

    public void setSoSP(int soSP) {
        this.soSP = soSP;
    }

    public boolean coVuotChuan() {
        if (soSP > 500) {
            return true;
        } else {
            return false;
        }

    }

    public String getTongKet() {
        if (coVuotChuan()) {
            return "Vượt";
        } else {
            return "";
        }
    }

    public long getLuong() {
        if (coVuotChuan()) {
            return 20000 * 500 + (soSP - 500) * 30000;
        } else {
            return (long) (soSP * 20000);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        MaNV = sc.nextLine();
        System.out.print("Nhập mã số sản phẩm: ");
        soSP = sc.nextInt();

    }

    public static void XuatTieuDe() {
        System.out.println("Mã Nhân Viên | Số Sản Phẩm | Lương | Tổng kết");
    }

    @Override
    public String toString() {
        return "\t" + MaNV + "\t" + soSP + "\t  " + getLuong() + "  " + getTongKet();
    }

}

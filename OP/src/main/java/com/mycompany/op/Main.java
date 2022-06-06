/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.op;

/**
 *
 * @author ddom6
 */
public class Main {

    public static void main(String[] args) {
//        ConNguoi cn = new ConNguoi();
//        DanhSach ds = new DanhSach();
//        ds.Nhap();
//        ds.Xuat();

        SinhVien sv = new SinhVien("123", "Nguyen Duy Hieu", 2002, "456", (float) 9.5);
        sv.Xuat();
    }
}

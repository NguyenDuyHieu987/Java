/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.op;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class SinhVien extends ConNguoi {

    private String MaSV;
    private float DTB;

    public SinhVien() {
    }

    // không khai báo lại các field đã có của class ConNguoi
    public SinhVien(String CMND, String HoTen, int NamSinh, String MaSV, float DTB) {
        super(CMND, HoTen, NamSinh);
        this.MaSV = MaSV;
        this.DTB = DTB;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma SV: ");
        MaSV = sc.nextLine();

        super.Nhap();
        System.out.print("Nhap DTB: ");
//        DTB = sc.nextFloat();

    }

    @Override
    public void Xuat() {
        System.out.println("MaSV: " + MaSV);
        super.Xuat();
        System.out.println("DTB: " + DTB);

    }

}

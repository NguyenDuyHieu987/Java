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
public class ConNguoi {

    private String CMND;
    private String HoTen;
    private int NamSinh;

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public ConNguoi() {

    }

    public ConNguoi(String CMND, String HoTen, int NamSinh) {
        this.CMND = CMND;
        this.HoTen = HoTen;
        this.NamSinh = NamSinh;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("CMND = ");
        CMND = sc.nextLine();
        System.out.print("Ho Ten = ");
        HoTen = sc.nextLine();
        System.out.print("Nam sinh = ");
        NamSinh = sc.nextInt();
    }

    public void Xuat() {
        System.out.println("CMND = " + CMND);
        System.out.println("Ho Ten = " + HoTen);
        System.out.println("Nam sinh = " + NamSinh);

    }
}

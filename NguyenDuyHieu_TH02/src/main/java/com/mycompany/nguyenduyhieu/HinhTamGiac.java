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
public class HinhTamGiac {

    private int ma;
    private int mb;
    private int mc;

    public HinhTamGiac(int a, int b, int c) {
        if (a < 0) {
            System.out.println(a + " la so am duoc gan bang 0");
            this.ma = 0;
        }

        if (b < 0) {
            System.out.println(b + " la so am duoc gan bang 0");
            this.mb = 0;
        }

        if (c < 0) {
            System.out.println(c + " la so am duoc gan bang 0");
            this.mc = 0;
        }
        if (IsTamGiac(a, b, c)) {
            this.ma = a;
            this.mb = b;
            this.mc = c;

        } else {
            System.out.println("khong phai hinh tam giac");
            this.ma = 0;
            this.mb = 0;
            this.mc = 0;
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap a: ");
        ma = sc.nextInt();

        System.out.print("Nhap b: ");
        mb = sc.nextInt();

        System.out.print("Nhap c: ");
        mc = sc.nextInt();

    }

    public void Xuat() {
        System.out.println("Canh a: " + ma);
        System.out.println("Canh b: " + mb);
        System.out.println("Canh c: " + mc);
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMb() {
        return mb;
    }

    public void setMb(int mb) {
        this.mb = mb;
    }

    public int getMc() {
        return mc;
    }

    public void setMc(int mc) {
        this.mc = mc;
    }

    public float getChuVi() {
        return ma + mb + mc;
    }

    public double getDienTich() {
        double DT = Math.sqrt(getChuVi() * (getChuVi() - ma) * (getChuVi() - mb) * (getChuVi() - mc));
        return DT;
    }

    public Boolean IsTamGiac() {
        if (ma > 0 || mb > 0 || mc > 0) {
            if (ma < mb + mc && mb < ma + mc && mc < ma + mb) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean IsTamGiac(int a, int b, int c) {

        if (a < b + c && b < a + c && c < a + b) {
            return true;
        } else {
            return false;
        }
    }

}

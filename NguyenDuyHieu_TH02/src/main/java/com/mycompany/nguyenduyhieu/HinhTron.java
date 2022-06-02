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
public class HinhTron {

    private float r;

    public HinhTron() {
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.err.print("Nhap r: ");
        r = sc.nextFloat();
    }

    public float TinhChuVi() {
        return 2 * (float) Math.PI * r;
    }

    public float TinhDienTich() {
        return (float) Math.PI * r * r;
    }
}

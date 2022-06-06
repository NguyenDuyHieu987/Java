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
public class DanhSach {

    private int SoLuong;
    private ConNguoi[] arr;

    public DanhSach() {
    }

    public DanhSach(int SoLuong, ConNguoi[] arr) {
        this.SoLuong = SoLuong;
        this.arr = arr;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong: ");
        SoLuong = sc.nextInt();

        this.arr = new ConNguoi[SoLuong];
        for (int i = 0; i < SoLuong; i++) {
            System.out.println("Nhap con nguoi thu " + i + 1 + ": ");
            arr[i] = new ConNguoi();
            arr[i].Nhap();
        }
    }

    public void Xuat() {

        for (int i = 0; i < SoLuong; i++) {
            System.out.println("Con nguoi thu " + i + 1 + ": ");
            arr[i].Xuat();
        }
    }

}

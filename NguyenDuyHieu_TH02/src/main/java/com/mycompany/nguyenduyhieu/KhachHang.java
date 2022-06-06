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
public class KhachHang {

    private String TenKhachHang;
    private String CaoVoi;
    private String TayTrang;
    private int NhoRang;
    private int TramRang;

    public KhachHang() {
    }

    public KhachHang(String CaoVoi, String TayTrang, int NhoRang, int TramRang) {
        this.CaoVoi = CaoVoi;
        this.TayTrang = TayTrang;
        this.NhoRang = NhoRang;
        this.TramRang = TramRang;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên khách hàng: ");
        TenKhachHang = sc.nextLine();

        do {
            System.out.print("Chọn cạo vôi (yes, no): ");
            CaoVoi = sc.nextLine();

            if (!CaoVoi.equals("yes") && !CaoVoi.equals("no")) {
                System.out.println("Nhập sai");
            }

        } while (!CaoVoi.equals("yes") && !CaoVoi.equals("no"));

        do {
            System.out.print("Chọn trám răng (yes, no): ");
            TayTrang = sc.nextLine();

            if (!TayTrang.equals("yes") && !TayTrang.equals("no")) {
                System.out.println("Nhập sai");
            }

        } while (!TayTrang.equals("yes") && !TayTrang.equals("no"));

        System.out.print("Nhâp số răng muốn nhổ: ");
        NhoRang = sc.nextInt();

        System.out.print("Nhâp số răng muốn trám: ");
        TramRang = sc.nextInt();

    }

    public void Xuat() {
        System.out.println("Tên khách hàng: " + TenKhachHang);
        System.out.println("Cạo vôi: " + CaoVoi);
        System.out.println("Tẩy trắng: " + TayTrang);
        System.out.println("Số răng nhổ: " + NhoRang);
        System.out.println("Số răng trám: " + TramRang);

    }

    public long TongTien() {
        if (CaoVoi.equals("yes") && TayTrang.equals("yes")) {
            return (long) (100000 + 1500000 + NhoRang * 150000 + TramRang * 200000);
        } else if (CaoVoi.equals("yes") && TayTrang.equals("no")) {
            return (long) (100000 + NhoRang * 150000 + TramRang * 200000);
        } else if (CaoVoi.equals("no") && TayTrang.equals("yes")) {
            return (long) (1500000 + NhoRang * 150000 + TramRang * 200000);
        } else {
            return (long) (NhoRang * 150000 + TramRang * 200000);
        }
    }

}

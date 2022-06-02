/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.nguyenduyhieu;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class NguyenDuyHieu {

    public static void Sort_TongTien(KhachHang[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                KhachHang temp = new KhachHang();
                if (arr[i].TongTien() > arr[j].TongTien()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Bai 1
        HinhTron r = new HinhTron();
        r.Nhap();
        System.out.println("Chu vi: " + r.TinhChuVi());
        System.out.println("Dien Tich: " + r.TinhDienTich());
        //Bai 2
        HinhTamGiac tamgiac = new HinhTamGiac(3, -4, 5);
        tamgiac.Xuat();
        System.out.println("Chu vi: " + tamgiac.getChuVi());
        System.out.println("Dien Tich: " + tamgiac.getDienTich());
        //Bai 3
        System.out.print("Nhập số lượng nhân viên : ");
        int n = sc.nextInt();
        NhanVien[] arr = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Nhap nhan vien thu " + (i + 1));
            arr[i] = new NhanVien();
            arr[i].Nhap();
        }
        NhanVien tieuDe = new NhanVien();
        tieuDe.XuatTieuDe();
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Nhan vien thu " + (i + 1));
            System.out.println(arr[i].toString());
        }
        //Bai 4
        System.out.print("Nhập số lượng khách hàng : ");
        int m = sc.nextInt();
        KhachHang[] kh = new KhachHang[m];
        for (int i = 0; i < m; i++) {
            System.out.println();
            System.out.println("Nhập khách hàng thứ " + (i + 1));
            kh[i] = new KhachHang();
            kh[i].Nhap();
        }
        System.out.println();
        System.out.println("Khach hang sau khi nhap la");
        for (int i = 0; i < m; i++) {
            System.out.println();
            System.out.println("Khách hàng thu " + (i + 1));
            kh[i].Xuat();
            System.err.println("Tổng cộng: " + kh[i].TongTien());
        }

        Sort_TongTien(kh, m);
        System.out.println();
        System.out.println("Khach hang sau khi sap xép la");
        for (int i = 0; i < m; i++) {
            System.out.println();
            System.out.println("Khách hàng thu " + (i + 1));
            kh[i].Xuat();
            System.err.println("Tổng cộng: " + kh[i].TongTien());
        }

    }
}

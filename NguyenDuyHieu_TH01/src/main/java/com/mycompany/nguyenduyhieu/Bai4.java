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
public class Bai4 {

    public static void TongSoNguyen() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("Tong cac so nguyen tu 1 den " + n + "la: " + sum);
    }
}

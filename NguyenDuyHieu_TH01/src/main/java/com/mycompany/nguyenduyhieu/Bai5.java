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
public class Bai5 {

    public static void TongSoThapPhan() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        n = sc.nextInt();

        float sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (float) 1 / i;
        }
        System.out.println("Tong cac so thap phan tu 1 den " + n + "la: " + sum);
    }
}

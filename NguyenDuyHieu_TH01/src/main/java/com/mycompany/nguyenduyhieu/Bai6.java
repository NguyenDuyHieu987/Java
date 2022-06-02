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
public class Bai6 {

    public static void TinhGiaiThua() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        n = sc.nextInt();

        int sum = 1;

        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        System.out.println(n + "! = " + sum);

    }
}

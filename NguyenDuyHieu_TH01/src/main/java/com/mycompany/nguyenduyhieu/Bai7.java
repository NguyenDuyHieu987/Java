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
public class Bai7 {

    public static void TinhGiaiThua() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        n = sc.nextInt();

        int sum = 1;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                sum *= i;
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                sum *= i;
            }
        }

        System.out.println(n + "! = " + sum);

    }
}

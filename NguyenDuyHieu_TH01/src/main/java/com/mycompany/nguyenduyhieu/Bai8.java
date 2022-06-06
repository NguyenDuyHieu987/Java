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
public class Bai8 {

    public static void UCLN() {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a = ");
        a = sc.nextInt();
        System.out.print("Nhap b = ");
        b = sc.nextInt();

        if (a == 0 || b == 0) {
            System.out.println("UCLN cua " + a + " va " + b + " la: " + (a + b));
            return;
        }

        int tempa = a;
        int tempb = b;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println("UCLN cua " + tempa + " va " + tempb + " la: " + a);

    }
}

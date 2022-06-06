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
public class Bai3 {

    public static void GiaiPTB2() {
        float a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a = ");
        a = sc.nextFloat();
        System.out.print("Nhap b = ");
        b = sc.nextFloat();
        System.out.print("Nhap c = ");
        c = sc.nextFloat();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh vo so nghiem");
                } else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            } else {
                System.out.println("Phuong trinh co nghiem la x = " + (-c / b));

            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta > 0) {
                System.out.println("Phuong trinh co 2 nghiem la:");
                System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
                System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));

            } else if (delta == 0) {
                System.out.println("Phuong trinh co nghiem duy nhat la x = " + (-b / (2 * a)));

            } else {
                System.out.println("Phuong trinh vo nghiem");

            }

        }
    }
}

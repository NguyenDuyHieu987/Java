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
public class Bai2 {

    public static void GaiPTBac1() {
        float a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a = ");
        a = sc.nextFloat();
        System.out.print("Nhap b = ");
        b = sc.nextFloat();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            System.out.println("Phuong trinh co nghiem la x = " + (-b / a));

        }

    }
}

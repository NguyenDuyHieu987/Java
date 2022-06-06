/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nguyenduyhieu;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author ddom6
 */
public class Bai9 {

    private static int n;
    private static int[] arr;

    public static void Nhap() {
        System.out.print("Nhap so phan tu cua mang: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "] = ");
            arr[i] = sc.nextInt();

        }
    }

    public static void Xuat() {
        System.out.println("---Mang sau khi nhap la-----");
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "] = " + arr[i]);
        }
    }

    public static void TimMax_Min() {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

    }

    public static void CounEven() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co so chan nao trong mang");

        } else {
            System.out.println("So phan tu chan cua mang la: " + count);

        }
    }

    public static void SoNguyenTo() {
        System.out.print("Cac so nguyen to cua mang la: ");
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(arr[i] + " ");
            }
            count = 0;
        }
    }

    public static void SortASC() {
        Arrays.sort(arr);
        System.out.println();
        Xuat();
    }

    public static void Search() {
        int x;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap phan gia tri can tim: ");
        x = sc.nextInt();

        System.out.print("Phan tu co gia tri " + x + " nam o vi tri; ");
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                System.out.print(i + " ");
            }
        }

    }

}

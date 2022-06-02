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
public class Bai10 {

    private static int m, n;
    private static int[][] arr;

    public static void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so hang: ");
        m = sc.nextInt();
        System.out.print("Nhap so cot: ");
        n = sc.nextInt();

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhap a[" + i + "]" + "[" + j + "]" + " = ");
                arr[i][j] = sc.nextInt();
            }

        }
    }

    public static void Xuat() {
        System.out.println("---Ma tran sau khi nhap la-----");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void TimMin() {
        int min = arr[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }

        System.out.println("Min = " + min);
    }

    public static void TimMaxOdd() {
        int max = 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 != 0) {
                    max = arr[i][j];
                    count++;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 != 0) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }

            }
        }
        if (count == 0) {
            System.out.println("Khong co phan tu le nao");
        } else {
            System.out.println("Max odd = " + max);

        }
    }

    public static void TimMaxRow() {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }
        System.out.println("Max row = " + max);

    }

}

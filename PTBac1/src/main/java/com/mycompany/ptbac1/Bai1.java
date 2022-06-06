/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ptbac1;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Bai1 {
    
    public static void GiaiPTB1() {
        // Nhap a, b
        Scanner sc = new Scanner(System.in);
        float a, b;
        System.out.print("a = ");
        a = sc.nextFloat();
        System.out.print("b = ");
        b = sc.nextFloat();
        
//      Giai va bien luan x = -b/a
        
        if(a == 0)
        {
            if(b == 0)
            {
                System.out.println("Phuong trinh vo so nghiem!");
            }
            else{
                System.out.println("Phuong trinh vo nghiem!");
            }
        }
        else{
            float x = -b/a;
            System.out.println("Nghiem x = " + x);
        }

    }
    
    public static void TimUoc(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap a; ");
        int a = sc.nextInt();
        
//        Xet voi cac uoc Duong cua a thuoc doan (1,a)
        System.out.println("Cac uoc cua" + a + "la:");
        for(int i = 1; i<=a; i++)
        {
//            Neu a chia het cho i thi i se la uoc cua a
            if(a % i == 0)
            {
                System.out.println(i + "\t");
            }
        }
            
    }
    
    public static void KTSoNT(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap a; ");
        int a; 
        do {     
            a = sc.nextInt();
            int dem = 0;
    //        Xet voi cac uoc Duong cua a thuoc doan (1,a)
            for(int i = 1; i<=a; i++)
            {
    //            Neu a chia het cho i thi i se la uoc cua a
                if(a % i == 0)
                {
                    dem++;
                }
            }
            if(dem == 2)
            {
                System.out.println("\n"+ a + "la so nguyen to");
            }
            else{
                System.out.println("\n"+ a + "khong phai la so nguyen to");
            }
        } 
        while (a > 0);
       
            
    }
    public static void main(String[] args) {
//      GiaiPTB1();
//      TimUoc();
        KTSoNT();
    }
}

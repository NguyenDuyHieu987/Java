/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Demo1 {

    public static void main(String[] args) throws IOException {
        
//        Buffer 
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String name = rd.readLine();
        String s_n = rd.readLine();
        int n = Integer.parseInt(s_n);
        System.out.println("n = "+n);
        System.out.println("Xin chao " + name);

//        Scanner 
        Scanner sc = new Scanner(System.in);
        
        float f = sc.nextFloat();
        sc.nextLine();
        String username = sc.nextLine();
        int number_username = Integer.parseInt(username);
        System.out.println("f = " + f);
        System.out.println("username = " + number_username);


    }
    
}

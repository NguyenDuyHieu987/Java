/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.try_catch;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Try_Catch {

    public static void main(String[] args) {
        try {
            int a, b;
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap a = ");
            a = sc.nextInt();
            System.out.print("Nhap b = ");
            b = sc.nextInt();

            int x = -b / a;
            System.out.println("Nghiem x = " + x);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "error: " + ex.getMessage()
                    + JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

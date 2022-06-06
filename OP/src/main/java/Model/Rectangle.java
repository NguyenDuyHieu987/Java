/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Rectangle implements IShape {

    private float a;
    private float b;

    public Rectangle() {
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap hinh chu nhat ");

        System.out.print("Nhap chieu dai = ");
        a = sc.nextFloat();

        System.out.print("Nhap chieu rong = ");
        b = sc.nextFloat();
    }

    @Override
    public void Xuat() {
        System.out.println("Hinh chu nhat [" + a + ", " + b + "] ");
    }

    @Override
    public float Tinh() {
        return a * b;
    }
}

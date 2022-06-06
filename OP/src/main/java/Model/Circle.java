
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ddom6
 */
public class Circle implements IShape {

    private float r;

    public Circle() {
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap hinh tron, r = ");
        r = sc.nextFloat();
    }

    @Override
    public void Xuat() {
        System.out.println("Hinh tron (" + r + ") ");
    }

    @Override
    public float Tinh() {
        return (float) Math.PI * r * r;
    }
}

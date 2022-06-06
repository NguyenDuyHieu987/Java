/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
//interface: implements
public class Square implements IShape {

    private float a;

    public Square() {
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap hinh vuong, a = ");
        a = sc.nextFloat();
    }

    @Override
    public void Xuat() {
        System.out.println("Hinh Vuong [" + a + "] ");
    }

    @Override
    public float Tinh() {
        return a * a;
    }
}

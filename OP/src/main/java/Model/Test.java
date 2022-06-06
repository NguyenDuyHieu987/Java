/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hinh: ");
        int n = sc.nextInt();

//        Shape[] arr = new Shape[n];
        IShape[] arr = new IShape[n];

        System.out.println("Nhap hinh!");
        for (int i = 0; i < n; i++) {
            System.out.println("Chon loại hinh:\n1. Hinh Vuong\n2. Hinh CN\n3. Hinh Tron");
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    arr[i] = new Square();
                    break;
                case 2:
                    arr[i] = new Rectangle();
                    break;
                case 3:
                    arr[i] = new Circle();
                    break;
//                default:
//                    arr[i] = new Shape();
//                    break;
            }
            arr[i].Nhap();

        }
        System.out.println("\nDanh sach cac hinh la!");
        for (int i = 0; i < n; i++) {
            arr[i].Xuat();
            System.out.println("Dien Tich; " + arr[i].Tinh());
        }

//        Shape sh = new Shape();
//        sh.Nhap();
//        sh.Xuat();
//        System.out.println("S = " + sh.Tinh());
//
//        sh = new Square();
//        sh.Nhap();
//        sh.Xuat();
//        System.out.println("S = " + sh.Tinh());
//
//        sh = new Rectangle();
//        sh.Nhap();
//        sh.Xuat();
//        System.out.println("S = " + sh.Tinh());
//
//        sh = new Circle();
//        sh.Nhap();
//        sh.Xuat();
//        System.out.println("S = " + sh.Tinh());
    }
}

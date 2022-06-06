package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tạo mảng");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử : ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        for (int i = 0 ; i <= n - 1 ; i++){
            System.out.print("Nhập phần tử : ");
            arr[i] = sc.next();
        }
        
        for (int i = 0 ; i <= n - 1 ; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        int count = 0;
        for (int i = 0 ; i <= n - 1 ; i++){
            if(arr[i].equals("java")){
                count++;
            }
        }
        System.out.println("Số lần java xuất hiện : " + count);

        System.out.print("Nhập chuỗi cần kiểm tra : ");
        String s = sc.next();
        int index = 0 ;
        for (int i = 0 ; i <= n - 1 ; i++){
            if(arr[i].contains(s)){
                System.out.println("Chỉ mục : " + i);
                index++;
            }
        }
        if(index == 0){
            System.out.printf("Không tìm thấy %s trong mảng !",s);
        }
        sc.close();
    }   
}


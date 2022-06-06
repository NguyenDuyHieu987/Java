package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private int id;
    private String name;
    private int age;
    private String address;

    public Person(){

    }

    public Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void insertPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID : ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên : ");
        name = sc.nextLine();
        System.out.print("Nhập tuổi : ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ : ");
        address = sc.nextLine();
    }

    @Override
    public String toString() {
        return "\nid : " + id + " - Name : " + name + " - Age : " + age + " - Address : " + address;
    }

}

package com.company;

import java.util.Scanner;

public class Teacher extends Person{
    private long salary;

    public Teacher(int id, String name, int age, String address, long salary) {
        super(id, name, age, address);
        this.salary = salary;
    }

    public Teacher(){
        super();
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void insertTeacher(){
        Scanner sc = new Scanner(System.in);

        super.insertPerson();

        System.out.print("Nhập lương : ");
        salary = sc.nextLong();
    }

    @Override
    public String toString() {
        return super.toString() + " - Salary : " + salary;
    }
}

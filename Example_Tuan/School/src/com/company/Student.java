package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{
    private double theoreticalPoint;
    private double practicePoint;

    public Student(int id, String name, int age, String address, double theoreticalPoint, double practicePoint) {
        super(id, name, age, address);
        this.theoreticalPoint = theoreticalPoint;
        this.practicePoint = practicePoint;
    }

    public Student(){
        super();
    }

    public double getTheoreticalPoint() {
        return theoreticalPoint;
    }

    public void setTheoreticalPoint(double theoreticalPoint) {
        this.theoreticalPoint = theoreticalPoint;
    }

    public double getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(double practicePoint) {
        this.practicePoint = practicePoint;
    }

    public double GPA(){
        return (theoreticalPoint + practicePoint)/2 ;
    }

    public void insertStudent(){
        Scanner sc = new Scanner(System.in);
        super.insertPerson();
        System.out.print("Nhập điểm lý thuyết : ");
        theoreticalPoint = sc.nextInt();
        System.out.print("Nhập điểm thực hành : ");
        practicePoint = sc.nextInt();
    }

    @Override
    public String toString() {
        return super.toString() + " - theoreticalPoint : " + theoreticalPoint + " - practicePoint : " + practicePoint
                + " - GPA : " + GPA();
    }

    public void insert(ArrayList<Student> listStudent){
        Scanner sc = new Scanner(System.in);
    }
}

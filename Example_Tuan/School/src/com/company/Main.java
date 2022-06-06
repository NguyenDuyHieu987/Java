package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> listPerson = new ArrayList<>();
        ArrayList<Student> listStudent = new ArrayList<>();
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        ArrayList<Person> listAll = new ArrayList<>();

        boolean isContinue = false;
        while (!isContinue){
            menu();
            System.out.print("Nhập lựa chọn : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Nhập số lượng : ");
                    int a = sc.nextInt();
                    for (int i = 0 ; i < a ; i++){
                        Person p = new Person();
                        p.insertPerson();
                        listPerson.add(p);
                        listAll.add(p);
                    }
                    break;
                case 2:
                    System.out.print("Nhập số lượng : ");
                    int b = sc.nextInt();
                    for (int i = 0 ; i < b ; i++){
                        Student s = new Student();
                        s.insertStudent();
                        listStudent.add(s);
                        listAll.add(s);
                    }
                    break;
                case 3:
                    System.out.print("Nhập số lượng : ");
                    int c = sc.nextInt();
                    for (int i = 0 ; i < c ; i++){
                        Teacher t = new Teacher();
                        t.insertTeacher();
                        listPerson.add(t);
                        listAll.add(t);
                    }
                    break;
                case 4:
                    System.out.println("Toàn bộ danh sách : ");
                    printAll(listAll);
                    break;
                case 5:
                    System.out.println("Danh sách người bình thường : ");
                    printPerson(listPerson);
                    break;
                case 6:
                    System.out.println("Danh sách học sinh : ");
                    printStudent(listStudent);
                    break;
                case 7:
                    System.out.println("Danh sách giáo viên : ");
                    printTeacher(listTeacher);
                    break;
                default:
                    isContinue = true;
                    System.exit(1);
            }
        }

    }

    public static void printAll(ArrayList<Person> listAll){
        for (Person str: listAll) {
            System.out.println(str);
        }
    }

    public static void printPerson(ArrayList<Person> listPerson){
        for (Person str: listPerson) {
            System.out.println(str);
        }
    }

    public static void printStudent(ArrayList<Student> listStudent){
        for (Student str: listStudent) {
            System.out.println(str);
        }
    }

    public static void printTeacher(ArrayList<Teacher> listTeacher){
        for (Teacher str: listTeacher) {
            System.out.println(str);
        }
    }

    public static void menu(){
        System.out.println("1 - Nhập người bình thường");
        System.out.println("2 - Nhập học sinh");
        System.out.println("3 - Nhập giáo viên");
        System.out.println("4 - Hiện thị toàn bộ danh sách");
        System.out.println("5 - Hiện thị danh sách người bình thường");
        System.out.println("6 - Hiện thị danh sách học sinh");
        System.out.println("7 - Hiện thị danh sách giáo viên");
        System.out.println("Nhập số bất kì để thoát chương trình");
    }
}


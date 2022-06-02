package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Repository repo = new Repository();
        ArrayList<SchoolBook> listBook = repo.getData();

        System.out.println(listBook);
    }
}

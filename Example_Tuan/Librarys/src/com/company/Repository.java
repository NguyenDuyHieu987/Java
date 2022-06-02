package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Repository {
    public ArrayList<SchoolBook> getData() {
        ArrayList<SchoolBook> listBook = new ArrayList<>();

        listBook.add(new SchoolBook(listBook.size(), "a", "a", LocalDate.of(2020, 11, 1), 100, 100, "Mới", 1));
        listBook.add(new SchoolBook(listBook.size(), "b", "b", LocalDate.of(2020, 11, 2), 101, 150, "Cũ", 2));
        listBook.add(new SchoolBook(listBook.size(), "c", "c", LocalDate.of(2020, 11, 3), 102, 200, "Mới", 102));

        return listBook;
    }
}

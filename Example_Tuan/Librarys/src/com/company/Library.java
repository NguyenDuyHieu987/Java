package com.company;

import java.time.LocalDate;

public class Library {
    private int id;
    private String name;
    private String nxb;
    private LocalDate date;
    private int count;

    public Library(int id, String name, String nxb, LocalDate date, int count) {
        this.id = id;
        this.name = name;
        this.nxb = nxb;
        this.date = date;
        this.count = count;
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

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + nxb + " - " + date + " - " + count;
    }
}

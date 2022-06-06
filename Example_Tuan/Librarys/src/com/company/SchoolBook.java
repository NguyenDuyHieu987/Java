package com.company;

import java.time.LocalDate;

public class SchoolBook extends Library {
    private int soTrang;
    private String tinhTrang;
    private int slMuon;

    public SchoolBook(int id , String name, String nxb, LocalDate date, int count, int soTrang, String tinhTrang, int slMuon) {
        super(id, name, nxb, date, count);
        this.soTrang = soTrang;
        this.tinhTrang = tinhTrang;
        this.slMuon = slMuon;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSlMuon() {
        return slMuon;
    }

    public void setSlMuon(int slMuon) {
        this.slMuon = slMuon;
    }

    public int tonKho(){
        if (getSlMuon() < getCount()){
            return getCount() - getSlMuon();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + soTrang + " - " + tinhTrang + " - " + slMuon + " - " + tonKho() + "\n";
    }
}

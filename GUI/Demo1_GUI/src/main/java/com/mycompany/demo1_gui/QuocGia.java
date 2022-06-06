/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo1_gui;

/**
 *
 * @author ddom6
 */
public class QuocGia {

    public QuocGia(String Code, String Name) {
        this.Code = Code;
        this.Name = Name;
    }

    public QuocGia() {
    }

    @Override
    public String toString() {
        return Code + ", " + Name;
    }

    private String Code;
    private String Name;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}

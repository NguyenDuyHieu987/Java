/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class HGDObject {
    String mahgd;
    String tenchuho;
    String SoCMND;
    int sltv;

    public HGDObject() {
    }

    public HGDObject(String mahgd, String tenchuho, String SoCMND, int sltv) {
        this.mahgd = mahgd;
        this.tenchuho = tenchuho;
        this.SoCMND = SoCMND;
        this.sltv = sltv;
    }

    public String getMahgd() {
        return mahgd;
    }

    public void setMahgd(String mahgd) {
        this.mahgd = mahgd;
    }

    public String getTenchuho() {
        return tenchuho;
    }

    public void setTenchuho(String tenchuho) {
        this.tenchuho = tenchuho;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public int getSltv() {
        return sltv;
    }

    public void setSltv(int sltv) {
        this.sltv = sltv;
    }
    
    
}

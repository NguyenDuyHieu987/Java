/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Dao.CanhoDao;
import NguoidungUse.CanhoSevice;
import NguoidungUse.HGDsevice;
import NguoidungUse.NhanvienUse;
import NguoidungUse.Thanhviensevice;
import NguoidungUse.hopdongUse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class main {

    private static Object CHTABLE;
    public static void main(String[] args) throws ParseException {
        HopdongObject hd = new HopdongObject();
        hd.setMahd("H013");
        hd.setTenhd("AHD");
        String loaiHD = String.valueOf("DHSADAS");
        hd.setLoaihd(loaiHD);
        String maNV = String.valueOf("SADSA");
        hd.setManv(maNV);
        hd.setTennv("FSD");
        String macanho = String.valueOf("SSADAS");
        hd.setMacanho(macanho);
        String mahgd = String.valueOf("SDSA");
        hd.setMahgd(mahgd);
        hd.setTenchuho("SDASD");
        hd.setNoidung("DSADA");
        hd.setNgaykihd("2020-10-10");
        hd.setThoihan("2021-20-10");
        hd.setTongtien(12435);
        hopdongUse hdu = new hopdongUse();
        hdu.themHD(hd);
    }
}

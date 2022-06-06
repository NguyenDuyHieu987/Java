/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.DienObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DienDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<DienObject> getALL()
    {
        String sql = "SELECT * FROM HOADONDIEN ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<DienObject> list = new ArrayList<>();
            while(rs.next())
            {
                DienObject dien = new DienObject();
                dien.setMahddien(rs.getString(1));
                dien.setTenhd(rs.getString(2));
                dien.setManv(rs.getString(3));
                dien.setTennv(rs.getString(4));
                dien.setNgayin(rs.getString(5));
                dien.setMahgd(rs.getString(6));
                dien.setTenchuho(rs.getString(7));
                dien.setMacanho(rs.getString(8));
                dien.setTencanho(rs.getString(9));
                dien.setGhichu(rs.getString(10));
                dien.setSoluong(rs.getInt(11));
                dien.setDongia(rs.getFloat(12));
                dien.setTongtien(rs.getFloat(13));
                dien.setTrangthai(rs.getString(14));
                list.add(dien);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public DienObject getOne(String mahddien)
    {
        String sql = "SELECT * FROM HOADONDIEN where mahddien = '"+mahddien+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            DienObject dien = new DienObject();
            while(rs.next())
            {
                dien.setMahddien(rs.getString(1));
                dien.setTenhd(rs.getString(2));
                dien.setManv(rs.getString(3));
                dien.setTennv(rs.getString(4));
                dien.setNgayin(rs.getString(5));
                dien.setMahgd(rs.getString(6));
                dien.setTenchuho(rs.getString(7));
                dien.setMacanho(rs.getString(8));
                dien.setTencanho(rs.getString(9));
                dien.setGhichu(rs.getString(10));
                dien.setSoluong(rs.getInt(11));
                dien.setDongia(rs.getFloat(12));
                dien.setTongtien(rs.getFloat(13));
                dien.setTrangthai(rs.getString(14));
            }
            return dien;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int CheckADD(String mahddien)
    {
        int Check = 0;
        String sql = "SELECT count(*) FROM HOADONDIEN where mahddien = '"+mahddien+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
                Check = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Check;
    }
    public DienObject getOnebyMahgd(String mahgd)
    {
        String sql = "SELECT * FROM HOADONDIEN where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            DienObject dien = new DienObject();
            while(rs.next())
            {
                dien.setMahddien(rs.getString(1));
                dien.setTenhd(rs.getString(2));
                dien.setManv(rs.getString(3));
                dien.setTennv(rs.getString(4));
                dien.setNgayin(rs.getString(5));
                dien.setMahgd(rs.getString(6));
                dien.setTenchuho(rs.getString(7));
                dien.setMacanho(rs.getString(8));
                dien.setTencanho(rs.getString(9));
                dien.setGhichu(rs.getString(10));
                dien.setSoluong(rs.getInt(11));
                dien.setDongia(rs.getFloat(12));
                dien.setTongtien(rs.getFloat(13));
                dien.setTrangthai(rs.getString(14));
            }
            return dien;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<DienObject> getALLFromMonth(int month)
    {
        String sql = "SELECT * FROM HOADONDIEN where MONTH(ngayin) = '"+month+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<DienObject> list = new ArrayList<>();
            while(rs.next())
            {
                DienObject dien = new DienObject();
                dien.setMahddien(rs.getString(1));
                dien.setTenhd(rs.getString(2));
                dien.setManv(rs.getString(3));
                dien.setTennv(rs.getString(4));
                dien.setNgayin(rs.getString(5));
                dien.setMahgd(rs.getString(6));
                dien.setTenchuho(rs.getString(7));
                dien.setMacanho(rs.getString(8));
                dien.setTencanho(rs.getString(9));
                dien.setGhichu(rs.getString(10));
                dien.setSoluong(rs.getInt(11));
                dien.setDongia(rs.getFloat(12));
                dien.setTongtien(rs.getFloat(13));
                dien.setTrangthai(rs.getString(14));
                list.add(dien);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<DienObject> getALLFromYear(int year)
    {
        String sql = "SELECT * FROM HOADONDIEN where YEAR(ngayin) = '"+year+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<DienObject> list = new ArrayList<>();
            while(rs.next())
            {
                DienObject dien = new DienObject();
                dien.setMahddien(rs.getString(1));
                dien.setTenhd(rs.getString(2));
                dien.setManv(rs.getString(3));
                dien.setTennv(rs.getString(4));
                dien.setNgayin(rs.getString(5));
                dien.setMahgd(rs.getString(6));
                dien.setTenchuho(rs.getString(7));
                dien.setMacanho(rs.getString(8));
                dien.setTencanho(rs.getString(9));
                dien.setGhichu(rs.getString(10));
                dien.setSoluong(rs.getInt(11));
                dien.setDongia(rs.getFloat(12));
                dien.setTongtien(rs.getFloat(13));
                dien.setTrangthai(rs.getString(14));
                list.add(dien);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ThemHDDien(DienObject dien)
    {
        String sql = "INSERT HOADONDIEN(mahddien,tenhd,manv,tennv,ngayin,mahgd,tenchuho,mach,tencanho,ghichu,soluong,dongia,tongtien,trangthai)"+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, dien.getMahddien());
            ps.setString(2, dien.getTenhd());
            ps.setString(3, dien.getManv());
            ps.setString(4, dien.getTennv());
            ps.setString(5, dien.getNgayin());
            ps.setString(6, dien.getMahgd());
            ps.setString(7, dien.getTenchuho());
            ps.setString(8, dien.getMacanho());
            ps.setString(9, dien.getTencanho());
            ps.setString(10, dien.getGhichu());
            ps.setInt(11, dien.getSoluong());
            ps.setFloat(12, dien.getDongia());
            ps.setFloat(13, dien.getTongtien());
            ps.setString(14, dien.getTrangthai());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateDien(DienObject dien)
    {
        String sql = "UPDATE HOADONDIEN set tenhd = ?,manv = ?,tennv = ?,ngayin = ?,mahgd = ?,tenchuho = ?,mach = ?,tencanho = ?,ghichu = ?,soluong = ?,dongia = ?,tongtien = ?, trangthai = ? where mahddien = ?";
                
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, dien.getTenhd());
            ps.setString(2, dien.getManv());
            ps.setString(3, dien.getTennv());
            ps.setString(4, dien.getNgayin());
            ps.setString(5, dien.getMahgd());
            ps.setString(6, dien.getTenchuho());
            ps.setString(7, dien.getMacanho());
            ps.setString(8, dien.getTencanho());
            ps.setString(9, dien.getGhichu());
            ps.setInt(10, dien.getSoluong());
            ps.setFloat(11, dien.getDongia());
            ps.setFloat(12, dien.getTongtien());
            ps.setString(13, dien.getTrangthai());
            ps.setString(14, dien.getMahddien());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaHDDien(String mahddien)
    {
        String sql = "DELETE HOADONDIEN WHERE mahddien = '"+mahddien+"'";
        
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

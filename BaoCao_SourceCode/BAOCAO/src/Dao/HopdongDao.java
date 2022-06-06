/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.HopdongObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HopdongDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<HopdongObject> getALL()
    {
        String sql = "SELECT * FROM HOPDONG ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HopdongObject> list = new ArrayList<>();
            
            while(rs.next())
            {
                HopdongObject hd = new HopdongObject();
                hd.setMahd(rs.getString(1));
                hd.setTenhd(rs.getString(2));
                hd.setLoaihd(rs.getString(3));
                hd.setManv(rs.getString(4));
                hd.setTennv(rs.getString(5));
                hd.setMacanho(rs.getString(6));
                hd.setMahgd(rs.getString(7));
                hd.setTenchuho(rs.getString(8));
                hd.setNgaykihd(rs.getString(9));
                hd.setThoihan(rs.getString(10));
                hd.setNoidung(rs.getString(11));
                hd.setTongtien(rs.getFloat(12));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int CheckADD(String mahd)
    {
        int Check = 0;
        String sql = "SELECT * FROM HOPDONG WHERE mahd = '"+mahd+"' ";
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
    public HopdongObject getOne(String mahd)
    {
        String sql = "SELECT * FROM HOPDONG WHERE mahd = '"+mahd+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
             HopdongObject hd = new HopdongObject();
            while(rs.next())
            {
               
                hd.setMahd(rs.getString(1));
                hd.setTenhd(rs.getString(2));
                hd.setLoaihd(rs.getString(3));
                hd.setManv(rs.getString(4));
                hd.setTennv(rs.getString(5));
                hd.setMacanho(rs.getString(6));
                hd.setMahgd(rs.getString(7));
                hd.setTenchuho(rs.getString(8));
                hd.setNgaykihd(rs.getString(9));
                hd.setThoihan(rs.getString(10));
                hd.setNoidung(rs.getString(11));
                hd.setTongtien(rs.getFloat(12));
            }
            return hd;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HopdongObject getOneByHGD(String mahgd)
    {
        String sql = "SELECT * FROM HOPDONG WHERE mahgd = '"+mahgd+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
             HopdongObject hd = new HopdongObject();
            while(rs.next())
            {
               
                hd.setMahd(rs.getString(1));
                hd.setTenhd(rs.getString(2));
                hd.setLoaihd(rs.getString(3));
                hd.setManv(rs.getString(4));
                hd.setTennv(rs.getString(5));
                hd.setMacanho(rs.getString(6));
                hd.setMahgd(rs.getString(7));
                hd.setTenchuho(rs.getString(8));
                hd.setNgaykihd(rs.getString(9));
                hd.setThoihan(rs.getString(10));
                hd.setNoidung(rs.getString(11));
                hd.setTongtien(rs.getFloat(12));
            }
            return hd;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void themHD(HopdongObject hd )
    {
        String sql = "INSERT INTO HOPDONG(mahd,tenhd,loaihd,manv,tennv,macanho,mahgd,tenchuho,ngaykihd,thoihan,noidung,tongtien)"
                +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, hd.getMahd());
            ps.setString(2, hd.getTenhd());
            ps.setString(3, hd.getLoaihd());
            ps.setString(4, hd.getManv());
            ps.setString(5, hd.getTennv());
            ps.setString(6, hd.getMacanho());
            ps.setString(7, hd.getMahgd());
            ps.setString(8, hd.getTenchuho());
            ps.setString(9, hd.getNgaykihd());
            ps.setString(10, hd.getThoihan());
            ps.setString(11, hd.getNoidung());
            ps.setFloat(12, hd.getTongtien());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateHD(HopdongObject hd )
    {
        String sql = "UPDATE HOPDONG SET tenhd = ?,loaihd = ?,manv = ?,tennv = ?,macanho = ?,mahgd = ?,tenchuho = ?,ngaykihd = ?,thoihan = ?,noidung = ?, tongtien = ? where mahd = ?";
        
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, hd.getTenhd());
            ps.setString(2, hd.getLoaihd());
            ps.setString(3, hd.getManv());
            ps.setString(4, hd.getTennv());
            ps.setString(5, hd.getMacanho());
            ps.setString(6, hd.getMahgd());
            ps.setString(7, hd.getTenchuho());
            ps.setString(8, hd.getNgaykihd());
            ps.setString(9, hd.getThoihan());
            ps.setString(10, hd.getNoidung());
            ps.setFloat(11, hd.getTongtien());
            ps.setString(12, hd.getMahd());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaHD(String mahd )
    {
        String sql = "DELETE HOPDONG WHERE mahd = '"+mahd+"' ";
        
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

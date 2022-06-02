/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.DienObject;
import Entity.NuocObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NuocDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<NuocObject> getALL()
    {
        String sql = "SELECT * FROM HOADONNUOC ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<NuocObject> list = new ArrayList<>();
            while(rs.next())
            {
                NuocObject nc = new NuocObject();
                nc.setMahdnc(rs.getString(1));
                nc.setTenhd(rs.getString(2));
                nc.setManv(rs.getString(3));
                nc.setTennv(rs.getString(4));
                nc.setNgayin(rs.getString(5));
                nc.setMahgd(rs.getString(6));
                nc.setTenchuho(rs.getString(7));
                nc.setMacanho(rs.getString(8));
                nc.setTencanho(rs.getString(9));
                nc.setGhichu(rs.getString(10));
                nc.setSokhoi(rs.getFloat(11));
                nc.setDongia(rs.getFloat(12));
                nc.setTongtien(rs.getFloat(13));
                nc.setTrangthai(rs.getString(14));
                list.add(nc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public NuocObject getOne(String mahdnc)
    {
        String sql = "SELECT * FROM HOADONNUOC where mahdnc = '"+mahdnc+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            NuocObject nc = new NuocObject();
            while(rs.next())
            {
                nc.setMahdnc(rs.getString(1));
                nc.setTenhd(rs.getString(2));
                nc.setManv(rs.getString(3));
                nc.setTennv(rs.getString(4));
                nc.setNgayin(rs.getString(5));
                nc.setMahgd(rs.getString(6));
                nc.setTenchuho(rs.getString(7));
                nc.setMacanho(rs.getString(8));
                nc.setTencanho(rs.getString(9));
                nc.setGhichu(rs.getString(10));
                nc.setSokhoi(rs.getFloat(11));
                nc.setDongia(rs.getFloat(12));
                nc.setTongtien(rs.getFloat(13));
                nc.setTrangthai(rs.getString(14));    
            }
            return nc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int CheckADD(String mahdnc)
    {
        int Check = 0;
        String sql = "SELECT count(*) FROM HOADONNUOC where mahdnc = '"+mahdnc+"'";
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
    public NuocObject getOnebyMahgd(String mahgd)
    {
        String sql = "SELECT * FROM HOADONNUOC where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            NuocObject nc = new NuocObject();
            while(rs.next())
            {
                nc.setMahdnc(rs.getString(1));
                nc.setTenhd(rs.getString(2));
                nc.setManv(rs.getString(3));
                nc.setTennv(rs.getString(4));
                nc.setNgayin(rs.getString(5));
                nc.setMahgd(rs.getString(6));
                nc.setTenchuho(rs.getString(7));
                nc.setMacanho(rs.getString(8));
                nc.setTencanho(rs.getString(9));
                nc.setGhichu(rs.getString(10));
                nc.setSokhoi(rs.getFloat(11));
                nc.setDongia(rs.getFloat(12));
                nc.setTongtien(rs.getFloat(13));
                nc.setTrangthai(rs.getString(14));
            }
            return nc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NuocObject> getALLFromMonth(int month)
    {
        String sql = "SELECT * FROM HOADONNUOC where MONTH(ngayin) = '"+month+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<NuocObject> list = new ArrayList<>();
            while(rs.next())
            {
                NuocObject nc = new NuocObject();
                nc.setMahdnc(rs.getString(1));
                nc.setTenhd(rs.getString(2));
                nc.setManv(rs.getString(3));
                nc.setTennv(rs.getString(4));
                nc.setNgayin(rs.getString(5));
                nc.setMahgd(rs.getString(6));
                nc.setTenchuho(rs.getString(7));
                nc.setMacanho(rs.getString(8));
                nc.setTencanho(rs.getString(9));
                nc.setGhichu(rs.getString(10));
                nc.setSokhoi(rs.getFloat(11));
                nc.setDongia(rs.getFloat(12));
                nc.setTongtien(rs.getFloat(13));
                nc.setTrangthai(rs.getString(14));
                list.add(nc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NuocObject> getALLFromYear(int year)
    {
        String sql = "SELECT * FROM HOADONNUOC where YEAR(ngayin) = '"+year+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<NuocObject> list = new ArrayList<>();
            while(rs.next())
            {
                NuocObject nc = new NuocObject();
                nc.setMahdnc(rs.getString(1));
                nc.setTenhd(rs.getString(2));
                nc.setManv(rs.getString(3));
                nc.setTennv(rs.getString(4));
                nc.setNgayin(rs.getString(5));
                nc.setMahgd(rs.getString(6));
                nc.setTenchuho(rs.getString(7));
                nc.setMacanho(rs.getString(8));
                nc.setTencanho(rs.getString(9));
                nc.setGhichu(rs.getString(10));
                nc.setSokhoi(rs.getFloat(11));
                nc.setDongia(rs.getFloat(12));
                nc.setTongtien(rs.getFloat(13));
                nc.setTrangthai(rs.getString(14));
                list.add(nc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ThemHDNC(NuocObject nc)
    {
        String sql = "INSERT HOADONNUOC(mahdnc,tenhd,manv,tennv,ngayin,mahgd,tenchuho,macanho,tencanho,ghichu,sokhoi,dongia,tongtien,trangthai)"+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, nc.getMahdnc());
            ps.setString(2, nc.getTenhd());
            ps.setString(3, nc.getManv());
            ps.setString(4, nc.getTennv());
            ps.setString(5, nc.getNgayin());
            ps.setString(6, nc.getMahgd());
            ps.setString(7, nc.getTenchuho());
            ps.setString(8, nc.getMacanho());
            ps.setString(9, nc.getTencanho());
            ps.setString(10, nc.getGhichu());
            ps.setFloat(11, nc.getSokhoi());
            ps.setFloat(12, nc.getDongia());
            ps.setFloat(13, nc.getTongtien());
            ps.setString(14, nc.getTrangthai());
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateNc(NuocObject nc)
    {
        String sql = "UPDATE HOADONNUOC set tenhd = ?,manv = ?,tennv = ?,ngayin = ?,mahgd = ?,tenchuho = ?,macanho = ?,tencanho = ?,ghichu = ?,sokhoi = ?,dongia = ?,tongtien = ?,trangthai = ? where mahdnc = ?";
                
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, nc.getTenhd());
            ps.setString(2, nc.getManv());
            ps.setString(3, nc.getTennv());
            ps.setString(4, nc.getNgayin());
            ps.setString(5, nc.getMahgd());
            ps.setString(6, nc.getTenchuho());
            ps.setString(7, nc.getMacanho());
            ps.setString(8, nc.getTencanho());
            ps.setString(9, nc.getGhichu());
            ps.setFloat(10, nc.getSokhoi());
            ps.setFloat(11, nc.getDongia());
            ps.setFloat(12, nc.getTongtien());
            ps.setString(13, nc.getTrangthai());
            ps.setString(14, nc.getMahdnc());
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaHDNC(String mahdnc)
    {
        String sql = "DELETE HOADONNUOC WHERE mahdnc = '"+mahdnc+"'";
        
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

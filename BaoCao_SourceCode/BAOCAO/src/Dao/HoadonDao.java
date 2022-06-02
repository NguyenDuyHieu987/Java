/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.HoadonObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoadonDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<HoadonObject> getALL()
    {
        String sql = "Select * from HOADON";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HoadonObject> list = new ArrayList<>();
            while(rs.next())
            {
                HoadonObject hd = new HoadonObject();
                hd.setMahd(rs.getInt(1));
                hd.setMahgd(rs.getString(2));
                hd.setMach(rs.getString(3));
                hd.setTiendien(rs.getFloat(4));
                hd.setTiennuoc(rs.getFloat(5));
                hd.setTiendv(rs.getFloat(6));
                hd.setNgay(rs.getString(7));
                hd.setManv(rs.getString(8));
                hd.setTongtien(rs.getFloat(9));
                
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HoadonObject getOne(String mahd)
    {
        String sql = "Select * from HOADON Where MaHD = '"+mahd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            HoadonObject hd = new HoadonObject();
            
            while(rs.next())
            {
                hd.setMahd(rs.getInt(1));
                hd.setMahgd(rs.getString(2));
                hd.setMach(rs.getString(3));
                hd.setTiendien(rs.getFloat(4));
                hd.setTiennuoc(rs.getFloat(5));
                hd.setTiendv(rs.getFloat(6));
                hd.setNgay(rs.getString(7));
                hd.setManv(rs.getString(8));
                hd.setTongtien(rs.getFloat(9));
          
            }
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HoadonObject> getALLwMoth(int month)
    {
        String sql = "Select * from HOADON where MONTH(ngay)= '"+month+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HoadonObject> list = new ArrayList<>();
            while(rs.next())
            {
                HoadonObject hd = new HoadonObject();
             
                hd.setMahd(rs.getInt(1));
                hd.setMahgd(rs.getString(2));
                hd.setMach(rs.getString(3));
                hd.setTiendien(rs.getFloat(4));
                hd.setTiennuoc(rs.getFloat(5));
                hd.setTiendv(rs.getFloat(6));
                hd.setNgay(rs.getString(7));
                hd.setManv(rs.getString(8));
                hd.setTongtien(rs.getFloat(9));
                
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HoadonObject> getALLwYear(int year)
    {
        String sql = "Select * from HOADON where YEAR(ngay)= '"+year+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HoadonObject> list = new ArrayList<>();
            while(rs.next())
            {
                HoadonObject hd = new HoadonObject();
             
                hd.setMahd(rs.getInt(1));
                hd.setMahgd(rs.getString(2));
                hd.setMach(rs.getString(3));
                hd.setTiendien(rs.getFloat(4));
                hd.setTiennuoc(rs.getFloat(5));
                hd.setTiendv(rs.getFloat(6));
                hd.setNgay(rs.getString(7));
                hd.setManv(rs.getString(8));
                hd.setTongtien(rs.getFloat(9));
                
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ThemHD(HoadonObject hd)
    {
        try {
            String sql = "INSERT INTO HOADON(MAHGD,MANV,NGAY) VALUES(?,?,?)";
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMahgd());
            ps.setString(2, hd.getManv());
            ps.setString(3, hd.getNgay());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
        }
    }
}

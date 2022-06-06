/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.HGDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HGDDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<HGDObject> getALL()
    {
        String sql = "Select * from HGD";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HGDObject> list = new ArrayList<>();
            while(rs.next())
            {
                HGDObject hgd = new HGDObject();
                hgd.setMahgd(rs.getString(1));
                hgd.setTenchuho(rs.getString(2));
                hgd.setSoCMND(rs.getString(3));
                hgd.setSltv(rs.getInt(4));
                list.add(hgd);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public int CheckADD(String mahgd)
    {
        int Check = 0;
        String sql = "Select count(*) from HGD where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next())
                Check = rs.getInt(1);
        } catch (Exception e) {
        }
        return Check;
    }
    public List<HGDObject> getALLByID(String mahgd)
    {
        String sql = "Select * from HGD where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<HGDObject> list = new ArrayList<>();
            while(rs.next())
            {
                HGDObject hgd = new HGDObject();
                hgd.setMahgd(rs.getString(1));
                hgd.setTenchuho(rs.getString(2));
                hgd.setSoCMND(rs.getString(3));
                hgd.setSltv(rs.getInt(4));
                list.add(hgd);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public HGDObject getOne(String mahgd)
    {
        HGDObject hgd = new HGDObject();
        String sql = "Select * from HGD where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                hgd.setMahgd(rs.getString(1));
                hgd.setTenchuho(rs.getString(2));
                hgd.setSoCMND(rs.getString(3));
                hgd.setSltv(rs.getInt(4));
                return hgd;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
    public void ThemHGD(HGDObject hgd)
    {
        String sql = "INSERT INTO HGD(mahgd,tench,socmnd,sltv) VALUES(?,?,?,?)";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, hgd.getMahgd());
            ps.setString(2, hgd.getTenchuho());
            ps.setString(3, hgd.getSoCMND());
            ps.setInt(4, hgd.getSltv());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
        }
    }
    public void XOaHGD(String mahgd)
    {
        String sql = "DELETE HGD where mahgd = '"+mahgd+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
        }
    }
    public void UpdateHGD(HGDObject hgd)
    {
        String sql = "UPDATE HGD SET tench = ? , socmnd = ?, sltv = ? where mahgd = ?";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);
       
            ps.setString(1, hgd.getTenchuho());
            ps.setString(2, hgd.getSoCMND());
            ps.setInt(3, hgd.getSltv());
            ps.setString(4, hgd.getMahgd());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.DichvuObject;
import Entity.canhoOject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DichvuDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null ;
   
    public List<DichvuObject> getALL() 
    {
        String sql = "select * from DICHVU";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<DichvuObject> list = new ArrayList<>();
            
            while(rs.next())
            {
                DichvuObject dv = new DichvuObject();
                dv.setMadv(rs.getString(1));
                dv.setTendv(rs.getString(2));
                dv.setGia(rs.getFloat(3));
                list.add(dv);
            }
            return list;
        } catch (Exception e) {
        }
       return null;
    }
    public DichvuObject getOne(String madv) 
    {
        String sql = "select * from DICHVU Where Madv = '"+madv+"'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                DichvuObject dv = new DichvuObject();
                dv.setMadv(rs.getString(1));
                dv.setTendv(rs.getString(2));
                dv.setGia(rs.getFloat(3));
                return dv;
            }           
        } catch (Exception e) {
        }
       return null;
    }
    public int CheckADD(String madv) 
    {
        int Check  = 0;
        String sql = "select count(*) from DICHVU Where Madv = '"+madv+"'";
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
    public List<DichvuObject> getDVbyID(String tendv) 
    {
        String sql = "select * from DICHVU Where Tendv like '%'+ '"+tendv+"' + '%' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
          
            List<DichvuObject> list = new ArrayList<>();
            
            while(rs.next())
            {
                DichvuObject dv = new DichvuObject();
                dv.setMadv(rs.getString(1));
                dv.setTendv(rs.getString(2));
                dv.setGia(rs.getFloat(3));
                list.add(dv);
            }
            return list;
        } catch (Exception e) {
        }
       return null;
    }
    public void themCH(DichvuObject dv) 
    {
        try {
            String sql = "INSERT INTO DICHVU(Madv,Tendv,Gia) VALUES(?,?,?)";
            conn = JDBCConnection.GetConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, dv.getMadv());
                ps.setString(2, dv.getTendv());
                ps.setFloat(3, dv.getGia());
              
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void XoaCH(String madv) 
    {
        String sql = "DELETE DICHVU WHERE Madv ='"+madv+"' ";
        try {
           
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void UpdatCH(DichvuObject dv) 
    {
         String sql = "UPDATE DICHVU SET Tendv = ? , Gia = ? WHERE Madv = ?";

        try {            
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, dv.getTendv());
            ps.setFloat(2, dv.getGia());
            ps.setString(3, dv.getMadv());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

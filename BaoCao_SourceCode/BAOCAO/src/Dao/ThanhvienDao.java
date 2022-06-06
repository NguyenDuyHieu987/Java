/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;

import Entity.ThanhvienObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThanhvienDao {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null ;
   
    public List<ThanhvienObject> getALL() 
    {
        String sql = "select * from THANHVIEN";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<ThanhvienObject> list = new ArrayList<>();
            
            while(rs.next())
            {
                ThanhvienObject tv = new ThanhvienObject();
                tv.setMatv(rs.getString(1));
                tv.setTentv(rs.getString(2));
                tv.setMahgd(rs.getString(3));
                tv.setSdt(rs.getString(4));
                tv.setNgaysinh(rs.getString(5));               
                tv.setSocmnd(rs.getString(6));
                tv.setEmail(rs.getString(7));
                tv.setGioitinh(rs.getString(8));
                
                list.add(tv);
            }
            return list;
        } catch (Exception e) {
        }
       return null;
    }
    public int CheckADD(String matv) 
    {
        int Check = 0;
        String sql = "select count(*) from THANHVIEN where matv ='"+matv+"' ";
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
    public ThanhvienObject getOne(String matv) 
    {
        String sql = "select * from THANHVIEN where matv ='"+matv+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
    
            while(rs.next())
            {
                ThanhvienObject tv = new ThanhvienObject();
                tv.setMatv(rs.getString(1));
                tv.setTentv(rs.getString(2));
                tv.setMahgd(rs.getString(3));
                tv.setSdt(rs.getString(4));
                tv.setNgaysinh(rs.getString(5));               
                tv.setSocmnd(rs.getString(6));
                tv.setEmail(rs.getString(7));
                tv.setGioitinh(rs.getString(8));
                
                return tv;
            }
        } catch (Exception e) {
        }
       return null;

    }
    public List<ThanhvienObject>  getOnebyMHGD(String mhgd) 
    {
        String sql = "select * from THANHVIEN where mahgd ='"+mhgd+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<ThanhvienObject> list = new ArrayList<>();
            while(rs.next())
            {
                ThanhvienObject tv = new ThanhvienObject();
                tv.setMatv(rs.getString(1));
                tv.setTentv(rs.getString(2));
                tv.setMahgd(rs.getString(3));
                tv.setSdt(rs.getString(4));
                tv.setNgaysinh(rs.getString(5));               
                tv.setSocmnd(rs.getString(6));
                tv.setEmail(rs.getString(7));
                tv.setGioitinh(rs.getString(8));
                
                list.add(tv);
            }
            return list;
        } catch (Exception e) {
        }
       return null;

    }
    public ThanhvienObject getTVbyID(String matv) 
    {
        String sql = "select * from THANHVIEN Where matv = '"+matv+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
          
            List<ThanhvienObject> list = new ArrayList<>();
            
            while(rs.next())
            {
                ThanhvienObject tv = new ThanhvienObject();
                tv.setMatv(rs.getString(1));
                tv.setTentv(rs.getString(2));
                tv.setMahgd(rs.getString(3));
                tv.setSdt(rs.getString(4));
                tv.setNgaysinh(rs.getString(5));               
                tv.setSocmnd(rs.getString(6));
                tv.setEmail(rs.getString(7));
                tv.setGioitinh(rs.getString(8));
                return tv;
            }
           
        } catch (Exception e) {
        }
       return null;
    }
    public void themTV(ThanhvienObject tv) 
    {
        try {
            String sql = "INSERT INTO THANHVIEN(matv,tentv,sdt,ngaysinh,mahgd,socmnd,email,gioitinh) VALUES(?,?,?,?,?,?,?,?)";
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            
                ps.setString(1, tv.getMatv());
                ps.setString(2, tv.getTentv());
                ps.setString(3, tv.getSdt());
                ps.setString(4, tv.getNgaysinh());
                ps.setString(5, tv.getMahgd());
                ps.setString(6, tv.getSocmnd());
                ps.setString(7, tv.getEmail());
                ps.setString(8, tv.getGioitinh());
                
              
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void XoaTV(String matv) 
    {
        String sql = "DELETE THANHVIEN WHERE matv ='"+matv+"' ";
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
    public void UpdatTV(ThanhvienObject tv) 
    {
         String sql = "UPDATE THANHVIEN SET tentv = ?,sdt = ?, ngaysinh = ? , mahgd = ?, socmnd = ?,email = ?,gioitinh =? where matv = ? ";

        try {            
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
           
            ps.setString(1, tv.getTentv());
            ps.setString(2, tv.getSdt());
            ps.setString(3, tv.getNgaysinh());
            ps.setString(4, tv.getMahgd());
            ps.setString(5, tv.getSocmnd());
            ps.setString(6, tv.getEmail());
            ps.setString(7, tv.getGioitinh());
            ps.setString(8, tv.getMatv());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

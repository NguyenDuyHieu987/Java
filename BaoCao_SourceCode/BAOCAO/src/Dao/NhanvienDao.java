/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.NhanvienObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanvienDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<NhanvienObject> getALL()
    {
        String sql = "Select * from NHANVIEN ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<NhanvienObject> list = new ArrayList<>();
            while(rs.next())
            {
                NhanvienObject nv = new NhanvienObject();
                nv.setManv(rs.getString(1));
                nv.setTennv(rs.getString(2));
                nv.setGioitinh(rs.getString(3));
                nv.setDiachi(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setNgaysinh(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setSocmnd(rs.getString(8));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public NhanvienObject GetOne(String manv)
    {
        String sql = "Select * from NHANVIEN Where manv ='"+manv+"' ";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            NhanvienObject nv = new NhanvienObject();
            while(rs.next())
            {
               
                nv.setManv(rs.getString(1));
                nv.setTennv(rs.getString(2));
                nv.setGioitinh(rs.getString(3));
                nv.setDiachi(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setNgaysinh(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setSocmnd(rs.getString(8));
                
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int CheckADD(String manv)
    {
        int Check = 0;
        String sql = "Select count(*) from NHANVIEN Where manv ='"+manv+"' ";
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
    public void Themnv(NhanvienObject nv)
    {
        String sql = "INSERT INTO NHANVIEN(manv,tennv,gioitinh,diachi,sdt,ngaysinh,email,socmnd) VALUES(?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setString(3, nv.getGioitinh());
            ps.setString(4, nv.getDiachi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getNgaysinh());
            ps.setString(7, nv.getEmail());
            ps.setString(8, nv.getSocmnd());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateNV(NhanvienObject nv)
    {
        String sql = "UPDATE NHANVIEN SET tennv= ?,gioitinh = ?,diachi = ?,sdt = ?,ngaysinh = ?,email = ?,socmnd = ? WHERE manv = ?";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getTennv());
            ps.setString(2, nv.getGioitinh());
            ps.setString(3, nv.getDiachi());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getNgaysinh());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getSocmnd());
            ps.setString(8, nv.getManv());
            
            int ex = ps.executeUpdate();
            System.out.println(ex);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaNV(String manv)
    {
        String sql = "DELETE NHANVIEN WHERE manv = '"+manv+"'";
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

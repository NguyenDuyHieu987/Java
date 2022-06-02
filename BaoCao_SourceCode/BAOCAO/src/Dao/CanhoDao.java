/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
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
public class CanhoDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<canhoOject> getALL() {
        String sql = "select * from CANHO";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<canhoOject> list = new ArrayList<>();

            while (rs.next()) {
                canhoOject canho = new canhoOject();
                canho.setMa_can_ho(rs.getString(1));
                canho.setMa_khu(rs.getString(2));
                canho.setLoai_can_ho(rs.getString(3));
                canho.setMa_loai_can_ho(rs.getString(4));
                canho.setGhi_chu(rs.getString(5));
                canho.setGia(rs.getFloat(6));
                canho.setTrang_thai(rs.getString(7));
                list.add(canho);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public int CheckADD(String mach) {
        int Check = 0;
        String sql = "select count(*) from CANHO where macanho = '" + mach + "'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                Check = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return Check;
    }

    public List<canhoOject> GetListML() {
        String sql = "select * from LOAICANHO";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            List<canhoOject> list = new ArrayList<>();

            while (rs.next()) {
                canhoOject canho = new canhoOject();
                canho.setMa_loai_can_ho(rs.getString(1));
                canho.setLoai_can_ho(rs.getString(2));

                list.add(canho);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<canhoOject> getListKhu() {
        String sql = "select * from LOAICANHO";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            List<canhoOject> list = new ArrayList<>();

            while (rs.next()) {
                canhoOject canho = new canhoOject();
                canho.setMa_loai_can_ho(rs.getString(1));
                canho.setMa_can_ho(rs.getString(2));
                canho.setMa_khu(rs.getString(3));
                list.add(canho);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public canhoOject getOne(String mach) {
        String sql = "select * from CANHO Where macanho = '" + mach + "'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                canhoOject canho = new canhoOject();
                canho.setMa_can_ho(rs.getString(1));
                canho.setMa_khu(rs.getString(2));
                canho.setLoai_can_ho(rs.getString(3));
                canho.setMa_loai_can_ho(rs.getString(4));
                canho.setGhi_chu(rs.getString(5));
                canho.setGia(rs.getFloat(6));
                canho.setTrang_thai(rs.getString(7));
                return canho;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void themCH(canhoOject ch) {
        try {
            String sql = "INSERT INTO CANHO(macanho,makhu,loaicanho,maloaicanho,ghichu,gia,trangthai) VALUES(?,?,?,?,?,?,?)";
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ch.getMa_can_ho());
            ps.setString(2, ch.getMa_khu());
            ps.setString(3, ch.getLoai_can_ho());
            ps.setString(4, ch.getMa_loai_can_ho());
            ps.setString(5, ch.getGhi_chu());
            ps.setFloat(6, ch.getGia());
            ps.setString(7, ch.getTrang_thai());
            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void XoaCH(String mach) {
        String sql = "DELETE CANHO WHERE macanho ='" + mach + "' ";
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

    public void UpdatCH(canhoOject ch) {
        String sql = "UPDATE CANHO SET makhu = ? , maloaicanho = ? , loaicanho = ?, ghichu = ?, gia = ?, trangthai = ? WHERE macanho = ?";

        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, ch.getMa_khu());
            ps.setString(2, ch.getMa_loai_can_ho());
            ps.setString(3, ch.getLoai_can_ho());
            ps.setString(4, ch.getGhi_chu());
            ps.setFloat(5, ch.getGia());
            ps.setString(6, ch.getTrang_thai());
            ps.setString(7, ch.getMa_can_ho());

            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CanhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

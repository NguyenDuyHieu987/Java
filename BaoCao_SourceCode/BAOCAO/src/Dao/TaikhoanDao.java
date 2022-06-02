/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.JDBCConnection;
import Entity.TaikhoanObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TaikhoanDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<TaikhoanObject> getALL() {
        String sql = "SELECT *FROM TAIKHOAN";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            List<TaikhoanObject> list = new ArrayList<>();
            while (rs.next()) {
                TaikhoanObject tk = new TaikhoanObject();
                tk.setID(rs.getInt(1));
                tk.setTendangnhap(rs.getString(2));
                tk.setMatkhau(rs.getString(3));
                tk.setQuyen(rs.getString(4));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int CheckADD(int manv) {
        int Check = 0;
        String sql = "SELECT count(*) FROM TAIKHOAN where id = '" + manv + "'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Check = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Check;
    }

    public TaikhoanObject getOne(int manv) {
        String sql = "SELECT *FROM TAIKHOAN where id = '" + manv + "'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            TaikhoanObject tk = new TaikhoanObject();
            while (rs.next()) {

                tk.setID(rs.getInt(1));
                tk.setTendangnhap(rs.getString(2));
                tk.setMatkhau(rs.getString(3));
                tk.setQuyen(rs.getString(4));

            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TaikhoanObject> GetTK(String tendangnhap, String mk) {
        String sql = "SELECT *FROM TAIKHOAN where tendangnhap = '" + tendangnhap + "' and matkhau = '" + mk + "'";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<TaikhoanObject> list = new ArrayList<>();
            while (rs.next()) {

                TaikhoanObject tk = new TaikhoanObject();
                tk.setID(rs.getInt(1));
                tk.setTendangnhap(rs.getString(2));
                tk.setMatkhau(rs.getString(3));
                tk.setQuyen(rs.getString(4));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void themTK(TaikhoanObject tk) {
        String sql = "INSERT INTO TAIKHOAN (manv,tendangnhap,matkhau,quyen) VALUES(?,?,?,?)";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);
            tk.setID(rs.getInt(1));
            ps.setString(2, tk.getTendangnhap());
            ps.setString(3, tk.getMatkhau());
            ps.setString(4, tk.getQuyen());

            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateTK(TaikhoanObject tk) {
        String sql = "UPDATE TAIKHOAN SET tendangnhap = ?,matkhau = ?,quyen = ? where id = ?";
        try {
            conn = JDBCConnection.GetConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, tk.getTendangnhap());
            ps.setString(2, tk.getMatkhau());
            ps.setString(3, tk.getQuyen());
            ps.setInt(4, tk.getID());

            int ex = ps.executeUpdate();
            System.out.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void XoaTK(String id) {
        String sql = "DELETE TAIKHOAN WHERE ID = '" + id + "' ";
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

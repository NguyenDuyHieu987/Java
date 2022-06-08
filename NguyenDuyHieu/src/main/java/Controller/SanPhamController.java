/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Models.LoaiSP;
import Models.SP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ddom6
 */
public class SanPhamController {

    public List<SP> GetAllSP() {
        List<SP> listSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT SanPham.MaSP, SanPham.TenSp, SanPham.DonGia, LoaiSP.TenLoai"
                    + " FROM SanPham, LoaiSP WHERE SanPham.MaLoai = LoaiSP.MaLoai";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                SP sp = new SP();

                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setMaLoai(rs.getString("TenLoai"));

                listSP.add(sp);
            }
            rs.close();
            conn.close();
            return listSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<LoaiSP> GetAll_MaLoai() {
        List<LoaiSP> listloaiSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaLoai FROM LoaiSP";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP();

                loaiSP.setMaLoai(rs.getString("MaLoai"));

                listloaiSP.add(loaiSP);
            }
            rs.close();
            conn.close();
            return listloaiSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public String GetAll_TenLoaiSP(String MaLoai) {
        List<LoaiSP> listloaiSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT TenLoai FROM LoaiSP WHERE MaLoai = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaLoai);
            ResultSet rs = preparedStatement.executeQuery();
            String TenLoaiSP = "";
            while (rs.next()) {
                TenLoaiSP = rs.getString("TenLoai");
            }
            rs.close();
            conn.close();
            return TenLoaiSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<SP> GetAllSP_ByTenLoai(String MaLoai) {
        List<SP> listSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM SanPham WHERE MaLoai = ?";

            String SqlQuery1 = "SELECT LoaiSP.TenLoai FROM SanPham, LoaiSP WHERE SanPham.MaLoai = LoaiSP.MaLoai AND SanPham.MaLoai = ?";
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuery1);
            preparedStatement1.setString(1, MaLoai);
            ResultSet rs1 = preparedStatement1.executeQuery();
            String Loaisp = "";
            while (rs1.next()) {
                Loaisp = rs1.getString("TenLoai");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaLoai);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SP sp = new SP();

                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setMaLoai(Loaisp);

                listSP.add(sp);
            }
            rs.close();
            conn.close();
            return listSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean ThemSP(SP sp) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "INSERT INTO SanPham (MaSP, TenSP, DonGia, MaLoai) VALUES "
                    + "(?, ?, ?, ?);";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, sp.getMaSP());
            preparedStatement.setString(2, sp.getTenSP());
            preparedStatement.setFloat(3, sp.getDonGia());
            preparedStatement.setString(4, sp.getMaLoai());

            conn.commit();
            conn.setAutoCommit(true);

            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean XoaSP(String MaSP) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "DELETE FROM SanPham WHERE MaSP = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, MaSP);
            conn.commit();
            conn.setAutoCommit(true);

            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean SuaSP(SP sp) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "UPDATE SanPham SET TenSP = ?, DonGia = ?, MaLoai = ? WHERE MaSP = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, sp.getTenSP());
            preparedStatement.setFloat(2, sp.getDonGia());
            preparedStatement.setString(3, sp.getMaLoai());
            preparedStatement.setString(4, sp.getMaSP());

            conn.commit();
            conn.setAutoCommit(true);

            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public List<SP> GetAllSP_ByTenSP(String TenSP) {
        List<SP> listSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM SanPham WHERE TenSP = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, TenSP);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SP sp = new SP();

                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setMaLoai(rs.getString("MaLoai"));

                listSP.add(sp);
            }
            rs.close();
            conn.close();
            return listSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<SP> GetAllSP_Gia(float GiaTu, float GiaDen) {
        List<SP> listSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM SanPham WHERE DonGia BETWEEN ? AND ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setFloat(1, GiaTu);
            preparedStatement.setFloat(2, GiaDen);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SP sp = new SP();

                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setMaLoai(rs.getString("MaLoai"));

                listSP.add(sp);
            }
            rs.close();
            conn.close();
            return listSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}

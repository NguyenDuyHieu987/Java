/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.Phong;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class PhongController {

    public boolean ThemPhong(Phong phong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO Phong(MaPhong, TenPhong, DienTich, TienNghi, Gia, TrangThai) VALUES"
                    + "(?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, phong.getMaPhong());
            preparedStatement.setString(2, phong.getTenPhong());
            preparedStatement.setString(3, phong.getDienTich());
            preparedStatement.setString(4, phong.getTienNghi());
            preparedStatement.setDouble(5, phong.getGia());
            preparedStatement.setString(6, phong.getTrangThai());

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public List<Phong> GetAllPhong() {
        List<Phong> listPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM Phong";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Phong phong = new Phong();

                phong.setMaPhong(rs.getString("MaPhong"));
                phong.setTenPhong(rs.getString("TenPhong"));
                phong.setDienTich(rs.getString("DienTich"));
                phong.setTienNghi(rs.getString("TienNghi"));
                phong.setGia(rs.getDouble("Gia"));
                phong.setTrangThai(rs.getString("TrangThai"));

                listPhongs.add(phong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<Phong> SearchPhong(String MaPhong) {
        List<Phong> listPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM Phong WHERE MaPhong = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPhong);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Phong phong = new Phong();

                phong.setMaPhong(rs.getString("MaPhong"));
                phong.setTenPhong(rs.getString("TenPhong"));
                phong.setDienTich(rs.getString("DienTich"));
                phong.setTienNghi(rs.getString("TienNghi"));
                phong.setGia(rs.getDouble("Gia"));
                phong.setTrangThai(rs.getString("TrangThai"));

                listPhongs.add(phong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaPhong(Phong phong) {

        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);

            CallableStatement cs = conn.prepareCall("{CALL CapNhatGia_Phong(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, phong.getTenPhong());
            cs.setString(2, phong.getDienTich());
            cs.setString(3, phong.getTienNghi());
            cs.setDouble(4, phong.getGia());
            cs.setString(5, phong.getTrangThai());
            cs.setString(6, phong.getMaPhong());

            int kt = cs.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean XoaPhong(String MaPhong) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM Phong WHERE MaPhong = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaPhong);

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public String CheckStatus_Phong(String MaPhong) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT TrangThai FROM Phong WHERE MaPhong = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPhong);
            ResultSet rs = preparedStatement.executeQuery();

            String status = "";
            while (rs.next()) {
                status = rs.getString("TrangThai");
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return status;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
}

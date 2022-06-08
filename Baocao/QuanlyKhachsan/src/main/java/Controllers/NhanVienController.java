/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.NhanVien;
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
public class NhanVienController {

    public boolean ThemNhanVien(NhanVien nhanVien) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO NhanVien(MaNV, TenNV, GioiTinh, NgaySinh, DiaChi, SDT, CMND, Luong) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getTenNV());
            preparedStatement.setString(3, nhanVien.getGioiTinh());
            preparedStatement.setString(4, nhanVien.getNgaySinh());
            preparedStatement.setString(5, nhanVien.getDiaChi());
            preparedStatement.setInt(6, nhanVien.getSDT());
            preparedStatement.setInt(7, nhanVien.getCMND());
            preparedStatement.setFloat(8, nhanVien.getLuong());

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

    public List<NhanVien> GetAllNhanVien() {
        List<NhanVien> listnhNhanViens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM NhanVien";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();

                nhanVien.setMaNV(rs.getString("MaNV"));
                nhanVien.setTenNV(rs.getString("TenNV"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh").toString());
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setSDT(rs.getInt("SDT"));
                nhanVien.setCMND(rs.getInt("CMND"));
                nhanVien.setLuong(rs.getFloat("Luong"));

                listnhNhanViens.add(nhanVien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listnhNhanViens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<NhanVien> SearchNhanVien(String MaNV) {
        List<NhanVien> listnhNhanViens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM NhanVien WHERE MaNV = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaNV);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();

                nhanVien.setMaNV(rs.getString("MaNV"));
                nhanVien.setTenNV(rs.getString("TenNV"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh").toString());
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setSDT(rs.getInt("SDT"));
                nhanVien.setCMND(rs.getInt("CMND"));
                nhanVien.setLuong(rs.getFloat("Luong"));

                listnhNhanViens.add(nhanVien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listnhNhanViens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaNhanVien(NhanVien nhanVien) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE NhanVien SET TenNV = ? , GioiTinh = ? , NgaySinh = ? "
                    + ", DiaChi = ?, SDT = ? , CMND = ? , Luong = ? WHERE MaNV = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, nhanVien.getTenNV());
            preparedStatement.setString(2, nhanVien.getGioiTinh());
            preparedStatement.setString(3, nhanVien.getNgaySinh());
            preparedStatement.setString(4, nhanVien.getDiaChi());
            preparedStatement.setInt(5, nhanVien.getSDT());
            preparedStatement.setInt(6, nhanVien.getCMND());
            preparedStatement.setFloat(7, nhanVien.getLuong());
            preparedStatement.setString(8, nhanVien.getMaNV());

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

    public boolean XoaNhanVien(String MaNV) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM NhanVien WHERE MaNV = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaNV);

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
}

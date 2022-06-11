/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.KhachHang;
import Models.ThongKe;
import Models.ThueTraPhong;
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
public class ThongKeController {

    public double ThongKe_Thang(int Month, int MonthEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT SUM(TongTien)\n"
                    + "	From ThuePhong\n"
                    + "	WHERE MONTH(NgayBD) = ? AND MONTH(NgayKT) = ? AND TrangThai = N'Đã thanh toán';";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setInt(1, Month);
            preparedStatement.setInt(2, MonthEnd);
            ResultSet rs = preparedStatement.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (DoanhThu > 0) {
                return DoanhThu;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public double ThongKe_Nam(int Year, int YearEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT SUM(TongTien)\n"
                    + "	From ThuePhong\n"
                    + "	WHERE YEAR(NgayBD) = ? AND YEAR(NgayKT) = ? AND TrangThai = N'Đã thanh toán';";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setInt(1, Year);
            preparedStatement.setInt(2, YearEnd);
            ResultSet rs = preparedStatement.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();
            if (DoanhThu > 0) {
                return DoanhThu;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public boolean ThemThongKe(ThongKe thongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO ThongKe (MaThongKe, TenThongKe, GhiChu, DoanhThu) VALUES"
                    + "(?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongKe.getMaThongKe());
            preparedStatement.setString(2, thongKe.getTenThongKe());
            preparedStatement.setString(3, thongKe.getGhiChu());
            preparedStatement.setDouble(4, thongKe.getDoanhThu());

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

    public boolean SuaThongKe(ThongKe thongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE ThongKe SET TenThongKe = ?, GhiChu = ? WHERE MaThongKe =?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongKe.getTenThongKe());
            preparedStatement.setString(2, thongKe.getGhiChu());
            preparedStatement.setString(3, thongKe.getMaThongKe());

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

    public boolean XoaThongKe(String MaThongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM ThongKe WHERE MaThongKe = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaThongKe);

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

    public List<ThongKe> GetAllThongKe() {
        List<ThongKe> listThiThongKes = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThongKe";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongKe thongKe = new ThongKe();

                thongKe.setMaThongKe(rs.getString("MaThongKe"));
                thongKe.setTenThongKe(rs.getString("TenThongKe"));
                thongKe.setGhiChu(rs.getString("GhiChu"));
                thongKe.setDoanhThu(rs.getDouble("DoanhThu"));

                listThiThongKes.add(thongKe);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThiThongKes;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
}

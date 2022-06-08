/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.DichVuDaThue;
import Models.DoDungMatHong;
import Models.DoDungTrongPhong;
import java.sql.CallableStatement;
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
public class DoDungController {

    public boolean ThemDoDung(DoDungTrongPhong doDungTrongPhong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DoDungTrongPhong(TenDo, DonGia, SoLuong) VALUES"
                    + "(?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, doDungTrongPhong.getTenDo());
            preparedStatement.setDouble(2, doDungTrongPhong.getDonGia());
            preparedStatement.setInt(3, doDungTrongPhong.getSoLuong());

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

    public List<DoDungTrongPhong> GetAllDoDungTrongPhong() {
        List<DoDungTrongPhong> listdoDoDungTrongPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DoDungTrongPhong";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDungTrongPhong doDungTrongPhong = new DoDungTrongPhong();

                doDungTrongPhong.setTenDo(rs.getString("TenDo"));
                doDungTrongPhong.setDonGia(rs.getDouble("DonGia"));
                doDungTrongPhong.setSoLuong(rs.getInt("SoLuong"));

                listdoDoDungTrongPhongs.add(doDungTrongPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdoDoDungTrongPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<DoDungMatHong> GetAllDoDungHongMat() {
        List<DoDungMatHong> listdoDoDungMatHongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DoDungHongMat";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDungMatHong doDungMatHong = new DoDungMatHong();

                doDungMatHong.setMaThue(rs.getString("MaThue"));
                doDungMatHong.setTenDo(rs.getString("TenDo"));
                doDungMatHong.setSoLuong(rs.getInt("SoLuong"));
                doDungMatHong.setTongTien(rs.getDouble("TongTien"));

                listdoDoDungMatHongs.add(doDungMatHong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdoDoDungMatHongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean UpdateDoDungHong(List<DoDungMatHong> listdDoDungMatHongs, String MaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQueryInsert = "INSERT INTO DoDungHongMat(MaThue, TenDo, SoLuong, TongTien) VALUES"
                    + "(?, ?, ?, ?)";

            String SqlQueryUpdate = "UPDATE DoDungHongMat SET SoLuong = SoLuong + ? WHERE MaThue = ? AND TenDo = ?";

            String SqlQuerySelect = "SELECT TenDo FROM DoDungHongMat WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            preparedStatement1.setString(1, MaThue);
            ResultSet rs1 = preparedStatement1.executeQuery();

            List<String> lisDoDoHongMat = new ArrayList<>();
            while (rs1.next()) {
                String DichVuDaThue = rs1.getString("TenDo");

                lisDoDoHongMat.add(DichVuDaThue);
            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryInsert);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt1 = 0;

            if (lisDoDoHongMat.isEmpty()) {
                for (DoDungMatHong doDungMatHong : listdDoDungMatHongs) {
                    preparedStatement.setString(1, MaThue);
                    preparedStatement.setString(2, doDungMatHong.getTenDo());
                    preparedStatement.setInt(3, doDungMatHong.getSoLuong());
                    preparedStatement.setFloat(4, 0);
                    preparedStatement.addBatch();
                    preparedStatement.clearParameters();
                }
            } else {

                for (DoDungMatHong doDungMatHong : listdDoDungMatHongs) {
                    if (lisDoDoHongMat.contains(doDungMatHong.getTenDo())) {
                        preparedStatemen2.setInt(1, doDungMatHong.getSoLuong());
                        preparedStatemen2.setString(2, MaThue);
                        preparedStatemen2.setString(3, doDungMatHong.getTenDo());
                        kt1 = preparedStatemen2.executeUpdate();
                    } else {
                        preparedStatement.setString(1, MaThue);
                        preparedStatement.setString(2, doDungMatHong.getTenDo());
                        preparedStatement.setInt(3, doDungMatHong.getSoLuong());
                        preparedStatement.setFloat(4, 0);
                        preparedStatement.addBatch();
                        preparedStatement.clearParameters();

                    }
                }

            }

            int[] kt = preparedStatement.executeBatch();

            int kt2 = 0;
            for (DoDungMatHong doDungMatHong : listdDoDungMatHongs) {
                CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDoMatHong(?, ?)}");
                cs.setString(1, MaThue);
                cs.setString(2, doDungMatHong.getTenDo());
                kt2 = cs.executeUpdate();
            }

            conn.commit();
            rs1.close();
            conn.setAutoCommit(true);
            conn.close();

            int count = 0;
            for (int i = 0; i < kt.length; i++) {
                if (kt[i] > 0) {
                    count++;
                }
            }

            if (count >= listdDoDungMatHongs.size() || kt1 > 0 && kt2 > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }
}

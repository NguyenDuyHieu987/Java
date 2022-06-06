/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Models.LoaiSP;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class LoaiSPController {

    public List<LoaiSP> GetAllLoaiSP() {
        List<LoaiSP> listLoaiSP = new ArrayList<>();
        try {

            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LoaiSP";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP();

                loaiSP.setMaLoai(rs.getString("MaLoai"));
                loaiSP.setTenLoai(rs.getString("TenLoai"));

                listLoaiSP.add(loaiSP);
            }
            rs.close();
            conn.close();
            return listLoaiSP;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean AddLoaiSP(LoaiSP loaiSP) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "INSERT INTO LoaiSP VALUES (?,?);";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, loaiSP.getMaLoai());
            preparedStatement.setString(2, loaiSP.getTenLoai());
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

    public boolean XoaLoaiSP(String Maloai) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "DELETE FROM LoaiSP WHERE MaLoai = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, Maloai);
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

    public boolean SuaLoaiSP(LoaiSP loaiSP) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlInsert = "UPDATE LoaiSP SET TenLoai = ? WHERE Maloai = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlInsert);
            preparedStatement.setString(1, loaiSP.getTenLoai());
            preparedStatement.setString(2, loaiSP.getMaLoai());

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

}

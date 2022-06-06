/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Models.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class SinhVienController {

    public List<SinhVien> GetAllSinhVien() {
        List<SinhVien> listSV = new ArrayList<SinhVien>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM SinhVien";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(SqlQuery);
            while (rs.next()) {
                SinhVien sv = new SinhVien();

                sv.setMaSV(rs.getString("MaSV"));
                sv.setHoTenSV(rs.getString("HoTenSV"));
                sv.setLop(rs.getString("Lop"));
                sv.setGioiTinh(rs.getInt("GioiTinh"));

                listSV.add(sv);
            }
            rs.close();
            conn.close();
            return listSV;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean addSinhVien(SinhVien sv) {
        try {
            Connection conn = ConnectDB.GetConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "INSERT INTO SinhVien (MaSV, HoTenSV, Lop, Gioitinh) VALUES \n"
                    + "	('" + sv.getMaSV() + "','" + sv.getHoTenSV() + "', '" + sv.getLop() + "', "
                    + "" + sv.getGioiTinh() + ");";

            Statement st = conn.createStatement();

//            String sqlUpdate = "INSERT INTO SinhVien (MaSV, HoTenSV, Lop, Gioitinh) "
//                    + "VALUES (?, ?, ?, ?);";
//
//            PreparedStatement preparedStatement = conn.prepareStatement(sqlUpdate);
//            preparedStatement.setString(1, sv.getMaSV());
//            preparedStatement.setString(2, sv.getHoTenSV());
//            preparedStatement.setString(3, sv.getLop());
//            preparedStatement.setInt(4, sv.getGioiTinh());
            conn.commit();
            conn.setAutoCommit(true);

            int kt = st.executeUpdate(sqlUpdate);
//            int kt = preparedStatement.executeUpdate();
            conn.close();

            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;
    }

    public boolean updateSinhVien(SinhVien sv) {
        try {
            Connection conn = ConnectDB.GetConnection();

            Statement st = conn.createStatement();

            String sqlUpdate = "UPDATE SinhVien SET HoTenSV='" + sv.getHoTenSV() + "', "
                    + "Lop='" + sv.getLop() + "', Gioitinh = " + sv.getGioiTinh() + "\n"
                    + "	WHERE MaSV = '" + sv.getMaSV() + "';";

            int kt = st.executeUpdate(sqlUpdate);
            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);

        }
        return false;
    }

    public boolean deleteSinhVien(String MaSV) {
        try {
            Connection conn = ConnectDB.GetConnection();

            Statement st = conn.createStatement();

            String sqlUpdate = "DELETE FROM SinhVien WHERE MaSV = '" + MaSV + "'";

            int kt = st.executeUpdate(sqlUpdate);
            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);

        }
        return false;
    }

}

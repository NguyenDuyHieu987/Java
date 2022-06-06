/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Models.GiangVien;
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
public class GiangVienController {

    public List<GiangVien> getAllGiangVien() {
        List<GiangVien> listGV = new ArrayList<GiangVien>();
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM GiangVien";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                GiangVien gv = new GiangVien();

                gv.setMaGV(rs.getString("MaGV"));
                gv.setHoTenGV(rs.getString("HoTenGV"));

                listGV.add(gv);
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return listGV;
    }

    public boolean addGiangVien(GiangVien gv) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlUpdate = "INSERT INTO GiangVien (MaGV, HoTenGV) VALUES \n"
                    + "	('" + gv.getMaGV() + "','" + gv.getHoTenGV() + "');";

            Statement st = conn.createStatement();
            int kt = st.executeUpdate(SqlUpdate);

            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;
    }

    public boolean updateGiangVien(GiangVien gv) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlUpdate = "UPDATE GiangVien SET HoTenGV = '" + gv.getHoTenGV() + "'"
                    + "WHERE MaGV = '" + gv.getMaGV() + "';";

            Statement st = conn.createStatement();
            int kt = st.executeUpdate(SqlUpdate);
            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;
    }

    public boolean deleteGiangVien(String MaGV) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlUpdate = "DELETE FROM GiangVien WHERE MaGV = '" + MaGV + "'";

            Statement st = conn.createStatement();
            int kt = st.executeUpdate(SqlUpdate);
            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;
    }

}

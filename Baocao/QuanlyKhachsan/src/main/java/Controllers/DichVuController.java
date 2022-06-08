/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.DichVuDaThue;
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
public class DichVuController {

    public boolean ThueDichVu(List<DichVuDaThue> listdDichVus, String MaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQueryInsert = "INSERT INTO DichVuDaThue(MaThue, TenDichVu, SoGio, TongTien) VALUES"
                    + "(?, ?, ?, ?)";

            String SqlQueryUpdate = "UPDATE DichVuDaThue SET SoGio = SoGio + ? WHERE MaThue = ? AND TenDichVu = ?";

            String SqlQuerySelect = "SELECT TenDichVu FROM DichVuDaThue WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            preparedStatement1.setString(1, MaThue);
            ResultSet rs1 = preparedStatement1.executeQuery();

            List<String> listDichVuDaThue = new ArrayList<>();
            while (rs1.next()) {
                String DichVuDaThue = rs1.getString("TenDichVu");

                listDichVuDaThue.add(DichVuDaThue);
            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQueryInsert);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt1 = 0;

            if (listDichVuDaThue.isEmpty()) {
                for (DichVuDaThue dichVu : listdDichVus) {
                    preparedStatement.setString(1, MaThue);
                    preparedStatement.setString(2, dichVu.getTenDichVu());
                    preparedStatement.setInt(3, dichVu.getSoGio());
                    preparedStatement.setFloat(4, 0);
                    preparedStatement.addBatch();
                    preparedStatement.clearParameters();
                }
            } else {

                for (DichVuDaThue dichVu : listdDichVus) {
                    if (listDichVuDaThue.contains(dichVu.getTenDichVu())) {
                        preparedStatemen2.setInt(1, dichVu.getSoGio());
                        preparedStatemen2.setString(2, MaThue);
                        preparedStatemen2.setString(3, dichVu.getTenDichVu());
                        kt1 = preparedStatemen2.executeUpdate();
                    } else {
                        preparedStatement.setString(1, MaThue);
                        preparedStatement.setString(2, dichVu.getTenDichVu());
                        preparedStatement.setInt(3, dichVu.getSoGio());
                        preparedStatement.setFloat(4, 0);
                        preparedStatement.addBatch();
                        preparedStatement.clearParameters();

                    }
                }

            }

            int[] kt = preparedStatement.executeBatch();

            int kt2 = 0;
            for (DichVuDaThue dichVu : listdDichVus) {
                CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDichVu(?, ?)}");
                cs.setString(1, MaThue);
                cs.setString(2, dichVu.getTenDichVu());
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

            if (count >= listdDichVus.size() || kt1 > 0 && kt2 > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.DichVu;
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

    public boolean ThemDichVu(DichVu dichVu) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DichVu(TenDichVu, GiaTrenGio) VALUES"
                    + "(?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, dichVu.getTenDichVu());
            preparedStatement.setDouble(2, dichVu.getGiaTrenGio());

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

    public boolean SuaDichVu(DichVu dichVu) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DichVu SET TenDichVu = ? WHERE GiaTrenGio = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setDouble(1, dichVu.getGiaTrenGio());
            preparedStatement.setString(2, dichVu.getTenDichVu());

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

    public boolean XoaDichVu(DichVu dichVu) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DichVu WHERE TenDichVu = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, dichVu.getTenDichVu());

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

    public List<DichVu> GetAllDichVu() {
        List<DichVu> líDichVus = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DichVu";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DichVu dichVu = new DichVu();

                dichVu.setTenDichVu(rs.getString("TenDichVu"));
                dichVu.setGiaTrenGio(rs.getDouble("GiaTrenGio"));

                líDichVus.add(dichVu);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return líDichVus;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean ThemDichVuDaThue(DichVuDaThue dichVuDaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DichVuDaThue(MaThue, TenDichVu, SoGio, TongTien) VALUES"
                    + "(?, ?, ?, ?)";
            String SqlQueryUpdate = "UPDATE DichVuDaThue SET SoGio = SoGio + ? WHERE MaThue = ? AND TenDichVu = ?";

            String SqlQuerySelect = "SELECT TenDichVu FROM DichVuDaThue WHERE MaThue = ? AND TenDichVu = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            preparedStatement1.setString(1, dichVuDaThue.getMaThue());
            preparedStatement1.setString(2, dichVuDaThue.getTenDichVu());

            ResultSet rs1 = preparedStatement1.executeQuery();
            List<String> listdichvudathue = new ArrayList<>();

            while (rs1.next()) {
                String DoDungMatHongDaThem = rs1.getString("TenDichVu");
                listdichvudathue.add(DoDungMatHongDaThem);
            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt = 0, kt1 = 0;
            if (!listdichvudathue.contains(dichVuDaThue.getTenDichVu())) {
                preparedStatement.setString(1, dichVuDaThue.getMaThue());
                preparedStatement.setString(2, dichVuDaThue.getTenDichVu());
                preparedStatement.setInt(3, dichVuDaThue.getSoGio());
                preparedStatement.setDouble(4, 0);
                kt = preparedStatement.executeUpdate();

            } else {
                preparedStatemen2.setInt(1, dichVuDaThue.getSoGio());
                preparedStatemen2.setString(2, dichVuDaThue.getMaThue());
                preparedStatemen2.setString(3, dichVuDaThue.getTenDichVu());
                kt1 = preparedStatemen2.executeUpdate();
            }

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDichVu(?, ?)}");
            cs.setString(1, dichVuDaThue.getMaThue());
            cs.setString(2, dichVuDaThue.getTenDichVu());
            int kt2 = cs.executeUpdate();

            conn.commit();
            rs1.close();
            cs.close();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0 || kt1 > 0 || kt2 > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean SuaDichVuDaThue(DichVuDaThue dichVuDaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DichVuDaThue SET SoGio = ? WHERE MaThue = ? AND TenDichVu = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setInt(1, dichVuDaThue.getSoGio());
            preparedStatement.setString(2, dichVuDaThue.getMaThue());
            preparedStatement.setString(3, dichVuDaThue.getTenDichVu());
            int kt = preparedStatement.executeUpdate();

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDichVu(?, ?)}");
            cs.setString(1, dichVuDaThue.getMaThue());
            cs.setString(2, dichVuDaThue.getTenDichVu());
            int kt2 = cs.executeUpdate();

            conn.commit();
            cs.close();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0 || kt2 > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean XoaDichVuDaThue(DichVuDaThue dichVuDaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DichVuDaThue WHERE MaThue = ? AND TenDichVu = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, dichVuDaThue.getMaThue());
            preparedStatement.setString(2, dichVuDaThue.getTenDichVu());
            int kt = preparedStatement.executeUpdate();

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDichVu(?, ?)}");
            cs.setString(1, dichVuDaThue.getMaThue());
            cs.setString(2, dichVuDaThue.getTenDichVu());
            int kt2 = cs.executeUpdate();

            conn.commit();
            cs.close();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0 || kt2 > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public List<DichVuDaThue> GetAllDichVuDaThue() {
        List<DichVuDaThue> listdiDichVuDaThues = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DichVuDaThue";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DichVuDaThue dichVuDaThue = new DichVuDaThue();

                dichVuDaThue.setMaThue(rs.getString("MaThue"));
                dichVuDaThue.setTenDichVu(rs.getString("TenDichVu"));
                dichVuDaThue.setSoGio(rs.getInt("SoGio"));
                dichVuDaThue.setTongTien(rs.getDouble("TongTien"));

                listdiDichVuDaThues.add(dichVuDaThue);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdiDichVuDaThues;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<DichVuDaThue> GetAllDichVuDaThue_MaThue() {
        List<DichVuDaThue> listdiDichVuDaThues = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaThue FROM DichVuDaThue GROUP BY MaThue";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DichVuDaThue dichVuDaThue = new DichVuDaThue();

                dichVuDaThue.setMaThue(rs.getString("MaThue"));

                listdiDichVuDaThues.add(dichVuDaThue);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();

            return listdiDichVuDaThues;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<DichVuDaThue> SearchAllDichVuDaThue_MaThue(String MaThue) {
        List<DichVuDaThue> listdiDichVuDaThues = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DichVuDaThue WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaThue);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DichVuDaThue dichVuDaThue = new DichVuDaThue();

                dichVuDaThue.setMaThue(rs.getString("MaThue"));
                dichVuDaThue.setTenDichVu(rs.getString("TenDichVu"));
                dichVuDaThue.setSoGio(rs.getInt("SoGio"));
                dichVuDaThue.setTongTien(rs.getDouble("TongTien"));

                listdiDichVuDaThues.add(dichVuDaThue);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();

            return listdiDichVuDaThues;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

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

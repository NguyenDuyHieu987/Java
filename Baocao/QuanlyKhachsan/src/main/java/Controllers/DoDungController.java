/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.DichVuDaThue;
import Models.DoDungMatHong;
import Models.DoDung;
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

    public boolean ThemDoDung(DoDung doDung) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DoDung(TenDo, DonGia) VALUES"
                    + "(?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, doDung.getTenDo());
            preparedStatement.setDouble(2, doDung.getDonGia());

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

    public boolean SuaDoDung(DoDung doDung) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DoDung SET DonGia = ? WHERE TenDo = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setDouble(1, doDung.getDonGia());
            preparedStatement.setString(2, doDung.getTenDo());

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

    public boolean XoaDoDung(DoDung doDung) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DoDung WHERE TenDo = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, doDung.getTenDo());

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

    public List<DoDung> GetAllDoDung() {
        List<DoDung> listdoDoDungs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DoDung";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDung doDung = new DoDung();

                doDung.setTenDo(rs.getString("TenDo"));
                doDung.setDonGia(rs.getDouble("DonGia"));

                listdoDoDungs.add(doDung);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdoDoDungs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean ThemDoDungTrongPhong(DoDungTrongPhong doDungTrongPhong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DoDungTrongPhong(MaPhong, TenDo, SoLuong) VALUES"
                    + "(?, ?, ?)";
            String SqlQueryUpdate = "UPDATE DoDungTrongPhong SET SoLuong = SoLuong + ? WHERE MaPhong = ? AND TenDo = ?";

            String SqlQuerySelect = "SELECT TenDo FROM DoDungTrongPhong WHERE MaPhong = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            preparedStatement1.setString(1, doDungTrongPhong.getMaPhong());
            ResultSet rs1 = preparedStatement1.executeQuery();

            List<String> listDoDungDaThem = new ArrayList<>();
            while (rs1.next()) {
                String DichVuDaThue = rs1.getString("TenDo");

                listDoDungDaThem.add(DichVuDaThue);
            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt = 0, kt1 = 0;
            if (listDoDungDaThem.isEmpty()) {
                preparedStatement.setString(1, doDungTrongPhong.getMaPhong());
                preparedStatement.setString(2, doDungTrongPhong.getTenDo());
                preparedStatement.setInt(3, doDungTrongPhong.getSoLuong());
                kt = preparedStatement.executeUpdate();

            } else {
                preparedStatemen2.setInt(1, doDungTrongPhong.getSoLuong());
                preparedStatemen2.setString(2, doDungTrongPhong.getMaPhong());
                preparedStatemen2.setString(3, doDungTrongPhong.getTenDo());
                kt1 = preparedStatemen2.executeUpdate();

            }

            conn.commit();
            rs1.close();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0 || kt1 > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean SuaDoDungTrongPhong(DoDungTrongPhong doDungTrongPhong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DoDungTrongPhong SET SoLuong = ? WHERE MaPhong = ? AND TenDo = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setInt(1, doDungTrongPhong.getSoLuong());
            preparedStatement.setString(2, doDungTrongPhong.getMaPhong());
            preparedStatement.setString(3, doDungTrongPhong.getTenDo());

            int kt = preparedStatement.executeUpdate();

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

    public boolean XoaDoDungTrongPhong(DoDungTrongPhong doDungTrongPhong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DoDungTrongPhong WHERE MaPhong = ? AND TenDo = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, doDungTrongPhong.getMaPhong());
            preparedStatement.setString(2, doDungTrongPhong.getTenDo());

            int kt = preparedStatement.executeUpdate();

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

    public List<DoDungTrongPhong> GetAllDoDungTrongPhong() {
        List<DoDungTrongPhong> listdDoDungTrongPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT DoDungTrongPhong.MaPhong, TenPhong, TenDo, SoLuong FROM DoDungTrongPhong, Phong WHERE DoDungTrongPhong.MaPhong = Phong.MaPhong";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDungTrongPhong doDungTrongPhong = new DoDungTrongPhong();

                doDungTrongPhong.setMaPhong(rs.getString("MaPhong"));
                doDungTrongPhong.setTenPhong(rs.getString("TenPhong"));
                doDungTrongPhong.setTenDo(rs.getString("TenDo"));
                doDungTrongPhong.setSoLuong(rs.getInt("SoLuong"));

                listdDoDungTrongPhongs.add(doDungTrongPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdDoDungTrongPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<DoDungTrongPhong> SearchDoDungTrongPhong_ByMaPH(String MaPhong) {
        List<DoDungTrongPhong> listdDoDungTrongPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT DoDungTrongPhong.MaPhong, TenPhong, TenDo, SoLuong FROM DoDungTrongPhong, Phong WHERE DoDungTrongPhong.MaPhong = Phong.MaPhong "
                    + "AND DoDungTrongPhong.MaPhong = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPhong);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDungTrongPhong doDungTrongPhong = new DoDungTrongPhong();

                doDungTrongPhong.setMaPhong(rs.getString("MaPhong"));
                doDungTrongPhong.setTenPhong(rs.getString("TenPhong"));
                doDungTrongPhong.setTenDo(rs.getString("TenDo"));
                doDungTrongPhong.setSoLuong(rs.getInt("SoLuong"));

                listdDoDungTrongPhongs.add(doDungTrongPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listdDoDungTrongPhongs;

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

    public List<DoDungMatHong> GetAllDoDungHongMat_MaThue() {
        List<DoDungMatHong> listdoDoDungMatHongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaThue FROM DoDungHongMat GROUP BY MaThue";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DoDungMatHong doDungMatHong = new DoDungMatHong();

                doDungMatHong.setMaThue(rs.getString("MaThue"));

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

    public List<DoDungMatHong> SearchAllDoDungHongMat_MaThue(String MaThue) {
        List<DoDungMatHong> listdoDoDungMatHongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DoDungHongMat WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaThue);
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

    public boolean ThemDoDungMatHong(DoDungMatHong doDungMatHong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DoDungHongMat(MaThue, TenDo, SoLuong, TongTien) VALUES"
                    + "(?, ?, ?, ?)";
            String SqlQueryUpdate = "UPDATE DoDungHongMat SET SoLuong = SoLuong + ? WHERE MaThue = ? AND TenDo = ?";

            String SqlQuerySelect = "SELECT TenDo FROM DoDungHongMat WHERE MaThue = ? AND TenDo = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            preparedStatement1.setString(1, doDungMatHong.getMaThue());
            preparedStatement1.setString(2, doDungMatHong.getTenDo());

            ResultSet rs1 = preparedStatement1.executeQuery();
            String DoDungMatHongDaThem = "";
            while (rs1.next()) {
                DoDungMatHongDaThem = rs1.getString("TenDo");

            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt = 0, kt1 = 0;
            if (DoDungMatHongDaThem.equals("")) {
                preparedStatement.setString(1, doDungMatHong.getMaThue());
                preparedStatement.setString(2, doDungMatHong.getTenDo());
                preparedStatement.setInt(3, doDungMatHong.getSoLuong());
                preparedStatement.setDouble(4, 0);
                kt = preparedStatement.executeUpdate();

            } else {
                preparedStatemen2.setInt(1, doDungMatHong.getSoLuong());
                preparedStatemen2.setString(2, doDungMatHong.getMaThue());
                preparedStatemen2.setString(3, doDungMatHong.getTenDo());
                kt1 = preparedStatemen2.executeUpdate();
            }

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDoMatHong(?, ?)}");
            cs.setString(1, doDungMatHong.getMaThue());
            cs.setString(2, doDungMatHong.getTenDo());
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

    public boolean SuaDoDungMatHong(DoDungMatHong doDungMatHong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DoDungHongMat SET SoLuong = ? WHERE MaThue = ? AND TenDo = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setInt(1, doDungMatHong.getSoLuong());
            preparedStatement.setString(2, doDungMatHong.getMaThue());
            preparedStatement.setString(3, doDungMatHong.getTenDo());
            int kt = preparedStatement.executeUpdate();

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDoMatHong(?, ?)}");
            cs.setString(1, doDungMatHong.getMaThue());
            cs.setString(2, doDungMatHong.getTenDo());
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

    public boolean XoaDoDungMatHong(DoDungMatHong doDungMatHong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DoDungHongMat WHERE MaThue = ? AND TenDo = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, doDungMatHong.getMaThue());
            preparedStatement.setString(2, doDungMatHong.getTenDo());
            int kt = preparedStatement.executeUpdate();

            CallableStatement cs = conn.prepareCall("{CALL CapNhatTongTienDoMatHong(?, ?)}");
            cs.setString(1, doDungMatHong.getMaThue());
            cs.setString(2, doDungMatHong.getTenDo());
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
}

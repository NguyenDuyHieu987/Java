/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.DichVuDaThue;
import Models.ThueTraPhong;
import Models.KhachHang;
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
public class ThueTraController {

    public boolean TraPhong(String MaThue) {
        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);

            CallableStatement cs = conn.prepareCall("{CALL TraPhong(?)}");
            cs.setString("MaThue", MaThue);
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

    public boolean ThuePhong_Thue(ThueTraPhong thueTraPhong) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO ThuePhong(MaThue, MaPhong, MaKH, NgayBD, NgayKT, TongTien, TrangThai) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thueTraPhong.getMaThue());
            preparedStatement.setString(2, thueTraPhong.getMaPhong());
            preparedStatement.setString(3, thueTraPhong.getMaKH());
            preparedStatement.setString(4, thueTraPhong.getNgayBD());
            preparedStatement.setString(5, thueTraPhong.getNgayKT());
            preparedStatement.setFloat(6, 0);
            preparedStatement.setString(7, "Chưa thanh toán");

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

    public boolean ThuePhong_KhachHang(KhachHang khachHang) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO KhachHang(MaKH, TenKH, SDT, DiaChi, GioiTinh) VALUES"
                    + "(?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, khachHang.getMaKH());
            preparedStatement.setString(2, khachHang.getTenKH());
            preparedStatement.setInt(3, khachHang.getSDT());
            preparedStatement.setString(4, khachHang.getDiaChi());
            preparedStatement.setString(5, khachHang.getGioiTinh());

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

    public List<ThueTraPhong> GetAllThueTraPhong() {
        List<ThueTraPhong> listThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThuePhong";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<ThueTraPhong> SearchThue_MaThue(String MaThue) {
        List<ThueTraPhong> listThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThuePhong WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaThue);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<ThueTraPhong> SearchThue_MaKH(String MaKH) {
        List<ThueTraPhong> listThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT ThuePhong.* \n"
                    + "    FROM ThuePhong, KhachHang \n"
                    + "    WHERE KhachHang.MaKH = ThuePhong.MaKH\n"
                    + "    AND KhachHang.MaKH = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaKH);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<ThueTraPhong> SearchThue_ChuaThanhToan() {
        List<ThueTraPhong> listThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThuePhong WHERE TrangThai = N'Chưa thanh toán'";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<ThueTraPhong> SearchThue_DaThanhToan() {
        List<ThueTraPhong> listThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThuePhong WHERE TrangThai = N'Đã thanh toán'";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaThue(ThueTraPhong thueTraPhong) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaPhong FROM ThuePhong WHERE MaThue = ?;";

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, thueTraPhong.getMaThue());
            ResultSet rs = preparedStatement.executeQuery();
            String MaPH_old = "";
            while (rs.next()) {
                MaPH_old = rs.getString("MaPhong");
            }
            System.out.println(MaPH_old);
            CallableStatement cs = conn.prepareCall("{CALL CapNhatPhong_KhiSua(?, ?, ?, ?, ?)}");
            cs.setString(1, thueTraPhong.getMaPhong());
            cs.setString(2, MaPH_old);
            cs.setString(3, thueTraPhong.getNgayBD());
            cs.setString(4, thueTraPhong.getNgayKT());
            cs.setString(5, thueTraPhong.getMaThue());

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

    public boolean XoaThue(String MaThue) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM ThuePhong WHERE MaThue = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaThue);

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

    public List<KhachHang> GetAllKhachHang() {
        List<KhachHang> listkhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM KhachHang";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSDT(rs.getInt("SDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));

                listkhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listkhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<KhachHang> SearchKhachHang_MaKhachHang(String MaKH) {
        List<KhachHang> liskhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM KhachHang WHERE MaKH = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaKH);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSDT(rs.getInt("SDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));

                liskhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return liskhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<KhachHang> SearchKhachHang_MaThue(String MaThue) {
        List<KhachHang> liskhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT KhachHang.* \n"
                    + "    FROM ThuePhong, KhachHang \n"
                    + "    WHERE KhachHang.MaKH = ThuePhong.MaKH\n"
                    + "    AND ThuePhong.MaThue = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaThue);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSDT(rs.getInt("SDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));

                liskhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return liskhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<KhachHang> SearchKhachHang_ChuaThanhToan() {
        List<KhachHang> listkhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT KhachHang.* \n"
                    + "    FROM ThuePhong, KhachHang \n"
                    + "    WHERE KhachHang.MaKH = ThuePhong.MaKH\n"
                    + "    AND ThuePhong.TrangThai = N'Chưa thanh toán'";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSDT(rs.getInt("SDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));

                listkhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listkhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<KhachHang> SearchKhachHang_DaThanhToan() {
        List<KhachHang> listkhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT KhachHang.* \n"
                    + "    FROM ThuePhong, KhachHang \n"
                    + "    WHERE KhachHang.MaKH = ThuePhong.MaKH\n"
                    + "    AND ThuePhong.TrangThai = N'Đã thanh toán'";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSDT(rs.getInt("SDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));

                listkhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listkhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaKhachHang(KhachHang khachHang) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE KhachHang SET TenKH = ? , SDT = ? "
                    + ", DiaChi = ?, GioiTinh = ? WHERE MaKH = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, khachHang.getTenKH());
            preparedStatement.setInt(2, khachHang.getSDT());
            preparedStatement.setString(3, khachHang.getDiaChi());
            preparedStatement.setString(4, khachHang.getGioiTinh());
            preparedStatement.setString(5, khachHang.getMaKH());

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

    public List<ThueTraPhong> GetAllThue_MaPH(String MaPH) {
        List<ThueTraPhong> listthThueTraPhongs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThuePhong WHERE MaPhong = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPH);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThueTraPhong thueTraPhong = new ThueTraPhong();

                thueTraPhong.setMaThue(rs.getString("MaThue"));
                thueTraPhong.setMaPhong(rs.getString("MaPhong"));
                thueTraPhong.setMaKH(rs.getString("MaKH"));
                thueTraPhong.setNgayBD(rs.getString("NgayBD"));
                thueTraPhong.setNgayKT(rs.getString("NgayKT"));
                thueTraPhong.setTongTien(rs.getDouble("TongTien"));
                thueTraPhong.setTrangThai(rs.getString("TrangThai"));

                listthThueTraPhongs.add(thueTraPhong);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listthThueTraPhongs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<KhachHang> GetAllKhachHang_MaPH(String MaPH) {
        List<KhachHang> listkhKhachHangs = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT KhachHang.MaKH \n"
                    + "    FROM ThuePhong, Phong, KhachHang \n"
                    + "    WHERE ThuePhong.MaPhong = Phong.MaPhong AND KhachHang.MaKH = ThuePhong.MaKH\n"
                    + "    AND ThuePhong.MaPhong = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPH);

            ResultSet rs = preparedStatement.executeQuery();
            String MaKH = "";
            while (rs.next()) {
                MaKH = rs.getString("MaKH");
            }

            String SqlQuery1 = "SELECT * FROM KhachHang WHERE MaKH = ?";
            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuery1);
            preparedStatement1.setString(1, MaKH);
            ResultSet rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs1.getString("MaKH"));
                khachHang.setTenKH(rs1.getString("TenKH"));
                khachHang.setSDT(rs1.getInt("SDT"));
                khachHang.setDiaChi(rs1.getString("DiaChi"));
                khachHang.setGioiTinh(rs1.getString("GioiTinh"));

                listkhKhachHangs.add(khachHang);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            rs1.close();
            conn.close();
            return listkhKhachHangs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

}

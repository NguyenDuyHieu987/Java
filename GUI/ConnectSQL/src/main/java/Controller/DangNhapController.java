/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Models.ThongTinDangNhap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DangNhapController {

    public boolean DangNhapHeThong(ThongTinDangNhap ttDN) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT COUNT(*) FROM DangNhap WHERE TaiKhoan = '" + ttDN.getTaiKhoan() + "' "
                    + "AND MatKhau = '" + ttDN.getMatKhau() + "';";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(SqlQuery);
            int kt = 0;
            while (rs.next()) {
                kt = rs.getInt(1);
            }
            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

}

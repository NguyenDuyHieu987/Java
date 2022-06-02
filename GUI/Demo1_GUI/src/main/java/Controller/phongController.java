/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import java.sql.Connection;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JOptionPane;
import model.Phong;

/**
 *
 * @author ddom6
 */
public class phongController {

    public boolean add(Phong obj) {
        try {
            ConnectDB db = new ConnectDB();
            Connection cn = db.getConnectDB();

            Statement st = cn.createStatement();
            String query = "INSERT INTO PHONG (MAPH, TENPH, DT, GIAPHONG) VALUES \n"
                    + "	('" + obj.getMaPH() + "', '" + obj.getTenPH() + "', "
                    + "'" + obj.getDienTich() + "', '" + obj.getGiaPhong() + "');";

            int kt = st.executeUpdate(query);
            if (kt == 1) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error: " + ex.getMessage());
        }

        return false;
    }
}

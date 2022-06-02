/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ddom6
 */
public class userController {

    public boolean DangNhap() {
        try {
            ConnectDB db = new ConnectDB();
            Connection cn = db.getConnectDB();
            JOptionPane.showMessageDialog(null, "Kết nối thành công!");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: " + e.getMessage());
        }
        return false;
    }
}

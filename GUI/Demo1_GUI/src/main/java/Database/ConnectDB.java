/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ddom6
 */
public class ConnectDB {

//    private String svName = "DESKTOP-ISH3HH8\\SQLEXPRESS";
    private String svName = "localhost";
//    private String svName = "MSI\\SQLEXPRESS";
    private int port = 1433;
    private String dbName = "QUANLYKHACHSAN";
    private String userID = "sa";
    private String Password = "hieusen123";
    private Connection conn;

    public Connection getConnectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://" + svName + ":" + port + ";databaseName=" + dbName
                    + ";encrypt=false;";
            conn = DriverManager.getConnection(dbUrl, userID, Password);

        } catch (Exception ex) {
//            System.out.println("Loi khong tim thay driver!");
            JOptionPane.showMessageDialog(null, "error: " + ex.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}

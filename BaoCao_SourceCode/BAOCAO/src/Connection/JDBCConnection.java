/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class JDBCConnection {
    
    public  static Connection GetConnection() throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DataBaseName = QLCC ; user = sa; password = sa123");
        return conn;
    }
    public static void CloseConnection(Connection connection) throws SQLException{
        if(connection !=null)
            connection.close();
    }
    public static void ClosePreparedStatement(PreparedStatement preparedStatement) throws SQLException
    {
        if(preparedStatement !=null)
            preparedStatement.close();
    }
    public static void CloseCallableStatement(CallableStatement callableStatement) throws SQLException
    {
        if(callableStatement !=null)
            callableStatement.close();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = GetConnection();
        if(connection !=null)
        {
            System.out.println("THÀNH CÔNG ");
        }
        else {
            System.out.println("KHÔNG THÀNH CÔNG ");
        }
        
    }
}

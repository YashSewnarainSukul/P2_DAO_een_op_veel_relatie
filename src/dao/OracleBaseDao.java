package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleBaseDao {
    private static String dbUrl = "jdbc:oracle:thin:@//ondora04.hu.nl:8521/EDUC06";
    private static String user = "yash";
    private static String password = "yash";
    private static Connection conn;

    public OracleBaseDao() throws SQLException{
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public Connection getConnection() throws SQLException{
        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}

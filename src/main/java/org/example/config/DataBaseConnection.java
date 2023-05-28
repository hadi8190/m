package org.example.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection = null;
    private DataBaseConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DataBaseConfig.URL,
                    DataBaseConfig.USERNAME, DataBaseConfig.PASSWORD);
        }
        return connection;
    }
}

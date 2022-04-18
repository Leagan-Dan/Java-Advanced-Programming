package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private Connection connection;

    public Database() {
    }

    public void createConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            System.err.println(exception);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static Database getDBConnection() {
        Database dbConnection = new Database();
        return dbConnection;
    }

    public static void closeConnection() {
        /* TODO*/
    }
}
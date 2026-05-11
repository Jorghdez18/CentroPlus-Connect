package com.proyecto.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteConnectionManager {

    private static String jdbcUrl = "jdbc:sqlite:src/main/resources/data/sqlite/centroplus.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl);
    }

    public static void setJdbcUrl(String url) {
        jdbcUrl = url;
    }

    public static void setDatabasePath(String testDb) {
        jdbcUrl = "jdbc:sqlite:" + testDb;
    }
}
package com.library;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:sqlite:library.db";

    static {
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            st.executeUpdate("PRAGMA foreign_keys = ON;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, author TEXT, isbn TEXT UNIQUE, copies INTEGER NOT NULL DEFAULT 1);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS members (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, email TEXT UNIQUE);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS issues (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, member_id INTEGER, issue_date TEXT, return_date TEXT, returned INTEGER DEFAULT 0, FOREIGN KEY(book_id) REFERENCES books(id), FOREIGN KEY(member_id) REFERENCES members(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

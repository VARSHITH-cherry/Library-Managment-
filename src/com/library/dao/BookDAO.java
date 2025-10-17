package com.library.dao;

import com.library.DB;
import com.library.models.Book;

import java.sql.*;
import java.util.*;

public class BookDAO {
    public static void add(Book b) throws SQLException {
        String sql = "INSERT INTO books(title,author,isbn,copies) VALUES(?,?,?,?)";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getIsbn());
            ps.setInt(4, b.getCopies());
            ps.executeUpdate();
        }
    }

    public static List<Book> listAll() throws SQLException {
        List<Book> list = new ArrayList<>();
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM books"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getInt("copies")));
            }
        }
        return list;
    }
}

package com.library.ui;

import com.library.dao.BookDAO;
import com.library.models.Book;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LibraryUI extends JFrame {
    private JTable bookTable;
    private DefaultTableModel model;

    public LibraryUI() {
        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"ID", "Title", "Author", "ISBN", "Copies"}, 0);
        bookTable = new JTable(model);
        add(new JScrollPane(bookTable), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh Books");
        refresh.addActionListener(e -> loadBooks());
        add(refresh, BorderLayout.SOUTH);

        loadBooks();
    }

    private void loadBooks() {
        try {
            model.setRowCount(0);
            List<Book> books = BookDAO.listAll();
            for (Book b : books) {
                model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.getIsbn(), b.getCopies()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }
}

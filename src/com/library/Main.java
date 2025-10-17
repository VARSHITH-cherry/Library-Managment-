package com.library;

import com.library.ui.LibraryUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryUI().setVisible(true));
    }
}

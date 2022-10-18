package org.uem.dam.GestorProg;

/*
Runnable class
 */

import org.uem.dam.GestorProg.ui.control.MainController;
import org.uem.dam.GestorProg.ui.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            MainController mainController = new MainController(mainWindow);
        });
    }
}

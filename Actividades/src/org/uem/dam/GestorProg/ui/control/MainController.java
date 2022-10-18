package org.uem.dam.GestorProg.ui.control;

import org.uem.dam.GestorProg.ui.view.MainWindow;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    private MainWindow mainWindow;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        onStart();
    }

    private static final Map<String, String> availPrograms = Map.ofEntries(
            Map.entry("Writer", "org.libreoffice.LibreOffice --writer"),
            Map.entry("Impress", "org.libreoffice.LibreOffice --impress"),
            Map.entry("Calc", "org.libreoffice.LibreOffice --calc")
    );

    public void onStart() {
        for (String program: availPrograms.keySet()) {
            mainWindow.addNewProgram(program);
        }
    }
}

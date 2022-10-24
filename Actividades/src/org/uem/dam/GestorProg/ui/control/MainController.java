package org.uem.dam.GestorProg.ui.control;

import org.uem.dam.GestorProg.ui.view.MainWindow;

import java.util.Map;

public class MainController {

    private final MainWindow mainWindow;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        onStart();
    }

    private static final Map<String, String> availPrograms = Map.ofEntries(
            Map.entry("Writer", "/usr/bin/flatpak run org.libreoffice.LibreOffice --writer"),
            Map.entry("Impress", "/usr/bin/flatpak run org.libreoffice.LibreOffice --impress"),
            Map.entry("Calc", "/usr/bin/flatpak run org.libreoffice.LibreOffice --calc")
    );

    public void onStart() {
        for (Map.Entry<String, String> program: availPrograms.entrySet()) {
            mainWindow.addNewProgram(program);
        }
    }
}

package org.uem.dam.GestorProg.ui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel programTab;
    private JPanel navigatorTab;
    private JPanel mainPanel;
    private JTextField urlTxtField;
    private JList<String> historyList;
    private JButton searchBtn;
    private JPanel buttonsPanel;
    private JTextPane introduceUnaDireccionURLTextPane;

    // swing models
    private final DefaultListModel<String> historyListModel;

    public MainWindow() {
        historyListModel = new DefaultListModel();
        historyList.setModel(historyListModel);
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        prepareCallbacks();
    }

    public void addNewProgram(Map.Entry<String, String> program) {
        JButton progBtn = new JButton(program.getKey());
        buttonsPanel.add(progBtn);
        progBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Executing " + program);
                ProcessBuilder processBuilder = new ProcessBuilder(program.getValue().split(" "));
                try {
                    Process process = processBuilder.start();
                } catch (IOException e) {
                    System.err.println("Error de entrada y salida");
                }
            }
        });
    }

    private void prepareCallbacks() {
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String url = urlTxtField.getText();
                    // comprobar si la url contiene el protocolo
                    if (!url.startsWith("http://") || !url.startsWith("https://")) {
                        url = "http://" + url;
                    }
                    Desktop.getDesktop().browse(new URI(url));
                    historyListModel.addElement(urlTxtField.getText());
                } catch (IOException e) {
                    JOptionPane.showConfirmDialog(null, "Error de E/S");
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

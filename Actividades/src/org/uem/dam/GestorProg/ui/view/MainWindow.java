package org.uem.dam.GestorProg.ui.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel programTab;
    private JPanel navigatorTab;
    private JPanel mainPanel;
    private JTextField textField1;
    private JList historyList;
    private JButton searchBtn;

    public MainWindow() {
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addNewProgram(String program) {
        JButton progBtn = new JButton(program);
        programTab.add(progBtn);
//        progBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                ProgramRunner programRunner = new ProgramRunner(program);
//            }
//        });
    }
}

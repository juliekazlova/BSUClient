package com.juliairina.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileNameDialog extends JDialog {

    private final JPanel mainPanel;
    private final JLabel fileNameLabel;
    private final JTextField fileNameField;
    private final JButton acceptButton;
    private final JButton cancelButton;

    private final MainWindow owner;

    public FileNameDialog(MainWindow owner) {
        super(owner, true);
        this.owner = owner;

        mainPanel = new JPanel(new GridLayout(2, 2));
        fileNameLabel = new JLabel("File name ");
        fileNameField = new JTextField();
        acceptButton = new JButton("Accept");
        cancelButton = new JButton("Cancel");

        addComponents();
        addListeners();
        configureComponents();
        setWindowPreferences();
    }

    private void configureComponents() {
        fileNameLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void addListeners() {
        acceptButton.addActionListener(e -> {
            owner.setCurrentFileName(fileNameField.getText());
            FileNameDialog.this.dispose();
        });
        cancelButton.addActionListener(e -> FileNameDialog.this.dispose());
    }

    private void addComponents() {
        mainPanel.add(fileNameLabel);
        mainPanel.add(fileNameField);
        mainPanel.add(acceptButton);
        mainPanel.add(cancelButton);
    }

    private void setWindowPreferences() {
        setTitle("File name dialog");
//        setIconImage(ResourceLoader.getImage("icon/order-info.png"));
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(WindowConfig.getFileNameDialogScreenWidth()[0],
                WindowConfig.getFileNameDialogScreenHeight()[0]));
        setResizable(false);
        pack();
    }
}

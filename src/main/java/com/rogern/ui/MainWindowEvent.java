package com.rogern.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowEvent implements ActionListener {

    //Local variable gui for the given MainWindow
    MainWindow gui;

    //Constructor to set MainWindow to the argument
    public MainWindowEvent(MainWindow in) {
        gui = in;
    }

    //Switching between top 3 headers
    public void actionPerformed(ActionEvent event) {
        String buttonPressed = event.getActionCommand();

        if(buttonPressed.equals("Daily Schedule")) {
            gui.switchToSchedule();
        }
        if(buttonPressed.equals("Current Events")) {
            gui.switchToCurrent();
        }
    }
}

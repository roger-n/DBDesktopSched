package com.rogern.ui;

import java.awt.event.*;

public class NewClassPanelEvent implements ActionListener {

    NewClassPanel newClassPanel;

    public NewClassPanelEvent(NewClassPanel newClassPanel) {
        this.newClassPanel = newClassPanel;
    }

    public void actionPerformed(ActionEvent event) {

        String buttonPressed = event.getActionCommand();

        if (buttonPressed.equals("Cancel")) {
            newClassPanel.schedPanel.update();
        }

    }
}

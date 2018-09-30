package com.rogern.ui;

import java.awt.event.*;

public class SchedPanelEvent implements ActionListener {

    SchedPanel schedPanel;

    public SchedPanelEvent(SchedPanel schedPanel) {
        this.schedPanel = schedPanel;
    }

    public void actionPerformed(ActionEvent event) {

        String buttonPressed = event.getActionCommand();

        if (buttonPressed.equals("(+) Add Class")) {
            schedPanel.switchToNewClassPanel();
        }

    }

}

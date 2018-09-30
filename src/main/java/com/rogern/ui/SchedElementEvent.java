package com.rogern.ui;

import com.rogern.db.controller.DBController;
import org.h2.bnf.context.DbColumn;

import java.awt.event.*;

public class SchedElementEvent implements ActionListener {

    SchedPanel schedPanel;
    SchedElementPanel schedElementPanel;
    DBController controller;

    public SchedElementEvent(SchedPanel schedPanel, SchedElementPanel schedElementPanel) {
        this.schedPanel = schedPanel;
        this.schedElementPanel = schedElementPanel;
        this.controller = schedPanel.getController();
    }

    public void actionPerformed(ActionEvent event) {

        String buttonPressed = event.getActionCommand();

        if (buttonPressed.equals("Remove")) {
            schedPanel.deleteSchedElementPanel(schedElementPanel.getID());
        }

    }

}

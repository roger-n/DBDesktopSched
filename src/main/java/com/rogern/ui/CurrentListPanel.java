package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;

//TODO Make this class a separate thread that constantly checks if current event is different and updates it

public class CurrentListPanel extends JPanel {

    ScheduleEvent currentEvent;
    DBController controller;

    public CurrentListPanel(DBController controller) {
        this.controller = controller;
    }

    public int getCurrentClass() {
        return 0;
    }
}

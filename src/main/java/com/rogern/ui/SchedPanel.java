package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SchedPanel extends JPanel {

    List<?> scheduleEvents;
    JScrollPane thisSchedScrollPane;
    JPanel schedulePan;
    JButton addClass;
    List<SchedElementPanel> allSchedPanels;

    public SchedPanel(DBController controller){

        setLayout(new BorderLayout());

        thisSchedScrollPane = new JScrollPane();
        thisSchedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        thisSchedScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        schedulePan = new JPanel();
        schedulePan.setLayout(new BoxLayout(schedulePan, BoxLayout.Y_AXIS));

        addClass = new JButton("(+) Add Class");
        thisSchedScrollPane.add(addClass);

        scheduleEvents = controller.getScheduleEvents();
        for(int i = 0; i< scheduleEvents.size(); i++){
            schedulePan.add(new SchedElementPanel((ScheduleEvent) scheduleEvents.get(i)));
        }
        thisSchedScrollPane.getViewport().setView(schedulePan);

        add(thisSchedScrollPane, BorderLayout.CENTER);

        controller.listScheduleEvents();

    }

}

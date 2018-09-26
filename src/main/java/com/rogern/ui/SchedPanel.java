package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SchedPanel extends JPanel {

    List<ScheduleEvent> scheduleEvents;
    JScrollPane thisSchedScrollPane;
    JPanel schedulePan;
    JButton addClass;
    List<SchedElementPanel> allSchedPanels;

    public SchedPanel(String scheduleName, DBController controller){

        thisSchedScrollPane = new JScrollPane();
        schedulePan = new JPanel();
        schedulePan.setLayout(new BoxLayout(schedulePan, BoxLayout.Y_AXIS));

        addClass = new JButton("(+) Add Class");
        add(addClass);

        allSchedPanels = new ArrayList<>();
        for(int i = 0; i< scheduleEvents.size(); i++){
            schedulePan.add(new SchedElementPanel(scheduleEvents.get(i)));
        }
        thisSchedScrollPane.add(schedulePan);
        add(thisSchedScrollPane);
    }

}

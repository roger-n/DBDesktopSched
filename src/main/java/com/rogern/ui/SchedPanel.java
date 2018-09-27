package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SchedPanel extends JPanel {

    DBController controller;
    List<?> scheduleEvents;
    JScrollPane thisSchedScrollPane;
    JPanel buttonPanel;
    JPanel schedulePan;
    JButton addClass;
    List<SchedElementPanel> allSchedPanels;

    public SchedPanel(DBController controller){

        setLayout(new BorderLayout());
        this.controller = controller;

        setupSchedPanel();

        controller.listScheduleEvents();

    }

    public void setupSchedPanel() {
        thisSchedScrollPane = new JScrollPane();
        thisSchedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        thisSchedScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        schedulePan = new JPanel();
        schedulePan.setLayout(new BoxLayout(schedulePan, BoxLayout.Y_AXIS));

        addClass = new JButton("(+) Add Class");
        addClass.setFont(new Font("Trebuchet MS",Font.PLAIN,16));

        scheduleEvents = controller.getScheduleEvents();
        for(int i = 0; i< scheduleEvents.size(); i++){
            schedulePan.add(new SchedElementPanel((ScheduleEvent) scheduleEvents.get(i)));
        }

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(addClass, BorderLayout.CENTER);

        schedulePan.add(buttonPanel);

        thisSchedScrollPane.getViewport().setView(schedulePan);

        add(thisSchedScrollPane, BorderLayout.CENTER);
    }

    //TODO write these methods and implement them with SchedPanelEvent and SchedElementPanel
    public void addSchedElementPanel(SchedElementPanel schedElementPanel) {

    }

    public void deleteSchedElementPanel(int id) {

    }

}

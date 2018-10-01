package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SchedPanel extends JPanel {

    DBController controller;
    List<?> scheduleEvents;
    JScrollPane thisSchedScrollPane;
    JPanel buttonPanel;
    JPanel schedulePan;
    JButton addClass;

    public SchedPanel(DBController controller){

        setLayout(new BorderLayout());
        this.controller = controller;

        setupSchedPanel();

        controller.listScheduleEvents();

    }

    public void setupSchedPanel() {

        //SETUP LISTENERS
        SchedPanelEvent schedListener = new SchedPanelEvent(this);

        //SETUP JSCROLLPANE
        thisSchedScrollPane = new JScrollPane();
        thisSchedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        thisSchedScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //BASE PANEL TO PUT IN JSCROLLPANE
        schedulePan = new JPanel();
        schedulePan.setLayout(new BoxLayout(schedulePan, BoxLayout.Y_AXIS));

        //ADDCLASS BUTTON SETUP
        addClass = new JButton("(+) Add Class");
        //ADD LISTENER TO BUTTON
        addClass.addActionListener(schedListener);
        addClass.setFont(new Font("Trebuchet MS",Font.PLAIN,16));
        addClass.setBackground(Color.BLUE);
        addClass.setOpaque(true);

        //ADD ALL EVENTS TO JPANEL AFTER ORDERING THEM
        scheduleEvents = orderSdcheduleEvents(controller.getScheduleEvents());
        for(int i = 0; i< scheduleEvents.size(); i++){
            schedulePan.add(new SchedElementPanel((ScheduleEvent) scheduleEvents.get(i), this));
        }

        //ADD BUTTON TO JPANEL
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(addClass, BorderLayout.CENTER);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        //ADD BOTH JPANELS TO JSCROLLPANE
        schedulePan.add(buttonPanel);

        thisSchedScrollPane.getViewport().setView(schedulePan);

        add(thisSchedScrollPane, BorderLayout.CENTER);
    }

    //SORT EVENTS BY START TIME USING INSERTION SORT
    public List<?> orderSdcheduleEvents(List<?> scheduleEvents) {
        ArrayList<ScheduleEvent> sortedEvents = new ArrayList<ScheduleEvent>();
        if (scheduleEvents.size() <= 1) {
            return scheduleEvents;
        }
        sortedEvents.add((ScheduleEvent) scheduleEvents.get(0));
        for(int i = 1; i < scheduleEvents.size(); i++) {
            for (int j = 0; j <= sortedEvents.size(); j++) {
                if (j == sortedEvents.size()) {
                    sortedEvents.add((ScheduleEvent) scheduleEvents.get(i));
                    break;
                } else if (!((ScheduleEvent) scheduleEvents.get(i)).getClassStartTime().isAfter(sortedEvents.get(j).getClassStartTime())) {
                    sortedEvents.add(j, (ScheduleEvent) scheduleEvents.get(i));
                    break;
                }
            }
        }
//        return sortedEvents;
        return sortedEvents;
    }

    public SchedPanel update() {
        //START BY CLEARING PANEL
        removeAll();
        setupSchedPanel();
        MainWindow.refreshComponent(this);
        return this;
    }

    //SWITCH TO NEW CLASS PANEL
    public void switchToNewClassPanel() {
        this.removeAll();
        NewClassPanel newClassPanel = new NewClassPanel(this);
        this.add(newClassPanel);
        MainWindow.refreshComponent(this);
    }

    //DELETE SCHEDELEMENTPANEL
    public void deleteSchedElementPanel(int id) {
        controller.deleteScheduleEvent(id);
        this.update();
    }

    //GET DB CONTROLLER
    public DBController getController() {
        return controller;
    }



}

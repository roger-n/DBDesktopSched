package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import java.awt.event.*;

public class NewClassPanelEvent implements ActionListener {

    SchedPanel schedPanel;
    NewClassPanel newClassPanel;

    public NewClassPanelEvent(NewClassPanel newClassPanel) {
        this.newClassPanel = newClassPanel;
        this.schedPanel = newClassPanel.schedPanel;
    }

    public void actionPerformed(ActionEvent event) {

        String buttonPressed = event.getActionCommand();

        if (buttonPressed.equals("Cancel")) {
            newClassPanel.schedPanel.update();
        } else if (buttonPressed.equals("Confirm")) {
            //Nested if to check in this specific order
            if (newClassPanel.verifyClassName()) {
                if (newClassPanel.verifyClassTime()) {
                    if (newClassPanel.verifyClassDays()) {
                        if (newClassPanel.verifyClassInstructor()) {
                            if (newClassPanel.verifyClassRoom()) {
                                //New ScheduleEvent if everything is verified
                                ScheduleEvent newScheduleEvent = new ScheduleEvent(newClassPanel.getClassName(),
                                        newClassPanel.getClassStartTime(),
                                        newClassPanel.getClassEndTime(),
                                        newClassPanel.getClassDays(),
                                        newClassPanel.getClassInstructor(),
                                        newClassPanel.getClassRoom(),
                                        newClassPanel.getClassLecture());

                                //Add ScheduledEvent to DB
                                schedPanel.controller.saveScheduleEvent(newScheduleEvent);

                                //Update SchedPanel
                                schedPanel.update();
                            }
                        }
                    }
                }
            }
        }
    }
}

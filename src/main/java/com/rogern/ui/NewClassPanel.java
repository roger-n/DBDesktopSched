package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NewClassPanel extends JPanel {

    //Initialize components for labels and user input
    JPanel[] newClassPanels;

    JLabel enterInfo;
    JTextField nameField;
    JTextField startTimeField;
    JTextField endTimeField;
    JTextField classRoomField;
    JTextField classInstructorField;
    JComboBox lectureComboBox;
    JCheckBox[] daysCheckBoxes;

    JLabel errorLabel;
    JPanel buttonsPanel;
    JButton confirmButton;
    JButton cancelButton;

    //Some padding components
    final Component titleVerticalPadding = Box.createRigidArea(new Dimension(20,1));
    final Component intermediateVerticalPadding = Box.createRigidArea(new Dimension(10,1));
    final Component lowerVerticalPadding = Box.createRigidArea(new Dimension(20,1));
    final Component buttonHorizontalPadding = Box.createRigidArea(new Dimension(1,10));

    public NewClassPanel() {

        setupNewClassPanel();

    }

    public void setupNewClassPanel() {

        newClassPanels = new JPanel[10];
        for (int i = 0; i < 10l; i++) {
            newClassPanels[i] = new JPanel();
        }

        enterInfo = new JLabel("Please Enter Class Information:");
        enterInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
            newClassPanels[0].add(enterInfo);
        nameField = new JTextField("Department ####" ,10);
            newClassPanels[1].add(nameField);
        startTimeField = new JTextField("Start Time",10);
            newClassPanels[2].add(startTimeField);
        endTimeField = new JTextField("End Time",10);
            newClassPanels[3].add(endTimeField);
        classRoomField = new JTextField("ClassRoom ###", 15);
            newClassPanels[4].add(classRoomField);
        classInstructorField = new JTextField("Prof / TA Name", 15);
            newClassPanels[5].add(classInstructorField);
        lectureComboBox = new JComboBox();
        lectureComboBox.addItem("Lecture");
        lectureComboBox.addItem("Recitation");
            newClassPanels[6].add(lectureComboBox);
        //TODO add lab option to UI and DB

        newClassPanels[7].setLayout(new GridLayout(1,5));
        daysCheckBoxes = new JCheckBox[5];
            daysCheckBoxes[0] = new JCheckBox("Monday");
            daysCheckBoxes[1] = new JCheckBox("Tuesday");
            daysCheckBoxes[2] = new JCheckBox("Wednesday");
            daysCheckBoxes[3] = new JCheckBox("Thursday");
            daysCheckBoxes[4] = new JCheckBox("Friday");
        for (int i = 0; i < 5; i++) {
            newClassPanels[7].add(daysCheckBoxes[i]);
        }

        errorLabel = new JLabel();
            newClassPanels[8].add(errorLabel);
        buttonsPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(cancelButton);
            newClassPanels[9].add(buttonsPanel);

        //Setup layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++) {
            add(newClassPanels[i]);
        }

//        //Adding components
//            add(titleVerticalPadding);
//        add(enterInfo);
//            add(titleVerticalPadding);
//        add(nameField);
//            add(titleVerticalPadding);
//        add(startTimeField);
//            add(intermediateVerticalPadding);
//        add(endTimeField);
//            add(intermediateVerticalPadding);
//        add(classRoomField);
//            add(intermediateVerticalPadding);
//        add(classInstructorField);
//            add(intermediateVerticalPadding);
//        add(lectureComboBox);
//            add(lowerVerticalPadding);
//        //TODO ADD checkboxes, panel for checkboxes, fix spacing
//        add(buttonsPanel);
    }



}

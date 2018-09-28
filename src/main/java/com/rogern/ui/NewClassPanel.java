package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NewClassPanel extends JPanel {

    //Initialize components for labels and user input
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
    final Component titleVerticalPadding = Box.createRigidArea(new Dimension(10,0));
    final Component intermediateVerticalPadding = Box.createRigidArea(new Dimension(5,0));
    final Component lowerVerticalPadding = Box.createRigidArea(new Dimension(10,0));
    final Component buttonHorizontalPadding = Box.createRigidArea(new Dimension(0,10));

    public NewClassPanel() {

        setupNewClassPanel();

    }

    public void setupNewClassPanel() {
        enterInfo = new JLabel("Please Enter Class Information:");
        enterInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        nameField = new JTextField("Department ####" ,10);
        startTimeField = new JTextField("Start Time",10);
        endTimeField = new JTextField("End Time",10);
        classRoomField = new JTextField("ClassRoom ###", 15);
        classInstructorField = new JTextField("Prof / TA Name", 15);
        lectureComboBox = new JComboBox();
        lectureComboBox.addItem("Lecture");
        lectureComboBox.addItem("Recitation");
        //TODO add lab option to UI and DB
        daysCheckBoxes = new JCheckBox[5];
            daysCheckBoxes[0] = new JCheckBox("Monday");
            daysCheckBoxes[1] = new JCheckBox("Tuesday");
            daysCheckBoxes[2] = new JCheckBox("Wednesday");
            daysCheckBoxes[3] = new JCheckBox("Thursday");
            daysCheckBoxes[4] = new JCheckBox("Friday");
        errorLabel = new JLabel();
        buttonsPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(cancelButton);

        //Setup layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Adding components
            add(titleVerticalPadding);
        add(enterInfo);
            add(titleVerticalPadding);
        add(nameField);
            add(titleVerticalPadding);
        add(startTimeField);
            add(intermediateVerticalPadding);
        add(endTimeField);
            add(intermediateVerticalPadding);
        add(classRoomField);
            add(intermediateVerticalPadding);
        add(classInstructorField);
            add(intermediateVerticalPadding);
        add(lectureComboBox);
            add(lowerVerticalPadding);
        //TODO ADD checkboxes, panel for checkboxes, fix spacing
        add(buttonsPanel);
    }



}

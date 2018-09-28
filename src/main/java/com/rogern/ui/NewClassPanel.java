package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import javax.swing.border.Border;
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

    Font componentFont;

    //Some padding components
    final Component buttonHorizontalPadding = Box.createRigidArea(new Dimension(1,10));

    public NewClassPanel() {

        //Setup NewClassPanel
        setupNewClassPanel();

    }

    public void setupNewClassPanel() {

        //Initialize array of panels
        newClassPanels = new JPanel[10];
        for (int i = 0; i < 10l; i++) {
            newClassPanels[i] = new JPanel();
        }

        //Font to use for components
        componentFont = new Font("Trebuchet MS", Font.PLAIN, 14);

        //Add all details for all components
        enterInfo = new JLabel("Please Enter Class Information:");
        enterInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
            newClassPanels[0].add(enterInfo);
        nameField = new JTextField("Department ####" ,10);
            nameField.setFont(componentFont);
            newClassPanels[1].add(nameField);
        startTimeField = new JTextField("Start Time",10);
            startTimeField.setFont(componentFont);
            newClassPanels[2].add(startTimeField);
        endTimeField = new JTextField("End Time",10);
            endTimeField.setFont(componentFont);
            newClassPanels[3].add(endTimeField);
        classRoomField = new JTextField("ClassRoom ###", 15);
            classRoomField.setFont(componentFont);
            newClassPanels[4].add(classRoomField);
        classInstructorField = new JTextField("Prof / TA Name", 15);
            classInstructorField.setFont(componentFont);
            newClassPanels[5].add(classInstructorField);
        lectureComboBox = new JComboBox();
        lectureComboBox.addItem("Lecture");
        lectureComboBox.addItem("Recitation");
            lectureComboBox.setFont(componentFont);
            newClassPanels[6].add(lectureComboBox);

        newClassPanels[7].setLayout(new BoxLayout(newClassPanels[7], BoxLayout.X_AXIS));
        daysCheckBoxes = new JCheckBox[5];
            daysCheckBoxes[0] = new JCheckBox("Monday");
            daysCheckBoxes[1] = new JCheckBox("Tuesday");
            daysCheckBoxes[2] = new JCheckBox("Wednesday");
            daysCheckBoxes[3] = new JCheckBox("Thursday");
            daysCheckBoxes[4] = new JCheckBox("Friday");
        for (int i = 0; i < 5; i++) {
            daysCheckBoxes[i].setFont(new Font("Trebuchet", Font.PLAIN, 13));
            newClassPanels[7].add(daysCheckBoxes[i]);
        }

        //Add all components to panel array
        errorLabel = new JLabel();
            errorLabel.setFont(componentFont);
            newClassPanels[8].add(errorLabel);
        buttonsPanel = new JPanel();
        confirmButton = new JButton("Confirm");
            confirmButton.setFont(componentFont);
        cancelButton = new JButton("Cancel");
            cancelButton.setFont(componentFont);
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(buttonHorizontalPadding);
        buttonsPanel.add(cancelButton);
            newClassPanels[9].add(buttonsPanel);

        //Setup layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Add all panels
        for (int i = 0; i < 10; i++) {
            add(newClassPanels[i]);
        }

    }

}

package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Area;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NewClassPanel extends JPanel {

    //Parent SchedPanel
    SchedPanel schedPanel;

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

    public NewClassPanel(SchedPanel schedPanel) {

        this.schedPanel =schedPanel;
        //Setup NewClassPanel
        setupNewClassPanel();

    }

    public void setupNewClassPanel() {

        //Create NewClassPanelEvent
        NewClassPanelEvent newClassPanelEvent = new NewClassPanelEvent(this);

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
            //Add listener to confirmButton
            confirmButton.addActionListener(newClassPanelEvent);
        cancelButton = new JButton("Cancel");
            cancelButton.setFont(componentFont);
            //Add listener to cancelButton
            cancelButton.addActionListener(newClassPanelEvent);
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

    //Getting values from NewClassPanel---------------------------------------

    public void setErrorLabelText(String errorLabelText) {
        this.errorLabel.setText("Error: " + errorLabelText);
    }

    public String getClassName() {
        return nameField.getText();
    }

    public LocalTime getClassStartTime() {
        return LocalTime.parse(startTimeField.getText());
    }

    public LocalTime getClassEndTime() {
        return LocalTime.parse(endTimeField.getText());
    }

    public String getClassDays() {
        String days = "";
        if (daysCheckBoxes[0].isSelected()) {
            days += "M";
        }
        if (daysCheckBoxes[1].isSelected()) {
            days += "T";
        }
        if (daysCheckBoxes[2].isSelected()) {
            days += "W";
        }
        if (daysCheckBoxes[3].isSelected()) {
            days += "R";
        }
        if (daysCheckBoxes[4].isSelected()) {
            days += "F";
        }
        return days;
    }

    public String getClassInstructor() {
        return classInstructorField.getText();
    }

    public String getClassRoom() {
        return classRoomField.getText();
    }

    public boolean getClassLecture() {
        return lectureComboBox.getSelectedItem().toString().equals("Lecture");
    }

    //Checking validity of NewClassPanel arguments---------------------------------

    public boolean verifyClassName() {
        if (nameField.getText().equals("") || nameField.getText().equals(null)) {
            setErrorLabelText("Please enter a class name");
            MainWindow.refreshComponent(errorLabel);
            return false;
        }
        return true;
    }

    public boolean verifyClassTime() {
        //String array of both times
        String timeTexts[] = {startTimeField.getText(), endTimeField.getText()};
        String incorrectTimeFormat = "Please enter both times in HH:MM format";
        String invalidTime = "Please enter valid times from 00:00 to 23:59";

        //Test all for both times
        for (int i = 0; i < timeTexts.length; i++) {
            //Verify not empty
            if (timeTexts[i].equals("")) {
                setErrorLabelText(incorrectTimeFormat);
                MainWindow.refreshComponent(errorLabel);
                return false;
            }
            //Verify correct length and colon placement
            if (timeTexts[i].length() != 5 || timeTexts[i].charAt(2) != ':') {
                setErrorLabelText(incorrectTimeFormat);
                MainWindow.refreshComponent(errorLabel);
                return false;
            }
            //Verify all numeric
            if (!Character.isDigit(timeTexts[i].charAt(0)) ||
                    !Character.isDigit(timeTexts[i].charAt(1)) ||
                    !Character.isDigit(timeTexts[i].charAt(3)) ||
                    !Character.isDigit(timeTexts[i].charAt(4))) {
                setErrorLabelText(incorrectTimeFormat);
                MainWindow.refreshComponent(errorLabel);
                return false;
            }
            //Verify correct number ranges
            if (Integer.parseInt(timeTexts[i].substring(0, 2)) < 0 ||
                    Integer.parseInt(timeTexts[i].substring(0, 2)) > 23 ||
                    Integer.parseInt(timeTexts[i].substring(3, 5)) < 0 ||
                    Integer.parseInt(timeTexts[i].substring(3, 5)) > 59) {
                setErrorLabelText(invalidTime);
                MainWindow.refreshComponent(errorLabel);
                return false;
            }

            //Verify endTime is after startTime
            if (getClassEndTime().isBefore(getClassStartTime())) {
                setErrorLabelText("Please ensure end time is after start time");
                MainWindow.refreshComponent(errorLabel);
                return false;
            }
        }
        //Valid time if both times pass all tests
        return true;
    }

    public boolean verifyClassDays() {
        //Cycle through, if any box is checked, it's valid
        for (int i = 0; i < 5; i++) {
            if (daysCheckBoxes[i].isSelected()) {
                return true;
            }
        }
        //No checked boxes, invalid
        setErrorLabelText("Please select at least one day");
        MainWindow.refreshComponent(errorLabel);
        return false;
    }

    public boolean verifyClassInstructor() {
        //Verify not empty
        if (classInstructorField.getText().equals("")) {
            setErrorLabelText("Please enter an instructor name");
            MainWindow.refreshComponent(errorLabel);
            return false;
        }
        return true;
    }

    public boolean verifyClassRoom() {
        //Verify not empty
        if (classRoomField.getText().equals("")) {
            setErrorLabelText("Please enter a class room");
            MainWindow.refreshComponent(errorLabel);
            return false;
        }
        return true;
    }
}

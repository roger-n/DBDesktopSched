package com.rogern.ui;

import com.rogern.db.model.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SchedElementPanel extends JPanel{

    //SCHEDPANEL UNDERNEATH
    SchedPanel schedPanel;

    //Declare list of ScheduleEvents
    ScheduleEvent scheduleEvent;

    //Declare UI components
    JLabel classNameLabel;
    JLabel timeLabel;
    JLabel instructorLabel;
    JLabel roomLabel;
    JLabel lectureOrDiscLabel;
    JLabel daysLabel;

    JButton removeButton;

    JLabel emptyLabel;

    //See GUI.png for details
    //NOTE: GridLayout adds Left>Right, Top>Bottom s

    JPanel panel0;
        //For className label
        JPanel panel0A;
        //For classTime label
        JPanel panel0B;
    JPanel panel1;
        //For classRoom label
        JPanel panel1A;
        //For classInstructor label
        JPanel panel1B;
    JPanel panel2;
        //For classLecture label
        JPanel panel2A;
        //For classDays label
        JPanel panel2B;
    //For removeButton button
    JPanel panel3;

    //Fonts for JLabels
    Font headFont = new Font("Trebuchet MS", Font.PLAIN, 20);
    Font bodyFont = new Font("Trebuchet MS", Font.PLAIN, 14);

    //Declare ScheduleEvent variables
    String className;
    LocalTime classStartTime;
    LocalTime classEndTime;
    String classDays;
    String classInstructor;
    String classRoom;

    boolean classLecture;

    public SchedElementPanel(ScheduleEvent e, SchedPanel schedPanel){

        scheduleEvent = e;
        this.schedPanel = schedPanel;

        setupSchedElementPanel();

    }

    public void setupSchedElementPanel() {

        //SETUP LISTENERS
        SchedElementEvent schedElementEvent = new SchedElementEvent(schedPanel,this);

        //Set all variables
        className = scheduleEvent.getClassName();
        classStartTime = scheduleEvent.getClassStartTime();
        classEndTime = scheduleEvent.getClassEndTime();
        classDays = scheduleEvent.getClassDays();
        classInstructor = scheduleEvent.getClassInstructor();
        classRoom = scheduleEvent.getClassRoom();
        classLecture = scheduleEvent.getClassLecture();

        //Set max size of panel
        setMaximumSize(new Dimension(420,120));

        //Set border using BorderFactory
        setBorder(BorderFactory.createLoweredBevelBorder());

        //Create and set fonts for JLabels
        classNameLabel = new JLabel(className);
        classNameLabel.setFont(headFont);

        timeLabel = new JLabel("" + classStartTime.truncatedTo(ChronoUnit.MINUTES) + " - " + classEndTime.truncatedTo(ChronoUnit.MINUTES));
        timeLabel.setFont(bodyFont);

        instructorLabel = new JLabel(classInstructor);
        instructorLabel.setFont(bodyFont);

        roomLabel = new JLabel(classRoom);
        roomLabel.setFont(bodyFont);

        lectureOrDiscLabel = new JLabel((classLecture)? "Lecture" : "Recitation");
        lectureOrDiscLabel.setFont(bodyFont);

        daysLabel = new JLabel(classDays);
        daysLabel.setFont(bodyFont);

        removeButton = new JButton("Remove");
        //ADD LISTENER TO REMOVEBUTTON
        removeButton.addActionListener(schedElementEvent);
        removeButton.setFont(bodyFont);
        removeButton.setBackground(Color.WHITE);

        emptyLabel = new JLabel("");


        //Setting up nested JPanels with GridLayouts, adding components and adding panels

        setLayout(new GridLayout(0,2,0,0));

        panel0 = new JPanel();
        panel0.setLayout(new GridLayout(2, 1));
        panel0A = new JPanel();
        panel0A.add(classNameLabel);
        panel0.add(panel0A);
        panel0B = new JPanel();
        panel0B.add(timeLabel);
        panel0.add(panel0B);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1,20,0));
        panel1A = new JPanel();
        panel1A.add(lectureOrDiscLabel);
        panel1.add(panel1A);
        panel1B = new JPanel();
        panel1B.add(daysLabel);
        panel1.add(panel1B);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1,0,0));
        panel2A = new JPanel();
        panel2A.add(roomLabel);
        panel2.add(panel2A);
        panel2B = new JPanel();
        panel2B.add(instructorLabel);
        panel2.add(panel2B);

        panel3 = new JPanel();
        panel3.add(removeButton);

        add(panel0);
        add(panel1);
        add(panel2);
        add(panel3);
    }

    public int getID() {
        return scheduleEvent.getClassID();
    }

}

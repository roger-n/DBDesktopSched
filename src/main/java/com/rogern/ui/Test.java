package com.rogern.ui;

import com.rogern.db.controller.DBController;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    //DECLARING ALL MAIN CONTAINER ELEMENTS
    JPanel header;
    JLabel desktopSchedLabel;
    JPanel headerButtonsPanel;
    Font headerButtonsFont;
    JButton scheduleButton;
    JButton currentButton;
    JPanel top_level_panel;

    SchedPanel schedPanel;

    //DECLARING DBCONTROLLER

    DBController controller;

    public Test(){

        super("DesktopScheduler");
        setupMainWindowProperties();

    }

    //SETTING UP PRIMARY CONTAINER
    private void setupMainWindowProperties(){

        //Main layout stuff
        setSize(420,600);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());

        //Adding MainWindowEvent

        //Making instance of DBController
        controller = new DBController();

        schedPanel = new SchedPanel(controller);

        //Format:
        //Make panel
        //Set panel layout to (new ___Layout())
        //Make new component/container
        //Define component properties
        //Add Listener
        //Add component
        //Add panel

        header = new JPanel();
        header.setLayout(new GridLayout(2, 1, 0, 0));

        desktopSchedLabel = new JLabel("Desktop Schedule 0.1.0", JLabel.CENTER);
        desktopSchedLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
        header.add(desktopSchedLabel);

        headerButtonsPanel = new JPanel();
        headerButtonsPanel.setLayout(new GridLayout(1, 2, 0, 0));

        headerButtonsFont = new Font("Trebuchet MS", Font.PLAIN, 14);

        scheduleButton = new JButton("Daily Schedule");
        scheduleButton.setFont(headerButtonsFont);
        headerButtonsPanel.add(scheduleButton);
        currentButton = new JButton("Current Events");
        currentButton.setFont(headerButtonsFont);
        headerButtonsPanel.add(currentButton);
        header.add(headerButtonsPanel);
        add(header, BorderLayout.NORTH);

        top_level_panel = new JPanel();
        top_level_panel.setLayout(new GridLayout(1,1));
        add(top_level_panel);
        //Set default view to mySchedules
        //switchToSchedule();
        switchToNewClassPanel();
        refreshComponent(this);

        setVisible(true);
    }
    //--------------------------------

    //ALTERNATING BETWEEN DIFFERENT ACTIVITIES

    public void switchToNewClassPanel(){
        top_level_panel.add(new NewClassPanel(schedPanel));
        refreshComponent(top_level_panel);
    }

    //----------------------------------------

    //UPDATE ANY CONTAINER
    public static void refreshComponent(Container container){
        container.revalidate();
        container.repaint();
    }
    //--------------------

    //New MainWindow
    public static void main(String[] args) {
        new Test();
    }
    //--------------
}



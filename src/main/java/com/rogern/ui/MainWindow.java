package com.rogern.ui;

import com.rogern.db.controller.DBController;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

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

    public MainWindow(){

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
        MainWindowEvent mainListener = new MainWindowEvent(this);

        //Making instance of DBController
        controller = new DBController();

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
                    scheduleButton.addActionListener(mainListener);
                    headerButtonsPanel.add(scheduleButton);
                currentButton = new JButton("Current Events");
                    currentButton.setFont(headerButtonsFont);
                    currentButton.addActionListener(mainListener);
                    headerButtonsPanel.add(currentButton);
                header.add(headerButtonsPanel);
            add(header, BorderLayout.NORTH);

        //Main activity panel
        top_level_panel = new JPanel();
            top_level_panel.setLayout(new GridLayout(1,1));
            add(top_level_panel);

            //Set default view to mySchedules
            schedPanel = new SchedPanel(controller);
            switchToSchedule();
            //switchTo(top_level_panel, schedPanel);

        setVisible(true);
    }
    //--------------------------------

    //ALTERNATING BETWEEN DIFFERENT ACTIVITIES
    /*
    public void switchTo(JPanel backPanel, JPanel topPanel) {
        //CLEAR BOTTOMPANEL AND UPDATE WITH TOPPANEL,
        backPanel.removeAll();
        refreshComponent(backPanel);

        //TRY TO CAST TO SCHEDPANEL OR CURRENTPANEL
        try{
            SchedPanel topPanelCast = (SchedPanel) topPanel;
            topPanelCast.update();
        } catch (Exception e) {
            try {
                CurrentPanel topPanelCast = (CurrentPanel) topPanel;
                //topPanelCast.update();
            } catch (Exception e2) {
                throw new RuntimeException("Incorrect Usage.  Use: switchto(jpanel, schedpanel/currentpanel)");
            }
        }

        backPanel.add(topPanel);
        refreshComponent(backPanel);
    }
    */

    //CURRENT METHOD OF ALTERNATING BETWEEN DIFFERENT ACTIVITIES
    public void switchToSchedule(){
        //CLEAR TOP_LEVEL_PANEL AND UPDATE WITH SCHEDPANEL,
        top_level_panel.removeAll();
        schedPanel.update();
        top_level_panel.add(schedPanel.update());
        refreshComponent(top_level_panel);
    }

    public void switchToCurrent(){
        top_level_panel.removeAll();
        //TOD0: make new currentPanel and set it up
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
        new MainWindow();
    }
    //--------------
}



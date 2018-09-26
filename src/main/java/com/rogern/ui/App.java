package com.rogern.ui;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.ScheduleEvent;

import java.time.LocalTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DBController controller = new DBController();

        /*Save a new ScheduleEvent*/
        ScheduleEvent scheduleEvent = new ScheduleEvent("Class1",
                LocalTime.parse("06:00"),
                LocalTime.parse("06:50"),
                "MWF",
                "ShitProf",
                "Room 1",
                true);
        controller.saveScheduleEvent(scheduleEvent);

        /*Gets all ScheduleEvents*/
        controller.listScheduleEvents();

        System.out.println();
        /*Updates ScheduleEvent*/
//        ScheduleEvent updated = new ScheduleEvent(------------);
//        controller.updateScheduleEvent(1, updated);

        /*Deletes ScheduleEvent(s) from DB*/
//        controller.deleteScheduleEvent(2, 34,35, 67);
//        controller.commit();

        /*findScheduleEventWithClassName example*/
        List<?> results = controller.findScheduleEventWithName("Class1");
        results.forEach(System.out::println);

        System.out.println();
        controller.listScheduleEvents();
//        ScheduleEvent scheduleEvent = session.find(ScheduleEvent.class, 1);
//        System.out.println(scheduleEvent);

        controller.close();
    }
}

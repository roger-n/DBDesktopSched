package com.rogern.db;

import com.rogern.db.controller.DBController;
import com.rogern.db.model.Employee;
import com.rogern.db.model.ScheduleEvent;

import java.time.LocalTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DBController controller = new DBController();

        /*Save a new Employee*/
        ScheduleEvent scheduleEvent = new ScheduleEvent("Class1",
                LocalTime.parse("06:00"),
                LocalTime.parse("06:50"),
                "MWF",
                "ShitProf",
                "Room 1",
                true);
        controller.saveScheduleEvent(scheduleEvent);

        /*Gets all Employees*/
        controller.listScheduleEvents();

        System.out.println();
        /*Updates Employee*/
//        Employee updated = new Employee("Roger", "Nhan", 42069);
//        controller.updateEmployee(1, updated);

        /*Deletes Employee/Employees from DB*/
//        controller.deleteEmployees(2, 34,35, 67);
//        controller.commit();

        /*findEmployeeWithFirstName example*/
        List<?> results = controller.findClassWithName("Class1");
        results.forEach(System.out::println);

        System.out.println();
        controller.listScheduleEvents();
//        Employee employee = session.find(Employee.class, 1);
//        System.out.println(employee);

        controller.close();
    }
}

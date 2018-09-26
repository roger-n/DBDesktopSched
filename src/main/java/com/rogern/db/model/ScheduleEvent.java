package com.rogern.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalTime;

@Entity
public class ScheduleEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classID;
    private String className;
    private LocalTime classStartTime;
    private LocalTime classEndTime;
    private String classDays;
    private String classInstructor;
    private String classRoom;
    private boolean classLecture;

    public ScheduleEvent() {
    }

    public ScheduleEvent(String className,
                         LocalTime classStartTime,
                         LocalTime classEndTime,
                         String classDays,
                         String classInstructor,
                         String classRoom,
                         boolean classLecture) {
        this.className = className;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classDays = classDays;
        this.classInstructor = classInstructor;
        this.classRoom = classRoom;
        this.classLecture = classLecture;
    }

    public int getClassID(){
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalTime getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(LocalTime classStartTime) {
        this.classStartTime = classStartTime;
    }

    public LocalTime getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(LocalTime classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassDays() {
        return classDays;
    }

    public void setClassDays(String classDays) {
        this.classDays = classDays;
    }

    public String getClassInstructor() {
        return classInstructor;
    }

    public void setClassInstructor(String classInstructor) {
        this.classInstructor = classInstructor;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public boolean getClassLecture() {
        return classLecture;
    }

    public void setClassLecture(boolean classLecture) {
        this.classLecture = classLecture;
    }

    @Override
    public String toString() {
        return "classID: " + classID +
                " className: " + className +
                " classStartTime: " + classStartTime.toString() +
                " classEndTime: " + classEndTime.toString() +
                " classDays: " + classDays +
                " classInstructor: " + classInstructor +
                " classRoom: " + classRoom +
                " lecture; " + classLecture;
    }
}

/**
 String className,
 LocalTime classStartTime,
 LocalTime classEndTime,
 String classDays,
 String classInstructor,
 String classRoom,
 boolean classLecture
 **/
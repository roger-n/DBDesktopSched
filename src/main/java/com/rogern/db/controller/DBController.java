package com.rogern.db.controller;

import com.rogern.db.util.HibernateUtil;
import com.rogern.db.model.ScheduleEvent;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

public class DBController {
    private Session session;

    public DBController() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public ScheduleEvent getScheduleEvent(int id) {
        return session.find(ScheduleEvent.class, id);
    }

    public void listScheduleEvents() {
        List<?> scheduleEvents = session.createQuery("FROM ScheduleEvent").getResultList();
        scheduleEvents.forEach(l -> System.out.println(l.toString()));
    }

    public List<?> getScheduleEvents(){
        return session.createQuery("FROM ScheduleEvent").getResultList();
    }

    public List findScheduleEventWithName(String className) {
        return session.createQuery("FROM ScheduleEvent WHERE className = '" + className + "'").getResultList();
    }

    public void updateScheduleEvent(Integer id, ScheduleEvent scheduleEvent) {
        ScheduleEvent e = session.find(ScheduleEvent.class, id);
        e.setClassName(scheduleEvent.getClassName());
        e.setClassStartTime(scheduleEvent.getClassStartTime());
        e.setClassEndTime(scheduleEvent.getClassEndTime());
        e.setClassDays(scheduleEvent.getClassDays());
        e.setClassRoom(scheduleEvent.getClassRoom());
        e.setClassLecture(scheduleEvent.getClassLecture());
        session.update(e);
        commit();
    }

    public void deleteScheduleEvent(Integer id) {
        ScheduleEvent e = session.find(ScheduleEvent.class, id);
        session.delete(e);
        commit();
    }

    public void deleteScheduleEvents(Integer... ids) {
        Arrays.asList(ids).forEach(this::deleteScheduleEvent);
    }

    public void saveScheduleEvent(ScheduleEvent scheduleEvent){
        session.save(scheduleEvent);
        commit();
    }

    public void saveScheduleEvents(ScheduleEvent... scheduleEvents){
        Arrays.asList(scheduleEvents).forEach(this::saveScheduleEvent);
    }

    private void commit() {
        session.getTransaction().commit();
    }

    public void close(){
        session.getSessionFactory().close();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}

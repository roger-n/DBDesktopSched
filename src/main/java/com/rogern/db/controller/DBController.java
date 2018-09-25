package com.rogern.db.controller;

import com.rogern.db.model.Employee;
import com.rogern.db.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

public class DBController {
    private Session session;

    public DBController() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void listEmployees() {
        List<?> employees = session.createQuery("FROM Employee").getResultList();
        employees.forEach(l -> System.out.println(l.toString()));
    }

    public List findEmployeesWithFirstName(String firstName) {
        return session.createQuery("FROM Employee WHERE firstName = '" + firstName + "'").getResultList();
    }

    public void updateEmployee(Integer id, Employee employee) {
        Employee e = session.find(Employee.class, id);
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setSalery(employee.getSalery());
        session.update(e);
        commit();
    }

    public void deleteEmployee(Integer id) {
        Employee e = session.find(Employee.class, id);
        session.delete(e);
        commit();
    }

    public void deleteEmployees(Integer... ids) {
        Arrays.asList(ids).forEach(this::deleteEmployee);
    }

    public void saveEmployee(Employee employee){
        session.save(employee);
        commit();
    }

    public void saveEmployees(Employee... employees){
        Arrays.asList(employees).forEach(this::saveEmployee);
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

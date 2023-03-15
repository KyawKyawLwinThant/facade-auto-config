package com.demo.facase;

import com.demo.entity.Employee;

import java.util.List;

public interface EmployeeFacadeLocal {
    void create(Employee employee);
    void edit(Employee employee);
    void remove(Employee employee);
    Employee find(Object id);
    List<Employee> findAll();
    int count();
}

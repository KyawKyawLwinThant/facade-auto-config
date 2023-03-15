package com.demo.facase;

import com.demo.entity.Employee;
import com.demo.facade.AbstractFacade;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {
    public EmployeeFacade(){
        super(Employee.class);
    }
}

package com.demo;

import com.demo.entity.Employee;
import com.demo.facase.EmployeeFacadeLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoFacadeTestApplication implements CommandLineRunner {
    @Autowired
    private EmployeeFacadeLocal employeeFacadeLocal;

    public static void main(String[] args) {
        SpringApplication.run(DemoFacadeTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee=new Employee(1,"Thaw","Thaw","thaw@gmail.com",2000);
        employeeFacadeLocal.create(employee);
        System.out.println(employeeFacadeLocal.find(1));
    }
}

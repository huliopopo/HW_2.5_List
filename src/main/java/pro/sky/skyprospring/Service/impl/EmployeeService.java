package pro.sky.skyprospring.Service.impl;

import pro.sky.skyprospring.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastname, int salary, int department);

    Employee removeEmployee(String firstName, String lastname);

    Employee findEmployee(String firstName, String lastname);

    Collection<Employee> allEmployyes();
}

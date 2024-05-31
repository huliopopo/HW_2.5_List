package pro.sky.skyprospring.Service;

import pro.sky.skyprospring.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastname);

    Employee removeEmployee(String firstName, String lastname);

    Employee findEmployee(String firstName, String lastname);

    Collection<Employee> allEmployees();
}

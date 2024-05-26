package pro.sky.skyprospring.EmployeeService;

import org.springframework.stereotype.Service;
import pro.sky.skyprospring.Employee;
import pro.sky.skyprospring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospring.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospring.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();
    private static final int MAXNUMBEROFEMPLOYEES = 5;

    public Employee addEmployee(String firstName, String lastName) {
        if (employeeList.size() < MAXNUMBEROFEMPLOYEES) {
            if (isMatchEmployees(firstName, lastName)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                Employee employee = new Employee(firstName, lastName);
                employeeList.add(employee);
                return employee;
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (!isMatchEmployees(firstName, lastName)) {
            throw new EmployeeNotFoundException();
        } else {
            Employee employee = new Employee(firstName, lastName);
            employeeList.remove(employee);
            return employee;
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (isMatchEmployees(firstName, lastName)) {
            return new Employee(firstName, lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    private boolean isMatchEmployees(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeList.contains(employee);
    }

    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employeeList);
    }
}
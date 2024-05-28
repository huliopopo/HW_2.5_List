package pro.sky.skyprospring.EmployeeService;

import org.springframework.stereotype.Service;
import pro.sky.skyprospring.Employee;
import pro.sky.skyprospring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospring.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospring.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    public static Map<String, Employee> employees = new HashMap<>();
    private static final int MAXNUMBEROFEMPLOYEES = 5;

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() < MAXNUMBEROFEMPLOYEES) {
            if (isMatchEmployees(firstName, lastName)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                Employee employee = new Employee(firstName, lastName);
                employees.put(buildKey(firstName, lastName), employee);
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
            return employees.remove(buildKey(firstName, lastName));
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (isMatchEmployees(firstName, lastName)) {
            return employees.get(buildKey(firstName, lastName));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    private boolean isMatchEmployees(String firstName, String lastName) {
        return employees.containsKey(buildKey(firstName, lastName));
    }

    public Collection<Employee> getEmployeeList() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String buildKey(String firstname, String lastName) {
        return firstname + lastName;
    }
}
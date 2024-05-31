package pro.sky.skyprospring.Service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.skyprospring.Exceptions.InvalidInputException;
import pro.sky.skyprospring.Service.EmployeeService;
import pro.sky.skyprospring.model.Employee;
import pro.sky.skyprospring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospring.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospring.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Map<String, Employee> employees = new HashMap<>();
    private static final int MAXNUMBEROFEMPLOYEES = 5;

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() < MAXNUMBEROFEMPLOYEES) {
            firstName = validateInput(firstName);
            lastName = validateInput(lastName);
            String key = buildKey(firstName, lastName);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                Employee employee = new Employee(firstName, lastName);
                employees.put(key, employee);
                return employee;
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> allEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }


    private String buildKey(String firstname, String lastName) {
        return firstname + lastName;
    }

    private String validateInput(String string) {
        if (!StringUtils.isAlpha(string)) {
            throw new InvalidInputException();
        }
        return StringUtils.capitalize(string.toLowerCase());
    }
}


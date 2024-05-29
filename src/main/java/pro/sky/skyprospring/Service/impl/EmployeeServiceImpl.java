package pro.sky.skyprospring.Service.impl;

import org.springframework.stereotype.Service;
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

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        if (employees.size() < MAXNUMBEROFEMPLOYEES) {
            String key = buildKey(firstName, lastName);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                Employee employee = new Employee(firstName, lastName, salary, department);
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


    /////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
 /*   public Employee findMinSalaryEmployeeByDepartment(int department) {
        Employee minSalaryEmployeeByDepartment = employees[0];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < minSum) {
                minSum = employees[i].getSalary();
                minSalaryEmployeeByDepartment = employees[i];
            }
        }
        return minSalaryEmployeeByDepartment;
    }

    public Map<String, Employee> findMinSalaryEmployeeByDepartment = employees.stream.





    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        int maxSum = 0;
        Employee maxSalaryEmployeeByDepartment = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > maxSum) {
                maxSum = employees[i].getSalary();
                maxSalaryEmployeeByDepartment = employees[i];
            }
        }
        return maxSalaryEmployeeByDepartment;
    }*/


}


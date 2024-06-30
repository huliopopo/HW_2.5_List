package pro.sky.skyprospring.Service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospring.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospring.Service.DepartmentService;
import pro.sky.skyprospring.Service.EmployeeService;
import pro.sky.skyprospring.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public int findMaxSalaryByDepartment(int department) {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .map(employee -> employee.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public int findMinSalaryByDepartment(int department) {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .map(employee -> employee.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(int department) {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartment() {
        return employeeService.allEmployees().stream()
                .collect(groupingBy(employee -> employee.getDepartment()));

    }

    @Override
    public int findSumSalaryByDepartment(int department) {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .map(employee -> employee.getSalary())
                .reduce(0, (integer, integer2) -> integer + integer2);
    }


}

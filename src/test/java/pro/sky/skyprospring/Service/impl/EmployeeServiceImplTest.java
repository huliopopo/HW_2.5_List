package pro.sky.skyprospring.Service.impl;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pro.sky.skyprospring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospring.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospring.Exceptions.EmployeeStorageIsFullException;
import pro.sky.skyprospring.Exceptions.InvalidInputException;

import pro.sky.skyprospring.model.Employee;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private final List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", 5000, 1),
            new Employee("Ivan", "Petrov", 2000, 1),
            new Employee("Ivan", "Sidorov", 1000, 2)
    );

    @BeforeEach
    public void beforeEach() {
        employees.forEach(employee -> employeeService.addEmployee(employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment())
        );
    }

    @AfterEach
    public void afterEach() {
        employeeService.allEmployees()
                .forEach(employee -> employeeService.removeEmployee(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    void addEmployee() {
        Employee expected = new Employee("Petr", "Petrovich", 1000, 3);

        Employee actual = employeeService.addEmployee("Petr", "Petrovich", 1000, 3);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isIn(employeeService.allEmployees());
    }

    @Test
    void addEmployee_ThrowException_EmployeeStorageIsFullException() {
        employeeService.addEmployee("Petr", "Petrovich", 1000, 3);
        employeeService.addEmployee("Oleg", "Olegovich", 4000, 3);

        assertThatExceptionOfType(EmployeeStorageIsFullException.class)
                .isThrownBy(() -> employeeService.addEmployee("Nikolai", "Ivanov", 3000, 4));
    }

    @Test
    void addEmployee_ThrowException_InvalidInputException() {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> employeeService.addEmployee("Ivan123", "Sidorov", 1000, 2));

    }

    @Test
    void addEmployee_ThrowException_EmployeeAlreadyAddedException() {
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.addEmployee("Ivan", "Sidorov", 1000, 2));
    }


    @Test
    void removeEmployee() {
        Employee expected = new Employee("Ivan", "Sidorov", 1000, 2);

        Employee actual = employeeService.removeEmployee("Ivan", "Sidorov");

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotIn(employeeService.allEmployees());
    }

    @Test
    void removeEmployee_ThrowException_EmployeeNotFoundException() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.removeEmployee("IvanQQQ", "Sidorov"));
    }

    @Test
    void findEmployee() {
        Employee expected = new Employee("Ivan", "Sidorov", 1000, 2);

        Employee actual = employeeService.findEmployee("Ivan", "Sidorov");

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isIn(employeeService.allEmployees());
    }

    @Test
    void findEmployee_ThrowException_EmployeeNotFoundException() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.findEmployee("IvanQQQ", "Sidorov"));
    }

    @Test
    void allEmployees() {
        assertThat(employeeService.allEmployees())
                .containsExactlyInAnyOrderElementsOf(employees);
    }
}
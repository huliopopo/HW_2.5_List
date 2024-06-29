package pro.sky.skyprospring.Service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospring.model.Employee;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", 5000, 1),
            new Employee("Ivan", "Petrov", 2000, 1),
            new Employee("Ivan", "Sidorov", 1000, 2),
            new Employee("Petr", "Petrovich", 4000, 2),
            new Employee("Oleg", "Olegovich", 8000, 3)
    );

    @BeforeEach
    public void beforeEach() {
        when(employeeService.allEmployees()).thenReturn(employees);
    }


    @Test
    void findMaxSalaryByDepartment() {
        int excepted = 4000;

        int actual = departmentService.findMaxSalaryByDepartment(2);

        assertThat(actual).isEqualTo(excepted);
    }


    @Test
    void findMinSalaryByDepartment() {
        int excepted = 1000;

        int actual = departmentService.findMinSalaryByDepartment(2);

        assertThat(actual).isEqualTo(excepted);
    }

    @Test
    void findAllEmployeesByDepartment() {
        assertThat(departmentService.findAllEmployeesByDepartment(2))
                .containsExactlyInAnyOrder(
                        new Employee("Ivan", "Sidorov", 1000, 2),
                        new Employee("Petr", "Petrovich", 4000, 2)
                );
    }

    @Test
    void testFindAllEmployeesByDepartment() {
        assertThat(departmentService.findAllEmployeesByDepartment())
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of(
                                1, List.of(
                                        new Employee("Ivan", "Ivanov", 5000, 1),
                                        new Employee("Ivan", "Petrov", 2000, 1)),
                                2, List.of(
                                        new Employee("Ivan", "Sidorov", 1000, 2),
                                        new Employee("Petr", "Petrovich", 4000, 2)),
                                3, List.of(
                                        new Employee("Oleg", "Olegovich", 8000, 3))
                        )
                );
    }

    @Test
    void findSumSalaryByDepartment() {
        int excepted = 5000;

        int actual = departmentService.findSumSalaryByDepartment(2);

        assertThat(actual).isEqualTo(excepted);
    }
}
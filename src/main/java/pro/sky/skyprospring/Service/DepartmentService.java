package pro.sky.skyprospring.Service;

import pro.sky.skyprospring.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryEmployeeByDepartment(int department);

    Employee findMinSalaryEmployeeByDepartment(int department);

    Collection<Employee> findAllEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> findAllEmployeesByDepartment();

}

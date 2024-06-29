package pro.sky.skyprospring.Service;

import pro.sky.skyprospring.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    int findMaxSalaryByDepartment(int department);

    int findMinSalaryByDepartment(int department);

    Collection<Employee> findAllEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> findAllEmployeesByDepartment();

    int findSumSalaryByDepartment(int department);
}

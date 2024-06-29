/*
package pro.sky.skyprospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospring.Service.DepartmentService;
import pro.sky.skyprospring.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentContoller {
    private final DepartmentService departmentService;


    public DepartmentContoller(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.findMinSalaryByDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> all(@RequestParam int departmentId) {
        return departmentService.findAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return departmentService.findAllEmployeesByDepartment();
    }

}
*/

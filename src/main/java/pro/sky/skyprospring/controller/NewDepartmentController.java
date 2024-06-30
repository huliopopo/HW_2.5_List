package pro.sky.skyprospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospring.Service.impl.DepartmentServiceImpl;
import pro.sky.skyprospring.model.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class NewDepartmentController {
    private final DepartmentService departmentService;

    public NewDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> employees(@PathVariable("id") int department) {
        return departmentService.findAllEmployeesByDepartment(department);
    }

    @GetMapping("{id}/salary/sum")
    public int sumSalary(@PathVariable("id") int department) {
        return departmentService.findSumSalaryByDepartment(department);
    }

    @GetMapping("{id}/salary/max")
    public int maxSalary(@PathVariable("id") int department) {
        return departmentService.findMaxSalaryByDepartment(department);
    }

    @GetMapping("{id}/salary/min")
    public int minSalary(@PathVariable("id") int department) {
        return departmentService.findMinSalaryByDepartment(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> employees() {
        return departmentService.findAllEmployeesByDepartment();
    }


}

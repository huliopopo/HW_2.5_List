package pro.sky.skyprospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospring.Employee;
import pro.sky.skyprospring.EmployeeService.EmployeeService;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.getEmployeeList();
    }

}

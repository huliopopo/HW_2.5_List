package pro.sky.skyprospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospring.model.Employee;
import pro.sky.skyprospring.Service.EmployeeServiceImpl;

import java.util.Collection;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
    public EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int salary,
                        @RequestParam int department) {
        return employeeServiceImpl.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName) {
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }

    @GetMapping()
    public Collection<Employee> employees() {
        return employeeServiceImpl.allEmployyes();
    }

}

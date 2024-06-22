package com.mockito.mockito;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> showEmployeesOfDep(@PathVariable int id) {
        return departmentService.getAllEmployeesOfDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public int showSumEmployeesOfDep(@PathVariable int id) {
        return departmentService.sumEmployeesOfDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee showMaxSalaryOfDep(@PathVariable int id) {
        return departmentService.maxSalary(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee showMinSalaryOfDep(@PathVariable int id) {
        return departmentService.minSalary(id);
    }

    @GetMapping(path = "/sortEmployees")
    public Map<Integer, List<Employee>> allEmployeesOfDepartment() {
        return departmentService.allEmployees();
    }

}

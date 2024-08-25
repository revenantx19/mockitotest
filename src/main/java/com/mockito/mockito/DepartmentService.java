package com.mockito.mockito;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeServiceImp employeeServiceImp;

    public DepartmentService(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    public int sumEmployeesOfDepartment(int departmentId) {
        return employeeServiceImp.getEmployeesMap().values().stream()
                .filter(employee -> employee.getDep() == departmentId)
                .mapToInt(Employee::getSalary).sum();
    }

    public Employee maxSalary(int departmentId) {
        return employeeServiceImp.getEmployeesMap().values().stream()
                .filter(employee -> employee.getDep() == departmentId)
                .max(Comparator.comparingInt(p -> p.getSalary()))
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));
    }

    public Employee minSalary(Integer departmentId) {
        return employeeServiceImp.getEmployeesMap().values().stream()
                .filter(employee -> employee.getDep() == departmentId)
                .min(Comparator.comparingInt(p -> p.getSalary()))
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));
    }

    public List<Employee> getAllEmployeesOfDepartment(int departmentId) {
        return employeeServiceImp.getEmployeesMap().values().stream()
                .filter(employee -> employee.getDep() == departmentId)
                .toList();
    }

    public Map<Integer, List<Employee>> allEmployees() {
        return employeeServiceImp.getEmployeesMap().values().stream().collect(
                Collectors.groupingBy(Employee::getDep));
    }

}

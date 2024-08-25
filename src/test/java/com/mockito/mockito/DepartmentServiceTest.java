package com.mockito.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    EmployeeServiceImp employeeService;

    @InjectMocks
    //EmployeeServiceImp employeeServiceImp;
    DepartmentService departmentService;



    @Test
    void sumEmployeesOfDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "Иванов Иван", new Employee("Иванов Иван", 1, 43000),
                "Петров Петр", new Employee("Петров Петр", 2, 75000),
                "Викторов Виктор", new Employee("Викторов Виктор", 3, 54000),
                "Смирнов Василий", new Employee("Смирнов Василий", 4, 70000),
                "Чашкин Роман", new Employee("Чашкин Роман", 5, 68000),
                "Газетов Игорь", new Employee("Газетов Игорь", 1, 43000),
                "Константинов Эдуард", new Employee("Константинов Эдуард", 2, 29000),
                "Трубных Виктория", new Employee("Трубных Виктория", 3, 90000),
                "Мышкина Вита", new Employee("Мышкина Вита", 4, 103000),
                "Безруков Степан", new Employee("Безруков Степан", 5, 55000)
        ));
        when(employeeService.getEmployeesMap()).thenReturn(employeeMap);
        employeeMap.put("Странный Пётр", new Employee("Странный Пётр", 3, 95000));
        assertEquals(239000, departmentService.sumEmployeesOfDepartment(3));
    }

    @Test
    void maxSalary() {

        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "Иванов Иван", new Employee("Иванов Иван", 1, 43000),
                "Петров Петр", new Employee("Петров Петр", 2, 75000),
                "Викторов Виктор", new Employee("Викторов Виктор", 3, 54000),
                "Смирнов Василий", new Employee("Смирнов Василий", 4, 70000),
                "Чашкин Роман", new Employee("Чашкин Роман", 5, 68000),
                "Газетов Игорь", new Employee("Газетов Игорь", 1, 43000),
                "Константинов Эдуард", new Employee("Константинов Эдуард", 2, 29000),
                "Трубных Виктория", new Employee("Трубных Виктория", 3, 90000),
                "Мышкина Вита", new Employee("Мышкина Вита", 4, 103000),
                "Безруков Степан", new Employee("Безруков Степан", 5, 55000)
        ));
        when(employeeService.getEmployeesMap()).thenReturn(employeeMap);
        Employee petr = new Employee("Странный Пётр", 3, 95000);
        employeeMap.put("Странный Пётр", petr);
        assertEquals(petr, departmentService.maxSalary(3));
    }

    @Test
    void minSalary() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "Иванов Иван", new Employee("Иванов Иван", 1, 43000),
                "Петров Петр", new Employee("Петров Петр", 2, 75000),
                "Викторов Виктор", new Employee("Викторов Виктор", 3, 54000),
                "Смирнов Василий", new Employee("Смирнов Василий", 4, 70000),
                "Чашкин Роман", new Employee("Чашкин Роман", 5, 68000),
                "Газетов Игорь", new Employee("Газетов Игорь", 1, 43000),
                "Константинов Эдуард", new Employee("Константинов Эдуард", 2, 29000),
                "Трубных Виктория", new Employee("Трубных Виктория", 3, 90000),
                "Мышкина Вита", new Employee("Мышкина Вита", 4, 103000),
                "Безруков Степан", new Employee("Безруков Степан", 5, 55000)
        ));
        when(employeeService.getEmployeesMap()).thenReturn(employeeMap);
        Employee petr = new Employee("Странный Пётр", 3, 35000);
        employeeMap.put("Странный Пётр", petr);
        assertEquals(petr, departmentService.minSalary(3));
    }


    @Test
    void getAllEmployeesOfDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "Иванов Иван", new Employee("Иванов Иван", 1, 43000),
                "Петров Петр", new Employee("Петров Петр", 2, 75000),
                "Викторов Виктор", new Employee("Викторов Виктор", 3, 54000),
                "Смирнов Василий", new Employee("Смирнов Василий", 4, 70000),
                "Чашкин Роман", new Employee("Чашкин Роман", 5, 68000),
                "Газетов Игорь", new Employee("Газетов Игорь", 1, 43000),
                "Константинов Эдуард", new Employee("Константинов Эдуард", 2, 29000),
                "Трубных Виктория", new Employee("Трубных Виктория", 3, 90000),
                "Мышкина Вита", new Employee("Мышкина Вита", 4, 103000),
                "Безруков Степан", new Employee("Безруков Степан", 5, 55000)
        ));
        when(employeeService.getEmployeesMap()).thenReturn(employeeMap);
        Employee petr = new Employee("Странный Пётр", 3, 35000);
        employeeMap.put("Странный Пётр", petr);
        List<Employee> listOfEmployee = List.of(
                petr,
                employeeMap.get("Викторов Виктор"),
                employeeMap.get("Трубных Виктория")
                );
        assertEquals(listOfEmployee, departmentService.getAllEmployeesOfDepartment(3));
    }

    @Test
    void allEmployees() {



    }

}
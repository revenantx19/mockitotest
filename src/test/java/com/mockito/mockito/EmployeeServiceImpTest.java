package com.mockito.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImpTest {

    @Mock
    private EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();

    @Test
    void addEmployee_success() {
        String result = employeeServiceImp.addEmployee("Ivan", 1, 25000);
        assertEquals("Ivan сотрудник успешно добавлен", result);
    }

    @Test
    void addEmployee_failed() {
        String result = employeeServiceImp.addEmployee("Ivan", 2, 25000);
        String result2 = employeeServiceImp.addEmployee("Ivan", 1, 25000);
        assertEquals("Сотрудник уже имеется в базе", result2);
    }

    @Test
    void findEmployee_success() {
        Employee employee = new Employee("Ivan", 1, 25000);
        when(employeeServiceImp.findEmployee("Ivan")).thenReturn("Ivan сотрудник найден в базе");
        String result = employeeServiceImp.findEmployee("Ivan");
        assertEquals("Ivan сотрудник найден в базе", result);
    }

    @Test
    void findEmployee_failed() {
        String result = employeeServiceImp.findEmployee("Ivan");
        assertEquals("Ivan не найден", result);
    }

    @Test
    void deleteEmployee_success() {
        Employee employee = new Employee("Ivan", 1, 25000);
        employeeServiceImp.getEmployeesMap().put("Ivan", employee);
        String result = employeeServiceImp.deleteEmployee("Ivan");
        assertEquals("Ivan успешно удалён", result);
    }

    @Test
    void deleteEmployee_failed() {
        String result = employeeServiceImp.deleteEmployee("Ivan");
        assertEquals("Ivan такого сотрудника в базе нет", result);
    }

    //не понимаю как создать тест по этому методу
    @Test
    void allEmployees() {
        Map<Integer, List<Employee>> result = employeeServiceImp.allEmployees();
        //assertEquals();
    }
}
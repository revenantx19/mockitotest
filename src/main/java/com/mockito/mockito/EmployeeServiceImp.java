package com.mockito.mockito;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private Map<String, Employee> employeesMap = new HashMap<>(Map.of(
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
    )
    );

    public Map<String, Employee> getEmployeesMap() {
        return employeesMap;
    }

    public String addEmployee(String fio, int dep, int salary) {
        if (employeesMap.get(fio) == null) {
            if (fio.replaceAll("[^ a-zA-Zа-яА-Я]", "").length() == fio.length()) {
                employeesMap.put(WordUtils.capitalizeFully(fio), new Employee(WordUtils.capitalizeFully(fio), dep, salary));
                return WordUtils.capitalizeFully(fio) + " сотрудник успешно добавлен";
            } else {
                throw new RuntimeException();
            }
        } else {
            return "Сотрудник уже имеется в базе";
        }
    }

    public String findEmployee(String fio) {
        if (employeesMap.get(fio) != null) {
            return fio + " сотрудник найден в базе";
        }
        return fio + " не найден";
    }

    public String deleteEmployee(String fio) {

        if (employeesMap.get(fio) != null) {
            employeesMap.remove(fio);
            return fio + " успешно удалён";
        } else {
            return fio + " такого сотрудника в базе нет";
        }
    }
    public Map<Integer, List<Employee>> allEmployees() {
        return employeesMap.values().stream().collect(
                Collectors.groupingBy(Employee::getDep));
    }
}

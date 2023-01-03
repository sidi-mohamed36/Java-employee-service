package com.bytecodevelocity.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();

    static{
        list.add(new Employee(1, "Nancy", "nancy@mail.com"));
        list.add(new Employee(2,"Nancy", "nancy@mail.com"));
        list.add(new Employee(3,"Nancy", "nancy@mail.com"));

    }
    public List<Employee> getAllEmployees(){
        return list;
    }
    public Employee getEmployeeById(int empId) {
        return list.stream()
                .filter(emp -> emp.getId() == empId)
                .findAny()
                .orElse(null);
    }

    public Employee saveEmployee(Employee emp){
        emp.setId(list.size()+1);
        list.add(emp);
        return emp;

    }

    public Employee deleteEmployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (empId == emp.getId()) {
                iterator.remove();
                return emp;
            }
        }
        return null;
    }
}

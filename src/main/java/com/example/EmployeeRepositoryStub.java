package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository{
    @Override
    public List<Employee> findAll() {
        Employee employee1 = new Employee("1", 2000);
        Employee employee2 = new Employee("2", 3000);
        Employee employee3 = new Employee("3", 4000);
        return Arrays.asList(employee1,employee2,employee3);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}

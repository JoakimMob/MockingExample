package com.example;


import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    private List<Employee> employees;


    public EmployeeRepositoryStub(List<Employee> employee) {
        this.employees = employee;
    }

    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        int index = findEmployeeByIndex(employee.getId());
        if (index != -1) {
            employees.remove(index);
        }
        employees.add(employee);
        return employee;
    }

    public int findEmployeeByIndex(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

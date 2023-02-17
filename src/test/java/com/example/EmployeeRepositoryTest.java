package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    private EmployeeRepository employeeRepository = new EmployeeRepositoryStub(new ArrayList<>());
    private BankService bankService = new BankServiceDummy();

    @Test
    void findAllEmployees() {
        Employee employee1 = new Employee("1", 3000);
        Employee employee2 = new Employee("2", 3500);
        Employee employee3 = new Employee("3", 2000);
        Employee employee4 = new Employee("4", 4000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);

        ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
        assertEquals(4, employees.size());
    }

    @Test
    void saveNewEmployee() {
        Employee employee1 = new Employee("1", 3000);
        Employee employee2 = new Employee("2", 3500);
        Employee employee3 = new Employee("1", 2000);
        Employee employee4 = new Employee("2", 4000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);

        ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
        assertEquals(2, employees.size());

    }

}
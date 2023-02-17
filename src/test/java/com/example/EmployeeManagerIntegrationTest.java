package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerIntegrationTest {

    @Test
    public void payEmployees() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryStub(new ArrayList<>());
        BankService bankService = new BankServiceDummy();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        employeeRepository.save(new Employee("1", 2000));
        employeeRepository.save(new Employee("2", 3000));
        employeeRepository.save(new Employee("3", 4000));
        int numberOfPayments = employeeManager.payEmployees();
        assertEquals(3, numberOfPayments);
    }
}
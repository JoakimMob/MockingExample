package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesIntegrationTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
    BankService bankService = new BankServiceDummy();
    private final Employees employees = new Employees(employeeRepository, bankService);

    @Test
    void testPayEmployees(){
        int NrOfPayments = employees.payEmployees();
        assertEquals(3, NrOfPayments);
    }

    @Test
    void testIfFindAllFindsEmployees(){
        int nrOfEmployees = employeeRepository.findAll().size();
        assertEquals(3, nrOfEmployees);
    }

}
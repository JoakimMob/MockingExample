package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesIntegrationTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
    BankService bankService = new BankServiceDummy();
    private final EmployeeManager employees = new EmployeeManager(employeeRepository, bankService);

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
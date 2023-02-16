package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesIntegrationTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
    BankService bankService = new BankServiceDummy();
    private final Employees employees = new Employees(employeeRepository, bankService);

    @Test
    void payEmployees(){
        int NrOfPayments = employees.payEmployees();
        assertEquals(3, NrOfPayments);
    }

}
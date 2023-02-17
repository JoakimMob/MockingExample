package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeManagerTest {

    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    BankService bankService = mock(BankService.class);
    EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub();

    BankServiceDummy bankServiceDummy = mock(BankServiceDummy.class);

    private final EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

    private final EmployeeManager employeeManagerTest = new EmployeeManager(employeeRepositoryStub, bankServiceDummy);
    Employee employee = mock(Employee.class);


    @Test
    void testIfFindEmployees(){
        int numberOfEmployees = employeeRepositoryStub.findAll().size();
        assertEquals(3,numberOfEmployees);
    }
    @Test
    void payEmployeesShouldBeCalledOnce(){
        bankServiceDummy.pay("1",2000);
        verify(bankServiceDummy, Mockito.times(1)).pay("1", 2000);
    }
    @Test
    void payEmployees(){
        when(employeeRepository.findAll()).thenReturn(List.of(employee));
        when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());
        assertEquals(1, employeeManager.payEmployees());
        verify(employee, times(1)).getSalary();
        verify(employee, times(1)).setPaid(true);
    }

    @Test
    void payEmployeesWithStub(){
        int numberOfPayments = employeeManagerTest.payEmployees();
        assertEquals(3, numberOfPayments);
    }

}
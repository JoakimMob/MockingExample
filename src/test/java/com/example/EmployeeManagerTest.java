package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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



    private final EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

    Employee employee = mock(Employee.class);


    @Test
    void testIfOneEmployee(){
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1",4000)));
        int numberOfEmployees = new EmployeeManager(employeeRepository,bankService).payEmployees();
        assertEquals(1,numberOfEmployees);
    }
    @Test
    void payEmployees(){
        when(employeeRepository.findAll()).thenReturn(List.of(employee));
        when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());
        assertEquals(1, employeeManager.payEmployees());
        verify(employee, times(1)).getSalary();
        verify(employee, times(1)).setPaid(true);
    }
}
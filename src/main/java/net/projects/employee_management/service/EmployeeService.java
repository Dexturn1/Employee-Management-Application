package net.projects.employee_management.service;


import net.projects.employee_management.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto addEmployee(Long departmentId,  EmployeeDto employeeDto);
 }

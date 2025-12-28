package net.projects.employee_management.service;


import net.projects.employee_management.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(Long departmentId,  EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long departmentId, Long employeeId);

    List<EmployeeDto> getAllEmployeesByDepartmentId(Long departmentID);

}

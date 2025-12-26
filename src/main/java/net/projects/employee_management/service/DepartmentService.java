package net.projects.employee_management.service;

import net.projects.employee_management.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(Long id);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id);
    void deleteDepartment(Long id);
}

package net.projects.employee_management.service.impl;

import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.DepartmentDto;
import net.projects.employee_management.entity.Department;
import net.projects.employee_management.repository.DepartmentRepository;
import net.projects.employee_management.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;


    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);
        return  modelMapper.map(savedDepartment,DepartmentDto.class);
    }
}

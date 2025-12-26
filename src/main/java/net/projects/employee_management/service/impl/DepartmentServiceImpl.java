package net.projects.employee_management.service.impl;

import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.DepartmentDto;
import net.projects.employee_management.entity.Department;
import net.projects.employee_management.exception.ResourceNotFoundException;
import net.projects.employee_management.repository.DepartmentRepository;
import net.projects.employee_management.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public DepartmentDto getDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not Found With id: "+ id));

        return modelMapper.map(department,DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto,Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department Not Found with id: "+ id));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        departmentRepository.save(department);
        return modelMapper.map(department,DepartmentDto.class);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department Not Found with id: "+ id));
        departmentRepository.delete(department);
    }


}









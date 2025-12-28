package net.projects.employee_management.service.impl;

import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.EmployeeDto;
import net.projects.employee_management.entity.Department;
import net.projects.employee_management.entity.Employee;
import net.projects.employee_management.exception.BadRequestException;
import net.projects.employee_management.exception.ResourceNotFoundException;
import net.projects.employee_management.repository.DepartmentRepository;
import net.projects.employee_management.repository.EmployeeRepository;
import net.projects.employee_management.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(Long departmentId, EmployeeDto employeeDto){

        Department department =  departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("There is no Department with department-id:"+ departmentId));

        Employee employee =   modelMapper.map(employeeDto, Employee.class);
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);
        return  modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long departmentId, Long employeeId) {
        Department department =  departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("There is no Department with department-id:"+ departmentId));

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("There is not Employee with id: "+employeeId));

        if(!employee.getDepartment().getId().equals(department.getId())){
            throw new BadRequestException("This employee does not belong to department with ID "+ departmentId);
        }

        return modelMapper.map(employee,EmployeeDto.class);

    }
}

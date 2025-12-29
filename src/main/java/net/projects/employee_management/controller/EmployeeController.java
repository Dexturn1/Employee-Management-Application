package net.projects.employee_management.controller;


import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.EmployeeDto;
import net.projects.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/{id}/employees")
    public ResponseEntity<EmployeeDto> addEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.addEmployee(id, employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}/employees/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("departmentId") Long departmentId,@PathVariable("employeeId") Long employeeId){
        EmployeeDto employeeDto =  employeeService.getEmployeeById(departmentId, employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesById(@PathVariable("id") Long id){
        List<EmployeeDto> employees =  employeeService.getAllEmployeesByDepartmentId(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{departmentId}/employees/{employeesId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("departmentId") Long departmentId,
                                                      @PathVariable("employeesId") Long employeeId,
                                                      @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployee(departmentId, employeeId, employeeDto);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }



    @DeleteMapping("{departmentId}/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long departmentId,
                                                 @PathVariable Long employeeId){
        employeeService.deleteEmployee(departmentId, employeeId);
        return new ResponseEntity<>("The employee Has been deleted", HttpStatus.OK);
    }

}


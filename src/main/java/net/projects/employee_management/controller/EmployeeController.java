package net.projects.employee_management.controller;


import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.EmployeeDto;
import net.projects.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @PostMapping("{id}/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@PathVariable ("id") Long departmentId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.addEmployee(departmentId, employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


}

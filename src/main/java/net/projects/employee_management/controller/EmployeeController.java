package net.projects.employee_management.controller;


import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.EmployeeDto;
import net.projects.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

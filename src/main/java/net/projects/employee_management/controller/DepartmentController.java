package net.projects.employee_management.controller;


import lombok.AllArgsConstructor;
import net.projects.employee_management.dto.DepartmentDto;
import net.projects.employee_management.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.addDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id){
        DepartmentDto departmentDto = departmentService.getDepartment(id);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();
        //return new ResponseEntity<>(departmentDtos,HttpStatus.OK);
        return ResponseEntity.ok(departmentDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("id") long id){
        DepartmentDto updatedDto = departmentService.updateDepartment(departmentDto, id);

        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteDepartment(@PathVariable ("id") Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department with Id: " + id + " is SUCCESSFULLY DELETED");
    }

}

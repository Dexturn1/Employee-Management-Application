package net.projects.employee_management.repository;

import net.projects.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByDepartmentId(Long departmentId);

}

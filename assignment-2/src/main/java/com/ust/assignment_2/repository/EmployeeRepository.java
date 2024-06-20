package com.ust.assignment_2.repository;

import com.ust.assignment_2.model.Department;
import com.ust.assignment_2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDept(Department dept);

    @Query("select e from Employee e where e.years>=5")
    List<Employee> getExperiencedEmployee();

    List<Employee> findBySalaryGreaterThanEqual(double Salary);
}


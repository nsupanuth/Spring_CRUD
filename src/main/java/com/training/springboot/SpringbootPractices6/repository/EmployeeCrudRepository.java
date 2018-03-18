package com.training.springboot.SpringbootPractices6.repository;

import com.training.springboot.SpringbootPractices6.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepository extends JpaRepository<Employee,Integer>{



}

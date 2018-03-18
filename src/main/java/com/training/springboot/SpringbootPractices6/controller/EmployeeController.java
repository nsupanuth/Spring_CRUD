package com.training.springboot.SpringbootPractices6.controller;

import com.training.springboot.SpringbootPractices6.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @RequestMapping(value = "/employees")
    public List<Employee> listAllEmployee(){

        System.out.println("=== Get All Employee ===");
        return null;
    }

    @RequestMapping(value = "/employees/1")
    public Employee getEmployee(){

        System.out.println("== Get Employee ==");
        return null;
    }







}

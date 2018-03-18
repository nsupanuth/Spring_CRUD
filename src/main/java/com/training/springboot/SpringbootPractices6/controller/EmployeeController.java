package com.training.springboot.SpringbootPractices6.controller;

import com.training.springboot.SpringbootPractices6.domain.Employee;
import com.training.springboot.SpringbootPractices6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees")
    public List<Employee> listAllEmployee(){

        System.out.println("=== Get All Employee ===");
        return employeeService.listAll();
    }

    @RequestMapping(value = "/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){

        System.out.println("== Get Employee "+id+" ==");
        return employeeService.get(id);
    }

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employeeParam){
        System.out.println("== Create Employee ==");

        System.out.println(employeeParam.getFirstName() + " "+employeeParam.getLastName());
        return null;
    }

    @RequestMapping(value = "/employees/{id}",method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable Integer id){
        System.out.println("== Update Employee "+id+" ==");
        return null;
    }

    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable Integer id){
        System.out.println("== Delete Employee "+id+" ==");
        return null;
    }



}
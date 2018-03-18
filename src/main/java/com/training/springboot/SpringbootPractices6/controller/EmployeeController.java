package com.training.springboot.SpringbootPractices6.controller;

import com.training.springboot.SpringbootPractices6.domain.Employee;
import com.training.springboot.SpringbootPractices6.dto.DataDTO;
import com.training.springboot.SpringbootPractices6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> listAllEmployee(){

        System.out.println("=== Get All Employee ===");
        return employeeService.listAll();
    }

    @GetMapping("/crud")
    public List<Employee> listAllEmployeeCrud(){
        return employeeService.listAllCrud();
    }

    @GetMapping("/native")
    public List<DataDTO> nativeQuery(){
        return employeeService.findAllByNative();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){

        System.out.println("== Get Employee "+id+" ==");
        return employeeService.get(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employeeParam){
        System.out.println("== Create Employee ==");
        System.out.println(employeeParam.getFirstName() + " "+employeeParam.getLastName());

        Employee employeeSaved = employeeService.save(employeeParam);

        return employeeSaved;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employeeParam,@PathVariable Integer id){
        System.out.println("== Update Employee "+id+" ==");

        return employeeService.update(employeeParam,id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.delete(id);
    }

    @GetMapping("/lastName/{lastName}")
    public List<Employee> getEmployeesByLastName(@PathVariable String lastName){
        System.out.println("Get employees by "+lastName);
        return employeeService.findEmployeesByLastName(lastName);
    }



}

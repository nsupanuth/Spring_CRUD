package com.training.springboot.SpringbootPractices6.service;

import com.training.springboot.SpringbootPractices6.domain.Employee;
import com.training.springboot.SpringbootPractices6.dto.DataDTO;
import com.training.springboot.SpringbootPractices6.repository.EmployeeCrudRepository;
import com.training.springboot.SpringbootPractices6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    /* CRUD Repository(Spring Data JPA) */
    public List<Employee> listAllCrud(){
        return employeeCrudRepository.findAll();
    }

    public Employee get(Integer id){
//        return employeeRepository.findById(id);
        return employeeCrudRepository.findOne(id);
    }

    @Transactional
    public Employee save(Employee employee){
//        return employeeRepository.save(employee);
        return employeeCrudRepository.save(employee);
    }

    @Transactional
    public Employee update(Employee employeeParam,Integer id){
        Employee employeeById = employeeRepository.findById(id);
        employeeById.setFirstName(employeeParam.getFirstName());
        employeeById.setLastName(employeeParam.getLastName());

        return  employeeRepository.save(employeeById);
    }

    @Transactional
    public void delete(Integer id){
        Employee entity = employeeRepository.findById(id);
        employeeRepository.delete(entity);
    }

    public List<Employee> findEmployeesByLastName(String lastname){
        return employeeRepository.findByLastName(lastname);
    }

    public List<DataDTO> findAllByNative(){
        return employeeRepository.findAllByNativeQuery();
    }


}

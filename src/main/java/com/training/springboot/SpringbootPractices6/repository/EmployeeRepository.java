package com.training.springboot.SpringbootPractices6.repository;


import com.training.springboot.SpringbootPractices6.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public Employee save(Employee employee){
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public void delete(Employee employee){
        entityManager.remove(employee);
    }
}

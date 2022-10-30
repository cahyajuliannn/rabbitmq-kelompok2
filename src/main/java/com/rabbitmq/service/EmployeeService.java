package com.rabbitmq.service;

import com.rabbitmq.models.Employee;
import com.rabbitmq.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee (Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee getById(String id){
        return employeeRepository.findById(id).get();
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}

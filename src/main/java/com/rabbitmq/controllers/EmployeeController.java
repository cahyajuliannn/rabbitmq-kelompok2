package com.rabbitmq.controllers;

import com.rabbitmq.models.Employee;
import com.rabbitmq.producers.RabbitMQProducer;
import com.rabbitmq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    private RabbitMQProducer producer;

    public EmployeeController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        producer.sendEmployeeMessage(employee);
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id){
        return employeeService.getById(id);
    }
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}

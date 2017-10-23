/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author p.stassinopoulos
 */
@RestController
@RequestMapping(path = "/", produces = APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    private final EmployeeRepository employeeRepository;
    
    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @RequestMapping(value = "employees", method = GET)
    public List<Employee> list() {
        return (List<Employee>) this.employeeRepository.findAll();
    }
    
    @RequestMapping(method = GET)
    public String HelloWorld() {
        return "Hello World";
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        Employee employee = this.employeeRepository.findOne(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }
    
//    @RequestMapping(value = "/{id}", method = PUT)
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
    
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> post(@RequestBody EmployeeDto input) {
        return ResponseEntity.ok(
            this.employeeRepository.save(
                new Employee(
                    input.getName(),
                    input.getEmail()
                )
            )
        );
    }
        
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Employee employee = this.employeeRepository.findOne(id);
        if (employee != null) {
            this.employeeRepository.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


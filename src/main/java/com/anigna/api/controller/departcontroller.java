package com.anigna.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anigna.api.model.Department;
import com.anigna.api.model.Employee;
import com.anigna.api.service.EmployeeService;
import com.anigna.api.service.departmentservice;


@RestController
@RequestMapping("/Department")
public class departcontroller {
	
	@Autowired
    private departmentservice departsee;

    @PostMapping
    public String saveEmployee(@RequestBody Department dep) {
        Optional<Department> _employee = departsee.create(dep);
        if(_employee.isPresent()){
            return "The employee data has been saved successfully!";
        }else{
            return "Employee already exist in records";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getEmployeeById(@PathVariable("id") Long id) {
      Optional<Department> employee = departsee.retrieveOne(id);  
      if (employee.isPresent()) {
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }    

    @GetMapping
    public List<Department> getALLEmployees() {
      return departsee.retrieve();
    }

    @PutMapping
    public String updateEmployee(@RequestBody Department dep) {
        Optional<Department> _employee = departsee.update(dep);
        if(_employee.isEmpty()){
            return "The employee data does not exist in records!";
        }else{
            return "The employee data has been updated successfully!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
      return  departsee.delete(id);   
    }

}

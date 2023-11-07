package com.anigna.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anigna.api.model.Department;
import com.anigna.api.model.Employee;
import com.anigna.api.repository.departmentrepository;

@Service
public class departmentservice {
	
	@Autowired
	private departmentrepository reop;
	
	public Optional<Department> create(Department dep){
		if (reop.existsById(dep.getId())){
            return Optional.empty();
        }else{
            return Optional.of(reop.save(dep));
        }
    }

    public List<Department> retrieve(){
        return reop.findAll();
    }

    public Optional<Department> retrieveOne(Long id){
        return reop.findById(id);
    }
    
    public Optional<Department> update(Department dep){
        if (reop.existsById(dep.getId())){
            return Optional.of(reop.save(dep));
        }else{
            return Optional.empty();
        }
    }   

    public String delete(Long id){
        if (reop.existsById(id)){
        	reop.deleteById(id);
            return id + " deleted successfully!";
        }else{
            return "The employee data does not exist in records!";
        }
        
    }
		
	}
	


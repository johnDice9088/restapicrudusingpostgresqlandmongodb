package com.anigna.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	
	    @Id
	    private Long id;
	    
	    private String departmentName;

		public Department(Long id, String departmentName) {
			super();
			this.id = id;
			this.departmentName = departmentName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

	    
	}

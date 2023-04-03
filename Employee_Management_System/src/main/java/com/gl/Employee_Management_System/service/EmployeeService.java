package com.gl.Employee_Management_System.service;

import java.util.List;

import com.gl.Employee_Management_System.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);
}

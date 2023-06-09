package com.gl.Employee_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Employee_Management_System.dao.EmployeeRepository;
import com.gl.Employee_Management_System.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee=employeeRepository.findById(id).get();
		if(employee==null) {
			throw new RuntimeException("did not find employee id"+id);
		}
		else {
		return employee;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}

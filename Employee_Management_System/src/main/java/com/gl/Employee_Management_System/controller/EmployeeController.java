package com.gl.Employee_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.Employee_Management_System.entity.Employee;
import com.gl.Employee_Management_System.service.EmployeeService;

@Controller
public class EmployeeController {
	/*
	 * @GetMapping("/employees")
	 * 
	 * @GetMapping("/employees/new")
	 * 
	 * @PostMapping("/employees")
	 * 
	 * @GetMapping("/employees/edit/{id}")
	 * 
	 * @DeleteMapping("/employees/{id}")
	 * 
	 * @PostMapping("/employees")
	 */
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// handler method to handle list employees and return mode and view
	@GetMapping("/employees")
	public String listemployees(Model theModel) {
		theModel.addAttribute("employee", employeeService);
		return "employees/employee-form";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model theModel) {

		// create employee object to hold employee form data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/create_employee-form";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return "redirect/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeform(@PathVariable Long id, Model theModel) {
		theModel.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee-form";
	}

	@PostMapping("employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee theEmployee) {
		// get employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		//existingEmployee.setId(id);
		existingEmployee.setfName(theEmployee.getfName());
		existingEmployee.setlName(theEmployee.getlName());
		existingEmployee.setEmail(theEmployee.getEmail());

		// save updated employee object
		employeeService.updateEmployee(existingEmployee);
		return "/employees/update_employee-form";

	}
	//handler method to handle delete request
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect/employees";
		
	}

}

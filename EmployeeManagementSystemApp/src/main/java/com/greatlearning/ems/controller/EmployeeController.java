package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.serviceImpl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service;
	
	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		
		service = employeeServiceImpl;
	}

	@GetMapping("/all_employees")
	public String findAllEmployees(Model model) {
		
		List<Employee> employeeList = this.service.findAllEmployees();
		model.addAttribute("employees",employeeList);
		
		return "employees/employees-list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		
		this.service.saveEmployee(employee);
		
		return "redirect:/employees/all_employees";
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		
		Employee newEmployee = new Employee();
		
		model.addAttribute("employee",newEmployee);
		
		return "employees/employee-create-form";
	}
	
	@PostMapping("/update")
	public String showFormForUpdate(@RequestParam("id")long id, Model model) {

		Employee updateEmployee = service.findEmployeeById(id);

		model.addAttribute("employee", updateEmployee);

		return "employees/employee-update-form";
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id")long id) {
		
		this.service.deleteEmployeeById(id);
		return "redirect:/employees/all_employees";
	}
}

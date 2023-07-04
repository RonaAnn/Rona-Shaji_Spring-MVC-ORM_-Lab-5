package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(long id);

	public void deleteEmployeeById(long id);

}

package com.greatlearning.ems.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements com.greatlearning.ems.service.EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

		repository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return this.repository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {

		return this.repository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {

		Optional<Employee> employee = this.repository.findById(id);
		if (employee.isPresent()) {

			return employee.get();
		}

		throw new IllegalArgumentException("Invalid Employee id passed.");
	}

	public Employee updateEmployee(long id, Employee employee) {
		
		Optional<Employee> findEmployee = this.repository.findById(id);
		if (findEmployee.isPresent()) {

			Employee updatedEmployee = findEmployee.get();
			updatedEmployee.setFirstName(employee.getFirstName());
			updatedEmployee.setLastName(employee.getLastName());
			updatedEmployee.setEmail(employee.getEmail());
			
			repository.save(updatedEmployee);
		}
		
		return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {

		this.repository.deleteById(id);
	}

}

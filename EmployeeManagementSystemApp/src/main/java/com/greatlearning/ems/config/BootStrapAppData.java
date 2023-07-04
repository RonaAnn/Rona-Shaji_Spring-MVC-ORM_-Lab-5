package com.greatlearning.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;

@Configuration
public class BootStrapAppData {

	@Autowired
	private EmployeeRepository repository;

	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent event) {

		Employee emp1 = new Employee();
		emp1.setFirstName("Robert");
		emp1.setLastName("Pattinson");
		emp1.setEmail("robert.pattinson@gmail.com");
		repository.save(emp1);

		Employee emp2 = new Employee();
		emp2.setFirstName("Anne");
		emp2.setLastName("Hathway");
		emp2.setEmail("hathwayAnne@gmail.com");
		repository.save(emp2);

		Employee emp3 = new Employee();
		emp3.setFirstName("Kate");
		emp3.setLastName("Winslet");
		emp3.setEmail("katierose@gmail.com");
		repository.save(emp3);

		Employee emp4 = new Employee();
		emp4.setFirstName("Keanu");
		emp4.setLastName("Reeves");
		emp4.setEmail("keanu.reeves@hotmail.com");
		repository.save(emp4);
	}
}

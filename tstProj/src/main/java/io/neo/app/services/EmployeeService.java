package io.neo.app.services;

import java.util.List;


import io.neo.app.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(int eId);
	
	public List<Employee> findEmployeesByBankId(Integer bId);

	public Employee updateEmployee(Employee emp);
	
	public List<Employee> findByEmployeeId(Integer employeeid);

	public void addEmployee(Employee empUp);
	
	

}

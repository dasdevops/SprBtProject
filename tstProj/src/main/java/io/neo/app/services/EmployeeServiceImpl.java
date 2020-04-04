package io.neo.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.neo.app.dao.EmployeeDao;
import io.neo.app.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee(){
		return (List<Employee>) employeeDao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int eId) {
		return employeeDao.getEmployee(eId);
	}

	@Override
	public List<Employee> findEmployeesByBankId(Integer bId) {
		return employeeDao.findEmployeesByBankId(bId);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public List<Employee> findByEmployeeId(Integer employeeid) {
		return employeeDao.findByEmployeeId(employeeid);
	}

	@Override
	public void addEmployee(Employee empUp) {
		employeeDao.addEmployee(empUp);
		
	}
	
}

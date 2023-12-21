package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employee;

@Service
public class EmployeeService {
		
	@Autowired
	private EmployeeDao empDao;

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}

	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}

	
	

	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDao.updateEmployeee(emp);
	}

	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDao.addEmployee(emp);
		
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empDao.deleteEmployee(id);
	}
}

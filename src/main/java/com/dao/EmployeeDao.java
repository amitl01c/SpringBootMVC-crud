package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Employee;
import com.model.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemp;
	
	public List<Employee> getAllEmployees() {
		String query = "SELECT * from employees";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		List<Employee> list = jdbcTemp.query(query, rowMapper);

		return list;
	}
	
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		String query = "Select * from employees where employee_id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee emp = jdbcTemp.queryForObject(query,rowMapper, id);
		
		return emp;
	}

	public void addEmployee(Employee emp) {
		
		String query = "insert into employees(employee_id,first_name, last_name,email,phone,job_title) values(?,?,?,?,?,?)";
		jdbcTemp.update(query, emp.getEmployeeId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPhone(),emp.getJobTitle());
		// TODO Auto-generated method stub
		
	}

	public void updateEmployeee(Employee emp) {
		// TODO Auto-generated method stub
		String query = "update employees set first_name=?,last_name=?,email=?,phone=?,job_title=? where employee_id =? ";
		jdbcTemp.update(query,emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPhone(),emp.getJobTitle(),emp.getEmployeeId());
		
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String query = "delete from employees where employee_id =?";
		jdbcTemp.update(query, id);
	}
	
	
	
}

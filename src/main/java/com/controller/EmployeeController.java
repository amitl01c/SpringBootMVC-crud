package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET )
	public ModelAndView getAllEmployee() {
		ModelAndView model = new ModelAndView();
		List<Employee> list = empService.getAllEmployee();
		
		model.addObject("employee_list",list);
		model.setViewName("emp_list");
		return model;
	}
	
	
	@RequestMapping(value="/update/{id}", method= RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable int id) {
		
		ModelAndView model = new ModelAndView();
		Employee emp = empService.findEmployeeById(id);
		
		model.addObject("employeeForm",emp);//path of form tag
		model.setViewName("emp_form"); // jsp file name given 
		return model;
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView model =new ModelAndView();
		
		Employee emp = new Employee();
		
		model.addObject("employeeForm",emp);
		model.setViewName("emp_form");
		return model;
	}
	
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView saveUpdateEmployee(@ModelAttribute ("employeeForm") Employee emp) {
		if(emp.getEmployeeId() != null) {
			empService.updateEmployee(emp);
		}
		else {
			empService.addEmployee(emp);
		}
		return new ModelAndView("redirect:/emp/list");
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);

		return new ModelAndView("redirect:/emp/list");
	}
	
}

package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.DAO.EmployeeDAO;
import com.hr.pojo.Employee;

@Controller 
public class EmployeeController {
	
	@Autowired 
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/showEmployee")
	public String showEmployeeList(Model model) {
		
		List<Employee> employeeList = employeeDAO.loadEmployee();
		model.addAttribute("employees", employeeList);
		
		return "view-employee";
	}
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "add-employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		if(employee.getEmployee_id() == 0) {
			employeeDAO.saveEmployee(employee);
		}
		else {
			employeeDAO.updateEmployee(employee);
		}
		return "redirect:/showEmployee";
	}
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
		Employee theEmployee = employeeDAO.getEmployee(id);
		model.addAttribute("employee", theEmployee);
		
		return "add-employee";
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeDAO.deleteEmployee(id);
		return "redirect:/showEmployee";
	}
}








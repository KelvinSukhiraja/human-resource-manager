package com.hr.DAO;

import java.util.List;

import com.hr.pojo.Employee;

public interface EmployeeDAO {
	
	List<Employee> loadEmployee();

	void saveEmployee(Employee employee);

	Employee getEmployee(int id);

	void deleteEmployee(int id);

	void updateEmployee(Employee employee);
	
}

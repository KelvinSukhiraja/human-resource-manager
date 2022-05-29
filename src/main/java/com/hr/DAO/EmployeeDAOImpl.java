package com.hr.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.pojo.Employee;
import com.hr.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired 
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<Employee> loadEmployee() {
		
		String sql = "SELECT * FROM employees";
		
		List<Employee> listofemployee = jdbctemplate.query(sql, new EmployeeRowMapper());
		
		return listofemployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Object[] sqlParameters = {employee.getEmployee_address(), employee.getEmployee_name(), employee.getEmployee_education(), employee.getEmployee_gender(), employee.getEmployee_job(), employee.getEmployee_email(), employee.getEmployee_dept(), employee.getEmployee_phone()};
		String sql = "INSERT INTO employees(employee_address,employee_name,employee_education,employee_gender,employee_job,employee_email,employee_dept,employee_phone) VALUES (?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql, sqlParameters);
	}

	@Override
	public Employee getEmployee(int id) {
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		Employee employee = jdbctemplate.queryForObject(sql, new EmployeeRowMapper(), id);
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		String sql = "DELETE FROM employees WHERE employee_id = ?";
		jdbctemplate.update(sql, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE employees SET employee_address = ?, employee_name = ?, employee_education = ?, employee_gender = ?, employee_job = ?, employee_email = ?, employee_dept = ?, employee_phone = ? WHERE employee_id = ?";
		jdbctemplate.update(sql, employee.getEmployee_address(), employee.getEmployee_name(), employee.getEmployee_education(), employee.getEmployee_gender(), employee.getEmployee_job(), employee.getEmployee_email(), employee.getEmployee_dept(), employee.getEmployee_phone(), employee.getEmployee_id());
	}

}

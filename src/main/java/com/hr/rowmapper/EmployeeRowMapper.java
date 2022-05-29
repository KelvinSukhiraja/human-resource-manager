package com.hr.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.pojo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		
		employee.setEmployee_id(rs.getInt("employee_id")); 
		employee.setEmployee_address(rs.getString("employee_address"));
		employee.setEmployee_name(rs.getString("employee_name"));
		employee.setEmployee_education(rs.getString("employee_education"));
		employee.setEmployee_gender(rs.getString("employee_gender"));
		employee.setEmployee_job(rs.getString("employee_job"));
		employee.setEmployee_created_date(rs.getString("employee_created_date"));
		employee.setEmployee_email(rs.getString("employee_email"));
		employee.setEmployee_dept(rs.getString("employee_dept"));
		employee.setEmployee_phone(rs.getLong("employee_phone"));
		
		return employee;
	}

}

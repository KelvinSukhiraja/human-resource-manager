package com.hr.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.pojo.Dept;

public class DeptRowMapper implements RowMapper<Dept> {

	@Override
	public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Dept dept = new Dept();
		
		dept.setId(rs.getInt("id"));
		dept.setDept_name(rs.getString("dept_name"));
		dept.setDept_details(rs.getString("dept_details"));
		
		return dept;
	}

}

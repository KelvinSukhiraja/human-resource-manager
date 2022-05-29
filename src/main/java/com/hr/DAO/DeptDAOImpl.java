package com.hr.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.pojo.Dept;
import com.hr.rowmapper.DeptRowMapper;

@Repository
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired 
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<Dept> loadDepts() {
		
		String sql = "SELECT * FROM departments";
		
		List<Dept> listofdept = jdbctemplate.query(sql, new DeptRowMapper());
		
		return listofdept;
	}

	@Override
	public void saveDept(Dept dept) {
		Object[] sqlParameters = {dept.getDept_name(), dept.getDept_details()};
		String sql = "INSERT INTO departments(dept_name, dept_details) VALUES (?,?)";
		jdbctemplate.update(sql, sqlParameters);
	}

	@Override
	public Dept getDept(int id) {
		String sql = "SELECT * FROM departments WHERE id = ?";
		Dept dept = jdbctemplate.queryForObject(sql, new DeptRowMapper(), id);
		return dept;
	}

	@Override
	public void updateDept(Dept dept) {
		String sql = "UPDATE departments SET dept_name = ?, dept_details = ? WHERE id = ?";
		jdbctemplate.update(sql, dept.getDept_name(), dept.getDept_details(), dept.getId());
	}

	@Override
	public void deleteDept(int id) {
		String sql = "DELETE FROM departments WHERE id = ?";
		jdbctemplate.update(sql, id);
	}
	
}

package com.hr.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.pojo.User;
import com.hr.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO users(username, password, enabled, name) VALUES (?,?,?,?)";
		String sql2 = "INSERT INTO authorities(username, authority) VALUES (?,?)";
		jdbctemplate.update(sql, user.getUsername(), user.getPassword(), 1, user.getName());
		jdbctemplate.update(sql2, user.getUsername(), "USER");
	}

	@Override
	public List<User> loadUser() {
		String sql = "SELECT * FROM users";
		
		List<User> listUser = jdbctemplate.query(sql, new UserRowMapper());
		
		return listUser;
	}
}

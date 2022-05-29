package com.hr.DAO;

import java.util.List;

import com.hr.pojo.User;

public interface UserDAO {

	void saveUser(User user);

	List<User> loadUser();
	
}

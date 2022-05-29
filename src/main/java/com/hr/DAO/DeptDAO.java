package com.hr.DAO;

import java.util.List;

import com.hr.pojo.Dept;

public interface DeptDAO {
	
	List<Dept> loadDepts();

	void saveDept(Dept dept);

	Dept getDept(int id);

	void updateDept(Dept dept);

	void deleteDept(int id);

}

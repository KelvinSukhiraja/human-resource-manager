package com.hr.DAO;

import java.util.List;

import com.hr.pojo.Job;

public interface JobDAO {
	List <Job> loadJob();

	void saveJob(Job job);

	void updateJob(Job job);

	Job getJob(int id);

	void deleteJob(int id);
}

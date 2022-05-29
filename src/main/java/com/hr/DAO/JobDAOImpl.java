package com.hr.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.pojo.Job;
import com.hr.rowmapper.JobRowMapper;

@Repository
public class JobDAOImpl implements JobDAO {
	@Autowired 
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<Job> loadJob() {
		
		String sql = "SELECT * FROM jobs";
		
		List<Job> listjob = jdbctemplate.query(sql, new JobRowMapper());
		
		return listjob;
	}

	@Override
	public void saveJob(Job job) {
		Object[] sqlParameters = {job.getJob_name(), job.getJob_details()};
		String sql = "INSERT INTO jobs(job_name, job_details) VALUES (?,?)";
		jdbctemplate.update(sql, sqlParameters);
	}

	@Override
	public void updateJob(Job job) {
		String sql = "UPDATE jobs SET job_name = ?, job_details = ? WHERE id = ?";
		jdbctemplate.update(sql, job.getJob_name(), job.getJob_details(), job.getId());
	}

	@Override
	public Job getJob(int id) {
		String sql = "SELECT * FROM jobs WHERE id = ?";
		Job job = jdbctemplate.queryForObject(sql, new JobRowMapper(), id);
		return job;
	}

	@Override
	public void deleteJob(int id) {
		String sql = "DELETE FROM jobs WHERE id = ?";
		jdbctemplate.update(sql, id);
	}

}

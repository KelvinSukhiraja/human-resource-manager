package com.hr.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.pojo.Job;

public class JobRowMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
		Job job = new Job();
		
		job.setId(rs.getInt("id"));
		job.setJob_name(rs.getString("job_name"));
		job.setJob_details(rs.getString("job_details"));
		
		return job;
	}

}

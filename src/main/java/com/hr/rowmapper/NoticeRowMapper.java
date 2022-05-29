package com.hr.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.pojo.Notice;

public class NoticeRowMapper implements RowMapper<Notice> {
	
	
	@Override
	public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notice notice = new Notice();
		
		notice.setIdnotices(rs.getInt("idnotices"));
		notice.setNotice_name(rs.getString("notice_name"));
		notice.setNotice_content(rs.getString("notice_content"));
		notice.setNotice_creation_time(rs.getString("notice_creation_time"));
		notice.setNotice_publisher(rs.getString("notice_publisher"));
		
		return notice;
	}

}

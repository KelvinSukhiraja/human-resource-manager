package com.hr.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.pojo.Notice;
import com.hr.pojo.User;
import com.hr.rowmapper.NoticeRowMapper;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<Notice> loadNotice() {
		
		String sql = "SELECT * FROM notices";
		
		List<Notice> listofnotice = jdbctemplate.query(sql, new NoticeRowMapper());
		
		return listofnotice;
	}
	
	@Override
	public void saveNotice(Notice notice, String username) {
		Object[] sqlParameters = {notice.getNotice_name(), notice.getNotice_content(), username};
		String sql = "INSERT INTO notices(notice_name, notice_content, notice_publisher) VALUES (?,?,?)";
		jdbctemplate.update(sql, sqlParameters);
	}

	@Override
	public void updateNotice(Notice notice) {
		String sql = "UPDATE notices SET notice_name = ?, notice_content = ?, notice_publisher = ? WHERE idnotices = ?";
		jdbctemplate.update(sql, notice.getNotice_name(), notice.getNotice_content(), notice.getNotice_publisher(), notice.getIdnotices());
	}

	@Override
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM notices WHERE idnotices = ?";
		Notice notice = jdbctemplate.queryForObject(sql, new NoticeRowMapper(), id);
		return notice;
	}

	@Override
	public void deleteNotice(int id) {
		String sql = "DELETE FROM notices WHERE idnotices = ?";
		jdbctemplate.update(sql, id);
	}

}

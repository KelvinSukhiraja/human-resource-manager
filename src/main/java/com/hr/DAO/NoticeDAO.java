package com.hr.DAO;

import java.util.List;

import com.hr.pojo.Notice;

public interface NoticeDAO {
	
	List<Notice> loadNotice();

	void saveNotice(Notice notice, String username);

	void updateNotice(Notice notice);

	Notice getNotice(int id);

	void deleteNotice(int id);
	
}

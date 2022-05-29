package com.hr.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.DAO.NoticeDAO;
import com.hr.pojo.Notice;

@Controller 
public class NoticeController {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@GetMapping("/showNotice")
	public String showNoticeList(Model model) {
		
		List<Notice> noticeList = noticeDAO.loadNotice();
		model.addAttribute("notices", noticeList);
		
		return "view-notice";
	}
	@GetMapping("/addNotice")
	public String addNotice(Model model) {
		Notice notice = new Notice();
		model.addAttribute("notice", notice);
		
		return "add-notice";
	}
	@PostMapping("/saveNotice")
	public String saveNotice(Notice notice, Principal principal) {
		String username = principal.getName();
		if(notice.getIdnotices() == 0) {
			noticeDAO.saveNotice(notice, username);
		}
		else {
			noticeDAO.updateNotice(notice);
		}
		return "redirect:/showNotice";
	}
	@GetMapping("/updateNotice")
	public String updateNotice(@RequestParam("noticeId") int id, Model model) {
		Notice theNotice = noticeDAO.getNotice(id);
		model.addAttribute("notice", theNotice);
		
		return "add-notice";
	}
	@GetMapping("/deleteNotice")
	public String deleteNotice(@RequestParam("noticeId") int id) {
		noticeDAO.deleteNotice(id);
		return "redirect:/showNotice";
	}
}

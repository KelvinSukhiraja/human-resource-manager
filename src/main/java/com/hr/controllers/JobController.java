package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.DAO.JobDAO;
import com.hr.pojo.Job;

@Controller 
public class JobController {

	@Autowired
	private JobDAO jobDAO;
	
	@GetMapping("/showJob")
	public String showJobList(Model model) {
		
		List<Job> jobList = jobDAO.loadJob();
		model.addAttribute("jobs", jobList);
		
		return "view-job";
	}
	
	@GetMapping("/addJob")
	public String addjob(Model model) {
		
		Job job = new Job();
		model.addAttribute("job", job);
		
		return "add-job";
	}
	
	@PostMapping("/saveJob")
	public String saveJob(Job job) {
		if(job.getId()==0) {
			jobDAO.saveJob(job);
		}
		else {
			jobDAO.updateJob(job);
		}
		return "redirect:/showJob";
	}
	
	@GetMapping("/updateJob")
	public String updateJob(@RequestParam("jobId") int id, Model model) {
		Job theJob = jobDAO.getJob(id);
		model.addAttribute("job", theJob);
		
		return "add-job";
	}
	
	@GetMapping("/deleteJob")
	public String deleteJob(@RequestParam("jobId") int id) {
		jobDAO.deleteJob(id);
		return "redirect:/showJob";
	}
}

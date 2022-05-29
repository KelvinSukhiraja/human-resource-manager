package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.DAO.DeptDAO;
import com.hr.pojo.Dept;

@Controller 
public class DeptController {
		@Autowired 
		private DeptDAO deptDAO;
		
		@GetMapping("/showDept")
		public String showDeptList(Model model) {
			
			List<Dept> deptList = deptDAO.loadDepts(); 
			model.addAttribute("depts", deptList);	
			
			return "view-dept";
		}
		
		@GetMapping("/addDept")
		public String addDept(Model model) {
			
			Dept dept = new Dept();
			model.addAttribute("dept", dept);
			
			return "add-dept";
		}
		
		@PostMapping("/saveDept")
		public String saveDept(Dept dept) {
			if(dept.getId() == 0) {
				deptDAO.saveDept(dept);
			}
			else {
				deptDAO.updateDept(dept);
			}
			
			return "redirect:/showDept";
		}
		
		@GetMapping("/updateDept")
		public String updateDept(@RequestParam("deptId")int id, Model model) {
			Dept theDept = deptDAO.getDept(id);
			model.addAttribute("dept", theDept);
			return "add-dept";
		}
		
		@GetMapping("/deleteDept")
		public String deleteDept(@RequestParam("deptId") int id) {
			deptDAO.deleteDept(id);
			return "redirect:/showDept";
		}
}

package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Student;
import com.spring.service.StudentService;


@Controller
public class homeController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value={"/home",""})
	public String Home(ModelMap model){
		model.addAttribute("students",studentService.getStudents());
		return "home";
	}
	
	@RequestMapping(value="/form" , method = RequestMethod.GET)
	public String getStudent(@RequestParam("state")String state, ModelMap model){
		model.addAttribute("state",state);
		model.addAttribute("student",new Student());
		return "insert";
	}
	
	@RequestMapping(value="/pupdate" , method = RequestMethod.GET)
	public String prepareStudent(@RequestParam("id") int id, ModelMap model){
		model.addAttribute("state","update");
		model.addAttribute("student", studentService.getStudent(id));
		return "insert";
	}
	
	@RequestMapping(value="/insert" , method = RequestMethod.POST)
	public String insertStudent(Student student, ModelMap model){
		studentService.insertStudent(student);
		model.addAttribute("students",studentService.getStudents());
		return "home";
	}
	
	@RequestMapping(value="/update" , method = RequestMethod.POST)
	public String updateStudent(Student student, ModelMap model){
		studentService.updateStudent(student);
		model.addAttribute("students",studentService.getStudents());
		return "home";
	}
	
	@RequestMapping(value="/delete" , method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") int id, ModelMap model){
		studentService.deleteStudent(id);
		model.addAttribute("students",studentService.getStudents());
		return "home";
	}
}

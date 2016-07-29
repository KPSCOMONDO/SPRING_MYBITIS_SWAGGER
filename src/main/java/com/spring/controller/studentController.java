package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Student;
import com.spring.service.StudentService;

@Controller
public class studentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value={"/gets"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getStudents(){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			ArrayList<Student> student = studentService.getStudents();
			if(!student.isEmpty()){
				map.put("DATA", student);
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA FOUND!");
			}else{
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA NOT FOUND!");
			}
		}catch(Exception e){
				map.put("STATUS", false);
				map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map ,HttpStatus.OK) ;
	}
	@RequestMapping(value={"/get/{id}"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Student> getStudent(@PathVariable("id")int id ){
		return new ResponseEntity<Student>(studentService.getStudent(id),HttpStatus.OK);
	}
	
		
}

package com.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring.model.Student;
@Service
public interface StudentService {

	public ArrayList<Student> getStudents();
	public Student getStudent(int id);
	public boolean updateStudent(Student student);
	public boolean insertStudent(Student student);
	public boolean deleteStudent(int id);
}

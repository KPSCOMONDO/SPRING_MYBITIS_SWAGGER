package com.spring.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public ArrayList<Student> getStudents() {
		return studentRepository.getStudents();
	}
	@Override
	public boolean updateStudent(Student student) {
		return studentRepository.ubdateStudent(student);
	}
	@Override
	public boolean insertStudent(Student student) {
		return studentRepository.insertStudent(student);
	}
	@Override
	public boolean deleteStudent(int id) {
		return studentRepository.deletStudent(id);
	}
	@Override
	public Student getStudent(int id) {
		return studentRepository.getStudent(id);
	}


}

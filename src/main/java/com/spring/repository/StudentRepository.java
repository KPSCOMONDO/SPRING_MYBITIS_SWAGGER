package com.spring.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;

//@Repository
public interface StudentRepository {
	public final String RS_STUDENT="Select * from tbstudent";
	public final String R_STUDENT="Select * from tbstudent where stu_id=#{id}";
	public final String D_STUDENT="Delete from tbstudent where stu_id=#{id}";
	public final String I_STUDENT="Insert into tbstudent values(#{id},#{name})";
	public final String U_STUDENT="Update tbstudent set stu_name=#{name} where stu_id=#{id}";
	
	@Results(value={
			@Result(property="id" , column="stu_id"),
			@Result(property="name" , column="stu_name")
	})
	@Select(RS_STUDENT)
	public ArrayList<Student> getStudents();
	
	@Results(value={
			@Result(property="id" , column="stu_id"),
			@Result(property="name" , column="stu_name")
	})
	@Select(R_STUDENT)
	public Student getStudent(int id);
	
	@Update(U_STUDENT)
	public boolean ubdateStudent(Student student);
	@Delete(D_STUDENT)
	public boolean deletStudent(int id);
	
	@Insert(I_STUDENT)
	public boolean insertStudent(Student student);
	/*public ArrayList<Student> getStudents();
	public Student getStudent(int id);
	public boolean deleteStudent(Student student);
	public boolean insertStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(int id);
	*/
}

package com._520it._02_smis.dao;

import java.util.List;

import com._520it._02_smis.domain.Student;

public interface IStudentDao {
	
	void set(Student stu);
	
	void delete(Long id);
	
	void update(Long id,Student stu);

	Student get(Long id);
	
	List<Student> listAll();
}

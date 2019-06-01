package com._520it._02_smis.test;

import java.util.List;

import org.junit.Test;

import com._520it._02_smis.dao.IStudentDao;
import com._520it._02_smis.dao.impl.StudentDaoImpl;
import com._520it._02_smis.domain.Student;

public class StudentDaoTest {
IStudentDao student=new StudentDaoImpl();
	@Test
	public void testSet() {
		Student stu=new Student();
		stu.setName("AA");
		stu.setAge(22);
		student.set(stu);
	}

	@Test
	public void testDelete() {
		student.delete(18L);
	}

	@Test
	public void testUpdate() {
		Student stu=new Student();
		stu.setName("bb");
		stu.setAge(88);
		student.update(19L, stu);
	}

	@Test
	public void testGet() {
		Student stu=student.get(19L);
		System.out.println(stu);
	}

	@Test
	public void testListAll() {
		List<Student> list=student.listAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

}

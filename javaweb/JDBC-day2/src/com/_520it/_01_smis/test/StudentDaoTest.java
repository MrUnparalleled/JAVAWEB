package com._520it._01_smis.test;

import java.util.List;

import org.junit.Test;

import com._520it._01_smis.dao.IStudentDao;
import com._520it._01_smis.dao.impl.StudentDaoImpl;
import com._520it._01_smis.domain.Student;
//Dao����Ĳ����࣬���Ե�����Dao���
public class StudentDaoTest {

	
	
	private IStudentDao studentDao=new StudentDaoImpl();
	@Test
	public void testSave() {
		Student stu=new Student();
		stu.setAge(11);
		stu.setName("����Ⱥ");
		studentDao.save(stu);
		
	}

	@Test
	public void testDelete() {
		studentDao.delete(13L);
	}

	@Test
	public void testUpdate() {
		Student student=new Student();
		student.setAge(22);
		student.setName("����");
		studentDao.update(17L, student);
	}

	@Test
	public void testGet() {
		Student stu=studentDao.get(15L);
		System.out.println(stu);
		
	}

	@Test
	public void testListsAll() {
		List<Student> stus=studentDao.listsAll();
		for (Student student : stus) {
			System.out.println(student);
		}
		
	}

}

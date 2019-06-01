package com._520it._01_smis.dao;

import java.util.List;

import com._520it._01_smis.domain.Student;

//封装Student对象的CRUD操作

public interface IStudentDao {
	
	/**
	 * 保存操作
	 * @param stu 学生对象，封装了需要保存的信息
	 */
	void save(Student stu);
	
	/**
	 * 删除操作
	 * @param id  被删除学生的主键值
	 */
	void delete(Long id);
	/**
	 * 更新操作
	 * @param id  被更改学生的主键值
	 * @param newstu  学生的新的信息 
	 */
	void update(Long id,Student newstu);
	/**
	 * 查询指定ID的学生信息
	 * @param id    被查询的学生的主键值
	 * @return      如果id存在，返回该学生对象，否则返回null
	 */
	Student get(Long id);
	
	/**
	 * 查询并返回所有的学生信息
	 * @return  如果结果集为空，返回一个空的list对象
	 */
	List<Student> listsAll();
}

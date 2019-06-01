package com._520it._01_smis.dao;

import java.util.List;

import com._520it._01_smis.domain.Student;

//��װStudent�����CRUD����

public interface IStudentDao {
	
	/**
	 * �������
	 * @param stu ѧ�����󣬷�װ����Ҫ�������Ϣ
	 */
	void save(Student stu);
	
	/**
	 * ɾ������
	 * @param id  ��ɾ��ѧ��������ֵ
	 */
	void delete(Long id);
	/**
	 * ���²���
	 * @param id  ������ѧ��������ֵ
	 * @param newstu  ѧ�����µ���Ϣ 
	 */
	void update(Long id,Student newstu);
	/**
	 * ��ѯָ��ID��ѧ����Ϣ
	 * @param id    ����ѯ��ѧ��������ֵ
	 * @return      ���id���ڣ����ظ�ѧ�����󣬷��򷵻�null
	 */
	Student get(Long id);
	
	/**
	 * ��ѯ���������е�ѧ����Ϣ
	 * @return  ��������Ϊ�գ�����һ���յ�list����
	 */
	List<Student> listsAll();
}

package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.AdminCategoryDao;
import com._520it.domain.Category;

public class AdminCategoryService {

	/**
	 * ��ѯ������Ʒ������Ϣ
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		List<Category> categoryList = dao.findAllCategory();
		return categoryList;
		
	}

	/**
	 * �����Ʒ���ķ���
	 * @throws SQLException 
	 */
	public void addCategory(Category category) throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.addCategory(category);
	}

	/**
	 * ����ɾ����Ʒ���ķ���
	 * @param cid
	 * @throws SQLException 
	 */
	public void delCategory(String cid) throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.delCategory(cid);
	}

	/**
	 * ������Ʒ���
	 * @param category
	 * @throws SQLException
	 */
	public void editCategory(Category category) throws SQLException {
		//������Ͳ������ݸ�dao��
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.editCategory(category);
	}

	/**
	 * ��ѯ��Ʒ������ǰ����Ϣ������id��ѯ��Ʒ��Ϣ��
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public Category findCategoryByID(String cid) throws SQLException {
		//������Ͳ�������dao��
		AdminCategoryDao dao =new AdminCategoryDao();
		Category category =dao.findCategoryByID(cid);
		return category;
		
	}

}

package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.AdminCategoryDao;
import com._520it.domain.Category;

public class AdminCategoryService {

	/**
	 * 查询所有商品类别的信息
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		List<Category> categoryList = dao.findAllCategory();
		return categoryList;
		
	}

	/**
	 * 添加商品类别的方法
	 * @throws SQLException 
	 */
	public void addCategory(Category category) throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.addCategory(category);
	}

	/**
	 * 根据删除商品类别的方法
	 * @param cid
	 * @throws SQLException 
	 */
	public void delCategory(String cid) throws SQLException {
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.delCategory(cid);
	}

	/**
	 * 更新商品类别
	 * @param category
	 * @throws SQLException
	 */
	public void editCategory(Category category) throws SQLException {
		//将请求和参数传递给dao层
		AdminCategoryDao dao =new AdminCategoryDao();
		dao.editCategory(category);
	}

	/**
	 * 查询商品类别更改前的信息（根据id查询商品信息）
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public Category findCategoryByID(String cid) throws SQLException {
		//将请求和参数传给dao层
		AdminCategoryDao dao =new AdminCategoryDao();
		Category category =dao.findCategoryByID(cid);
		return category;
		
	}

}

package com._520it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com._520it.domain.Category;
import com._520it.utils.DataSourceUtils;

public class AdminCategoryDao {

	/**
	 * ��ѯ���е���Ʒ�����Ϣ
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		List<Category> categories = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return categories;
	}

	/**
	 * �����Ʒ���
	 * @throws SQLException 
	 */
	public void addCategory(Category category) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into category values(?,?)";
		runner.update(sql,category.getCid(),category.getCname());
	}

	/**
	 * ɾ����Ʒ���
	 * @param cid
	 * @throws SQLException
	 */
	public void delCategory(String cid) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from category where cid=?";
		runner.update(sql,cid);
	}
	/**
	 * ������Ʒ���
	 * @param category
	 * @throws SQLException
	 */
	public void editCategory(Category category) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update category set cname=? where cid=?";
		runner.update(sql,category.getCname(),category.getCid());
		//System.out.println(category.getCname());
		//System.out.println(category.getCid());
	}
	
	/**
	 * ����cid��ѯ��Ʒ�����Ϣ
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public Category findCategoryByID(String cid) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category where cid=?";
		Category category = runner.query(sql, new BeanHandler<Category>(Category.class), cid);
		return category;
	}

}

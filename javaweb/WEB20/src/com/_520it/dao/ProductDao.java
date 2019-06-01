package com._520it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com._520it.domain.Product;
import com._520it.utils.DataSourceUtils;

public class ProductDao {
	//查询所有的商品信息
	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
		
	}

	//查询全部的商品信息条数
	public int getTotalCount() throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from product";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		return query.intValue();
	}
	//查询当前页的商品信息
	public List<Product> finCurrentProduct(int currentIndex, int currentCount) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from product limit ?,?";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class),currentIndex,currentCount);
		return list;
	}

	public List<Object> search(String pname) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select pname from product where pname like ? limit 0,8";
		List<Object> list = runner.query(sql, new ColumnListHandler("pname"), "%"+pname+"%");
		System.out.println(pname);
		return list;
	}

}

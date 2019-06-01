package com._520it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com._520it.domain.Product;
import com._520it.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		//Êý¾Ý¿â´úÂë
		
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

	public Product findProduct(String pid) {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid ="+pid;
		return null;
	}

}

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
	//��ѯ���е���Ʒ��Ϣ
	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
		
	}

	//��ѯȫ������Ʒ��Ϣ����
	public int getTotalCount() throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from product";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		return query.intValue();
	}
	//��ѯ��ǰҳ����Ʒ��Ϣ
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

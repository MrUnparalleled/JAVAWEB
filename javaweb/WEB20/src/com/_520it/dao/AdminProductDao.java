package com._520it.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com._520it.domain.Category;
import com._520it.domain.Product;
import com._520it.utils.DataSourceUtils;
import com._520it.vo.Select;

public class AdminProductDao {

	/**
	 * 查询所有的商品信息
	 * @return
	 * @throws SQLException
	 */
	public List<Product> finaAllProduct() throws SQLException {

		//加载核心类
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		//sql语句
		String sql="select * from product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}
	/**
	 * 查询所有的商品类别信息
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return list;
	}
	/**
	 * 添加商品
	 * @param product
	 * @throws SQLException
	 */
	public int addProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into product values(?,?,?,?,?,?,?,?,?,?)";
		Object[] param= {product.getPid(),product.getPname(),
				product.getMarket_price(),product.getShop_price(),
				product.getPimage(),product.getPdate(),product.getIs_hot(),
				product.getPdesc(),product.getPflag(),product.getCid()};
		int update = runner.update(sql, param);
		return update;
	}
	/**
	 * 删除商品的方法
	 * @param pid
	 * @throws SQLException
	 */
	public void delProduct(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="delete from product where pid=?";
		runner.update(sql,pid);
		
	}
	public Product findProduct(String pid) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
		
	}
	public void editProduct(Product product) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set pname=?,market_price=?,shop_price=?,is_hot=?,pdesc=?,cid=?,pdate=?,pflag=? where pid=?";
		runner.update(sql, product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getIs_hot(),product.getPdesc(),
				product.getCid(),product.getPdate(),product.getPflag(),product.getPid());
		
	}
	public List<Product> selectProduct(Select select) throws SQLException {
		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		List<String> param =new ArrayList<String>();
		String sql ="select * from product where 1=1";
		if (!select.getCid().trim().equals("")&&select.getCid()!=null) {
			sql+=" and cid=?";
			param.add(select.getCid().trim());
		}
		if (!select.getIs_hot().trim().equals("")&&select.getIs_hot()!=null) {
			sql+=" and is_hot=?";
			param.add(select.getIs_hot().trim());
		}
		if (!select.getPname().trim().equals("")&&select.getPname()!=null) {
			sql+=" and pname like ?";
			param.add("%"+select.getPname().trim()+"%");
		}
		List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class), param.toArray());
		
		return products;
	}



}

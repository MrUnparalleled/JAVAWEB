package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.AdminProductDao;
import com._520it.domain.Category;
import com._520it.domain.Product;
import com._520it.vo.Select;

public class AdminProductService {

	/**
	 * 查询所有商品的方法
	 * @return 所有的商品集合
	 */
	public List<Product> findAllProduct() {
		//因为没有复杂的业务，直接传递请求就ok
		List<Product> list=null;
		//调用dao层的方法查询所有的商品信息
		AdminProductDao dao =new AdminProductDao();
		try {
			list = dao.finaAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	/**
	 * 查询所有商品类别的方法
	 * @return 所有的商品类别的集合
	 * @throws SQLException 
	 */
	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao =new AdminProductDao();
		List<Category> categoryList = dao.findAllCategory();
		return categoryList;
		
	}

	/**
	 * 添加商品
	 * @param product
	 * @throws SQLException 
	 */
	public int addProduct(Product product) throws SQLException {
		AdminProductDao dao =new AdminProductDao();
		return dao.addProduct(product);
	}

	/**
	 * 删除商品的方法
	 * @param pid
	 * @throws SQLException
	 */
	public void delProduct(String pid) throws SQLException {
		//没有复杂的业务，将请求和参数传递给dao层
		AdminProductDao dao=new AdminProductDao();
		dao.delProduct(pid);
	}

	/**
	 * 根据id查询商品信息
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product editProduct(String pid) throws SQLException {
		//将参数传递到dao层
		AdminProductDao dao = new AdminProductDao();
		Product product = dao.findProduct(pid);
		
		return product;
		
	}

	/**
	 * 更新商品信息的方法
	 * @param product
	 * @throws SQLException 
	 */
	public void editProduct(Product product) throws SQLException {
		
		//将请求和参数传递给dao层
		AdminProductDao dao = new AdminProductDao();
		dao.editProduct(product);
	}

	public List<Product> selectProduct(Select select) throws SQLException {
		//将请求和参数传递给dao层
		AdminProductDao dao =new AdminProductDao();
		List<Product> product = dao.selectProduct(select);
		return product;
		
	}

}

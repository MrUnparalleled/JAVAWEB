package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.ProductDao;
import com._520it.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		//没有复杂业务
		//传递请求到dao层
		ProductDao dao=new ProductDao();
		List<Product> list =dao.findAllProduct();
		return list;
	}

	public Product findProduct(String pid) {
		ProductDao dao =new ProductDao();
		Product product = dao.findProduct(pid);
		return product;
	}

}

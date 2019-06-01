package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.ProductDao;
import com._520it.domain.Product;
import com._520it.vo.PageBean;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		//将请求和数据传递到dao层
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAllProduct();
		return list;
	}

	public PageBean<Product> getPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao dao =new ProductDao();
		
		PageBean<Product> pageBean =new PageBean<Product>();
		//当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//当前商品条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//总商品数private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//总页数private int totalPage;
		int totalPage =(int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//当前页商品信息private List<T> ProductList = new ArrayList<T>();
		int currentIndex = (currentPage-1)*currentCount;
		List<Product> productList = dao.finCurrentProduct(currentIndex,currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}

	/**
	 * 主页面的搜索框
	 * @param pname 
	 * @return 
	 * @throws SQLException 
	 */
	public List<Object> search(String pname) throws SQLException {
		//将请求和数据传递给dao层
		ProductDao dao =new ProductDao();
		List<Object> list = dao.search(pname);
		return list;
		
	}

}

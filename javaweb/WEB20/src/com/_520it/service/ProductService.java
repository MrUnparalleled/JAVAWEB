package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.ProductDao;
import com._520it.domain.Product;
import com._520it.vo.PageBean;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		//����������ݴ��ݵ�dao��
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAllProduct();
		return list;
	}

	public PageBean<Product> getPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao dao =new ProductDao();
		
		PageBean<Product> pageBean =new PageBean<Product>();
		//��ǰҳprivate int currentPage;
		pageBean.setCurrentPage(currentPage);
		//��ǰ��Ʒ����private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//����Ʒ��private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//��ҳ��private int totalPage;
		int totalPage =(int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//��ǰҳ��Ʒ��Ϣprivate List<T> ProductList = new ArrayList<T>();
		int currentIndex = (currentPage-1)*currentCount;
		List<Product> productList = dao.finCurrentProduct(currentIndex,currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}

	/**
	 * ��ҳ���������
	 * @param pname 
	 * @return 
	 * @throws SQLException 
	 */
	public List<Object> search(String pname) throws SQLException {
		//����������ݴ��ݸ�dao��
		ProductDao dao =new ProductDao();
		List<Object> list = dao.search(pname);
		return list;
		
	}

}

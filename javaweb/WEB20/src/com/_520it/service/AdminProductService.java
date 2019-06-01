package com._520it.service;

import java.sql.SQLException;
import java.util.List;

import com._520it.dao.AdminProductDao;
import com._520it.domain.Category;
import com._520it.domain.Product;
import com._520it.vo.Select;

public class AdminProductService {

	/**
	 * ��ѯ������Ʒ�ķ���
	 * @return ���е���Ʒ����
	 */
	public List<Product> findAllProduct() {
		//��Ϊû�и��ӵ�ҵ��ֱ�Ӵ��������ok
		List<Product> list=null;
		//����dao��ķ�����ѯ���е���Ʒ��Ϣ
		AdminProductDao dao =new AdminProductDao();
		try {
			list = dao.finaAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	/**
	 * ��ѯ������Ʒ���ķ���
	 * @return ���е���Ʒ���ļ���
	 * @throws SQLException 
	 */
	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao =new AdminProductDao();
		List<Category> categoryList = dao.findAllCategory();
		return categoryList;
		
	}

	/**
	 * �����Ʒ
	 * @param product
	 * @throws SQLException 
	 */
	public int addProduct(Product product) throws SQLException {
		AdminProductDao dao =new AdminProductDao();
		return dao.addProduct(product);
	}

	/**
	 * ɾ����Ʒ�ķ���
	 * @param pid
	 * @throws SQLException
	 */
	public void delProduct(String pid) throws SQLException {
		//û�и��ӵ�ҵ�񣬽�����Ͳ������ݸ�dao��
		AdminProductDao dao=new AdminProductDao();
		dao.delProduct(pid);
	}

	/**
	 * ����id��ѯ��Ʒ��Ϣ
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product editProduct(String pid) throws SQLException {
		//���������ݵ�dao��
		AdminProductDao dao = new AdminProductDao();
		Product product = dao.findProduct(pid);
		
		return product;
		
	}

	/**
	 * ������Ʒ��Ϣ�ķ���
	 * @param product
	 * @throws SQLException 
	 */
	public void editProduct(Product product) throws SQLException {
		
		//������Ͳ������ݸ�dao��
		AdminProductDao dao = new AdminProductDao();
		dao.editProduct(product);
	}

	public List<Product> selectProduct(Select select) throws SQLException {
		//������Ͳ������ݸ�dao��
		AdminProductDao dao =new AdminProductDao();
		List<Product> product = dao.selectProduct(select);
		return product;
		
	}

}

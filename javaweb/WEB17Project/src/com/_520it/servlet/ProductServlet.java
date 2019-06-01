package com._520it.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com._520it.domain.Product;
import com._520it.utils.DataSourceUtils;



@WebServlet("/productList")
public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//׼�����е���Ʒ������----List<Product>
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="SELECT * FROM product";
		List<Product> productList=null;
		try {
			productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//��Ʒ�ļ����Ѿ�׼������
		//�����ݴ浽request��ת����product_list.js��ʾ
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
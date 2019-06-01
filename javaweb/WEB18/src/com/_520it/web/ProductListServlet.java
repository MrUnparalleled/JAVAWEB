package com._520it.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.Product;
import com._520it.service.ProductService;


@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������service��
		ProductService service =new ProductService();
		List<Product> productList=null;
		try {
			productList = service.findAllProduct();
			request.setAttribute("productList", productList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ȫ����Ʒ��Ϣ׼������ ת����jsp�������ݵ�չʾ
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
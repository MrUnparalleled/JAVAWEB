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
		//传递请求到service层
		ProductService service =new ProductService();
		List<Product> productList=null;
		try {
			productList = service.findAllProduct();
			request.setAttribute("productList", productList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//全部商品信息准备好了 转发给jsp进行数据的展示
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
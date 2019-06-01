package com._520it.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.Product;
import com._520it.service.ProductService;


@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求数据
		String pid = request.getParameter("pid");
		//传递请求
		ProductService service =new ProductService();
		Product products =service.findProduct(pid);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
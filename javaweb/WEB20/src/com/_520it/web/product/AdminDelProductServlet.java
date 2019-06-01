package com._520it.web.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.service.AdminProductService;


/**
 * 删除商品
 * @author Administrator
 *
 */
@WebServlet("/adminDelProduct")
public class AdminDelProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String pid = request.getParameter("pid");
		//传递参数和请求给service层
		AdminProductService service =new AdminProductService();
		try {
			service.delProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//重定向
		response.sendRedirect(request.getContextPath()+"/adminProductList");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
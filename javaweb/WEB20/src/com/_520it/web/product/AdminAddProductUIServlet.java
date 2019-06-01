package com._520it.web.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.Category;
import com._520it.service.AdminProductService;

/**
 * 后台添加页面的获取所有商品类别
 * @author Administrator
 *
 */
@WebServlet("/adminAddProductUI")
public class AdminAddProductUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//将请求传给service
			AdminProductService service =new AdminProductService();
			List<Category> categoryList = service.findAllCategory();
			//将结果放到request域当中
			request.setAttribute("categoryList", categoryList);
			//请求转发
			request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
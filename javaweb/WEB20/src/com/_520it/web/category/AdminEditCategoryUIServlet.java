package com._520it.web.category;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.Category;
import com._520it.service.AdminCategoryService;


@WebServlet("/adminEditCategoryUI")
public class AdminEditCategoryUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取参数
			String cid = request.getParameter("cid");
			//传递请求和参数给service层
			AdminCategoryService service =new AdminCategoryService();
			Category category = service.findCategoryByID(cid);
			//将数据传到request域当中
			request.setAttribute("category", category);
			//请求转发
			request.getRequestDispatcher("/admin/category/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
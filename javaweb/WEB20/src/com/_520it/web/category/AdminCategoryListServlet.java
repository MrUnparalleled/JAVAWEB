package com._520it.web.category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.Category;
import com._520it.service.AdminCategoryService;


@WebServlet("/adminCategoryList")
public class AdminCategoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��������service��
			AdminCategoryService service =new AdminCategoryService();
			List<Category> allCategory = service.findAllCategory();
			//�����ݴ��ݵ�ǰ��
			request.setAttribute("allCategory", allCategory);
			request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
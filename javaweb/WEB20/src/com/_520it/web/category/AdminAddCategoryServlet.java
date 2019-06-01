package com._520it.web.category;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.domain.Category;
import com._520it.service.AdminCategoryService;


@WebServlet("/adminAddCategory")
public class AdminAddCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//处理中文乱码问题
			request.setCharacterEncoding("utf-8");
			//获取请求参数
			Map<String, String[]> parameterMap = request.getParameterMap();
			Category category =new Category();
			BeanUtils.populate(category, parameterMap);
			//设置为赋值的属性
			category.setCid(UUID.randomUUID().toString());
			//传递请求到dao层
			AdminCategoryService dao =new AdminCategoryService();
			dao.addCategory(category);
			//重定向
			response.sendRedirect(request.getContextPath()+"/adminCategoryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
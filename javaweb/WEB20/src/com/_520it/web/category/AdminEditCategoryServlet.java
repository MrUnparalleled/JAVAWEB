package com._520it.web.category;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.domain.Category;
import com._520it.service.AdminCategoryService;


@WebServlet("/adminEditCategory")
public class AdminEditCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//处理中文乱码问题
			request.setCharacterEncoding("utf-8");
			//获取参数
			Map<String, String[]> parameterMap = request.getParameterMap();
			//将参数封装到JavaBean当中
			Category category =new Category();
			BeanUtils.populate(category, parameterMap);
			
			System.out.println(category.getCid());
			
			//将请求和参数传递到service层
			AdminCategoryService service =new AdminCategoryService();
			service.editCategory(category);
			//重定向到list界面
			response.sendRedirect(request.getContextPath()+"/adminCategoryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
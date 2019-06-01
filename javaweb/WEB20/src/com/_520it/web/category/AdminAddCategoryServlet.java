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
			//����������������
			request.setCharacterEncoding("utf-8");
			//��ȡ�������
			Map<String, String[]> parameterMap = request.getParameterMap();
			Category category =new Category();
			BeanUtils.populate(category, parameterMap);
			//����Ϊ��ֵ������
			category.setCid(UUID.randomUUID().toString());
			//��������dao��
			AdminCategoryService dao =new AdminCategoryService();
			dao.addCategory(category);
			//�ض���
			response.sendRedirect(request.getContextPath()+"/adminCategoryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
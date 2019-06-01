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
			//����������������
			request.setCharacterEncoding("utf-8");
			//��ȡ����
			Map<String, String[]> parameterMap = request.getParameterMap();
			//��������װ��JavaBean����
			Category category =new Category();
			BeanUtils.populate(category, parameterMap);
			
			System.out.println(category.getCid());
			
			//������Ͳ������ݵ�service��
			AdminCategoryService service =new AdminCategoryService();
			service.editCategory(category);
			//�ض���list����
			response.sendRedirect(request.getContextPath()+"/adminCategoryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package com._520it.web.category;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.service.AdminCategoryService;

/**
 * ɾ����Ʒ���
 * @author Administrator
 *
 */
@WebServlet("/adminDelCategory")
public class AdminDelCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��ȡ����
			String cid = request.getParameter("cid");
			//���ݲ���������
			AdminCategoryService service =new AdminCategoryService();
			service.delCategory(cid);
			//�ض���listҳ��
			response.sendRedirect(request.getContextPath()+"/adminCategoryList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
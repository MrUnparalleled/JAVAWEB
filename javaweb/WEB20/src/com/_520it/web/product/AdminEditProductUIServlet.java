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
import com._520it.domain.Product;
import com._520it.service.AdminProductService;

/**
 * ��Ʒ��Ϣ�޸�
 * @author Administrator
 *
 */
@WebServlet("/adminEditUIProduct")
public class AdminEditProductUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��ȡ�������
			String pid = request.getParameter("pid");
			//��������Ͳ�����service��
			AdminProductService service =new AdminProductService();
			//���Ҫ�޸ĵ���Ʒ��������Ϣ
			List<Category> allCategory = service.findAllCategory();
			Product product = service.editProduct(pid);
			request.setAttribute("product", product);
			request.setAttribute("allCategory", allCategory);
			//����Ϣ���ݵ�ǰ��----����ת��
			request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
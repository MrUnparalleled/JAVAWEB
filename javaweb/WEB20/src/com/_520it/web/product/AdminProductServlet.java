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
 * ��̨��ʾ��Ʒ�б�
 * @author Administrator
 *
 */
@WebServlet("/adminProductList" )
public class AdminProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//����service����
		try {
			AdminProductService service=new AdminProductService();
			List<Category> categoryList = service.findAllCategory();
			List<Product> list = service.findAllProduct();
			//����Ϣ�ŵ�request����
			request.setAttribute("list",list);
			request.setAttribute("categoryList",categoryList);
			//����ת��
			request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
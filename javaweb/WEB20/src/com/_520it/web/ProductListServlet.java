package com._520it.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com._520it.domain.Product;
import com._520it.service.ProductService;
import com._520it.vo.PageBean;


@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String currentPageStr=request.getParameter("currentPage");
			int currentPage=1;
			if (currentPageStr!=null) {
				currentPage=Integer.parseInt(currentPageStr);
			}
			int currentCount=12;
			
			//�������������
			ProductService service =new ProductService();
			List<Product> products = service.findAllProduct();
			
			//����һ��pageBean����
			PageBean<Product> pageBean = service.getPageBean(currentPage,currentCount);
			
			//������ŵ�request����
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("product_list", products);
			//�ض���
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
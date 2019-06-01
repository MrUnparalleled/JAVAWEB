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
 * 商品信息修改
 * @author Administrator
 *
 */
@WebServlet("/adminEditUIProduct")
public class AdminEditProductUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取请求参数
			String pid = request.getParameter("pid");
			//传递请求和参数到service层
			AdminProductService service =new AdminProductService();
			//获得要修改的商品的所有信息
			List<Category> allCategory = service.findAllCategory();
			Product product = service.editProduct(pid);
			request.setAttribute("product", product);
			request.setAttribute("allCategory", allCategory);
			//将信息传递到前端----请求转发
			request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
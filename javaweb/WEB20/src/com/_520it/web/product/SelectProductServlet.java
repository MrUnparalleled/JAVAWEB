package com._520it.web.product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.domain.Category;
import com._520it.domain.Product;
import com._520it.service.AdminProductService;
import com._520it.vo.Select;
@WebServlet("/selectProduct")


/**
 * 查询特定条件的商品
 * @author Administrator
 *
 */
public class SelectProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码的问题
		request.setCharacterEncoding("utf-8");
		try {
			//获取参数
			Map<String, String[]> parameterMap = request.getParameterMap();
			Select select =new Select();
			//封装数据
			BeanUtils.populate(select, parameterMap);
			//将请求和数据传输到service层
			AdminProductService service =new AdminProductService();
			//返回结果
			List<Product> product = service.selectProduct(select);
			List<Category> categoryList = service.findAllCategory();
			//将结果放到request域当中
			request.setAttribute("select", select);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("list", product);
			request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
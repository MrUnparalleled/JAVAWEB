package com._520it.web.product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.domain.Product;
import com._520it.service.AdminProductService;
/**
 * 后台添加商品
 * @author Administrator
 *
 */
@WebServlet("/adminAddProduct")
public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		try {
			//获得请求参数
			Map<String, String[]> parameterMap =request.getParameterMap();
			Product product=new Product();
			//封装数据
			BeanUtils.populate(product, parameterMap);
			//------------此位置product已经封装完毕
			//手动设置表单中没有的数据
			//1).private String pid;
			product.setPid(UUID.randomUUID().toString());
			//2).private String pimage;
			product.setPimage("products/1/c_0001.jpg");
			//3).private String pdate;----商品的上架日期
			SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd");
			String pdate = format.format(new Date());
			product.setPdate(pdate);
			//4).private int pflag;-----商品是否下架,1为下架
			product.setPflag(0);
			
			//将数据传递到service层
			AdminProductService dao=new AdminProductService();
			int update = dao.addProduct(product);
//			request.getRequestDispatcher("/adminProductList").forward(request, response);
			//使用重定向
			response.sendRedirect(request.getContextPath()+"/adminProductList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
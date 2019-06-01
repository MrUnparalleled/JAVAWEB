package com._520it.web.product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.domain.Product;
import com._520it.service.AdminProductService;


@WebServlet("/adminEditProduct")
public class AdminEditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码问题
		
		request.setCharacterEncoding("utf-8");
		try {
			//获取请求参数
			Map<String, String[]> parameterMap = request.getParameterMap();
			Product product = new Product();
			//封装到JavaBean当中
			BeanUtils.populate(product, parameterMap);
			//手动设置未赋值的参数
			//pimage-----图片---暂时不写，之后的dao层也得补上
			
			
			//pdate-----上架时间
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
			String pdate = format.format(new Date());
			product.setPdate(pdate);
			//pflag-------是否下架---0为未下架
			product.setPflag(0);
			//传递请求和参数到service层
			AdminProductService service =new AdminProductService();
			service.editProduct(product);
			//重定向
			response.sendRedirect(request.getContextPath()+"/adminProductList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
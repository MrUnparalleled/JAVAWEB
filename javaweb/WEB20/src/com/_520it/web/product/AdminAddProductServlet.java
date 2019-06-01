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
 * ��̨�����Ʒ
 * @author Administrator
 *
 */
@WebServlet("/adminAddProduct")
public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������������
		request.setCharacterEncoding("utf-8");
		try {
			//����������
			Map<String, String[]> parameterMap =request.getParameterMap();
			Product product=new Product();
			//��װ����
			BeanUtils.populate(product, parameterMap);
			//------------��λ��product�Ѿ���װ���
			//�ֶ����ñ���û�е�����
			//1).private String pid;
			product.setPid(UUID.randomUUID().toString());
			//2).private String pimage;
			product.setPimage("products/1/c_0001.jpg");
			//3).private String pdate;----��Ʒ���ϼ�����
			SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd");
			String pdate = format.format(new Date());
			product.setPdate(pdate);
			//4).private int pflag;-----��Ʒ�Ƿ��¼�,1Ϊ�¼�
			product.setPflag(0);
			
			//�����ݴ��ݵ�service��
			AdminProductService dao=new AdminProductService();
			int update = dao.addProduct(product);
//			request.getRequestDispatcher("/adminProductList").forward(request, response);
			//ʹ���ض���
			response.sendRedirect(request.getContextPath()+"/adminProductList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
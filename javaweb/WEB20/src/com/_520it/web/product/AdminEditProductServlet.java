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
		//����������������
		
		request.setCharacterEncoding("utf-8");
		try {
			//��ȡ�������
			Map<String, String[]> parameterMap = request.getParameterMap();
			Product product = new Product();
			//��װ��JavaBean����
			BeanUtils.populate(product, parameterMap);
			//�ֶ�����δ��ֵ�Ĳ���
			//pimage-----ͼƬ---��ʱ��д��֮���dao��Ҳ�ò���
			
			
			//pdate-----�ϼ�ʱ��
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
			String pdate = format.format(new Date());
			product.setPdate(pdate);
			//pflag-------�Ƿ��¼�---0Ϊδ�¼�
			product.setPflag(0);
			//��������Ͳ�����service��
			AdminProductService service =new AdminProductService();
			service.editProduct(product);
			//�ض���
			response.sendRedirect(request.getContextPath()+"/adminProductList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
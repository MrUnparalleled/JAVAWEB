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
 * ��ѯ�ض���������Ʒ
 * @author Administrator
 *
 */
public class SelectProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������������
		request.setCharacterEncoding("utf-8");
		try {
			//��ȡ����
			Map<String, String[]> parameterMap = request.getParameterMap();
			Select select =new Select();
			//��װ����
			BeanUtils.populate(select, parameterMap);
			//����������ݴ��䵽service��
			AdminProductService service =new AdminProductService();
			//���ؽ��
			List<Product> product = service.selectProduct(select);
			List<Category> categoryList = service.findAllCategory();
			//������ŵ�request����
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
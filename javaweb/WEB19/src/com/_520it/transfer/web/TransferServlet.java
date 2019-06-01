package com._520it.transfer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.transfer.service.MyTransferService;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String money = request.getParameter("money");
		
		//����service���tansfer(out,in,money)
		MyTransferService service =new MyTransferService();
		boolean isTransferSuccess = service.tansfer(out,in,money);
		response.setContentType("text/html;charset=UTF-8");
		if (isTransferSuccess) {
			response.getWriter().write("ת�˳ɹ�");
		}else {
			response.getWriter().write("ת��ʧ��");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
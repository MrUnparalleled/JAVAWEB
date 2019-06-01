package com._520it.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//�����֤���Ƿ���ȷ
		//��ȡ�������֤��
		String checkCode = request.getParameter("checkCode");
		//��ȡ��֤��ͼƬ����
		HttpSession session = request.getSession();
		Object checkCode_img = session.getAttribute("checkcode_session");
		if (!checkCode.equals(checkCode_img.toString())) {
			
			//���������д�����
			request.setAttribute("CheckImgInfo", "��֤�����");
			//����ת��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
			//��ȡ�û������룬���ݿ������ʵ�˻�����
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
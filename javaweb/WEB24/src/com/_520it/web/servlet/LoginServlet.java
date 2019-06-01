package com._520it.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com._520it.domain.User;
import com._520it.service.LoginService;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user =null;
			//��ȡ����������
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			//���ݵ�service��
			LoginService service=new LoginService();
			user = service.findUser(uname,upwd);
			//�ж��Ƿ����
			if (user==null) {
				//�û������������
				request.setAttribute("LoginInfo", "�û������������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			} else {
				//��¼�ɹ�
				//�ж��Ƿ�ѡ�Զ���¼
				String autoLogin = request.getParameter("autoLogin");
				if (autoLogin!=null) {
					//���û���������ŵ�cookie�У����ó־û�ʱ��
					Cookie cookie_uname =new Cookie("cookie_uname", user.getUname());
					Cookie cookie_upwd =new Cookie("cookie_upwd", user.getUpwd());
					//���ó־û�ʱ��
					cookie_uname.setMaxAge(60*60*24*30);
					cookie_upwd.setMaxAge(60*60*24*30);
					//����cookieЯ��·��
					cookie_uname.setPath(request.getContextPath());
					cookie_upwd.setPath(request.getContextPath());
					//���cookie
					response.addCookie(cookie_uname);
					response.addCookie(cookie_upwd);
				}
				
				//����ȷ���û�����������뵽session����
				session.setAttribute("user", user);
				//�ض���
				response.sendRedirect(request.getContextPath());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package com._520it.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.service.UserService;
@WebServlet("/userRegister")
/**
 * �û�ע��ʱ����û����Ƿ����
 * @author Administrator
 *
 */
public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��ȡ�������
			String username = request.getParameter("username");
			//��������Ͳ���
			UserService service =new UserService();
			int count = service.checkRegisterUsername(username);
			System.out.println(count);
			boolean isUsed=false;
			if (count>0) {
				isUsed=true;
			}
			//�����ݴ����ȥ
			response.getWriter().write("{\"isUsed\":"+isUsed+"}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
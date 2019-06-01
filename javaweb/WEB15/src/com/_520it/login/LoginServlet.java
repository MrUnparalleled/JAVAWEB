package com._520it.login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.register.User;
import com._520it.util.DruidUtil;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ��¼������������
		Map<String, String[]> parameterMap = request.getParameterMap();
		//2.��������װ��һ��JavaBean����
		User user=new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//3.���ݷ����ж��Ƿ��¼�ɹ�
		try {
			boolean login = login(user);
//			System.out.println(login);
			if (login==true) {
				response.sendRedirect(request.getContextPath());
			} else {
				//���������д�����
				request.setAttribute("loginInfo", "�˺Ż����벻��ȷ");
				//����ת��
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//������һ�㲻�᷵��boolean���ͣ�һ��᷵��JavaBean
	public boolean login(User user) throws SQLException {
		Connection conn = DruidUtil.getConn();
		String sql="SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet query = ps.executeQuery();
		if (query.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
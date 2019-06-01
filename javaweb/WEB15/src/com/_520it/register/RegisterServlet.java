package com._520it.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.util.DruidUtil;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������������
		//�÷���ֻ������post�ύ����
		//request.setCharacterEncoding("UTF-8");
		
		//!!!!!!����д��get��ʽ�������������������Ǵ���Tomcat8 ֮ǰ�ķ�����Tomcat8֮ǰ��Ĭ�ϱ����ʽ��ISO8859-1��
		//Tomcat8֮��ı����ʽ��UTF-8 ����ʹ��Tomcat8֮��ķ�����ʱ����Ҫ����get��ʽ���������⣡����������
		
		
		//get�ύ�����Ĵ�����-----�Ƚ�����ͨ��ISO8859-1���룬��ͨ��utf-8����(�ײ��ʵ�ַ�ʽ��postͬ�����ã��������Ƽ�)
		String username = request.getParameter("username");
		username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(username);
		//1.��ȡ����Ϣ
		Map<String, String[]> parameterMap = request.getParameterMap();
		//2.������Ϣ��װ��һ��JavaBean����
		//BeanUtil�Ĺ���ԭ����Map�е����ݸ���key��ʵ������ԵĶ�Ӧ��ϵ��װ
		//ֻҪkey�����ֺ�ʵ������Ե�����һ�������Զ���װ��ʵ���У�����
		User user=new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(UUID.randomUUID().toString());
		//3.����Ϣ���뵽���ݿ⵱��------���ݿ�Ĳ���-----
		try {
			register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	public void register(User user) throws SQLException {
		Connection conn = DruidUtil.getConn();
		String sql="insert into user values (?,?,?,?,?,?,?,?,null,null)";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, user.getUid());
		prepareStatement.setString(2, user.getUsername());
		prepareStatement.setString(3, user.getPassword());
		prepareStatement.setString(4, user.getName());
		prepareStatement.setString(5, user.getEmail());
		prepareStatement.setString(6, user.getTelephone());
		prepareStatement.setString(7, user.getBirthday());
		prepareStatement.setString(8, user.getSex());
		prepareStatement.executeUpdate();
		DruidUtil.close(null,prepareStatement, conn);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
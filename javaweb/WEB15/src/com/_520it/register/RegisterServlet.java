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
		//解决中文乱码问题
		//该方法只适用于post提交方法
		//request.setCharacterEncoding("UTF-8");
		
		//!!!!!!这里写的get方式请求处理中文乱码问题是处理Tomcat8 之前的方法，Tomcat8之前的默认编码格式是ISO8859-1，
		//Tomcat8之后的编码格式是UTF-8 所以使用Tomcat8之后的服务器时不需要处理get方式的中文问题！！！！！！
		
		
		//get提交的中文处理方法-----先将乱码通过ISO8859-1编码，再通过utf-8解码(底层的实现方式，post同样适用，不过不推荐)
		String username = request.getParameter("username");
		username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(username);
		//1.获取表单信息
		Map<String, String[]> parameterMap = request.getParameterMap();
		//2.将表单信息封装到一个JavaBean当中
		//BeanUtil的工作原理：将Map中的数据根据key和实体的属性的对应关系封装
		//只要key的名字和实体的属性的名字一样，就自动封装到实体中！！！
		User user=new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(UUID.randomUUID().toString());
		//3.将信息传入到数据库当中------数据库的操作-----
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
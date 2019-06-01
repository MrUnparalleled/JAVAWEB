<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com._520it.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//往域中存数据
		//存字符串
		request.setAttribute("name", "zhangsan");
		//存user类
		User user=new User();
		user.setName("lisi");
		user.setAge(12);
		session.setAttribute("user", user);
		//存list
		List<User> list=new ArrayList();
		User user1=new User();
		user1.setName("wangwu");
		user1.setAge(12);
		list.add(user1);
		User user2=new User();
		user2.setName("laoliu");
		user2.setAge(12);
		list.add(user2);
		application.setAttribute("list", list);
	%>
	
	<%--使用脚本的方式将数据读取出来 --%>
	<%=request.getAttribute("name") %>
	<%
		User sessionUser = (User)session.getAttribute("user");
		out.write(sessionUser.getName());
	%>
	<hr>
	<%--使用el的方式将数据读取出来 --%>
		${requestScope.name}
		${sessionScope.user.name}
		${applicationScope.list[1].name}
		<%--下面的方式是从所有域当中去数据   也是从小到大找，找到了就不再往下找，其底层实现是pageContext.findAttribute() --%>
		${name}
</body>
</html>
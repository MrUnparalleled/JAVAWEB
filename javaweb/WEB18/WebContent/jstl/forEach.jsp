<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com._520it.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	//1）遍历List<String>的值
	List<String> nameList=new ArrayList();
	nameList.add("zhangsan");
	nameList.add("lisi");
	nameList.add("wangwu");
	nameList.add("laoliu");
	session.setAttribute("nameList", nameList);
	
	
	
	//遍历List<User>的值
	List<User> userList=new ArrayList();
	User user =new User();
	user.setAge(19);
	user.setName("张三");
	user.setPassword("123");
	userList.add(user);
	User user1 =new User();
	user1.setAge(22);
	user1.setName("李四");
	user1.setPassword("123");
	userList.add(user1);
	session.setAttribute("userList", userList);
	
	
	//遍历Map<String,String>的值
	Map<String,String> strMap =new HashMap();
	strMap.put("name", "张三");
	strMap.put("age", "12");
	strMap.put("sex", "男");
	strMap.put("password", "12345432");
	session.setAttribute("strMap", strMap);
	
	//遍历Map<String,User>的值
	Map<String,User> map2 =new HashMap();
	User user2 =new User();
	user2.setAge(19);
	user2.setName("三儿");
	user2.setPassword("123");
	map2.put("1", user2);
	User user3 =new User();
	user3.setAge(19);
	user3.setName("四儿");
	user3.setPassword("123");
	map2.put("2", user3);
	session.setAttribute("map2", map2);
	
	//5）遍历Map<User,Map<String,User>>的值
	Map<User,Map<String,User>> map3 =new HashMap();
	map3.put(user2, map2);
	map3.put(user3, map2);
	session.setAttribute("map3",map3);
	%>
	
	
	
	<c:forEach items="${nameList }" var="name">
		${name }<br>
	</c:forEach>
	
	
	<c:forEach items="${userList }" var="user">
		${user.name }
	</c:forEach>
		
	<c:forEach items="${strMap }" var="str">
	${str.key }:${str.value }<br>
	</c:forEach>
	
	<c:forEach items="${map2 }" var="map11">
	${map11.key }:${map11.value.name }<br>
	</c:forEach>
	
	<c:forEach items="${map3 }" var="map22">
		<c:forEach items="${map22.value }" var="map44">
			${map22.key }-----${map44.key }<br>
		</c:forEach>
	</c:forEach>
</body>
</html>
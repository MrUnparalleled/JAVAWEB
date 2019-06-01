<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%--<%@ taglib uri="标签库地址" prefix="c" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 这是HTML的注释 -->
	<%--这是jsp的注释 --%>
	<%--include指令  可以将一个页面包含到另一个页面 --%>
	<%@include file="/include.jsp" %>
	<%--taglib指令   在jsp页面引入标签库 --%>
	

	<%--使用c库的标签 --%>
	<c:if></c:if>
	<% 
	
		//这是java的单行注释
		/*
		这是java的多行注释
		*/
		
	%>
</body>
</html>
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
		request.setAttribute("name", "zhangsan");
		//使用pageContext向request域中存数据
		pageContext.setAttribute("name", "lisi",PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "wangwu",PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "laoliu",PageContext.APPLICATION_SCOPE);
	%>
	
	<%
		//取数据
		pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE);
		pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);
		pageContext.getAttribute("name", PageContext.SESSION_SCOPE);
	%>
	<%--从所有域找数据,范围从小到大搜索--%>
	<%--pageContext<requestContext<sessionContext<applicationContext --%>
	<%=pageContext.findAttribute("name")%>
</body>
</html>
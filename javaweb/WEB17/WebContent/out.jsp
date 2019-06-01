<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="0kb"%>
    <%--buffer指的是out缓冲区大小 默认8kb 设置为0时，关闭out缓冲区，直接写到response缓冲区 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	aaaaaaaaaaaaaaaaaaa
	<%
		out.write("bbbbbbbbbbbb");
		response.getWriter().write("ccccccccccc");
	%>
	<%="dddddddddddddddd" %>
</body>
</html>
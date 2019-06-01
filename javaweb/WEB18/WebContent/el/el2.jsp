<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<%--获取全局的初始化参数，xml中配置的 --%>
	<%--使用jsp脚本实现 --%>
	<%=application.getInitParameter("name")%>
	<%--使用el实现 --%>
	${initParam.name }
	<br>
	
	<%--获取请求头信息      这里是因为中间有一个-所以用[]，正常情况下用.就好了 --%>
	${header["User-Agent"] }
	
	<%--获得cookie --%>
	<%
		Cookie cookie=new Cookie("name","zhangsan");
		response.addCookie(cookie);
	%>
	${cookie.name.value }
	
	
	<br>
	<%--pageContext获得其他对象     之后的项目中写文件路径的时候都带上，相对路径可能会有问题    这句语句可以写在""里面--%>
	${pageContext.request.contextPath }
	
	
	<%--el可以进行表达式运算 --%>
	${1==1?true:false }
	${1+1 }
	<%--empty 判定某个对象是否是null，是null返回true --%>
	${empty "" }
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("name", "zhangsan");
	%>
	
	<%--jstl一般和el配合使用 --%>
	<%--不要将=='zhangsan'写到{}外面 --%>
	<c:if test="${requestScope.name=='zhangsan'}">
		xxxxxxxxxxxx
	</c:if>
	
	
	<%--forEach 模拟
		for(int i=0;i<=5;i++){
		
		}
	 --%>
	 <c:forEach begin="0" end="5" var="i">
	 	${i }
	 </c:forEach>
	 <%--forEach  模拟
	 	for(User user:userList){
	 		
	 	}
	  --%>
	  <%-- items表示集合或数组       var表示集合中的一个元素 --%>
	  <c:forEach items="${ProductList }" var="">
	  	
	  </c:forEach>
	 
</body>
</html>
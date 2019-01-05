<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 遍历Map集合 -->
     <c:forEach var="me" items="${fileNameMap}">
         <c:url value="/FileDownServlet" var="downurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
         ${me.value}<a href="${downurl}">下载</a>
         
         
         <c:url value="/FileDeleteServlet" var="delurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
         <a href="${delurl}">删除</a>
         <br/>
     </c:forEach>
</body>
</html>
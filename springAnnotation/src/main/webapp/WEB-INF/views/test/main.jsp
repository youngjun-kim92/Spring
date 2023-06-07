<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	<h2>스프링 애너테이션 실습</h2>
	<h2>mainController에서 전달받은 메시지 => ${msg}</h2>
</body>
</html>
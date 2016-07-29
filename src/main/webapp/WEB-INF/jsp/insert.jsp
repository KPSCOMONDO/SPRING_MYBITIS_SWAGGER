<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
   <link rel="stylesheet" href="source/css/bootstrap.min.css">
</head>
<body>
<div class="col-lg-4 col-lg-offset-4 text-center" style="background-color: #EA80FC;">
	<h1>Student Form</h1>
	<mvc:form action="${pageContext.request.contextPath}/${state}" method="POST" modelAttribute="student">
		<mvc:input type="number" path="id" class="form-control"  placeholder="ID : example 1"/><br/>
		<mvc:input type="text" path="name" class="form-control" placeholder="Name : exmaple Sok Channy"/> <br/>
		<input type="submit" class="btn btn-primary" value="${state}"/>
	</mvc:form>
</div>
</body>
</html>
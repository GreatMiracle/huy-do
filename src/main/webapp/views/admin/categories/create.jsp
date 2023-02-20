<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/ASM_J5/category/store"
		modelAttribute="item">
		<div>
			<label>Name</label>
			<form:input path="name" name="name" />
		</div>
		<div>
			<button>Save</button>
		</div>
		
	</form:form>
</body>
</html>
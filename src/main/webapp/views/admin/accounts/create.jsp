<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16308 - Create Account</title>
</head>
<body>
	<form:form
		method="POST"
		action="/ASM_J5/admin/account/store"
		modelAttribute="account">
		<div>
			<label>Fullname</label>
			<form:input path="fullname" />
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" type="email" />
		</div>
		<div>
			<label>Username</label>
			<form:input path="username" />
		</div>
		<div>
			<label>Password</label>
			<form:password path="password" />
		</div>
		<div>
			<label>Photo</label>
			<form:input path="photo" />
		</div>
		<div>
			<label>Admin</label>
			<form:select path="admin">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<button>Save</button>
	</form:form>
</body>
</html>
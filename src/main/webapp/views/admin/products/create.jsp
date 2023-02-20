<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form
		method="POST"
		action="/ASM_J5/admin/product/store"
		modelAttribute="product">
		<div>
			<label>Name</label>
			<form:input path="name" />
		</div>
		<div>
			<label>Image</label>
			<form:input path="image" type="image" />
		</div>
		<div>
			<label>Price</label>
			<form:input path="price" />
		</div>
		<div>
			<label>Ngày tạo</label>
			<form:input path="createdDate" type="date" />
		</div>
		<div>
			<label>Available</label>
			<form:select path="available">
				<form:option value="0">Chưa sắn sàng</form:option>
				<form:option value="1"> Sẵn sàng</form:option>
			</form:select>
		</div>
		<div>
			<label>Danh mục</label>
			<form:select path="category">
				<form:option value="${product.category}" label="${category.name }"></form:option>
			</form:select>
		</div>
		<button>Save</button>
	</form:form>
</body>
</html>
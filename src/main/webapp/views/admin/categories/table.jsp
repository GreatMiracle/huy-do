<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/ASM_J5/css/bootstrap.min.css" />
</head>
<body>
	<table border="1" style="width: 100%">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${ data.content }">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><a href="/ASM_J5/category/edit/${item.id}" class="btn btn-primary">Edit</a>
					<a href="/ASM_J5/category/delete/${item.id}" class="btn btn-danger">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<div class="row">
		<ul class="pagination">
			<c:forEach var="i" begin="0" end="${ data.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/ASM_J5/category/index?page=${ i }"> ${ i + 1 } </a></li>
			</c:forEach>
		</ul>
	</div>
	<script src="/ASM_J5/js/jquery.min.js"></script>
	<script src="/ASM_J5/js/popper.min.js"></script>
	<script src="/ASM_J5/js/bootstrap.min.js"></script>
</body>
</html>
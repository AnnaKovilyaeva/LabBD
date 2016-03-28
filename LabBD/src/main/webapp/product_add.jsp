<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product ADD</title>
	</head>
	<body>
		<h1>Product ADD</h1>
		<form action="productAdd" method="post">
			<br>Product Name:
			<input type="text" name="productName" value="" />
			<br>quantity:
			<input type="text" name="quantity" value="" />
			<input type="submit" name="Submit">
		</form>
	</body>
</html>
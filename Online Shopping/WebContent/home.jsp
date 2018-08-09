<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	table {
		font-family: monospace;
		font-weight: bold;
		font-size:x-large;
	}

</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div align="center"><h2>Home Page</h2></div> 
	<h1>Item List</h1>
	<div align="right"><a href="cart.app"><h2>Cart: ${sessionScope.count.size()}</h2></a></div>
			<table border="1">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Cost</th>
				</tr>
				<jstl:forEach var="item" items="${requestScope.item }">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.cost}</td>
						<td><a href="addToCart.app?itemId=${item.id}">Add To Cart</a></td>
						
					</tr>
				</jstl:forEach>
</table>
         <div align="right"><h1>Total: ${sessionScope.sum}</h1></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<c:url value="/resources/images" var="img"/>
<style>
h1 {
    text-align: center;
    color: blue;
}
body{
background-image:url("${img}/img1.jpg");
}
p{
font-family:Arial;
font-size:20px;
}
div {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid green;
    padding: 70px;
     margin-left:425px;
    margin-top:45px;
}

</style>
</head>
<body>
<div>
 <c:url value="/addproduct" var="product"/>
<form:form action="${product}" method="post" commandName="product" enctype="multipart/form-data">
<fieldset>
<legend>PRODUCT FORM</legend>
ProductID:<form:input type="text" name="productId" path="productId"/><br>
Name:<form:input type="text" name="name" path="name"/><br>
Price:<form:input type="text" name="price" path="price"/><br>
Quantity:<form:input type="text" name="quantity" path="quantity"/><br>
Description:<form:input type="text" name="description" path="description"/><br>
CategoryId:<form:select path="category.catId">
<c1:forEach items="${categories}" var="cat">
<option value="${cat.getCatId()}" label="${cat.getCatName()}"></option>
</c1:forEach>
</form:select>
SUPPLIER_ID:<form:select path="supplier.suppID">
<c1:forEach items="${suppliers}" var="sup">
<option value="${sup.getSuppID()}" label="${sup.getSuppName()}">
</option>
</c1:forEach>
</form:select>
<form:input path="pimg" type="file" name="image" value="UploadFile"/>
<input type="submit" value="submit"/>
<input type="reset" value="cancel"/>
</fieldset>
</form:form>
</div>
</body>
<table>
<tr>
<th>productId</th>
<th>product name</th>
<th>price</th>
<th>quantity</th>
<th>description</th>

<th>images</th>
<th>edit/delete</th>
</tr>

<c1:forEach items="${products}" var="prodlist">
<tr>


<td> ${prodlist.getProductId()}</td>
<td> ${prodlist.getName()}</td>
<td> ${prodlist.getPrice()}</td>
<td> ${prodlist.getQuantity()}</td>
<td> ${prodlist.getDescription()}</td>
<td><img src="<c:url value="/resources/images/${prodlist.getProductId()}.jpg"/>"style="width:50px; height:40px;"></td>
<td><a href="<c:url value='/editproduct/${prodlist. getProductId()}'/>">Edit</a>/<a href="<c:url value='/deleteProduct/${prodlist. getProductId()}'/>">Delete</a>
</td>

</tr>
</c1:forEach>
</table>
</html>
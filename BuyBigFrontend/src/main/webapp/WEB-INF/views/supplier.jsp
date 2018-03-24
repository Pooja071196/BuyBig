<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Form</title>
<c:url value="/resources/images" var="img"/>
<style>
h1 {
    text-align: center;
    color: blue;
}
body{
background-image:url("${img}/img13.jpg");
}
p{
font-family:Arial;
font-size:20px;
}
div {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid red;
    padding: 40px;
     margin-left:425px;
    margin-top:45px;
}


</style>
</head>
<body>
<h2>SUPPLIER FORM</h2>
<div>
<c:url value="/addsupplier" var="supp"/>
<form:form action="${supp}" method="post" commandName="supplier">
<fieldset>
<legend>SUPPLIER FORM</LEGEND>
SUPPLIERID:
<form:input type="text" name="suppId" path="suppID"/><br>
SUPPNAME:
<form:input type="text" name="suppName" path="suppName"/><br>
Address:
<form:input type="text" name="address" path="address"/><br>
PhoneNo:
<form:input type="text" name="phno" path="phno"/><br>
emailId:
<form:input type="text" name="email" path="email"/><br>
<input type="submit" value="submit"/>
<input type="reset" value="cancel"/>
</fieldset>
</form:form>
</div>
</body>
<table>
<tr>
<th>SupplierId</th>
<th>Supplier name</th>
<th>Address</th>
<th>Phone number</th>
<th>e-mail</th>
<th>edit/delete</th>
</tr>

<c1:forEach items="${suppliers}" var="supplist">
<tr>
<td> ${supplist.getSuppID()}</td>
<td> ${supplist.getSuppName()}</td>
<td> ${supplist.getAddress()}</td>
<td> ${supplist.getPhno()}</td>
<td> ${supplist.getEmail()}</td>
<td><a href="<c:url value='/editsupp/${supplist.getSuppID()}'/>">Edit</a>/<a href="<c:url value='/deletesupply/${supplist.getSuppID()}'/>">Delete</a>
</td>
</tr>
</c1:forEach>
</table>
</html>
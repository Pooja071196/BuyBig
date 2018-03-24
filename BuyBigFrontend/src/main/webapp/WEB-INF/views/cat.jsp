<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login form</title>
<c:url value="/resources/images" var="img"/>
<style>

h1 {
    text-align: center;
    color: blue;
}
body{
background-image:url("${img}/img11.jpg");
height:350px;
width:350px;
}
p{
font-family:Arial;
font-size:20px;
}
div {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid green;
    padding: 50px;
    margin-left:425px;
    margin-top:45px;
}


</style>

</head>

<body>

<div> 
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="post" commandName="category">
<fieldset>
<legend> CATEGORY FORM</legend>
CategoryId:<form:input type ="text" name= "CategoryId" path="catId"/><br>
<br>CategoryName:<form:input type ="text" name = "CategoryName " path="catName"/><br>
<input type="submit" value="submit"/>
<input type="reset" value="cancel"/>
</fieldset>
</form:form>
</div>
</body>
<table>
<tr>
<th>CatId</th>
<th>Catname</th>
<th>edit/delete</th>
</tr>

<c1:forEach items="${categories}" var="catlist">
<tr>
<td> ${catlist.getCatId()}</td>
<td> ${catlist.getCatName()}</td>
<td><a href="<c:url value='/editcat/${catlist.getCatId()}'/>">Edit</a>/<a href="<c:url value='/deleteCategory/${catlist.getCatId()}'/>">Delete</a>
</td>
</tr>
</c1:forEach>
</table>
</html>

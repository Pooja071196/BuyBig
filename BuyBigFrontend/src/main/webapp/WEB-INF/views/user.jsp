<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<style>
h1 {
    text-align: center;
    color: blue;
}
body{
background-color:green
}
p{
font-family:Arial;
font-size:20px;
}
div {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid blue;
    padding: 40px;
    margin-left:425px;
    margin-top:45px;
}
img{
top:0;
left:00;
right:0;
width:300px;
position:relative;
margin-left:125px;
margin-top:45px
}

</style>
</head>
<body>
<h2>USER FORM</h2>
<div>
 <c:url value="/adduser" var="user"/>
<form:form action="${user}" method="post" commandName="user">
<fieldset>
<legend>USER FORM</legend>
<label>USERID:</label>
<form:input type="text" name="userId" path="userId"/><br>
<label>Name:</label>
<form:input type="text" name="name" path="name"/><br>
<label>Address</label>
<form:input type="text" name="address" path="price"/><br>
<label>PhoneNo</label>
<form:input type="text" name="phoneNo" path="phoneNo"/><br>
<label>emailId</label>
<form:input type="text" name="emailId" path="emailId"/><br>
<label>Password</label>
<form:input type="text" name="password" path="password"/><br>
<input type="submit" value="submit"/>
<input type="reset" value="cancel"/>
</fieldset>
</form:form>
</div>
</body>
</html>
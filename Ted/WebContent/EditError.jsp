<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<% String name=(String)session.getAttribute("name"); %>
<% String surname=(String)session.getAttribute("surname"); %>
<% String username=(String)session.getAttribute("username"); %>
<% String id=(String)session.getAttribute("idUser"); %>
<% String password=(String)session.getAttribute("password"); %>
<% String mail=(String)session.getAttribute("mail"); %>
<% String phone=(String)session.getAttribute("phone"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Your User Profile</title>
</head>

<body>

<h1>Edit Your User Profile</h1>
<P><B>THIS USERNAME ALREADY EXISTS, PLEASE CHOOSE ANOTHER:</B></P>

<form method="get" action="EditProfilActionServlet" >

<P><input type="text" size="30" name="FD_profile_username" value=<%=username%>>
<BR>Username


<P><input type="text" size="15" name="FD_profile_first_name" value=<%=name%>>
<input type="text" size="15" name="FD_profile_last_name" value=<%=surname%>>
<BR>Name Surname

<P><input type="text" size="30" name="FD_profile_email" value=<%=mail%>>
<BR>Email

<P><input type="text" size="30" name="FD_profile_phone" value=<%=phone%>>
<BR>Phone

<P><input type="password" size="10" name="FD_profile_password" value=<%=password%>>
<BR>Enter a new password (or leave blank to keep password the same)

<P><input type="submit" name="submitbtn" value="Change User Profile">

</form>

</body>
</html>
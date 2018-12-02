<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% String username=(String)request.getAttribute("username"); %>
<% String id=(String)request.getAttribute("id"); %>
<% String password=(String)request.getAttribute("password"); %>
<% String name=(String)request.getAttribute("name"); %>
<% String surname=(String)request.getAttribute("surname"); %>
<% String mail=(String)request.getAttribute("mail"); %>
<% String phone=(String)request.getAttribute("phone"); %>
<% String photo=(String)request.getAttribute("photo"); %>
<% String role=(String)request.getAttribute("role"); %>
<% String req=(String)request.getAttribute("request"); %>
<% String reqID=(String)request.getAttribute("requestID");
request.setAttribute("to",reqID);%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Info</title>
     
	<link rel="stylesheet" href="css/adminTable.css">
</head>
<body>

<h1>User Info</h1>
<a href="admin.jsp" class="button2">Home</a>
<table>
  <tr>
    <th>Id</th>
	<th>Username</th>
	<th>Password</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Mail</th>
    <th>Phone</th>
    <th>Photo</th>
  </tr>
  <tr>
    <td><%=id%></td>
    <td><%=username%></td>
    <td><%=password%></td>
	<td><%=name%></td>
	<td><%=surname%></td>
	<td><%=mail%></td>
	<td><%=phone%></td>
	<td><%=photo%></td>
  </tr>
  
</table>
<% if(role != null && req.equals("1")) { %>
	<a href="<c:url value="adminUpdateServlet">
         	<c:param name="toto" value="${to}"/>
         	</c:url>"
      
       class="button2">Accept Request</a>
<% } else { %>
<a href="#" class="disabled">Request Accepted/Tenant</a>
<% } %>

</body>
</html>

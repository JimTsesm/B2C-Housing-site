<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Page</title>
     
	<link rel="stylesheet" href="css/adminTable.css">
</head>
<body>

<h1>Users List</h1>
<div class="w3-top">
  <div class="w3-bar w3-red w3-card-2 w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="admin.jsp" class="button2">Home</a>
  </div>
</div>

<table>
	<tr>
		<th>Id</th>
		<th>Username</th>
		<th>Request</th>
		<th>Role1</th>
		<th>Role2</th>
		<th>Role3</th>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result}">
		<tr>
		<td>
		 <a href="<c:url value="adminEditServlet">
         	<c:param name="userId" value="${row.getIdUser()}"/>
         	<c:param name="username" value="${row.getUsername()}"/>
         	<c:param name="password" value="${row.getPassword()}"/>
         	<c:param name="name" value="${row.getName()}"/>
         	<c:param name="surname" value="${row.getSurname()}"/>
         	<c:param name="mail" value="${row.getMail()}"/>
         	<c:param name="phone" value="${row.getPhone()}"/>
         	<c:param name="photo" value="${row.getPhoto()}"/>
         	
         	<c:forEach items="${row.getRoles()}" var="item">
         		<c:if test="${item.getRole() eq 'host' }">
					<c:param name="role" value="10"/>
					<c:param name="requestID" value="${row.getRequest().getIdHost()}"/>										
					<c:param name="request" value="${row.getRequest().getPending()}"/>
				</c:if>
			</c:forEach>
			
         	
         </c:url>">${row.getIdUser()}</a>
        </td>
			<td>${row.getUsername()}</td>
			<c:choose>
			<c:when test="${row.getRequest() != null }">
				<c:choose>	
				<c:when test="${row.getRequest().getPending() == '1' }">
					<td><font color="red">Pending</font></td>
				</c:when>
				<c:when test="${row.getRequest().getPending() == '0' }">
					<td>Accepted</td>
				</c:when>
				</c:choose>
			</c:when>
			<c:when test="${row.getRequest() == null }">
				<td>No Request</td>
			</c:when>
			</c:choose>
			
			<c:forEach items="${row.getRoles()}" var="item">
    				<td>${item.getRole()}</td>
			</c:forEach>
			<c:if test="${row.getRoles().size() == '2' }">
				<td>---</td>
			</c:if>
			<c:if test="${row.getRoles().size() == '1' }">
				<td>---</td>
				<td>---</td>
			</c:if>
			
        </tr>
    </c:forEach>
	
</table>

</body>
</html>

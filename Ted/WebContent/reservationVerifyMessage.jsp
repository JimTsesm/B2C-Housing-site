<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String role1=(String)session.getAttribute("role1"); %>
<% String role2=(String)session.getAttribute("role2"); %>

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Welcome page</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/hostVerifyMessage.css">

  
</head>

<body>
  <br>
  <div class="paragraph">Your reservation has been committed</p>
  <br><br>
  <c:if test="${role1 eq 'tenant' && empty role2}">
  <div class="rerun"><a href="logedIn-tenant.jsp">Go to welcome page</a></div>
  </c:if>
  <c:if test="${role1 eq 'tenant' && role2 eq 'host'}">
  <div class="rerun"><a href="logedIn-host_tenant.jsp">Go to welcome page</a></div>
  </c:if>
  <c:if test="${role1 eq 'host' && role2 eq 'tenant'}">
  <div class="rerun"><a href="logedIn-host_tenant.jsp">Go to welcome page</a></div>
  </c:if>
	<!--href to hostPage-->
<!-- Portfolio--><a id="portfolio" href="http://andytran.me/" title="View my portfolio!"><i class="fa fa-link"></i></a>
<!-- CodePen--><a id="codepen" href="https://codepen.io/andytran/" title="Follow me!"><i class="fa fa-codepen"></i></a>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/login.js"></script>

</body>
</html>

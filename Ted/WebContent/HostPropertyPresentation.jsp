<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="model.User" %>
<% HttpSession sess = request.getSession(false);
	User user = (User)sess.getAttribute("logedInUser");
%>

<% String role1=(String)session.getAttribute("role1"); %>
<% String role2=(String)session.getAttribute("role2"); %>

<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link rel="stylesheet" href="css/apartment_rental.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Raleway:300,500,800|Old+Standard+TT' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:300,500,800' rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- uniform -->
<link type="text/css" rel="stylesheet" href="assets/uniform/css/uniform.default.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/wow/animate.css" />


<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">


<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">

<link rel="stylesheet" href="assets/style.css">
</head>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.mySlides {display:none}
</style>
<body class="w3-content w3-border-left w3-border-right">

<c:set var="total" scope="session" value="${fn:length(list2)}"/>
<c:set var="perPage" scope="session"  value="10"/>
<c:set var="pageStart" value="${param.start}"/>
<c:if test="${empty pageStart or pageStart < 0}">
<c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${total <= pageStart}">
<c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>


<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <span class="w3-bar-item">Rental</span>
  <a href="javascript:void(0)" class="w3-right w3-bar-item w3-button" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>


<!-- !PAGE CONTENT! -->
<div class="w3-main w3-white" style="margin-left:260px">


  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:80px"></div>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-red w3-card-2 w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <c:if test="${role1 eq 'host' && empty role2}">
    <a href="logedIn.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
    </c:if>
    <c:if test="${role1 eq 'tenant' && role2 eq 'host'}">
    <a href="logedIn-host_tenant.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
    </c:if>
    <c:if test="${role1 eq 'host' && role2 eq 'tenant'}">
    <a href="logedIn-host_tenant.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
    </c:if>
    <a href="logOutServlet" class="w3-bar-item w3-button w3-black w3-padding-large w3-hover-white">Log out</a>
    
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
  </div>
</div>
<br><br><br>

  <!-- Slideshow Header -->
  
    
	<div class="w3-container">
		<div class="row">
			<c:forEach var="item" items="${list2}" begin="${pageStart}" end="${pageStart + perPage - 1}" >
			<div class="col-sm-6 wowload fadeInUp"><div class="rooms"><img src="${item.getPictureUrl()}" class="img-responsive"><div class="info"><h3>${item.getId()}</h3><p><b>Type:</b>${item.getRoomType()}<br><b>Street:</b>${item.getStreet()},<br></p>
			<a href="<c:url value="PropertyEditServlet" >
			<c:param name="PropId" value="${item.getId()}"/>
          	<c:param name="BedsNum" value="${item.getBeds()}"/>
          	<c:param name="BedRoomsNum" value="${item.getBedrooms()}"/>
          	<c:param name="BathsNum" value="${item.getBathrooms()}"/>
          	<c:param name="RoomType" value="${item.getRoomType()}"/>
          	<c:param name="SquareSpace" value="${item.getSquareFeet()}"/>
            <c:param name="Description" value="${item.getDescription()}"/>
            <c:param name="MinNights" value="${item.getMinimumNights()}"/>
            <c:param name="Lat" value="${item.getLatitude()}"/>
            <c:param name="Lon" value="${item.getLongitude()}"/>
            <c:param name="Street" value="${item.getStreet()}"/>
            <c:param name="Neighbourhood" value="${item.getNeighbourhood()}"/>
            <c:param name="Transit" value="${item.getTransit()}"/>
          	</c:url>"
			class="btn btn-default">Edit</a></div></div></div>
			</c:forEach>
		</div>
	</div>
	
	<a href="?start=${pageStart - perPage}" class="btn btn-default">Previous</a>${pageStart +1} - ${pageStart + perPage} 
	<a  href="HostPropertyPresentation.jsp?start=${pageStart + perPage}" class="btn btn-default">Next</a><br/>
    
  <hr>
  
  

<script>
// Script to open and close sidebar when on tablets and phones
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Slideshow Apartment Images
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-opacity-off";
}
</script>

</body>
</html>
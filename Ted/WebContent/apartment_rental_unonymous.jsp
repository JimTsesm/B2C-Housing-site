<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="model.User" %>
<% HttpSession sess = request.getSession(false);
	User user = (User)sess.getAttribute("logedInUser");
%>

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

<c:set var="total" scope="session" value="${fn:length(list)}"/>
<c:set var="perPage" scope="session"  value="10"/>
<c:set var="pageStart" value="${param.start}"/>
<c:if test="${empty pageStart or pageStart < 0}">
<c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${total <= pageStart}">
<c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-light-grey w3-collapse w3-top" style="z-index:3;width:260px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-transparent w3-display-topright"></i>
    <h3>Found ${total }</h3>
    <h6>properties</h6>
    <hr>
    <form action="searchPropertyFilterServlet" method="get">
      <p><label><i class="fa fa-calendar-check-o"></i>Property Type</label></p>
	  <select class="custom-dropdown" name="menu">
		<option>Private Room</option>
		<option>Shared Room</option>
		<option>House</option>
	  </select>      
	  <br><br><p><label><i class="fa fa-calendar-o"></i> Price Range</label></p>
      <input class="w3-input w3-border" type="number" placeholder="Min" name="min" > 
      <input class="w3-input w3-border" type="number" placeholder="Max" name="max" >         	  
      <br><p><label><i class="fa "></i> Amenities</label></p>
		<div class="checkboxes">
		<div class="label1" for="x"> <input class="input1" type="checkbox" name="box1" id="x" /> <span>Wifi</span></div>
		<div class="label1" for="y"> <input class="input1" type="checkbox" name="box2" id="y" /> <span>Air Conditioning</span></div>
		<div class="label1" for="z"> <input class="input1" type="checkbox" name="box6" id="z" /> <span>Heating</span></div> 
		<div class="label1" for="u"> <input class="input1" type="checkbox" name="box7" id="u" /> <span>Kitchen</span></div> 
		<div class="label1" for="h"> <input class="input1" type="checkbox" name="box3" id="h" /> <span>Tv</span></div> 		
		<div class="label1" for="r"> <input class="input1" type="checkbox" name="box4" id="r" /> <span>Parking</span></div> 
		<div class="label1" for="k"> <input class="input1" type="checkbox" name="box5" id="k" /> <span>Elevator</span></div> 		
		</div>
      <br><p><button class="w3-button w3-block w3-green w3-left-align" type="submit"><i class="fa fa-search w3-margin-right"></i> Search availability</button></p>
    </form>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <span class="w3-bar-item">Rental</span>
  <a href="javascript:void(0)" class="w3-right w3-bar-item w3-button" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>


<!-- !PAGE CONTENT! -->
<div class="w3-main w3-white" style="margin-left:260px">

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-red w3-card-2 w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="index.html" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
    
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
  </div>
</div>

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:80px"></div>

  <!-- Slideshow Header -->
  
    
	<div class="w3-container">
		<div class="row">
			<c:forEach var="item" items="${list}" begin="${pageStart}" end="${pageStart + perPage - 1}" >
			<div class="col-sm-6 wowload fadeInUp"><div class="rooms"><img src="${item[13]}" class="img-responsive"><div class="info"><h3>${item[0]}</h3><p><b>Price/day:</b>${item[56]},<b>Type:</b>${item[48]}<br><b>Bed(s):</b>${item[52]},<b>Review(s):</b>${item[72]}<br><b>Star(s):</b>${item[81]/2}</p>
			<a href="<c:url value="RoomDetailServlet" >
          	<c:param name="BedsNum" value="${item[52]}"/>
          	<c:param name="BedRoomsNum" value="${item[51]}"/>
          	<c:param name="BathsNum" value="${item[50]}"/>
          	<c:param name="RoomType" value="${item[48]}"/>
          	<c:param name="SquareSpace" value="${item[55]}"/>
          	<c:param name="host_id" value="${item[16]}"/>
          	<c:param name="Am" value="${item[54]}"/>
          	
            <c:param name="Description" value="${item[7]}"/>
            <c:param name="MinNights" value="${item[63]}"/>
            <c:param name="Lat" value="${item[44]}"/>
            <c:param name="Lon" value="${item[45]}"/>
            <c:param name="Street" value="${item[34]}"/>
            <c:param name="Neighbourhood" value="${item[35]}"/>
            <c:param name="Transit" value="${item[11]}"/>
            <c:param name="photo1" value="${item[91]}"/>
            <c:param name="photo2" value="${item[92]}"/>
            <c:param name="photo3" value="${item[93]}"/>
            <c:param name="photo4" value="${item[94]}"/>
          	</c:url>"
			class="btn btn-default">Check Details</a></div></div></div>
			</c:forEach>
		</div>
	</div>
	
	<a href="?start=${pageStart - perPage}" class="btn btn-default">Previous</a>${pageStart +1} - ${pageStart + perPage} 
	<a  href="apartment_rental_unonymous.jsp?start=${pageStart + perPage}" class="btn btn-default">Next</a><br/>
    
  <hr>
  	
  
  <footer class="w3-container w3-padding-16" style="margin-top:32px">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></footer>

<!-- End page content -->
</div>

<!-- Subscribe Modal -->
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide">SUBSCRIBE</h2>
      <p>Join our mailing list to receive updates on available dates and special offers.</p>
      <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail"></p>
      <button type="button" class="w3-button w3-padding-large w3-green w3-margin-bottom" onclick="document.getElementById('subscribe').style.display='none'">Subscribe</button>
    </div>
  </div>
</div>

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
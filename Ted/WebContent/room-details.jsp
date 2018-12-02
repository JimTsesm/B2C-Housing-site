<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String role1=(String)session.getAttribute("role1"); %>
<% String role2=(String)session.getAttribute("role2"); %>
    <% String BedsNum = (String)request.getAttribute("BedsNum"); %>
    <% String BathsNum = (String)request.getAttribute("BathsNum"); %>
    <% String BedRoomsNum = (String)request.getAttribute("BedRoomsNum"); %>
    <% String SquareSpace = (String)request.getAttribute("SquareSpace"); %>
    <% String RoomType = (String)request.getAttribute("RoomType"); %>
    <% String Description = (String)request.getAttribute("Description"); %>
	<% String MinNights = (String)request.getAttribute("MinNights"); %>
	<%	String Lat = (String)request.getAttribute("Lat"); %>
	<%	String Lon = (String)request.getAttribute("Lon"); %>
	<%  String Street = (String)request.getAttribute("Street"); %>
	<%	String Neighbourhood = (String)request.getAttribute("Neighbourhood"); %>
	<%  String Transit = (String)request.getAttribute("Transit"); %>
	<%  String Id = (String)request.getAttribute("Id"); %>	
	<%	String host_username = (String)request.getAttribute("host_username"); %>
	<%  String Am = (String)request.getAttribute("Am"); %>
	<%  String photo1 = (String)request.getAttribute("photo1"); %>
	<%  String photo2 = (String)request.getAttribute("photo2"); %>
	<%  String photo3 = (String)request.getAttribute("photo3"); %>
	<%  String photo4 = (String)request.getAttribute("photo4"); %>
	
	<%String Kitchen;%>
	<%String TV; %>
	<%String Internet; %>
	<%String Wireless; %>
	<%String Air; %>
	<%String Heating; %>
	<%String Pets; %>
	<%String Events;%>
	<%String Smoking; %>
	
	<% if (Am.contains("Kitchen"))  
	Kitchen = "Yes"; 
	else Kitchen = "No"; %>
	<% if (Am.contains("TV"))  
	TV = "Yes"; 
	else TV = "No"; %>
	<% if (Am.contains("Internet"))  
	Internet = "Yes"; 
	else Internet = "No"; %>
	<% if (Am.contains("Wireless Internet"))  
	Wireless = "Yes"; 
	else Wireless = "No"; %>
	<% if (Am.contains("Air Conditioning"))  
	Air = "Yes"; 
	else Air = "No"; %>
	<% if (Am.contains("Heating"))  
	Heating = "Yes"; 
	else Heating = "No"; %>
	<% if (Am.contains("Pets Allowed"))  
	Pets = "Yes"; 
	else Pets = "No"; %>
	<% if (Am.contains("Suitable for Events"))  
	Events = "Yes"; 
	else Events = "No"; %>
	<% if (Am.contains("Smoking"))  
	Smoking = "Yes"; 
	else Smoking = "No"; %>
	
		
	<% float lat = Float.parseFloat(Lat); %>
	<% float lon = Float.parseFloat(Lon); %>
	
	
	<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="room-details.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.mySlides {display:none}
</style>
<body class="w3-content w3-border-left w3-border-right">

<!-- Sidebar/menu -->

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

<div class="w3-top">
  <div class="w3-bar w3-red w3-card-2 w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <c:if test="${role1 eq 'tenant' && empty role2}">
    <a href="logedIn-tenant.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
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

  <!-- Slideshow Header -->
  <div class="w3-container" id="apartment">
    <h2 class="w3-text-green">The Apartment</h2>
    <div class="w3-display-container mySlides">
    <img src="${photo1 }" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Living Room</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
    <img src="${photo2 }" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Dining Room</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
    <img src="${photo3 }" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Bedroom</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
    <img src="${photo4 }" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Other</p>
      </div>
    </div>
  </div>
  <div class="w3-row-padding w3-section">
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${photo1 }" style="width:100%;cursor:pointer" onclick="currentDiv(1)" title="Living room">
    </div>
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${photo2 }" style="width:100%;cursor:pointer" onclick="currentDiv(2)" title="Dining room">
    </div>
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${photo3 }" style="width:100%;cursor:pointer" onclick="currentDiv(3)" title="Bedroom">
    </div>
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${photo4 }" style="width:100%;cursor:pointer" onclick="currentDiv(4)" title="Second Living Room">
    </div>
  </div>

  <div class="w3-container">
    <h4><strong>The space</strong></h4>
    <div class="w3-row w3-large">
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-male"></i> Beds: <%= BedsNum %></p>
        <p><i class="fa fa-fw fa-bath"></i> Bathrooms: <%= BathsNum %></p>
        <p><i class="fa fa-fw fa-bed"></i> Bedrooms: <%= BedRoomsNum %></p>
      </div>
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-clock-o"></i> Square Space: <%= SquareSpace %></p>
        <p><i class="fa fa-fw fa-clock-o"></i> Room Type: <%= RoomType %></p>
      </div>
    </div>
    <hr>
    
    <h4><strong>Amenities</strong></h4>
    <div class="w3-row w3-large">
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-shower"></i> Air Conditioning: <%=Air %></p>
        <p><i class="fa fa-fw fa-wifi"></i> WiFi: <%= Wireless %> </p>
        <p><i class="fa fa-fw fa-tv"></i> Internet: <%= Internet %></p>
        <p><i class="fa fa-fw fa-tv"></i> Pets Allowed: <%= Pets %></p>
        <p><i class="fa fa-fw fa-tv"></i> Suitable for Events: <%= Events %></p>
      </div>
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-cutlery"></i> Kitchen: <%= Kitchen %></p>
        <p><i class="fa fa-fw fa-thermometer"></i> Heating : <%= Heating %></p>
        <p><i class="fa fa-fw fa-wheelchair"></i> TV: <%= TV %></p>
        <p><i class="fa fa-fw fa-tv"></i> Smoking: <%= Smoking %></p>
      </div>
    </div>
    <hr>
    
    <h4><strong>Description</strong></h4>
    <p><%= Description %></p>
    <hr>
    
    <h4><strong>Rules</strong></h4>
    <p> Minimum Nights: <%=MinNights%> </p>
    
    <h4><strong>Location</strong></h4>
    <p>Street: <%= Street %></p>
    <p>Neighbourhood: <%= Neighbourhood %></p>
    <p>Transit: <%= Transit %></p>
    <div id="map" style="width:400px;height:400px;background:yellow"></div>
    
  <a class="btn btn-default button" 
  	href="<c:url value="reservationServlet" >
          	<c:param name="id" value="${Id}"/>
          	</c:url>">Make Reservation</a>
  </div>
  <hr>
  
  <!-- Contact -->
  <div class="w3-container" id="contact">
    <h2>Contact</h2>
    <p>To contant with the host send him a message using this username:<b>${host_username}</b></p>
  </div>
  
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

<script>
function myMap() {
	var myLatLng = {lat: <%=lat%>, lng: <%=lon%>};
	var mapOptions = {
    	center: new google.maps.LatLng(<%=lat%>,<%=lon%>),
    	zoom: 10,
    	mapTypeId: google.maps.MapTypeId.HYBRID
	}
	var map = new google.maps.Map(document.getElementById("map"), mapOptions);
	var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: '<%= Street %>'
      });
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCDuHvVsKmNZSzY5_nesUnujGeeIu4o71E&callback=myMap"></script>

</body>
</html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Listing" %>

<% String name=(String)session.getAttribute("name"); %>
<% String surname=(String)session.getAttribute("surname"); %>
<% String username=(String)session.getAttribute("username"); %>
<% String idUser=(String)session.getAttribute("idUser"); %>
<% String password=(String)session.getAttribute("password"); %>
<% String mail=(String)session.getAttribute("mail"); %>
<% String phone=(String)session.getAttribute("phone"); %>
<% String Pending=(String)session.getAttribute("Pending"); %>
<%
int P = Integer.parseInt(Pending);
String pend;
if (P==1) pend = "request pending";
else pend = "request accepted";
%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}

#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #DEB887;
    color: #000000;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-red w3-card-2 w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
     
    <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
    	  href = "EditProfileServlet"> Edit Profil </a>
    <button class="w3-bar-item2 w3-button w3-black w3-padding-large w3-hover-white" onmouseover="myFunction()">Request Status</button>
    <a href="mailServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Messages</a>
    <a href="InsertPropertyServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"> Insert Property</a>
    <a href="ShowPropertiesServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">My Properties</a>
	<a href="logOutServlet" class="w3-bar-item2 w3-button w3-black w3-padding-large w3-hover-white">Log out</a>
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Edit Profil</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Pending or Not</a>
    <a href="" class="w3-bar-item w3-button w3-padding-large">Log out</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
  </div>
</div>

<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Looking for Residence?</h1>
  <form action="searchPropertyServlet" method="post" id="search">
	<input type="text" name="box1" placeholder="Country"/>
	<input type="text" name="box2" placeholder="Town"/>
	<input type="text" name="box3" placeholder="Neighborhood"/><br><br>
	<input id="checkin" min="" onchange="updatedate();" name="box4" placeholder="CheckIn" class="textbox-n" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date" required/>
	<input id="checkout" min="" name="box5" placeholder="CheckOut" class="textbox-n" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date" required/>
	<input type="number" name="box6" placeholder="People" required/><br><br>
	<button class="button" style="vertical-align:middle" onclick="checkDates()"><span>Go</span></button>  
	</form>
</header>


<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">  
  <div class="w3-xlarge w3-padding-32">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
 </div>
 <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>


<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
if(dd<10){
	dd='0'+dd
	} 
if(mm<10){
    mm='0'+mm
    } 
today = yyyy+'-'+mm+'-'+dd;
document.getElementById("checkin").min= today;
</script>

<div id="snackbar"><%= pend %></div>
<script>
function myFunction() {
    var x = document.getElementById("snackbar")
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}
</script>

<script src="js/home.js"></script>

</body>
</html>

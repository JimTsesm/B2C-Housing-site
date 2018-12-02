<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<% String BedsNum = (String)request.getAttribute("BedsNum"); %>
    <% String BathsNum = (String)request.getAttribute("BathsNum"); %>
    <% String BedRoomsNum = (String)request.getAttribute("BedRoomsNum"); %>
    <% String SquareSpace = (String)request.getAttribute("SquareSpace"); %>
    <% String RoomType = (String)request.getAttribute("RoomType"); %>
    <% String Description = (String)request.getAttribute("Description"); %>
	<% String MinNights = (String)request.getAttribute("MinNights"); %>
	<%  String Street = (String)request.getAttribute("Street"); %>
	<%	String Neighbourhood = (String)request.getAttribute("Neighbourhood"); %>
	<%  String Transit = (String)request.getAttribute("Transit"); %>
	<%  String PropId = (String)request.getAttribute("PropId"); %>




<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/login.css">
      
</head>

<body>
  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Edit Property</h1>	
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Edit your Property</h1>
    <form method="post" action="PropertyEditActionServlet" enctype="multipart/form-data">
    
    <input type="hidden" size="30" name="PropId" value=<%=PropId%>>
    
    <div class="input-container">
        <input  name="BedsNum" type="number"  required="required" value=<%=BedsNum%>>
        <label>Beds Number</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input name="BathsNum" type="number"  required="required" value=<%=BathsNum%>>
        <label>Bathrooms Number</label>
        <div class="bar"></div>
	  </div>
    
      <div class="input-container">
        <input name="BedRoomsNum" type="number" required="required" value=<%=BedRoomsNum%>>
        <label>Bedrooms Number</label>
        <div class="bar"></div>
      </div>
      
      
     <div class="input-container">
        <input  name="RoomType" type="text" list = "options" required="required">
        <label>Type</label>
        <div class="bar"></div>
        <datalist id="options">
        <option value="Entire home/apt">
        <option value="Private Room">
        <option value="Shared Room">
        </datalist>
	  </div>
	  
	  <div class="input-container">
        <input name="Description" type="text"  required="required"  value=<%=Description%>>
        <label>Description</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input name="Street" type="text"  required="required"  value=<%=Street%>>
        <label>Street</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input name="MinNights" type="number"  required="required"  value=<%=MinNights%>>
        <label>MinNights</label>
        <div class="bar"></div>
	  </div>
	  
	  
	  <div class="input-container">
        <input name="Transit" type="text"  required="required"  value=<%=Transit%>>
        <label>Transit</label>
        <div class="bar"></div>
	  </div>
	  
	  
	  <div id="map" style="width:400px;height:400px;background:yellow"></div>
	
		<input name = "Lat" type="text" id="latFld" required="required">
    	<input name = "Lon" type="text" id="lngFld" required="required"><br><br>
    	
    	<input type="file" name="file">
        <label>Property Photo</label>
        <div class="bar"></div>
	  
      <div class="button-container">
        <button><span>Edit Property</span></button>
      </div>
      
    </form>
  </div>
</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/login.js"></script>
    
    <script>
  
  var map;
  var markersArray = [];
  
  function myMap() 
  
  {
  
    var myLatLng = {lat: 3.759, lng: 2.344};
	var mapOptions = {
  	center: new google.maps.LatLng(3.759,2.344),
  	zoom: 1,
  	mapTypeId: google.maps.MapTypeId.ROADMAP
	}
	var map = new google.maps.Map(document.getElementById("map"), mapOptions);

	 google.maps.event.addListener(map, "click", function(event)
	            {
	                // place a marker
	                placeMarker(event.latLng);

	                // display the lat/lng in your form's lat/lng fields
	                document.getElementById("latFld").value = event.latLng.lat();
	                document.getElementById("lngFld").value = event.latLng.lng();
	            });
  }
     
  function placeMarker(location) {
      // first remove all markers if there are any
      deleteOverlays();

      var marker = new google.maps.Marker({
          position: location, 
          map: map
      });

      // add marker in markers array
      markersArray.push(marker);

      //map.setCenter(location);
  }

  // Deletes all markers in the array by removing references to them
  function deleteOverlays() {
      if (markersArray) {
          for (i in markersArray) {
              markersArray[i].setMap(null);
          }
      markersArray.length = 0;
      }
  }

</script>

 

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCDuHvVsKmNZSzY5_nesUnujGeeIu4o71E&callback=myMap"></script>

</body>
</html>
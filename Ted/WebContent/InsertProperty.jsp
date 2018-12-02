<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>

      <link rel="stylesheet" href="css/insertProperty.css">
      
</head>

<body>

  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Insert Property</h1>	
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Complete all the fields</h1>
    <form method="post" action="InsertPropertyActionServlet" enctype="multipart/form-data" id="container7">
    
	<div id="map" style="width:400px;height:400px;background:yellow"></div>
	
	<input name = "Lat" type="text" id="latFld" required="required">
    <input name = "Lon" type="text" id="lngFld" required="required"><br><br>
	
	<div class="input-container">
        <input  name="City" type="text"  required="required">
        <label>City</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="Neighborhood" type="text"  required="required">
        <label>Neighbourhood</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="Country" type="text"  required="required">
        <label>Country</label>
        <div class="bar"></div>
	  </div>
	  
    <div class="input-container">
        <input  name="Street" type="text"  required="required">
        <label>Street</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="Transit" type="text"  required="required">
        <label>Transit</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="MaxPeople" type="number"  required="required">
        <label>Max People</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="MinNights" type="number"  required="required">
        <label>Minimum Nights</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="ExtraCostPerPerson" type="number"  required="required">
        <label>Extra cost per person</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="Price" type="number"  required="required">
        <label>Price</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="Type" type="text" list = "options" required="required">
        <label>Type</label>
        <div class="bar"></div>
        <datalist id="options">
        <option value="Entire home/apt">
        <option value="Private Room">
        <option value="Shared Room">
        </datalist>
	  </div>
	  
	  <div class="input-container2">
	    <label>Amenities</label>
		<div class="checkboxes">
		<div class="label1" for="y"> <input class="input1" type="checkbox" name="box1" id="y" /> <span>TV</span></div>
		<div class="label1" for="z"> <input class="input1" type="checkbox" name="box2" id="z" /> <span>Wireless Internet</span></div>
		<div class="label1" for="x"> <input class="input1" type="checkbox" name="box2" id="x" /> <span>Kitchen</span></div>
		<div class="label1" for="c"> <input class="input1" type="checkbox" name="box4" id="c" /> <span>Air Conditioning</span></div> 
		<div class="label1" for="b"> <input class="input1" type="checkbox" name="box5" id="b" /> <span>Smoking</span></div>
		<div class="label1" for="m"> <input class="input1" type="checkbox" name="box6" id="m" /> <span>Pets Allowed</span></div> 
		</div>
	   </div>
	  
	  <div class="input-container">
        <input  name="Description" type="text"  required="required">
        <label>Description</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="BedsNum" type="number"  required="required">
        <label>Beds Number</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="BedRoomsNum" type="number"  required="required">
        <label>Bedrooms Number</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input  name="BathsNum" type="number" step="any" required="required">
        <label>BathsNum</label>
        <div class="bar"></div>
	  </div>
	   
	  <input type="file" name="file" required="required">
        <label>Property Photo</label>
        <div class="bar"></div>
        
        <input type="file" name="file1" required="required">
        <label>Living Room</label>
        <div class="bar"></div>
        
        <input type="file" name="file2" required="required">
        <label>Dining room</label>
        <div class="bar"></div>
        
        <input type="file" name="file3" required="required">
        <label>BedRoom</label>
        <div class="bar"></div>
        
        <input type="file" name="file4" required="required">
        <label>Other</label>
        <div class="bar"></div>
        
	  <div class="input-container">
        <input id="1" min="" onchange="updatedate(1);" type="date" name="from1" required="required"/>
        <label>Rent From Date1</label>
        <div class="bar"></div>      
      </div>
	  <div class="input-container">
        <input id="2" min="" type="date" name="to1" required="required"/>
        <label>Rent To Date1</label>
        <div class="bar"></div>      
      </div>
	  <div class="input-container">
	  	<img src="images/add_button.jpg" onclick="addField()" style="width:25px;height:25px;" onmouseover="bigImg(this)" onmouseout="normalImg(this)">
	</div>
	  
      <div class="button-container">
        <button><span>Insert</span></button>
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
<script type='text/javascript'>
		var id=1;
		var id2=2;
        function addField(){      
		//get the number of child elements
		var number = document.getElementById('container7').childElementCount;
		id++;
		id2++;
		var temp_id = id2+1;
        //var container = document.getElementById("container7");
        var div1 = document.createElement('div');
		div1.className = 'input-container';
		
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

		div1.innerHTML = '<input id="' + id2 + '" min="' + today + '" onchange="updatedate(' + id2 +  ');" type="date" name="from' + id + '" required="required"/><label>Rent From Date' + id + '</label><div class="bar"></div>';
						 
			var div2 = document.createElement('div');
			div2.className = 'input-container';
			id2++;
		div2.innerHTML = '<input id="' + id2 + '" min="" type="date" name="to' + id + '" required="required"/><label>Rent To Date' + id + '</label><div class="bar"></div>';
		//document.getElementById('container7').appendChild(div);
		document.getElementById('container7').children[number-3].insertAdjacentElement("afterEnd", div1);
		document.getElementById('container7').children[number-2].insertAdjacentElement("afterEnd", div2);
            
        }
    </script>
	<script type='text/javascript'>
	function removeField(){
			//get the number of child elements
			var number = document.getElementById('container7').childElementCount;
			document.getElementById('container7').removeChild(document.getElementById('container7').childNodes[number-2]);
			//document.getElementById('container7').removeChild(document.getElementById('container7').childNodes[number-3];
		}
	</script>
	<script>
	function bigImg(x) {
    x.style.height = "35px";
    x.style.width = "35px";
	}

	function normalImg(x) {
    x.style.height = "25px";
    x.style.width = "25px";
	}
	</script>
	<script>
	function updatedate(id) {
    var firstdate = document.getElementById(id).value;
    var next_id = parseInt(id) + 1;
    var next_id_string = next_id.toString();
    var seconddate = document.getElementById(next_id_string);
    seconddate.min=firstdate;
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
  	document.getElementById("1").min= today;
  </script>

 

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCDuHvVsKmNZSzY5_nesUnujGeeIu4o71E&callback=myMap"></script>
</body>
</html>
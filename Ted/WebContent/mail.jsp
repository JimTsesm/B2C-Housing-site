<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String surname=(String)session.getAttribute("surname"); %>
<% String role1=(String)session.getAttribute("role1"); %>
<% String role2=(String)session.getAttribute("role2"); %>


<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><style>
html,body,h1,h2,h3,h4,h5 {font-family: "RobotoDraft", "Roboto", sans-serif;}
.w3-bar-block .w3-bar-item{padding:16px}
</style>
<body>

<!-- Side Navigation -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card-2" style="z-index:3;width:320px;" id="mySidebar">
  <c:if test="${role1 eq 'host' && empty role2}">	
  <a href="logedIn.jsp" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align">Home</a>
  </c:if>
  <c:if test="${role1 eq 'tenant' && empty role2}">	
  <a href="logedIn-tenant.jsp" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align">Home</a>
  </c:if>
  <c:if test="${role1 eq 'host' && role2 eq 'tenant'}">	
  <a href="logedIn-host_tenant.jsp" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align">Home</a>
  </c:if>
  <c:if test="${role1 eq 'tenant' && role2 eq 'host'}">	
  <a href="logedIn-host_tenant.jsp" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align">Home</a>
  </c:if>
  <h1 class="w3-bar-item w3-border-bottom w3-large">Mail Box</h1>
  <a href="javascript:void(0)" onclick="w3_close()" title="Close Sidemenu" 
  class="w3-bar-item w3-button w3-hide-large w3-large">Close <i class="fa fa-remove"></i></a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align" onclick="document.getElementById('id01').style.display='block'">New Message <i class="w3-padding fa fa-pencil"></i></a>
  <a id="myBtn" onclick="myFunc('Demo1')" href="javascript:void(0)" class="w3-bar-item w3-button"><i class="fa fa-inbox w3-margin-right"></i>Inbox<i class="fa fa-caret-down w3-margin-left"></i></a>
  <div id="Demo1" class="w3-hide w3-animate-left">
    <c:forEach var="row" items="${messages2}" varStatus = "status">
    	 <a href="javascript:void(0)" class="w3-bar-item w3-button w3-border-bottom test w3-hover-light-grey" onclick="openMail('${row.getIdMessage()}');w3_close();" ${status.first ? 'id="firstTab"' : ''}">
      		<div class="w3-container">
      		<c:if test="${surname eq row.getSender().getSurname()}">
        	<span class="w3-opacity w3-large">${row.getReceiver().getName()} ${row.getReceiver().getSurname()}</span>
        	</c:if>
        	<c:if test="${surname ne row.getSender().getSurname()}">
        	<span class="w3-opacity w3-large">${row.getSender().getName()} ${row.getSender().getSurname()}</span>
        	</c:if>
      		</div>
    	</a>
    </c:forEach>
  </div>
</nav>

<!-- Modal that pops up when you click on "New Message" -->
<form method="get" action="mailSendServlet">
<div id="id01" class="w3-modal" style="z-index:4">
  <div class="w3-modal-content w3-animate-zoom">
    <div class="w3-container w3-padding w3-red">
       <span onclick="document.getElementById('id01').style.display='none'"
       class="w3-button w3-red w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
      <h2>Send Mail</h2>
    </div>
    <div class="w3-panel">
      <label>To</label>
      <input name="to" class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Insert an existing username here">
      <label>Subject</label>
      <input name="subject" class="w3-input w3-border w3-margin-bottom" type="text">
      <input name="text" class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="What's on your mind?">
      <div class="w3-section">
        <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel  <i class="fa fa-remove"></i></a>
        <button class="w3-button w3-light-grey w3-right">Send  <i class="fa fa-paper-plane"></i></button> 
      </div>    
    </div>
  </div>
</div>
</form>

<!-- Overlay effect when opening the side navigation on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="Close Sidemenu" id="myOverlay"></div>

<!-- Page content -->
<div class="w3-main" style="margin-left:320px;">
<i class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top" onclick="w3_open()"></i>
<a href="javascript:void(0)" class="w3-hide-large w3-red w3-button w3-right w3-margin-top w3-margin-right" onclick="document.getElementById('id01').style.display='block'"><i class="fa fa-pencil"></i></a>

<c:forEach var="data" items="${messages}">
	<div id="${data.get(0)[0]}" class="w3-container person">
	<c:forEach var="row_data" items="${data}" varStatus="status">	
  		<br>
  		<c:if test="${status.first}">
  			<form method="get" action="mailDeleteServlet">	
  				<input name="idMessage" type="hidden" value="${row_data[0]}">
  				<button class="w3-button w3-light-grey">Delete Conversation<i class="w3-margin-left fa fa-mail-reply"></i></button>
			</form>
  		</c:if>
  		<h5 class="w3-opacity">Subject: ${row_data[1]}</h5>
  		<h4><i class="fa fa-clock-o"></i> ${row_data[3]}.</h4>
  		<hr>
  		<p>${row_data[2]}</p>
  		<c:if test="${status.last}">
  			<c:if test="${!status.first}">
  				<form method="get" action="mailReplyServlet">
  					<input name="text" class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="What's on your mind?">
  					<input name="to" type="hidden" value="${row_data[4]}">
  					<input name="idMessage" type="hidden" value="${row_data[0]}">
  					<input name="subject" type="hidden" value="${row_data[1]}">
  					<button class="w3-button w3-light-grey">Reply<i class="w3-margin-left fa fa-mail-reply"></i></button>
				</form>
			</c:if>
			<c:if test="${status.first}"> 
			<form method="get" action="mailReplyServlet">
  					<input name="text" class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="What's on your mind?">
  					<input name="to" type="hidden" value="${row_data[4].getIdUser()}">
  					<input name="idMessage" type="hidden" value="${row_data[0]}">
  					<input name="subject" type="hidden" value="${row_data[1]}">
  					<button class="w3-button w3-light-grey">Reply<i class="w3-margin-left fa fa-mail-reply"></i></button>
				</form>
			</c:if> 				
  		</c:if>
 	</c:forEach>
 	</div>
</c:forEach>
     
</div>

<script>
var openInbox = document.getElementById("myBtn");
openInbox.click();

function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

function myFunc(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show"; 
        x.previousElementSibling.className += " w3-red";
    } else { 
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-red", "");
    }
}

openMail("${row.get(0).getIdMessage()}")
function openMail(personName) {
    var i;
    var x = document.getElementsByClassName("person");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
    }
    x = document.getElementsByClassName("test");
    for (i = 0; i < x.length; i++) {
       x[i].className = x[i].className.replace(" w3-light-grey", "");
    }
    document.getElementById(personName).style.display = "block";
    event.currentTarget.className += " w3-light-grey";
}
</script>

<script>
var openTab = document.getElementById("firstTab");
openTab.click();
</script>

</body>
</html> 

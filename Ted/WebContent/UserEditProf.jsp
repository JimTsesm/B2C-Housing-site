<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<% String name=(String)session.getAttribute("name"); %>
<% String surname=(String)session.getAttribute("surname"); %>
<% String username=(String)session.getAttribute("username"); %>
<% String id=(String)session.getAttribute("idUser"); %>
<% String password=(String)session.getAttribute("password"); %>
<% String mail=(String)session.getAttribute("mail"); %>
<% String phone=(String)session.getAttribute("phone"); %>
<% String photo=(String)request.getAttribute("photo"); %>



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
  <h1>Edit Profile</h1>	
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Edit Profile</h1>
    <form method="post" action="EditProfilActionServlet" enctype="multipart/form-data">
    
    <input type="hidden" size="30" name="FD_profile_id" value=<%=id%>>

    <input type="hidden" size="30" name="FD_profile_username" value=<%=username%>>
    
    <div class="input-container">
        <input  name="FD_profile_last_name" type="text"  required="required" value=<%=surname%>>
        <label>Surname</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input name="FD_profile_first_name" type="text"  required="required" value=<%=name%>>
        <label>Name</label>
        <div class="bar"></div>
	  </div>
    
      <div class="input-container">
        <input name="FD_profile_email" type="text" required="required" value=<%=mail%>>
        <label>Mail</label>
        <div class="bar"></div>
      </div>
      
      <div class="input-container">
        <input name="FD_profile_phone" type="text"  required="required" value=<%=phone%>>
        <label>Phone</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
        <input name="FD_profile_password" type="password"  required="required"  value=<%=password%>>
        <label>Password</label>
        <div class="bar"></div>
	  </div>
	  
	  <div class="input-container">
	  <img src="data:image/png;base64, ${photo}" height="50%" width="50%"/>
	  </div>
	  
	  <input type="file" name="photo">
        <label>Photo</label>
        <div class="bar"></div>
        
         <label>Leave blank if you do not want to change the photo</label>
	  
      <div class="button-container">
        <button><span>Change user Profile</span></button>
      </div>
      
    </form>
  </div>
</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/login.js"></script>

</body>
</html>
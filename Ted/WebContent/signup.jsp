<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Signup Form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/login.css">

  
</head>

<body>
  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Sign Up Form</h1>	
</div>
<div class="rerun"><a href="signupServlet">Clear All</a></div>
<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Sign up</h1>
    <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
	<!--redirect according to checkbox-->
      <div class="input-container">
        <input name="username" type="text" required="required"/>
        <label>Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input name="password" type="password" id="password" required="required"/>
        <label>Password</label>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
        <input name="confirm_password" type="password" id="confirm_password" required="required"/>
        <label>Confirm Password</label>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
        <input name="name" required="required"/>
        <label>Name</label>
        <div class="bar"></div>
      </div>
	  <div class="input-container">
        <input name="surname" required="required"/>
        <label>Surname</label>
        <div class="bar"></div>
      </div>
	   <div class="input-container">
        <input name="email" required="required"/>
        <label>Email</label>
        <div class="bar"></div>
      </div>
	   <div class="input-container">
        <input name="phone" required="required"/>
        <label>Phone</label>
        <div class="bar"></div>
      </div>
	  
	   <div class="input-container2">
	    <label>Role</label>
		<div class="checkboxes">
		<div class="label1" for="y"> <input class="input1" type="checkbox" name="box2" id="y" /> <span>Host</span></div>
		<div class="label1" for="z"> <input class="input1" type="checkbox" name="box3" id="z" /> <span>Tenant</span></div> 
		</div>
	   </div>
        
        <input type="file" name="photo"/>
        <label>Photo</label>
        <div class="bar"></div>
        
      <div class="button-container">
        <button onclick="return validate();"><span>Go</span></button>
      </div>
    </form>
  </div>
</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/login.js"></script>

</body>
</html>

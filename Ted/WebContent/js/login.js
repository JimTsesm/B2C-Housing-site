$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});

$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});

var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

function validate() {
	var x=0;
	var checkedValue = null; 
	var inputElements = document.getElementsByClassName('input1');
	for(var i=0; inputElements[i]; ++i){
		if(inputElements[i].checked){
			x++;
		}	
	}
	if(x==0) 
	{
		alert("Please check at least 1 checkbox");
        return false;
	}
}
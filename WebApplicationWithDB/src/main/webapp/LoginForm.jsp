<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" src = "JS/jquery-3.6.0.js"></script>

<form action="" name="loginmembers" id="hai" >
<label for="Name">Name : </label>
<input type="text" id="Name" name="name" >
<br>
<label for="Password">Password : </label>
<input type="password" id="Password" name="pass">
<br>
<input type="button" id="buttonSubmit" value="Click me">

</form>
<div id="one"></div>




<script>

$("#buttonSubmit").click(function(){
	functionButton();
});

functionButton = function(){
	var name=document.getElementById("Name").value;
	var pass=document.getElementById("Password").value;
	
	var object={
			"url":"/users?name="+name+"&pass="+pass,
			"Method":"GET"
	};
	$.ajax(object).done(function(response){
		
		
	});
	
};


</script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loginpage</title>

<style type="text/css">
td{
background-color: lavenderblush;
text-align: center;
}
form{
    margin-top: 250px;
    margin-left: 40%;}

#buttonSubmit{
	margin-top: 20px;
    margin-left: 60px;
}

</style>
</head>
<body>

<script type="text/javascript" src = "JS/jquery-3.6.0.js"></script>

<button>Details viewer</button>

<form action="/users" method="POST" name="loginmembers" id="hai" >


<table>
 
  <tr>
    <td><label for="Name">Name : </label></td>
    <td><input type="text" id="Name" name="name" ></td> 
  </tr>
  <tr>
    <td><label for="Password">Password : </label></td>
    <td><input type="password" id="Password" name="pass"></td> 
  </tr>
</table>

<input type="submit" id="buttonSubmit" value="Click me">

</form>
<div id="one"></div>




<!-- <script>

$("#buttonSubmit").click(function(){
	functionButton();
});

functionButton = function(){
	var name=document.getElementById("Name").value;
	var pass=document.getElementById("Password").value;
	
	var object={
			"url":"/users?name="+name+"&pass="+pass,
			"Method":"POST"
	};
	$.ajax(object).done(function(response){
		
		
	});
	
};


</script> -->


</body>
</html>
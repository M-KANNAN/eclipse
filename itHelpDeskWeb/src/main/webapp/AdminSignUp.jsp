<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sysadmin Page</title>

 <link rel="stylesheet" href="/itHelpDeskWeb/src/main/webapp/ithelpdesk.css/usersignup.css">
 

</head>
<body>

<script type="text/javascript" src="jsQuery/jquery-3.6.0.js"></script>

	<%
	
	if(session.getAttribute("name") == null){
		response.sendRedirect("UserSignUp.jsp");
	}
	
	%>

            <div id="AdminUserdiv">
                <DIV id="heading_uTag">ADMIN SIGNUP</DIV>
                <table id="form1"  >
                    <form  >
                        <tr>
                            <td>
                                <label for="name"> Username : </label>
                            </td>
                            <td> 
                                <input type="text" id="aname" name ="aname" placeholder="Type a user name" required="required"/> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="pass">Password : </label>
                            </td>
                            <td>
                                <input type="password" id="apass" name = "apass" required="required"/>
                            </td>
                        </tr>
    
                        <tr>
                            <td >
                                <input type="button" value="Sign up" id="button_submit1" onclick="siginpFunction()">
                               
                            </td>
                            <td>
                            	 <input type="button" value="logout" id="button_submit2" onclick="logoutFunction()">
                            </td>
                        </tr> 
    
                    </form>
                </table>
    
            </div>
            
            <script type="text/javascript">
            	
            	
            /* $("#button_submit1").click(function(){
            	siginpFunction();
            }); */

            siginpFunction =function(){
            	var object={
   
            			"url" : "/itHelpDeskWeb/AdminSignUp.jsp",
            			"method":"POST"
            	};
            	
            	$.ajax(object).done(function(response){
            		//response=JSON.parse(response);
            		//console.log(response)
            		//$("#one").html(response);
            	});
            };
            
            logoutFunction()=function(){
            	
            	<%  
            		session.removeAttribute("name") ;
            		response.sendRedirect("SignInPage.jsp");
            	
            	%>
            	
            };
            
            
            
            </script>


</body>
</html>
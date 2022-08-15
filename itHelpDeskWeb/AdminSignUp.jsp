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
	
	response.setHeader("Cache-Control", "no-store");
	
	if( session.getAttribute("name") == null){
		response.sendRedirect("http://localhost:8080/itHelpDeskWeb/SignInPage.jsp"); // redirecting to the home page
	} 
	
	%>

            <div id="AdminUserdiv">
                <DIV id="heading_uTag">ADMIN SIGNUP</DIV>
                <table id="form1"  >
                    <form action="AdminUserSignUp" method="post">
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
                                <input type="submit" value="Sign up" id="button_submit1" >
                               
                            </td>
                            <td>
                            	 <input type="button"  value="logout" id="button_submit2" >
                            </td>
                        </tr> 
    
                    </form>
                </table>
    
            </div>
            
            <script type="text/javascript">
            

            $(document).ready(function(){
            	
            	$('#button_submit2').click(function(){

            		var object={
            				type :'POST',
                			url : 'UserSignOut',
                			error : function(){
                				window.location="SignInPage.jsp";
                			}  
                			
            		};
            		
            		$.ajax(object).done(function(response){
            			window.location="SignInPage.jsp";
            		}); 
            		
            	});
            	
            });
            

            </script>


</body>
</html>
<%@page import="com.ithelpdesk.javaclasses.TrashCleaner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>

 <link rel="stylesheet" href="/itHelpDeskWeb/src/main/webapp/ithelpdesk.css/usersignup.css">

</head>

<body>


<%

new TrashCleaner().trashCleaner();


%>

        <div >
        
        <button id="button_Login" onclick="loginFunction()" > Login </button>

            <div id="userSigindiv">
                <div id="heading_uTag"> USER SIGNUP</div>
                <table id="form1">
                    <form action="UserSignUpServlet" method="post">
                        <tr>
                            <td>
                                <label for="name"> Username : </label>
                            </td>
                            <td> 
                                <input type="text" id="name" name ="uname" placeholder="Type a user name" required="required"/> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="pass">Password : </label>
                            </td>
                            <td>
                                <input type="password" id="pass" name = "upass" required="required"/>
                            </td>
                        </tr>
    
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Sign in" id="button_submit1">
                            </td>
                        </tr> 
    
                    </form>
                </table>
    
            </div>
    
    
            <div id="adminSigindiv">
                <div id="heading_aTag"> SYSADMIN SIGNUP </div>
                <table id="form2" >
                    <form action="SysadminPage" method="post">
                        <tr>
                            <td>
                                <label for="name"> Username : </label>
                            </td>
                            <td> 
                                <input type="text" id="aname" name ="aname" placeholder="Type Sysadmin name" required="required"/> 
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
                            <td colspan="2">
                                <input type="submit" value="Sign in" id="button_submit2" >
                            </td>
                        </tr>
    
                    </form>
                </table>
    
            </div>

        </div>
        
        <script type="text/javascript">
        	
       		function loginFunction() {
       			window.location = "Userlogin.jsp";
			}

        </script>
      
      </body>
      
     </html>


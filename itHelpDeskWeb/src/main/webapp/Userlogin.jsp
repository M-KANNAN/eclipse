<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <link rel="stylesheet" href="/itHelpDeskWeb/src/main/webapp/ithelpdesk.css/usersignup.css">

<script type="text/javascript" src="jsQuery/jquery-3.6.0.js"></script>


            <div id="AdminUserdiv">
                <div id="heading_uTag">User Login</div>
                <table id="form1"  >
                    <form action="UserSignIn" method="post">
                        <tr>
                            <td>
                                <label for="name"> Username : </label>
                            </td>
                            <td> 
                                <input type="text" id="aname" name ="uname" placeholder="Type a user name" required="required"/> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="pass">Password : </label>
                            </td>
                            <td>
                                <input type="password" id="apass" name = "upass" required="required"/>
                            </td>
                        </tr>
    
                        <tr>
                            <td colspan="2">
                                <input type="submit" name="submit" value="Sign In" id="button_submit1" >
                               
                            </td>
                        </tr> 
    
                    </form>
                </table>
    
            </div>
            

</body>
</html>
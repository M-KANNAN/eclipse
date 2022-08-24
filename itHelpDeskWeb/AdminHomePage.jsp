<%@ page import="java.util.* , com.ithelpdesk.javaclasses.Userdetails , com.ithelpdesk.javaclasses.TicketDetails ,java.util.Map.Entry ,com.ithelpdesk.javaclasses.TrashCleaner" 


language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Homepage</title>

<link rel="stylesheet"
	href="/itHelpDeskWeb/ithelpdesk.css/Userhomepage.css">
	
</head>
<body>


<body>



	<%-- 
					<!-- //Declearation tag -->
					
					<%
					
					int userId = Integer.parseInt(session.getAttribute("UserId").toString());
					
					
					
					Userdetails userdetails=new Userdetails();

					HashMap<Integer, TicketDetails> userDetails = userdetails.getUserTickets(userId, true);
				/* 	
					for (Entry<Integer, TicketDetails> entry : userTickets.entrySet()) {
						TicketDetails details = entry.getValue();
						System.out.println(entry.getValue().getDiscription());
						}  */
		

					%> --%>


 


	<script type="text/javascript" src="jsQuery/jquery-3.6.0.js"></script>


	<%
	response.setHeader("Cache-Control", "no-store");

	if (session.getAttribute("name") == null) {
		response.sendRedirect("http://localhost:8080/itHelpDeskWeb/Userlogin.jsp"); // redirecting to the Login page
	}
	%>



	<div>

		<h1 id="banner">Welcome to IT Help Desk</h1>

		<div id="lable">LOGOUT :</div>

		<div id="name">${ name }</div>

		<div>

			<div>

				<ul>
					<li id="Ticket_Raiser"><a href="#">Raise a Ticket</a></li>
					<li id="View_Tickets"><a href="#">View Raised Ticket</a></li>
					<!-- <li id="MyclosedTickets"><a href="#">My Closed Ticket</a></li> -->
					<li id="PickRequest"><a href="#">Pick a support Request</a></li>
					<li id="MyRequest"><a href="#">My Assigned Tickets</a></li>
					<li id="ClosedTickets"><a href="#">Assigned Closed Tickets</a></li>
					<li id="ArchiveTickets"><a href="#">Archived Tickets</a></li>

				</ul>

				<div id="Ticket_Raiser_form">

					<div id="ticket_Raiser_outer_box">
						<DIV id="ticket_Raiser_Heading">Ticket Raiser</DIV>
						<table id="ticketForm">
							<form action="UserTicketRaiser" method="post">

								<tr>
									<td><label for="subject">Subject : </label></td>
									<td><input type="text" id="subject" name="subject"
										placeholder="Type a subject ..." required="required" /></td>
								</tr>

								<tr>
									<td><label for="discription"> Discription : </label></td>
									<td><textarea type="text" id="discription"
											name="discription" placeholder="Type a Discription ..."
											required="required"></textarea></td>
								</tr>


								<tr>
									<td colspan="2"><input type="submit" value="Submit"
										id="button_submit1"></td>

								</tr>

							</form>
						</table>

					</div>


				</div>


			</div>


			<div id="user_Tickets" style="display:none;"></div>
			
			

			<div id="ticket_Updator" style="display:none;">
			<br>

				<div id="ticket_Updator_form" style="display:none;"></div>
				<br>

			</div>
			
			<!-- chat -->
			<div id="UserTickets_for_chat" style="display:none;"></div>
			<br>
			
			<div id="chat_details" style="display:none;"></div>
			<br>
			
			<!-- Pick User Request -->
			
			<div id="pick_UserRequest" style="display:none;"></div>
			<br>
			
			<!-- Show Admin Assigned Tickets  -->
			
			<div id="My_assigned_Tickts" style="display:none;"></div>
			<br>
	
			
				<%-- <table width="100%" border="1"> <tr ><th>Ticket No</th><th>Admin Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th></tr>
				
			 	<c:forEach items="${map}" var="entry">
	
					hai
					
				    <tr> <td> ${entry.key} </td> <td>${entry.value.getAdminName()} </td> <td> ${entry.value.getSubject()} </td><td> ${entry.value.getDiscription()} </td><td> ${entry.value.getTicket_Status()} </td><td> ${entry.value.getTimeOfCreation()} </td> </tr>
				    
				</c:forEach> 
					
				</table>
				
			 --%>

		</div>


	</div>

	<script type="text/javascript">
	
	
		//logout function
		$(document).ready(function() {

			$('#name').click(function() {

				var object = {
					type : 'POST',
					url : 'UserSignOut',
					error : function() {
						window.location = "Userlogin.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					window.location = "Userlogin.jsp";
				});

			});

		});

		//ticket raiser invoke

		$(document).ready(function() {

			$('#Ticket_Raiser').click(function() {

				var divElement = document.getElementById("Ticket_Raiser_form");

				if (divElement.style.display === 'none') {
					divElement.style.display = 'block';
				} else {
					divElement.style.display = 'none';
				}

			});

		});

		//View tickets

		$(document).ready(function() {

			$('#View_Tickets').click(function() {

				var divElement = document.getElementById("user_Tickets");

				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';

					var object = {
						type : 'GET',
						url : 'ViewRaisedSupportTickets',
						error : function() {
							window.location = "Userlogin.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#user_Tickets').html(response);
					});

				} else {
			
					divElement.style.display = 'none';
				}

			});

		});
		

		// chat Implementation
		
		function getIdFunction(ticketNo) { //  check wheather admin is available to chat 
			
			
			var object = {
					type : 'POST',
					data : {
						ticketNo : ticketNo
						
					},
					url : 'ChattingImplementation',
					error : function(error) {
						alert(error.stack);
						window.location = "UserHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					$('#chat_details').html(response);
				});

			
		}
		
		
		function ticketChatFunction(ticketNo){ //
			
			var divElement = document.getElementById("chat_details");

			if (divElement.style.display === 'none') {

				divElement.style.display = 'block';
				var object = {
					type : 'POST',
					data : {
						ticketNo : ticketNo
						
					},
					url : 'GetChatDetails',
					error : function(error) {
						alert(error.stack);
						window.location = "UserHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					$('#chat_details').html(response);
				});

			} else {
				divElement.style.display = 'none';
			}

		}
		
		
		function messageFunction(){ 
			
			var message=document.getElementById("message_sender").value;
			
			var object = {
					type : 'POST',
					data : {
						
						message : message
					},
					url : 'UserMessageSender',
					error : function(error) {
						alert(error.stack);
						window.location = "UserHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response,xhr) {
					
					if(xhr.status == 203){
						alert("Message Not sended");
					}
					else{
						alert("Message Send sucessfully");
						$('#chat_details').hide();
					}
					
				});
				
				//ticketChatFunction(ticketNo);
			
		}
		
		
		//update function

		$(document).ready(function() { // not required

			$('#Update_Tickets').click(function() {

				var divElement = document.getElementById("ticket_Updator");

				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';
					var object = {
						type : 'GET',
						url : 'GetTicketNumber',
						error : function(error) {
							alert(error.stack);
							window.location = "Userlogin.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#ticket_Updator').html(response);
					});

				} else {
					divElement.style.display = 'none';
				}

			});

		});

		function ticketUpdateFunction(ticketNo) {


			var text = "Sure you want to update press OK!";
			if (confirm(text) == true) {

				var divElement = document.getElementById("Ticket_Raiser_form");

				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';
					var object = {
						type : 'GET',
						url : 'UpdateRaisedSupportTickets',
						data : {
							ticketNo : ticketNo
						},
						error : function(error) {
							alert(error.stack);
							window.location = "Userlogin.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#Ticket_Raiser_form').html(response);

					});

				} else {
					
					divElement.style.display = 'none';
				}

			} else {

				var divElement = document.getElementById("ticket_Updator");

				if (divElement.style.display === 'none') {
					divElement.style.display = 'block';
				} else {
					divElement.style.display = 'none';
				}

			}

		}

		// update function
		
		// UpdateRaisedSupportTickets

	/* 	$(document).ready(function() {

			$('#button_Update').click(function() {

				var subject = document.getElementById("updatesubject").value;
				var discription = document.getElementById("updatediscription").value;

				var object = {
								type : 'POST',
								url : 'UserTicketUpdadter',
								data : {

										subject : subject,
										discription : discription

										},
										error : function() {
												window.location = "Userlogin.jsp";
										}

								};

				$.ajax(object).done(function(response) 
						{
						
					});

				});

		}); */
		
		//pick a user Request
		
		$(document).ready(function() {

			$('#PickRequest').click(function() {
				
				var divElement = document.getElementById("pick_UserRequest");
				
				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';
			
				$('#pick_UserRequest').show()
					var object = {
						type : 'GET',
						url : 'PickSupportRequest',
						error : function() {
							window.location = "AdminHomePage.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#pick_UserRequest').html(response);
						
					});
					
				} else {
					divElement.style.display = 'none';
				}

			});

		});
		
		
		function ticketPickButton(){
			
			var ticketId= document.getElementById("ticket_Picker").value;  
			
			var text="Want to pick a support Request : " + ticketId;
			
			if(confirm(text)){
				
				var object = {
						type : 'POST',
						url : 'PickSupportRequest',
						data : {
							ticketId : ticketId
						},
						error : function() {
							window.location = "AdminHomePage.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						alert("Ticket "+ticketId+" Picked Sucessfully")
						$('#pick_UserRequest').hide();
					});
				

			}
			
		}
		
		
		// My assigned Tickets
		
		$(document).ready(function() {
			
			$('#MyRequest').click(function() {
				
			var divElement = document.getElementById("user_Tickets");
			
			
				
				if (divElement.style.display === 'block') {

					divElement.style.display = 'none';
				
				
				/* $('#pick_UserRequest').show() */
					var object = {
						type : 'GET',
						url : 'GetAssignedSupportTickets',
						error : function() {
							window.location = "AdminHomePage.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#user_Tickets').html(response);
						
					});
					
				}
				else{
					divElement.style.display = 'block';
					/* $('#pick_UserRequest').show(); */
					
				} 

			});

		});
		
		
		function ticketCloseFunction(ticketId){
			var object = {
					type : 'POST',
					url : 'CloseSupportTicket',
					data : {
						ticketId : ticketId
					},
					error : function() {
						window.location = "AdminHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					//$('#'+ticketId).remove();
					/* alert(document.getElementById(ticketId).cells[4].innerHTML); */
					document.getElementById(ticketId).cells[4].innerHTML="closed";
					alert("Ticket closed sucessfully");
					
				});
		}
		

		function AdminUpdateFunction(ticketId){
			
			var object = {
					type : 'POST',
					url : 'GetAdminUsers',
					data : {
						ticketId : ticketId
					}, 
					error : function() {
						window.location = "AdminHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					$('#'+ticketId).remove();
					$('#My_assigned_Tickts').html(response);
					
				});
			
		}
		
		function selectAdmin(){
			
			var adminId= document.getElementById("available_Admin").value;  
			
			if(confirm(text)){
				
				var object = {
						type : 'POST',
						url : 'UpdateAdminId',
						data : {
							adminId : adminId
						},
						error : function() {
							window.location = "AdminHomePage.jsp";
						}
					};

					$.ajax(object).done(function(response) {;
						alert("Ticket "+ticketId+" Admin is Changed ");
						
						$('#pick_UserRequest').hide();
					});
			
			}

		}
		
		
		//closed to archive  function 
		
		$(document).ready(function() {

			$('#ClosedTickets').click(function() {
				
				var divElement = document.getElementById("user_Tickets");

				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';

					var object = {
						type : 'GET',
						url : 'GetClosedTickets',
						error : function() {
							window.location = "Userlogin.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#user_Tickets').html(response);
					});
					
					
				}else{
					divElement.style.display = 'none';
				}


			});

		}); 
		
		function ticketArchiveFunction(ticketId){
			
			var object = {
					type : 'POST',
					url : 'GetClosedTickets',
					data : {
						ticketId: ticketId
					}, 
					error : function() {
						window.location = "AdminHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					$('#'+ticketId).remove();
					
				});
			
		}
		
		
		
		//JSP integeration
		

		
		<%-- $(document).ready(function() {

			$('#ArchiveTickets').click(function() {
				
			
				var divElement = document.getElementById("UserTickets_for_chat");

				if (divElement.style.display === 'none') {
					
						
				<%
				
				
			
				/* for (Entry<Integer, TicketDetails> entry : userDetails.entrySet()) {
					
					TicketDetails details = entry.getValue();
					
					out.println("'<table width='100% border='1'> <tr ><th>Ticket No</th><th>Admin Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th></tr>'");
					
					if(!"Archive".equals(details.getTicket_Status())){
						out.println("<tr> <td>'+ key +'</td> <td>'"+ entry.value.getAdminName() +"'</td> <td>'" + entry.value.getSubject() + "'</td><td>'" + entry.value.getDiscription() + "'</td><td>' "+ entry.value.getTicket_Status() + "'</td><td>'"+ entry.value.getTimeOfCreation() +"'</td> </tr>'");
					
					}  
					out.println("</table>"); */
				
				
				%>
				
				
				 var dynamicTable = '<table width="100%" border="1"> <tr ><th>Ticket No</th><th>Admin Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th></tr>';
				
			 	<c:forEach items="${userTickets}" var="entry">
				    var key = ${entry.key};
				    alert('loop')
				   // var value = ${entry.value};
				    dynamicTable += '<tr> <td>'+ key +'</td> <td>'+ ${entry.value.getAdminName()} +'</td> <td>'+ ${entry.value.getSubject()} +'</td><td>'+ ${entry.value.getDiscription()} +'</td><td>'+ ${entry.value.getTicket_Status()} +'</td><td>'+ ${entry.value.getTimeOfCreation()} +'</td> </tr>';
				    
				</c:forEach> 
					
				dynamicTable += '</table>';
				
				console.log(dynamicTable);
				
				
				$('#UserTickets_for_chat').html(dynamicTable);
					
					
					
					
				}else{
					
					divElement.style.display = 'none';
				}


			});

		});  --%>
		
		
		//Archive tickets

		$(document).ready(function() {

			$('#ArchiveTickets').click(function() {
				
					
				var divElement = document.getElementById("user_Tickets"	);

				if (divElement.style.display === 'none') {
					divElement.style.display = 'block';
					
					var object = {
							type : 'GET',
							url : 'GetArchivedTickets',
							error : function() {
								window.location = "Userlogin.jsp";
							}
						};

						$.ajax(object).done(function(response) {
							$('#user_Tickets').html(response);
						});
					
					
					
				}else{
					divElement.style.display = 'none';
				}
				
			});

		}); 
		function ticketArchiveFunction(ticketId){
			
			var object = {
					type : 'POST',
					url : 'GetArchivedTickets',
					data : {
						ticketId: ticketId
					}, 
					error : function() {
						window.location = "AdminHomePage.jsp";
					}
				};

				$.ajax(object).done(function(response) {
					$('#'+ticketId).remove();
					
				});
			
		}

	</script>


</body>


</body>
</html>
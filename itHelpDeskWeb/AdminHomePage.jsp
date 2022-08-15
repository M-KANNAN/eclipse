<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<li id="View_Tickets"><a href="#">View a Ticket</a></li>
					<li id="Update_Tickets"><a href="#">Update a Ticket</a></li>
					<li id="PickRequest" onclick=""><a href="#">Pick a support Request</a></li>
					<li id="MyRequest"><a href="#">My Assigned Tickets</a></li>
					<li id="Chatbox"><a href="#">Customer Support</a></li>

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


			<div id="user_Tickets"></div>

			<div id="ticket_Updator">

				<div id="ticket_Updator_form"></div>

			</div>
			
			<!-- chat -->
			<div id="UserTickets_for_chat"></div>
			
			<div id="chat_details"></div>
			
			<!-- Pick User Request -->
			
			<div id="pick_UserRequest"></div>
			
			<!-- Show Admin Assigned Tickets  -->
			
			<div id="My_assigned_Tickts"></div>

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

		
		//chat implementation
		function getIdFunction(ticketNo) {
			alert("Ticket Number : "+ticketNo);
			
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
		
		//update function

		$(document).ready(function() {

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

		function ticketUpdateFunction() {

			var value=document.getElementById("ticket_Select").value;

			var text = "Sure you want to update press OK!";
			if (confirm(text) == true) {

				var divElement = document.getElementById("Ticket_Raiser_form");

				if (divElement.style.display === 'none') {

					divElement.style.display = 'block';
					var object = {
						type : 'GET',
						url : 'UpdateRaisedSupportTickets',
						data : {
							value : value
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

		$(document).ready(function() {

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

		});

		//chat function
			
		$(document).ready(function() {

			$('#Chatbox').click(function() {

				var divElement = document.getElementById("user_Tickets");

					var object = {
						type : 'GET',
						url : 'UserTickets_for_chat',
						error : function() {
							window.location = "Userlogin.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#UserTickets_for_chat').html(response);
					});

			});

		});
		
		
		function ticketChatFunction(ticketNo){
			
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
			
		//	var ticketNo= document.getElementById("ticket_Chat").value;  
			
			var message=document.getElementById("message_sender").value;
			
			var object = {
					type : 'POST',
					data : {
						//ticketNo : ticketNo,
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
		
		
		//pick a user Request
		

		
		$(document).ready(function() {

			$('#PickRequest').click(function() {
			
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
			else{
				alert("cancel");
			}
		}
		
		
		// My assigned Tickets
		
		$(document).ready(function() {

			$('#MyRequest').click(function() {
			
				$('#pick_UserRequest').show()
					var object = {
						type : 'GET',
						url : 'GetAssignedSupportTickets',
						error : function() {
							window.location = "AdminHomePage.jsp";
						}
					};

					$.ajax(object).done(function(response) {
						$('#My_assigned_Tickts').html(response);
						
					});

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
					$('#'+ticketId).remove();
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
					$('#My_assigned_Tickts').html(response);
					
				});
			
		}
		

	</script>


</body>


</body>
</html>
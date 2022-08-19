<%@ page import="com.ithelpdesk.javaclasses.TrashCleaner"

	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Homepage</title>

<link rel="stylesheet"
	href="/itHelpDeskWeb/ithelpdesk.css/Userhomepage.css">

</head>
<body>


<%

new TrashCleaner().trashCleaner();


%>


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
					<!-- <li id="Update_Tickets"><a href="#">Update a Ticket</a></li> -->
					<!-- <li id="Chatbox"><a href="#">Customer Support</a></li> -->

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
			
			<br>

			<div id="ticket_Updator">
			
			<br>

				<div id="ticket_Updator_form"></div>
				
				<br>

			</div>
			<br>
			
			
			<!-- chat -->
			<div id="UserTickets_for_chat"></div>
			
			<br>
			
			<div id="chat_details"></div>
			
			<br>


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

		//chat Function
		
		function getIdFunction(ticketNo) {
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

		function ticketUpdateFunction(ticketNo) {


			var text = "Sure you want to update press OK!";
			if (confirm(text) == true) {

				var divElement = document.getElementById("Ticket_Raiser_form");

				if (divElement.style.display === 'none') {
					
					alert("none");

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
					alert("block");
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
		

		/* $(document).ready(function() {

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

		function ticketUpdateFunction(value) {

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

		} */

		// update function

		/* $(document).ready(function() {

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

		//chat function
			
		//chat implemetation 2
		
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
		

	</script>


</body>
</html>
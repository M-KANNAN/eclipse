package com.ithelpdesk.javaclasses;

import java.sql.Timestamp;

public class TicketDetails {
	
	private String adminName;
	private String subject;
	private String discription;
	private String ticket_Status;
	private Timestamp timeOfCreation;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getTicket_Status() {
		return ticket_Status;
	}
	public void setTicket_Status(String ticket_Status) {
		this.ticket_Status = ticket_Status;
	}
	public Timestamp getTimeOfCreation() {
		return timeOfCreation;
	}
	public void setTimeOfCreation(Timestamp timeOfCreation) {
		this.timeOfCreation = timeOfCreation;
	}

}

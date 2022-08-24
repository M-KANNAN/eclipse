package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ChatDetailsForTicket {
	
	

	public HashMap<Integer, ArrayList<ChatPojo>> chatDetailsForTicket(int userId, int ticketId) throws SQLException {
		
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String getChatQuery;
		
		UserMessager messager=new UserMessager();
		
		int ticketUserId=messager.getUserId(ticketId);
		
		int ticketAdminId=messager.getAdminId(ticketId);
		
		
		if(ticketUserId == userId) {
			
			getChatQuery="select cd.ticket_id,cd.chat_message,ud.user_name as sender_Name, ud_U.user_name as reciver_Name\n"
					+ "from chat_details as cd\n"
					+ "LEFT join user_details as ud on ud.user_id = cd.sender_id\n"
					+ "left join user_details as ud_U on ud_U.user_id = cd.reciver_id\n"
					+ "where ticket_id in\n"
					+ "(select ticket_id from ticket_details where USER_id =?) order by cd.timeof_creation DESC;";
			
		}
		else {
			getChatQuery="select cd.ticket_id,cd.chat_message,ud.user_name as sender_Name, ud_U.user_name as reciver_Name\n"
					+ "from chat_details as cd\n"
					+ "LEFT join user_details as ud on ud.user_id = cd.sender_id\n"
					+ "left join user_details as ud_U on ud_U.user_id = cd.reciver_id\n"
					+ "where ticket_id in\n"
					+ "(select ticket_id from ticket_details where  =?) order by cd.timeof_creation DESC;";
			
		}
			
		
		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(getChatQuery);
		
		preparedStatement.setInt(1, userId);
		
		HashMap<Integer, ArrayList<ChatPojo>> hashMap=new LinkedHashMap<Integer, ArrayList<ChatPojo>>();
		
		ResultSet  resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			ChatPojo chatPojo=new ChatPojo();
			chatPojo.setTicketId(resultSet.getInt(1));
			chatPojo.setTextMessage(resultSet.getString(2));
			chatPojo.setSenderName(resultSet.getString(3));
			chatPojo.setReciverName(resultSet.getString(4));
			
			if(!hashMap.containsKey(resultSet.getInt(1))) {
				ArrayList<ChatPojo> arrayList=new ArrayList<ChatPojo>();
				arrayList.add(chatPojo);
				hashMap.put(resultSet.getInt(1), arrayList);
			}
			else {
				hashMap.get(resultSet.getInt(1)).add(chatPojo);
			}
			
			
		}
		
		return hashMap;

	}

	public boolean chatAvailableChecker(int ticketId) throws SQLException {
		

		ValidatorClass validatorClass=new ValidatorClass();
		
		String isChatAvaiabeQuerry="select techician_id from ticket_details\n"
				+ "where ticket_id= ? ;";

		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(isChatAvaiabeQuerry);
		
		preparedStatement.setInt(1, ticketId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		}
		
		else {
			return false;
		}
		
	}

	
	

}

package ChatBotWithDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Stack;

public class ApplicationStart {
	
	protected Stack<SelectionPojo> backStack=new Stack<SelectionPojo>();
	
	private void flowManager() throws SQLException {
		Scanner scanner=new Scanner(System.in);
		byte choice=0;
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement= connection.createStatement();
		
		SelectionPojo pojo=new SelectionPojo();
		pojo.setLayerId(0);
		pojo.setChoice_Id(0);
		pojo.setOptionId(0);
	
		backStack.push(pojo);
		
		do {
			
			System.out.println("Enter your choice ");
			
			ResultSet resultSet=statement.executeQuery("SELECT option_Text FROM chatbot_table\n"
					+ "WHERE level_id= "+ backStack.peek().getLayerId()+" and option_selected="+backStack.peek().getChoice_Id()+";");
			System.out.println();
			while(resultSet.next()) {
			
				System.out.println(resultSet.getString("option_Text"));
				
			}
			
			resultSet.close();
			
			System.out.println("Enter 9 to back");
			choice=scanner.nextByte();
			if(choice == 9) {
				backStack.pop();
			}
			else {
				SelectionPojo pojo1=new SelectionPojo();
				pojo1.setLayerId(backStack.peek().getLayerId()+1);
				pojo1.setChoice_Id(choice);
				pojo1.setOptionId(0);
				
				backStack.push(pojo1);
				
				System.out.println(pojo1.getLayerId()+" "+pojo1.getChoice_Id());
			}
			
		}
		while(choice !=0);
		
		statement.close();
		connection.close();
		
	}

	public static void main(String[] args) throws SQLException {
		new ApplicationStart().flowManager();

	}

	

}

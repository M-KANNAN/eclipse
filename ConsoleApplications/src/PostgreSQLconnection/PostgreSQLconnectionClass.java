package PostgreSQLconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLconnectionClass {
	
	private final String url="jdbc:postgresql://localhost/Onilne_Examination_db";
	private final String user = "postgres";
	private final String password="Kanna872717##";
	
	private void connection() {
		
		try(Connection connection = DriverManager.getConnection(url,user,password)) {
			
			if(connection != null) {
				
				
				//System.out.println("conneted to postgrees");
				
				Statement stmt = connection.createStatement();
				
				 ResultSet rs = stmt.executeQuery("select sd.first_name || '.' || sd.last_name as student_Name,sd.age,sld.user_name,sld.student_PassWord,qt.quota\n"
				 		+ "from  student_details as sd\n"
				 		+ "inner join student_login_table as sld on sld.student_id =10\n"
				 		+ "inner join quota_table as qt on qt.quota_id = sd.quota;");
				 
					while(rs.next()) {
                		System.out.println( rs.getString("student_Name") + "\t"
                                + rs.getString("user_name") + "\t" 
                				+ rs.getInt("age") + "\t"
                				+rs.getString("student_PassWord") + "\t"
                				+rs.getString("quota")
                				);
                	
                	}  	
			}
			else {
				System.out.println("No connecntion");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		
		new PostgreSQLconnectionClass().connection();

	}

}

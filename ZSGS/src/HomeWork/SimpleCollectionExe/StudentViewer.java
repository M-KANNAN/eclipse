package HomeWork.SimpleCollectionExe;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentViewer {

	public void studentViewer() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println();
		System.out.println("Verify Your admin status by providing admin user name and password");
		System.out.println();
		System.out.println("Enter admin username");
		String userName=scanner.next();
		System.out.println("Enter admin password");
		String password=scanner.next();
		
		if(userName.equals("ADMIN") && password.equals("!@#$%")) {
			
			if(StudentDetails.database.isEmpty()) {
				
				System.out.println("!!! No student details Available !!!");
				
			}
			else {
				
				System.out.println("       **Registerd Students Details**");
				
				Iterator<Entry<Long, Student>> iterator=StudentDetails.database.entrySet().iterator();
				if(iterator != null) {
					
					while(iterator.hasNext()) {
						Entry<Long, Student> entry=iterator.next();
						System.out.println();
						System.out.println("****************************************");
						System.out.println("Student Registeration Number :"+entry.getKey());
						Student details=entry.getValue();
						System.out.println("Student Name :"+details.studentName);
						System.out.println("Student Age :"+details.studentAge);
						System.out.println("Student Mobile Number :"+details.mobileNo);
						System.out.println("Student Email ID :"+details.emailId);
						System.out.println();
						System.out.println("****************************************");
					}
					
				}
				else {
					System.out.println("!!! No student details Available !!!");
				}
				
				
			}
			
			
			
		}
		else {
			System.out.println("!!! Access Denied !!!");
		}
		
		
		

		
		
	}

}

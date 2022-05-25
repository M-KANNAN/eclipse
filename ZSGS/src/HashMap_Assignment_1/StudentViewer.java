package HashMap_Assignment_1;

import java.util.Map.Entry;
import java.util.Scanner;

public class StudentViewer {

	public void studentViewer() {
		
		for(Entry<Long,StudentPojo> entry : StudentDetails.studentDatabse.entrySet()) {
			System.out.println();
			System.out.println("  **Welcome to Student Viewer");
			System.out.println();
			System.out.println("Reg No : "+entry.getKey());
			StudentPojo pojo=entry.getValue();
			System.out.println("Student Name : "+pojo.getStudentName());
			System.out.println("Student Age : "+pojo.getStudentAge());
			System.out.println("Student MobileNo : "+pojo.getStudentMobileNo());
			System.out.println("Student EmailID : "+pojo.getStudentEmailID());
			System.out.println();
			
		}
	}

	public void studentCountViewer() {
		System.out.println();
		System.out.println("Count of students Added : "+StudentDetails.studentDatabse.size());
		System.out.println();
		
	}

	public void isKeyContains() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your reg NO");
		long regNo=scanner.nextLong();
		
		StudentPojo pojo=StudentDetails.studentDatabse.get(regNo);
		if(pojo != null) {
			System.out.println();
			System.out.println("!!! USER FOUND !!!");
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("!!! USER NOT FOUND !!!");
			System.out.println();
		}
		
	}

	public void setMakker() {
		
		System.out.println();
		System.out.println("KeySet : "+StudentDetails.studentDatabse.keySet());
		System.out.println("EntrySet : "+StudentDetails.studentDatabse.entrySet());
		System.out.println();
		
	}

	public void detailsCheckerByRollNo() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your reg NO");
		long regNo=scanner.nextLong();
		
		StudentPojo pojo=StudentDetails.studentDatabse.get(regNo);
		if(pojo != null) {
			System.out.println("Reg No :"+regNo);
			System.out.println("Student Name : "+pojo.getStudentName());
			System.out.println("Student Age : "+pojo.getStudentAge());
			System.out.println("Student MobileNo : "+pojo.getStudentMobileNo());
			System.out.println("Student EmailID : "+pojo.getStudentEmailID());
			System.out.println();
		}
		else {
			System.out.println("!!! NO RECORDS FOUND !!!");
			System.out.println();
		}
		
	}

}

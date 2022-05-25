package LinkedList_Assignment_1;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentDetails {
	protected long StudentRegNo;
	protected String studentName;
	protected byte studentAge;
	protected String studentMobileNo;
	protected String studentEmailID;
	
	protected static LinkedList<StudentPojo> studentDatabase=new LinkedList<StudentPojo>();
	
	public void studentDetails() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter your RegNo :");
		this.StudentRegNo=scanner.nextLong();
		System.out.println("Enter your name ");
		scanner.nextLine();
		this.studentName=scanner.nextLine();
		System.out.println("Enter Your age ");
		this.studentAge=scanner.nextByte();
		System.out.println("Enter your mobile Number");
		this.studentMobileNo=scanner.next();
		System.out.println("Enter your EmailId");
		this.studentEmailID=scanner.next();
		
		//Pushing values to PojoClass
		
		StudentPojo pojo=new StudentPojo();
		pojo.setStudent(studentName, studentAge, studentMobileNo, studentEmailID,StudentRegNo);
		studentDatabase.add(pojo);
		
		
		
	}

}

package Vector_Assignment_1;

import java.util.Scanner;


public class StudentInsetter {
	
	protected long StudentRegNo;
	protected String studentName;
	protected byte studentAge;
	protected String studentMobileNo;
	protected String studentEmailID;

	public void studentInsetter() {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("   **Welcome to Student Insertion Menu**");
		System.out.println();
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
		StudentDetails.studentDatabase.add(0,pojo);
	}

	
	public void studentUpdaterByRegNo() {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("  **Welcome to Update Menu**");
		System.out.println();
		System.out.println("Enter a student RegNo :");
		long regNo=scanner.nextLong();
		
		for(StudentPojo pojo : StudentDetails.studentDatabase) {
			if(regNo == pojo.getStudentRegNo()) {
				System.out.println();
				System.out.println("   **Update Student details**");
				System.out.println();
				System.out.println("Enter your name ");
				scanner.nextLine();
				this.studentName=scanner.nextLine();
				System.out.println("Enter Your age ");
				this.studentAge=scanner.nextByte();
				System.out.println("Enter your mobile Number");
				this.studentMobileNo=scanner.next();
				System.out.println("Enter your EmailId");
				this.studentEmailID=scanner.next();
				pojo.setStudent(studentName, studentAge, studentMobileNo, studentEmailID, regNo);
		
			}
		
		
		}

	}
}
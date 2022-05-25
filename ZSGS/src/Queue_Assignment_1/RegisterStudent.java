package Queue_Assignment_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RegisterStudent {
	
	protected static int admissionNumber=0;
	protected String studentName;
	protected String studentMobileNo;
	protected static Queue<StudentDetailsPojo> studentDatabase=new LinkedList<StudentDetailsPojo>();

	public void resgisterStudent() {
		Scanner  scanner=new Scanner(System.in);
		if(admissionNumber < 20) {
			admissionNumber++;
			System.out.println(" **Welcome to Student Registration");
			System.out.println();
			System.out.println("Enter your name");
			studentName=scanner.nextLine();
			System.out.println("Enter your mobileNo");
			studentMobileNo=scanner.next();
			StudentDetailsPojo detailsPojo=new StudentDetailsPojo();
			detailsPojo.setStudent(studentName, studentMobileNo,admissionNumber);
			studentDatabase.add(detailsPojo);
		}
		else {
			System.out.println("!!! NO SEATES AVAILABLE !!!");
		}
		
		
	}

}

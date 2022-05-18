package HomeWork.SimpleCollectionExe;

import java.util.Scanner;
import java.util.TreeMap;


public class StudentDetails {
	
	protected static long regNo=100000001;
	protected String studentName;
	protected String mobileNo;
	protected String emailId;
	protected byte studentAge;
	static TreeMap<Long, Student> database=new TreeMap<>();
	
	
	public void flowManager() {
		

		Scanner scanner=new Scanner(System.in);
		boolean isExite=true;
		while(isExite) {
			System.out.println();
			System.out.println("****************************************");
			System.out.println();
			System.out.println("     **Welcome to Student Menu**");
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("~1 to add students details");
			System.out.println("~2 to Modify student details");
			System.out.println("~3 to exit");
			System.out.println("****************************************");
			System.out.println();
			byte choice=scanner.nextByte();
			switch(choice) {
			
			case 1 :
				this.studentDetails();
				break;
				
			case 2 :
				this.detailsModifier();
				break;
				
			case 3 :
				isExite=false;
				System.out.println("!!!Thank You!!!");
				break;
			default :
				System.out.println("Enter the vaild choice");
				System.out.println();
				break;
			
			}
		}
		
	}
	
	
	

	private void detailsModifier() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("    **Details Modifier**");
		System.out.println("Enter the Register Number of the Student : ");
		long regNumber=scanner.nextLong();
		Student details=StudentDetails.database.get(regNumber);
		if(details != null) {
			System.out.println();
			System.out.println("**********************************");
			System.out.println("Details of the student to modify");
			System.out.println();
			System.out.println("Student Name :"+details.studentName);
			System.out.println("Student Age :"+details.studentAge);
			System.out.println("Student Mobile Number :"+details.mobileNo);
			System.out.println("Student Email ID :"+details.emailId);
			System.out.println();
			
			
			boolean isExite=true;
			while(isExite) {
				System.out.println("Enter 1 to correct name");
				System.out.println("Enter 2 to correct age");
				System.out.println("Enter 3 to correct mobileNumber");
				System.out.println("Enter 4 to correct emailID");
				System.out.println("Enter 5 to exit");
				System.out.println();
				byte choice=scanner.nextByte();
				switch(choice) {
				case 1:
					System.out.println("Enter a correct name ");
					scanner.nextLine();
					details.studentName=scanner.nextLine();
					System.out.println("!!! Name modified sucessfully !!!");
					System.out.println();
					break;
					
				case 2:
					System.out.println("Enter a correct age ");
					details.studentAge=scanner.nextByte();
					System.out.println("!!! age modified sucessfully !!!");
					System.out.println();
					break;
					
				case 3 :{
					boolean repater=true;
					while(repater) {
						System.out.println("Enter a correct mobile Number ");
						this.mobileNo=scanner.next();
						if(mobileNo.length() == 10) {
							details.mobileNo=mobileNo;
							repater=false;
						}
						else {
							System.out.println("!!! Enter the 10 digit mobile number !!!");
							
						}
					}
					System.out.println("!!! mobile Number modified sucessfully !!!");
					System.out.println();
					break;
					
				}
					
				
					
				case 4 :{
					
					boolean repater=true;
					while(repater) {
						System.out.println("Enter a correct Email ID ");
						this.emailId=scanner.next();
						if(emailId.contains("@") && (emailId.contains(".com") || emailId.contains(".in"))){
							details.emailId=emailId;
							repater=false;
						}
						else {
							System.out.println("Email Id must contain '@' and '.com' or 'in'");
							
						}
					}
					System.out.println("!!! EmailID modified sucessfully !!!");
					System.out.println();
					break;
				}
				
				case 5 :{
					System.out.println(" **Redirecting to student menu ");
					isExite=false;
					break;
				}
				default :
					System.out.println("!!! Enter the valid choice !!!");
					break;
					
					
					
				}
				
				
				
			}

	
		}
		else {
			System.out.println("!!! No records Found !!!");
		}
		
	}




	public void studentDetails() {
		
		Scanner scanner=new Scanner(System.in);
		
		byte i=1;
		
		System.out.println();
		System.out.println("   ** Welcome to Student Account Creation **");
		System.out.println();
		while(i<6) {
			
				if(i == 1 ) {
					System.out.println("Enter your name :");
					this.studentName= scanner.nextLine();
					i++;
					
				}
				else if(i == 2) {
					System.out.println("Enter your age : ");
					this.studentAge=Byte.parseByte(scanner.next());
					i=3;
				}
				else if(i == 3) {
					System.out.println("Enter Your mobile No");
					this.mobileNo=scanner.next();
					if(mobileNo.length() == 10) {
						i=4;
					}
					else {
						System.out.println("!!! Enter the 10 digit mobile number !!!");
						i=3;
					}

				}
				else if(i == 4) {
					System.out.println("Enter Email Id : ");
					this.emailId=scanner.next();
					if(emailId.contains("@") && (emailId.contains(".com") || emailId.contains(".in"))) {
						i=5;
					}
					else {
						System.out.println("Email Id must contain '@' and '.com' or 'in'");
						i=4;
					}
				}
				else if(i == 5) {
					Student details=new Student(studentName,studentAge,mobileNo,emailId);
					database.put(regNo, details);
					regNo++;
					i++;
				}

				
		}
		
	}


}

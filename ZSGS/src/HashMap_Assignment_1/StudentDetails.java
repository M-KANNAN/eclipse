package HashMap_Assignment_1;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class StudentDetails {
	
	protected long StudentRegNo;
	protected String studentName;
	protected byte studentAge;
	protected String studentMobileNo;
	protected String studentEmailID;
	
	protected static LinkedHashMap<Long, StudentPojo> studentDatabse=new LinkedHashMap<Long, StudentPojo>();
	

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
		pojo.setStudent(studentName, studentAge, studentMobileNo, studentEmailID);
		studentDatabse.put(StudentRegNo, pojo);
		
		
	}


	public void mapCoppier() {
		LinkedHashMap<Long, StudentPojo> copiedHashMap=new LinkedHashMap<Long, StudentPojo>(studentDatabse);
		System.out.println();
		System.out.println("Coppied student details");
		System.out.println();
		for(Entry<Long,StudentPojo> entry : copiedHashMap.entrySet()) {
			System.out.println();
			System.out.println("  **Welcome to Student Viewer");
			System.out.println();
			System.out.println("Reg No : "+entry.getKey());
			StudentPojo pojo=entry.getValue();
			System.out.println("Student Name : "+pojo.getStudentName());
			System.out.println("Student Age : "+pojo.getStudentAge());
			System.out.println("Student MobileNo : "+pojo.getStudentMobileNo());
			System.out.println("Student EmailID : "+pojo.getStudentEmailID());
			
			
		}
		
	}


	public void detailsDeleter() {
		studentDatabse.clear();
		System.out.println("!!! Details removed sucessfully !!!");
		System.out.println();
		
	}


	public void isEmptyChecker() {
		
		if(studentDatabse.isEmpty()) {
			System.out.println("!!! NO DETAILS AVAILABLE !!!");
			System.out.println();
		}
		else {
			System.out.println("!!! MAP IS NOT EMPTY !!!");
			System.out.println();
		}
		
	}


	public void shallowCopyGenerator() {
		
		LinkedHashMap<Long, StudentPojo> shallowHashMap=new LinkedHashMap<Long, StudentPojo>();
		shallowHashMap.putAll(studentDatabse);
		System.out.println();
		System.out.println("Coppied student details");
		System.out.println();
		for(Entry<Long,StudentPojo> entry : shallowHashMap.entrySet()) {
			System.out.println();
			System.out.println("  **Welcome to Student Viewer");
			System.out.println();
			System.out.println("Reg No : "+entry.getKey());
			StudentPojo pojo=entry.getValue();
			System.out.println("Student Name : "+pojo.getStudentName());
			System.out.println("Student Age : "+pojo.getStudentAge());
			System.out.println("Student MobileNo : "+pojo.getStudentMobileNo());
			System.out.println("Student EmailID : "+pojo.getStudentEmailID());
			
			
		}
		
	}

}

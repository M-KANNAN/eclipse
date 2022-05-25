package HashMap_Assignment_1;

public class StudentPojo {
	private String studentName;
	private byte studentAge;
	private String studentMobileNo;
	private String studentEmailID;
	
	public String getStudentName() {
		return studentName;
	}
	public byte getStudentAge() {
		return studentAge;
	}
	
	public String getStudentMobileNo() {
		return studentMobileNo;
	}
	
	public String getStudentEmailID() {
		return studentEmailID;
	}
	
	
	public void setStudent(String studentName,byte studentAge,String studentMobileNo,String studentEmailID) {
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentMobileNo = studentMobileNo;
		this.studentEmailID = studentEmailID;
		
		
	}

}

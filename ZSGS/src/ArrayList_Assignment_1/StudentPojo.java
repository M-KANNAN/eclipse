package ArrayList_Assignment_1;

public class StudentPojo {
	private String studentName;
	private byte studentAge;
	private String studentMobileNo;
	private String studentEmailID;
	private long StudentRegNo;
	
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
	public long getStudentRegNo() {
		return StudentRegNo;
	}
	
	public void setStudent(String studentName,byte studentAge,String studentMobileNo,String studentEmailID,long StudentRegNo) {
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentMobileNo = studentMobileNo;
		this.studentEmailID = studentEmailID;
		this.StudentRegNo=StudentRegNo;
	}
		
	
	
}

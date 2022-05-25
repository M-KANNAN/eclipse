package LinkedList_Assignment_1;

public class StudentPojo {
	protected long StudentRegNo;
	protected String studentName;
	protected byte studentAge;
	protected String studentMobileNo;
	protected String studentEmailID;
	public String getStudentName() {
		return studentName;
	}
	public byte getStudentAge() {
		return studentAge;
	}
	
	public String getStudentMobileNo() {
		return studentMobileNo;
	}
	
	public long getStudentRegNo() {
		return StudentRegNo;
	}
	
	public String getStudentEmailID() {
		return studentEmailID;
	}
	public void setStudent(String studentName,byte studentAge,String studentMobileNo,String studentEmailID,long StudentRegNo) {
		this.studentName = studentName;
		this.studentEmailID = studentEmailID;
		this.studentMobileNo = studentMobileNo;
		this.studentAge = studentAge;
		this.StudentRegNo=StudentRegNo;
	}

	
	
}

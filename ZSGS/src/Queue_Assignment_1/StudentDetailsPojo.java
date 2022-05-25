package Queue_Assignment_1;

public class StudentDetailsPojo {
	
	protected  int admissionNumber=1;
	protected String studentName;
	protected String studentMobileNo;
	public String getStudentName() {
		return studentName;
	}
	public String getStudentMobileNo() {
		return studentMobileNo;
	}
	public int getAdmissionNumber() {
		return admissionNumber;
	}
	public void setStudent(String studentName,String studentMobileNo,int admissionNumber) {
		this.studentMobileNo = studentMobileNo;
		this.studentName = studentName;
		this.admissionNumber=admissionNumber;
	}
	

	

}

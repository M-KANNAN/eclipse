package Queue_Assignment_1;


public class StudentViewer {

	public void studentViewer() {
		
		System.out.println("  **REGISTERED STUDENTS**");
		System.out.println();
		
		for(StudentDetailsPojo detailsPojo : RegisterStudent.studentDatabase ) {
			System.out.println("ADMISSION NUMBER : "+detailsPojo.getAdmissionNumber());
			System.out.println("STUDENT NAME : "+detailsPojo.getAdmissionNumber());
			System.out.println("STUDENT MOBILE NUMBER : "+detailsPojo.getStudentMobileNo());
			
		}
		
	}

}

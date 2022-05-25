package ArrayList_Assignment_1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



class Sortbyname implements Comparator<StudentPojo> {

	@Override
	public int compare(StudentPojo o1, StudentPojo o2) {
			return o1.getStudentName().compareTo(o2.getStudentName());
		
	}
}

public class StudentViewer {

	public void studentViewer() {
		
		System.out.println();
		System.out.println("   **Welcome to Details page**");
		System.out.println();
		
		for(StudentPojo pojo : StudentDetails.studentDatabase) {
			
			System.out.println();
			System.out.println("Reg No :"+pojo.getStudentRegNo());
			System.out.println("NAME : "+pojo.getStudentName());
			System.out.println("AGE : "+ pojo.getStudentAge());
			System.out.println("EMAIL ID : "+pojo.getStudentEmailID());
			System.out.println("MOBILE NO : "+pojo.getStudentMobileNo());
			System.out.println();
			
		}
		
		
	}

	public void studentViewerByRegNo() {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("  **Student viewer**");
		System.out.println();
		System.out.println("Enter a student RegNo :");
		long regNo=scanner.nextLong();
		
	for(StudentPojo pojo : StudentDetails.studentDatabase) {
		if(regNo == pojo.getStudentRegNo()) {
			System.out.println();
			System.out.println("Reg No :"+pojo.getStudentRegNo());
			System.out.println("NAME : "+pojo.getStudentName());
			System.out.println("AGE : "+ pojo.getStudentAge());
			System.out.println("EMAIL ID : "+pojo.getStudentEmailID());
			System.out.println("MOBILE NO : "+pojo.getStudentMobileNo());
			System.out.println();
		}
		
		}	
		
	}
	

	public void studentRemoverByRegNo() {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("  **Student viewer**");
		System.out.println();
		System.out.println("Enter a student RegNo :");
		long regNo=scanner.nextLong();
		int i=0;
		for(StudentPojo pojo : StudentDetails.studentDatabase) {
			if(regNo == pojo.getStudentRegNo()) {
				StudentDetails.studentDatabase.remove(i);	
				break;
			}
			i++;	
		}
		
		
	}

	public void studentSorterByName() {
		
		Collections.sort(StudentDetails.studentDatabase,new Sortbyname());	
	}

	public void studentSuffleByRegNo() {
		
		Collections.shuffle(StudentDetails.studentDatabase);
		
	}

	public void studentExtractorByIndex() {
		
		Scanner  scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the size of the list to which is subdivided");
		int sizeOfList=scanner.nextInt();
		List<StudentPojo> details=StudentDetails.studentDatabase.subList(0, sizeOfList);
		for(StudentPojo pojo : details) {
			System.out.println();
			System.out.println("Reg No :"+pojo.getStudentRegNo());
			System.out.println("NAME : "+pojo.getStudentName());
			System.out.println("AGE : "+ pojo.getStudentAge());
			System.out.println("EMAIL ID : "+pojo.getStudentEmailID());
			System.out.println("MOBILE NO : "+pojo.getStudentMobileNo());
			System.out.println();
		}
		
	}

	public void studentReverser() {
		Collections.reverse(StudentDetails.studentDatabase);
		System.out.println("!!! Student-Info reversed !!!");
		
	}

	public void studentSwapper() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the first index for swaping");
		int i=scanner.nextInt();
		System.out.println("Enter the second index for swaping");
		int j=scanner.nextInt();
		
		StudentPojo pojo1=StudentDetails.studentDatabase.get(i);
		StudentPojo pojo2=StudentDetails.studentDatabase.get(j);
		if(pojo1 != null && pojo2 != null) {
			StudentPojo temp=pojo2;
			StudentDetails.studentDatabase.set(j,pojo1);
			StudentDetails.studentDatabase.set(i,temp);
		}
	}

	public void removeDetails() {
		StudentDetails.studentDatabase.clear();
		System.out.println("!!! Student-Info Cleared !!!");
		
	}

	public void isEmptyChecker() {
		if(StudentDetails.studentDatabase.isEmpty()) {
			System.out.println("!!! Student-Details is Empty !!!");
		}
		else {
			System.out.println("!!! Student-Details is not Empty !!!");
		}
		
	}

	public void trimTheSize() {
		StudentDetails.studentDatabase.trimToSize();;
		System.out.println("!!! Student-Info is trimed to capacity!!!");
		
	}

	public void increaseTheCapacity() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the capacity value ");
		int capacityOfList=scanner.nextInt();
		if(capacityOfList > 100) {
			System.out.println("!!! CAPACITY EXEEDS OVER A LIMIT !!!");
		}
		else {
			System.out.println("!!! CAPACITY INCREASED !!!");
		}
		
	}

	public void printStudentInfoByIndex() {
		
		System.out.println(" **Printing Details by Index**");
		for(int i=0;i<StudentDetails.studentDatabase.size();i++) {
			StudentPojo pojo=StudentDetails.studentDatabase.get(i);
			System.out.println();
			System.out.println("Reg No :"+pojo.getStudentRegNo());
			System.out.println("NAME : "+pojo.getStudentName());
			System.out.println("AGE : "+ pojo.getStudentAge());
			System.out.println("EMAIL ID : "+pojo.getStudentEmailID());
			System.out.println("MOBILE NO : "+pojo.getStudentMobileNo());
			System.out.println();
		}
		
	}

}

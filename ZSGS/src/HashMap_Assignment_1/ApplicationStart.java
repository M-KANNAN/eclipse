package HashMap_Assignment_1;

import java.util.Scanner;

public class ApplicationStart {
	
	private void flowManager() {
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			
			System.out.println();
			System.out.println("   **Student Menu**");
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println();
			System.out.println("Enter 1 to add student details");
			System.out.println("Enter 2 to view Student details");
			System.out.println("Enter 3 to view the count");
			System.out.println("Enter 4 to duplicate the map");
			System.out.println("Enter 5 to Remove all details");
			System.out.println("Enter 6 to check Whether the map is empty or not");
			System.out.println("Enter 7 to create a shallow");
			System.out.println("Enter 8 to check Whether the key is present ");
			System.out.println("Enter 9 to check student details by rollNo ");
			System.out.println("Enter 10 to Make map as entryset and keyset ");
			System.out.println("Enter 11 to exit");
			System.out.println();
			byte choice=scanner.nextByte();
			switch(choice) {
				case 1:
					new StudentDetails().studentDetails();
					break;
				case 2:
					new StudentViewer().studentViewer();
					break;
				case 3:
					new StudentViewer().studentCountViewer();
					break;
				case 4:
					new StudentDetails().mapCoppier();
					break;
				case 5:
					new StudentDetails().detailsDeleter();
					break;
				case 6:
					new StudentDetails().isEmptyChecker();
					break;
				case 7:
					new StudentDetails().shallowCopyGenerator();
					break;
				case 8:
					new StudentViewer().isKeyContains();
					break;
				case 9:
					new StudentViewer().detailsCheckerByRollNo();
					break;
				case 10:
					new StudentViewer().setMakker();
					break;
				case 11:
					System.out.println("!!! THank You !!!");
					isExit=false;
					break;
				default :
					System.out.println("!!! Enter the vaild Choice !!!");
					System.out.println();
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		
		new ApplicationStart().flowManager();

	}

}

package ArrayList_Assignment_1;

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
			System.out.println("Enter 3 to insert student details in 0 index");
			System.out.println("Enter 4 to retrive Student by RollNo");
			System.out.println("Enter 5 to update Student by RollNo");
			System.out.println("Enter 6 to remove student by RollNo");
			System.out.println("Enter 7 to sort student by Name");
			System.out.println("Enter 8 to suffle student details");
			System.out.println("Enter 9 to Extact the portion of Students");
			System.out.println("Enter 10 to reverse the Student-Info");
			System.out.println("Enter 11 to swap to elements in Student_Info");
			System.out.println("Enter 12 to Empty the Student_Info");
			System.out.println("Enter 13 to Check Whether the Student_Info is Empty");
			System.out.println("Enter 14 to Trim the size and capacity");
			System.out.println("Enter 15 to Increase the capacity");
			System.out.println("Enter 16 to print Student-Info using Index");
			System.out.println("Enter 17 to exit");
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
					new StudentInsetter().studentInsetter();
					break;
				case 4:
					new StudentViewer().studentViewerByRegNo();
					break;
				case 5:
					new StudentInsetter().studentUpdaterByRegNo();
					break;
				case 6:
					new StudentViewer().studentRemoverByRegNo();
					break;
				case 7:
					new StudentViewer().studentSorterByName();
					break;
				case 8:
					new StudentViewer().studentSuffleByRegNo();
					break;
				case 9:
					new StudentViewer().studentExtractorByIndex();
					break;
				case 10:
					new StudentViewer().studentReverser();
					break;
				case 11:
					new StudentViewer().studentSwapper();
					break;
				case 12:
					new StudentViewer().removeDetails();
					break;
				case 13:
					new StudentViewer().isEmptyChecker();
					break;
				case 14:
					new StudentViewer().trimTheSize();
					break;
				case 15:
					new StudentViewer().increaseTheCapacity();
					break;
				case 16:
					new StudentViewer().increaseTheCapacity();
					break;
				case 17:
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

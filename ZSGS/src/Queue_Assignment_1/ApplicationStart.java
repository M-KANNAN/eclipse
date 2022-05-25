package Queue_Assignment_1;

import java.util.Scanner;

public class ApplicationStart {
	
private void flowManager() {
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			System.out.println();
			System.out.println("  **Welcome to Zoho Schools**");
			System.out.println();
			System.out.println("Seates Available : "+(20 - RegisterStudent.admissionNumber));
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("Enter 1 to Register your name ");
			System.out.println("Enter 2 to view students");
			System.out.println("Enter 3 to Exit");
			System.out.println();
			byte choice=scanner.nextByte();
			switch(choice) {
				case 1 :
					new RegisterStudent().resgisterStudent();
					break;
				case 2 :
					new StudentViewer().studentViewer();
					break;
				case 3 :
					System.out.println("!!! THANK YOU !!!");
					isExit=false;
					break;
			}
		}
		
	}


	public static void main(String[] args) {
		new ApplicationStart().flowManager();

	}

	
}

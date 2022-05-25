package ClassExample;

import java.util.Scanner;

public class ApplcationStart {
	
	
	private void flowManager() {
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			System.out.println();
			System.out.println("    **Welcome to ZSGS**");
			System.out.println();
			System.out.println("Enter a choice");
			System.out.println();
			System.out.println("1 for student creation");
			System.out.println("2 for student details viewing");
			System.out.println("3 for Exit");
			byte choice=scanner.nextByte();
			
			switch(choice) {
			case 1 :
				new StudentCreation().studentCreation();
				break;
				
			case 2 :
				new StudentView().studentView();
				break;
			case 3:
				System.out.println("!!! Thank You !!!");
				isExit=false;
				break;
			default :
				System.out.println();
				System.out.println("!!! Enter a valid choice !!!");
				break;
					
			}
			
				
			
		}
		
		}
	
	

	public static void main(String[] args) {
		
		new ApplcationStart().flowManager();
		

	}

	

}

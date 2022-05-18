package HomeWork.SimpleCollectionExe;

import java.util.Scanner;

public class ApplictaionStart {
	
	private void flowManager() {
		Scanner scanner=new Scanner(System.in);
		boolean isExite=true;
		while(isExite) {
			System.out.println();
			System.out.println("****************************************");
			System.out.println();
			System.out.println("     **Welcome to ZSGS**");
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("~1 to add students details");
			System.out.println("~2 to view student details");
			System.out.println("~3 to exit");
			System.out.println("****************************************");
			System.out.println();
			byte choice=scanner.nextByte();
			switch(choice) {
			
			case 1 :
				new StudentDetails().flowManager();;
				break;
				
			case 2 :
				new StudentViewer().studentViewer();
				break;
				
			case 3 :
				isExite=false;
				System.out.println("!!!Thank You!!!");
				break;
			default :
				System.out.println("Enter the vaild choice");
				System.out.println();
				break;
			
			}
		}
		
	}
	

	public static void main(String[] args) {
		
		new ApplictaionStart().flowManager();

	}

	

}



import java.util.Scanner;


public class HandleInputMismatchException {

	public static void main(String[] args) {
		
		inputMisMatchExceptionHandler();

	}

	private static void inputMisMatchExceptionHandler() {
		Scanner scanner=new   Scanner(System.in);
		boolean isExit=true;
		StringBuilder s1=new StringBuilder();
			
			while(isExit) {
				System.out.println("Enter your choice ");
				System.out.println("1 to print name ");
				System.out.println("2 to exit");
				
				s1.append(scanner.nextLine());
				
				System.out.println(s1.length());
				
				if(s1.length() == 1 && Character.isDigit(s1.charAt(0)) && !s1.toString().contains(" ")) {
					byte choice=Byte.parseByte(s1.toString());
					switch(choice) {
					case 1 :
						System.out.println("Enter your name");
						scanner.nextLine();
						String Name=scanner.nextLine();
						System.out.println(Name);
						break;
					case 2 :
						System.out.println("Exit");
						isExit=false;
						break;
					default : 
						System.out.println("Invalid choice");
						break;
				}
					
				}
				else {
					s1.setLength(0);
					System.out.println("!!! Invalid input !!!");
				}
				
				
			}
			
			
	}

}

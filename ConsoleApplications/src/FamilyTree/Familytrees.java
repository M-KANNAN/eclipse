package FamilyTree;

import java.util.Scanner;

public class Familytrees {

	private static void main() {
		
		Scanner scanner=new Scanner(System.in);
		
		
		boolean isExite=true;
		byte choice ;
		while(isExite){
			System.out.println("*********************");
			System.out.println("Welcome to Family map");
			System.out.println("********************");
			System.out.println("Enter 1 to update family information :");
			System.out.println("Enter 2 to check eligible pepole to marry :");
			System.out.println("Enter 3 to exit");
			choice=scanner.nextByte();
			switch(choice) {
				case 1 :{
					new FamilyMap().createFamily();
					break;
				}
				case 2 : {
					new EligibleChecker().eligibleChecker();
					break;
				}
				case 3 :{
					isExite=false;
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		main();

	}

	

}

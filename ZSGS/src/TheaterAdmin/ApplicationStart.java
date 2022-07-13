package TheaterAdmin;

import java.util.Scanner;

public class ApplicationStart {
	

	private void flowManager() {
		Scanner scanner=new Scanner(System.in);
		boolean isExit=true;
		while(isExit) {
			System.out.println("Enter 1 to alter movie");
			System.out.println("2 to exit");
			byte choice =scanner.nextByte();
			switch(choice) {
			case 1 :
				new Admin().movieAlter();
				break;
			case 2 :
				isExit=false;
				break;
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		new Admin().moviesRunning();
		new  ApplicationStart().flowManager();

	}


}

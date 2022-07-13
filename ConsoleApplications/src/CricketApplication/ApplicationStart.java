package CricketApplication;

public class ApplicationStart {

	private void flowManager() {
		
		System.out.println("\t\t !!! WELCOME TO CRICKET MATCH !!!");
		System.out.println();
		
		new CricketMatch().playerAdder();
		
	}
	
	public static void main(String[] args) {
		new ApplicationStart().flowManager();

	}

	

}

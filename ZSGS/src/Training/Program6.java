package Training;


public class Program6 {

	public static void main(String[] args) {
		
		int number = 100;
		int group = 4;
	    System.out.println("Output :");
	    System.out.println();
	    for(int i = 1;i <= group;i++) {
	    	System.out.println("Group "+i);
	    	System.out.println();
	    	int j=number + i;
	    	while(j <= 120) {
	    		System.out.println(j);
	    		j = j + 4;
	    	}
	    	System.out.println();
	    }
 

		
	}
	
	

}

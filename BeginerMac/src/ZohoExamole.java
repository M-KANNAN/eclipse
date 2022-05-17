import java.util.Scanner;

public class ZohoExamole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TO REVERSE A STRING WORDES FROM END TO START

		 Scanner scanner=new Scanner(System.in);
		 System.out.println("Enter the string");
	        String s1=new String();
	        s1=scanner.nextLine();
	        int count =0;
//	        for(int i=0;i<s1.length();i++){
//	        	
//	            if(s1.charAt(i)==' ') {
//	                count++;
//	            }
//	        }
	        
	       String a[]=s1.split("\\s");  //SPACE CHARACTER => //S
	      
	        for(int j=a.length-1;j>=0;j--){
	            System.out.print(a[j]);
	            System.out.print(" ");
	        }
	        
		
	}

}

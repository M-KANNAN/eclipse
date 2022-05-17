import java.util.Scanner;

public class RunLengthEncoding {

	//INPUT = AAABBC
	//OUTPUT = A3B2C1
	
	public String runLengthEncoding(String str) {
		
		int len=str.length();
		
		//for loop for encoding the elements of the string
		
		for(int i=0;i<len;i++) {
			int count=1; //MUST BE 1 NOT '0'
			while(i<len-1 && str.charAt(i)==str.charAt(i+1)) {
				count++;
				i++;
			}
			System.out.print(str.charAt(i));  //NO PRINTLN
			System.out.print(count);
		}	
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunLengthEncoding encoding=new RunLengthEncoding();
		try (Scanner scanner = new Scanner(System.in)) {
			String str=new String();
			System.out.println("Enter the String");
			str=scanner.next();
			encoding.runLengthEncoding(str);
		}
	
	}

}

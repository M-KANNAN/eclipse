import java.util.Scanner;

public class DiagnolPrintingSting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		String s1=new String();
		String s2= ("kanna");//Pre decleration
		System.out.println("Enter the string :");
		s1=scanner.next();
		int len=s1.length();
		for(int i=0;i<len;i++) {
			int g=len-i-1;
			for(int j=0;j<len;j++) {
				if(i==j) {
					System.out.print(s1.charAt(j));
				}
				else if(j==g) {
					System.out.print(s1.charAt(j));
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
			
		}
		

	}

}

import java.util.Scanner;

public class SplittingStringAsAlphapetNumberSymbols {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//THIS IS DONE BY USING STRING BUFFER
		
		StringBuffer alpha=new StringBuffer(),num=new StringBuffer(),special=new StringBuffer();
		Scanner scanner=new Scanner(System.in);
		String s1=new String();
		System.out.println("Enter the string:");
		s1=scanner.nextLine();
		//splliting the string using character class inside StringBuffer
		
		for(int i=0;i<s1.length();i++) {
			
			if (Character.isAlphabetic(s1.charAt(i))) {
				alpha.append(s1.charAt(i));
			}
			else if (Character.isDigit(s1.charAt(i))) {
				num.append(s1.charAt(i));
			}
			else {
				special.append(s1.charAt(i));
			}
			
		}
		System.out.println("ALPHAPETS ARE : "+alpha);
		System.out.println("NUMBERS ARE : "+num);
		System.out.println("SPECIAL SYMBOLS ARE : "+special);
		

	}

}

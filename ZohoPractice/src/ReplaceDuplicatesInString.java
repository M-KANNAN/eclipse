import java.util.HashSet;
import java.util.Scanner;

public class ReplaceDuplicatesInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//USING HASHSET AND STRINGBUFFER
		
		Scanner scanner=new Scanner(System.in);
		String str = new String();
		System.out.println("Enter the String ");
		str=scanner.next();
		
		//INITIALIZE STRING BUFFER AND HASHSET
		
		HashSet<Character> set=new HashSet<Character>();
		StringBuffer buffer=new StringBuffer();
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(!set.contains(c)) {
				set.add(c);
				buffer.append(c);
			}
		}
		System.out.println("String without duplicates : "+buffer);
		
	}

}

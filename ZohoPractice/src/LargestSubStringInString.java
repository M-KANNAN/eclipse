import java.util.HashSet;
import java.util.Scanner;

public class LargestSubStringInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String str1=new String();
		System.out.println("Enter the the string");
		str1=scanner.next();
		String str2=longest(str1);
		System.out.println("LongestSubString : "+str2);
		
	}

	private static String longest(String str1) {
		// TODO Auto-generated method stub
		HashSet<Character> hashSet=new HashSet<>();
		String longestTillNow=" ";
		String longestAll=" ";
		for(int i=0;i<str1.length();i++) {
			char c=str1.charAt(i);
			if(hashSet.contains(c)){
				  longestTillNow=" ";
				  hashSet.clear();
			  }
			longestTillNow+=c;
			hashSet.add(c);
			if(longestTillNow.length()>longestAll.length()) {
				longestAll=longestTillNow;
			}
		  
			
		}
		
		
		return longestAll;
	}

}

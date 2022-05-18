import java.util.Scanner;

public class LongestSubstringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		String str=new String();
		System.out.println("Enter the String");
		str=scanner.next();
		longestSubString(str);

	}

	private static void longestSubString(String str) {
		// TODO Auto-generated method stub
		
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			for(int j=str.length()-1;j>i;j--) {
				if(str.charAt(i)==str.charAt(j)) {
					builder.append(str.substring(i,j+1));
					builder.reverse();
					if(builder.toString().equals(str.substring(i, j+1))) {
						System.out.println(builder);
						break;
					}
					
				}
			}
		}
		
		
		
	}

}

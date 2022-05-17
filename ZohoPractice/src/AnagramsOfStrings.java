import java.util.Arrays;
import java.util.Scanner;

public class AnagramsOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ANAGRAMS MEANS THE 2 STRING CONATINS SAMAE NUMBER OF CHARACTERS BUT IN DIFFRENT ORDER
		
		Scanner scanner=new  Scanner(System.in);
		String str1=new String();
		System.out.println("Enter the string 1");
		str1=scanner.next();
		String str2=new String();
		System.out.println("Enter the string 2");
		str2=scanner.next();
		
		
		//if lengths are not equal then they are not a anagrams
		
		if(str1.length()!=str2.length()) {
			System.out.println("These two given strings are not an ANAGRAMS");
		}
		else {
			
			//character array used for string processing
			
			char arr1[]=str1.toCharArray();
			char arr2[]=str2.toCharArray();
			
			//sorting the array elements in ASCII order
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			if(Arrays.equals(arr1,arr2)) {
				System.out.println("These two given strings are ANAGRAMS");
			}
			else {
				System.out.println("These two given strings are not an ANAGRAMS");
			}
			
			
		}
		
		
		
		
	}

}

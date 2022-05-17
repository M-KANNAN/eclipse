import java.lang.reflect.Array;
import java.util.Scanner;

public class Qustion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		String str1=new String();
		System.out.println("enter the string:");
		str1=scanner.nextLine();
		String str2=new String();
		System.out.println("Enter the number ");
		str2=scanner.nextLine();
		
		//spliting the words as EXAMPLE :	kanna-k,ka,kan,kann,kanna
		String arr1[]=new String[str1.length()];
		
		for(int i=0;i<str1.length();i++ ) {
			arr1[i]=str1.substring(0,i+1);
			
		}
		
		//splting the string has number into 1 digit number
		//EXAPLE : 1234-1,2,3,4
		
		int arr2[]=new int[str2.length()];
		
		for(int i=0;i<str2.length();i++) {
			arr2[i]=Integer.parseInt(str2.substring(i, i+1));
			
		}
		//EXAMPLE OPUTPUT 
//		enter the string:
//			kanna
//			Enter the number 
//			12345
		//OUTPUT
//			k
//			kaka
//			kankankan
//			kannkannkannkann
//			kannakannakannakannakanna

		
		for(int i=0;i<arr2.length;i++) {
			int count=arr2[i];
			for(int j=0;j<count;j++) {
				System.out.print(arr1[i]);
			}
			System.out.println();
		}
		
	}

}









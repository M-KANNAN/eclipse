import java.util.Scanner;

public class RemoveSubstringFromMainString {
	//Using STRINGBULIDER

	public static void main(String[] args) {
		
		String s1=new String();
		String s2=new String();
		Scanner scanner=new Scanner(System.in);
		
		//getting input for MainString and SubString
		
		System.out.println("enter the Mainstring :");
		s1=scanner.next();
		System.out.println("Enter the SubString :");
		s2=scanner.next();
		
		//Check the SubString is present in MainString or not
		//if present Remove the SubString from the MainString and store in S3
		//Else print Substring not found in the main string
		
		StringBuilder s3=new StringBuilder();
		StringBuilder str=new StringBuilder(s1);
		
		if(s1.contains(s2)) {
			System.out.println("MainString before removal : "+s1);
			
			//to find the index of the substring in the main string
			
			int index=s1.indexOf(s2);
			System.out.println("SubString present in the index "+index);
			
			//removal
			
			s3=str.delete(index, index +s2.length());
			
			System.out.println("MainString after removal : "+s3);
		}
		else{
			System.out.println("SubString is not present in MainString");
		}

	}

}

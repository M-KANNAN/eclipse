import java.util.Scanner;

public class Pallindrome {
 public static void main(String []args) {
	 Scanner scanner=new Scanner(System.in);
	 String s1=new String();
	 System.out.println("Enter the string to be reversed");
	 s1=scanner.next();
	 //PRE DEFINED STRING FUNCTION FOR STRING IS UNAVAILABLE
	 //SO WE ARE USING CHARACTER ARRAY
	 int mid=s1.length()/2;
	 System.out.println(s1.substring(0,mid));
	 System.out.println(s1.substring(mid+1,s1.length()));
	 if(s1.substring(0,mid).equalsIgnoreCase(s1.substring(mid+1,s1.length()))) {
		 System.out.println("Pallindrom");
	 }
	 else {
		 System.out.println("Not a pallindrom");
	 }
	 
	}
}

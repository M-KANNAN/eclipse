import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfNumbersInStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Input ={"ab2","12","bc6","bc","ac'}
		//output sum=2+1+2+6=11
		
		Scanner scanner=new Scanner(System.in);
		int sum=0;
		String str[]=new String[5];
		System.out.println("Enter the input for the string array");
		for(int i=0;i<str.length;i++) {
			str[i]=scanner.next();
		}
		String array=Arrays.toString(str);//converting Array to string
		System.out.println("String representation of array : "+array);
		StringBuilder number=new StringBuilder();
		for(int i=0;i<array.length();i++) {
			if(Character.isDigit(array.charAt(i))) {
				number.append(array.charAt(i));
			}
		}
		int digit=Integer.parseInt(number.substring(0, number.length()));
		System.out.println("digit + "+digit); 	
		while(digit>0) {
			sum=sum+digit%10;
			digit=digit/10;
					
		}
		System.out.println("Sum = "+sum);

	}

}


//
//OUTPUT:
//	
//	Enter the input for the string array
//	ab2
//	12
//	bc6
//	bc
//	ac
//	digit + 2126
//	Sum = 11

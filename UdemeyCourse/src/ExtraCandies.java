import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ExtraCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//AN ARRAY CONTAINS THE NUMBER OF CANDIES GIVEN TO A STUDENT 
		//IF SOME EXTRA CANTIES ARE GIVEN TO THE STUDENT 
		//TO CHECK SUM OF THE AVAILABLE CANDIES AND THE EXTRA CANDIES 
		//MUST BE  >= MAXIMUM CANDIES HAVE BY A STUDENT
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of Students ");
		int len=scanner.nextInt();
		int candies[]=new int[len];
		System.out.println("Enter the number of candies ");
		for(int i=0;i<len;i++) {
			candies[i]=scanner.nextInt();
		}
		System.out.println("Enter the extra candies ");
		int extraCandies=scanner.nextInt();
		
		List<Boolean> booleans=new Stack<Boolean>();
		int max=Integer.MIN_VALUE;
		for(int i=0;i<len;i++) {
			if(max<candies[i]) {
				max=candies[i];
			}
				
		}
		for(int i=0;i<len;i++) {
			if(candies[i] + extraCandies >= max) {
				booleans.add(true);
			}
			else {
				booleans.add(false);
			}
		}
		System.out.println(booleans.toString());

	}

}

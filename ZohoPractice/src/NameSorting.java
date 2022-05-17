import java.util.Arrays;
import java.util.Scanner;

public class NameSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the array length :");
		int len=scanner.nextInt();
		String arr[]=new String[len];
		System.out.println("Enter the Names to be sort");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.next();
		}
		nameSorting(arr);
		
		
	}

	private static void nameSorting(String[] arr) {
		// TODO Auto-generated method stub
		String temp=" ";
		String temp1=" ";
		String temp2=" ";
		for(int i=0;i<arr.length;i++) {
			temp1 =arr[i];
			for(int j=i+1;j<arr.length;j++) {
				temp2=arr[j];
				if(temp1.compareToIgnoreCase(temp2)>0)
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}
			
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		
		
		
	}


}

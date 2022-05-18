package Training;

import java.util.Scanner;

public class Program11 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a value for row :");
		int row=scanner.nextInt();
		System.out.println("Enter a value for column :");
		int column=scanner.nextInt();
		System.out.println("Enter the array elements");
		int[][] arr=new int[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.println("Enter the element for position : "+i+" "+j);
				arr[i][j]=scanner.nextInt();
			}
		}
		
		System.out.println("before transistion");
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Enter the rotation count :");
		int count=scanner.nextInt();
		int temp=0;
		for(int k=0;k<count;k++) {
			for(int i=0;i<row;i++) {
				temp=arr[i][0];
				for(int j=0;j<column-1;j++) {
					arr[i][j]=arr[i][j+1];
				}
				arr[i][column -1]=temp;
			}
			
		}
		System.out.println("left rotation of multidimensional array ");
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		scanner.close();

	}

}

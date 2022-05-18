package HomeWork;

import java.util.Scanner;

public class ReplacingRowColumnWithZeros {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter row size ");
		int row=scanner.nextInt();
		System.out.println("Enter column size");
		int column=scanner.nextInt();
		int arr[][]=new int[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.println("Enter the element for ["+i+" "+j+"]");
				arr[i][j]=scanner.nextInt();
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		int result[][]=new int[row][column];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(arr[i][j] == 0) {
					for(int k=0;k<column;k++) { //row change
						result[i][k]=-1;
					}
					for(int k=0;k<row;k++) { //column change
						result[k][j]=-1;
					}
				}
				else if(result[i][j] != -1) {
					result[i][j]=arr[i][j];
				}
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(result[i][j] == -1) {
					result[i][j]=0;
				}
			}
			
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		scanner.close();

	}

}

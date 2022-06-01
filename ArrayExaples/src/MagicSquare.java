import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a row size ");
		int row=scanner.nextInt();
		System.out.println("Enter a column size");
		int column=scanner.nextInt();
		int arr[][]=new int[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.println("Enter row "+(i+1)+" Column "+(j+1) + " Element");
				arr[i][j] = scanner.nextInt();
			}
		}
		
		// To find sum of first row
		
		int sum=0;
		boolean flag=true;
		
		sum=(row*(row*row +1))/2;
		
		
		// row sum checker
		int sumChecker=0;
		for(int i=1;i<row;i++) {
			sumChecker=0;
			for(int j=0;j<column;j++){
				sumChecker=sumChecker+arr[i][j];
			}
			if( sumChecker == sum) {
				continue;
			}
			else {
				flag=false;
				break;
			}
		}
		
		// column sum checker
		
		for(int i=0;i<column;i++) {
			sumChecker=0;
			for(int j=0;j<row;j++){
				sumChecker=sumChecker+arr[j][i]; // interchange i and j
			}
			if( sumChecker == sum) {
				continue;
			}
			else {
				flag=false;
				break;
			}
		}
		if(flag == true) {
			System.out.println("Magic Square");
		}
		else {
			System.out.println("Not a Magic Square");
		}
		scanner.close();
		
	}

}

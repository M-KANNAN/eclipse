import java.util.Scanner;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length of an array : ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements : ");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		
		for(int i=1;i<=arr[0];i++) {
			if((len -1) - i == arr[i]) {
				System.out.println("Jump to last element is possible by element : "+arr[i]+" index : "+i);
				break;
			}
			else
				System.out.println("No Jump is possible");
		}

	}

}

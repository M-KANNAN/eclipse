import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UndispersedNumbersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the array size ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements : ");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		List<Integer> list=new Stack<Integer>();
		for(int i=1;i<=len;i++) {
			int flag=0;
			for(int j=0;j<len;j++) {
				if(i ==arr[j]) {
					flag=1;
					continue;
				}
			}
			if(flag!=1) {
				list.add(i);
			}
		}
		System.out.println(list.toString());

	}

}

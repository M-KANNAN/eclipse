import java.util.*;
public class ProductOfArrayExceptItself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length of an array :");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements :");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
			}
		List<Integer> list=new Stack<Integer>();
		for(int i=0;i<len;i++) {
			int mul=1;
			for(int j=0;j<len;j++) {
				if(i ==j) {
					continue;
				}
				else {
					mul=mul*arr[j];
				}
			}
			list.add(mul);
		}
		System.out.println(list.toString());
	}

}

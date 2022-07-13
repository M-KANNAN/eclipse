import java.util.Scanner;

public class MaximumValueForInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a size of array ");
		int len=scanner.nextInt();
		System.out.println("Enter a array elements");
		int arr[]=new int[len];
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
		}
		
		new MaximumValueForInteger().functionallogic(arr);

	}

	private void functionallogic(int[] arr) {
		// TODO Auto-generated method stub
		
		int sum=0,product=1;
		int num=0;
		
		for(int i=0;i<arr.length;i++) {
			sum=0;
			product=1;
			num=arr[i];
			while(num > 0) {
				sum=sum+num%10;
				product=(product)*(num%10);
				num/=10;
			}
			if(sum >= product) {
				System.out.println("Sum : "+sum);
			}
			else {
				System.out.println("Product : "+product);
			}
			
		}
		
	}

}

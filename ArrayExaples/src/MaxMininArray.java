import java.util.Scanner;

public class MaxMininArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i,len,max,min;
		System.out.println("Enter the array size");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("Enter the array elements");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();
		}
		//TO FIND MAX AND MIN OF ARRAY
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		for(i=0;i<len;i++) {
			if(a[i]<min) {
				min=a[i];
			}
			if(a[i]>max) {
				max=a[i];
				
			}
		}
		System.out.println("MINIMUM ELEMENT OF ARRAY IS "+min);
		System.out.println("MAXIMUM ELEMENT OF ARRAY IS "+max);
	}

}

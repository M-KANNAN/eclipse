package Training;

import java.util.Scanner;

public class Program60 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number : ");
		int num=scanner.nextInt();
		int sum=0;
		StringBuilder  builder=new StringBuilder();
		builder.trimToSize();
		for(int i=0;i<num;i++) {
			for(int j=0;j<=i;j++) {
				builder.append(1);
			}
			sum=sum+Integer.parseInt(builder.toString());
			builder.replace(0, builder.length(),"");
		}
		System.out.println(sum);
		scanner.close();
	}

}

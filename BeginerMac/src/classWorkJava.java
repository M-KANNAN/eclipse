import java.util.Scanner;

public class classWorkJava {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number :");
		int num=scanner.nextInt();
		for(int i=0;i<5;i++) {
			for(int j=0;j<=9;j++) {
				if(i+j == num && i<j) {
					System.out.println(i+""+j);
				}
			}
		}
		scanner.close();

	}

}

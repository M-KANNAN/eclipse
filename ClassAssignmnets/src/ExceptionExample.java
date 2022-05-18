import java.util.InputMismatchException;
import java.util.Scanner;

class MyOwnException extends Exception{
	public MyOwnException(String s) {
		System.out.println("Exception throw" +s);
	}
}

public class ExceptionExample {

	public static void main(String[] args) throws InputMismatchException,ArithmeticException,MyOwnException {
		// TODO Auto-generated method stub
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the value :");
			int a =scanner.nextInt();
			if(a>10) {
				throw new MyOwnException("Hai");
			}
			else{
				throw new MyOwnException("Hai");
			}
	}

}

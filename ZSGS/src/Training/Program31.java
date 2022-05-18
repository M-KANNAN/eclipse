package Training;

import java.util.Scanner;

public class Program31 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);  
		System.out.print("Enter the value of a: ");  
		double a = input.nextDouble();  
		System.out.print("Enter the value of b: ");  
		double b = input.nextDouble();  
		System.out.print("Enter the value of c: ");  
		double c = input.nextDouble();  
		double determinant= b * b - 4.0 * a * c;  

		double root1, root2;

		// check if determinant is greater than 0
		if (determinant > 0) {

		// two real and distinct roots
		root1 = (-b + Math.sqrt(determinant)) / (2 * a);
		root2 = (-b - Math.sqrt(determinant)) / (2 * a);

		System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
		}

		// check if determinant is equal to 0
		else if (determinant == 0) {

		// two real and equal roots
		// determinant is equal to 0
		// so -b + 0 == -b
		root1 = root2 = -b / (2 * a);
		System.out.format("root1 = root2 = %.2f;", root1);
		}

		// if determinant is less than zero
		else {

		// roots are complex number and distinct
		double real = -b / (2 * a);
		double imaginary = Math.sqrt(-determinant) / (2 * a);
		System.out.format("root1 = %.2f+%.2fi", real, imaginary);
		System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
		}

		input.close();
		

	}

}

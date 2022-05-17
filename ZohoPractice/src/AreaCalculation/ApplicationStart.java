package AreaCalculation;

import java.util.Scanner;

public class ApplicationStart {
	Scanner scanner=new Scanner(System.in);
	
private void mensurationcalculator() {
		
	System.out.println("Welcome to Mensuration Calculation Class");
	System.out.println("****************************************");
	System.out.println("Find the area and perimeter of following shapes");
	boolean isExite=true;
	while(isExite) {
		System.out.println("Enter your choice :");
		System.out.println("1 . Rectangle ");
		System.out.println("2 . Square ");
		System.out.println("3 . Triangle");
		System.out.println("4 . Exit ");
		byte choice=scanner.nextByte();
		switch(choice) {
			case 1 :{
				new RectangleMensuration().findRectangle();
				break;
				}
			case 2 :{
				new SquareMensuration().findSquare();
				break;
				}
			case 3 : {
				new TriangleMensuration().findTriangle();
				break;
				}
			case 4 : {
				System.out.println("!!! THANK YOU !!!");
				isExite=false;
				break;
				}
			default :{
				System.out.println("!!! Enter a valid choice !!!");
				break;
			}
		}
		
	}
}


	public static void main(String[] args) {
		

		ApplicationStart start=new ApplicationStart();
		start.mensurationcalculator();

	}

	
}

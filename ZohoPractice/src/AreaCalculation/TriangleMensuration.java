package AreaCalculation;

import java.util.Scanner;

public class TriangleMensuration {
	Scanner scanner=new Scanner(System.in);
	public void findTriangle() {
		
		
		boolean isExite=true;
		while(isExite) {
			System.out.println("Welcome to triangle menu");
			System.out.println("*************************");
			System.out.println("Enetr your choice : ");
			System.out.println("1 . Area of Triangle");
			System.out.println("2 . Perimeter of Traiange");
			System.out.println("3 . exit");
			byte choice =scanner.nextByte();
			switch(choice) {
				case 1 :{
					System.out.println(" ****** Area of Triangle *****");
					System.out.println("Eneter breadth of the Triangle in (cm)");
					double breadth=scanner.nextDouble();
					System.out.println("Enter height of the triangle in (cm)");
					double height=scanner.nextDouble();
					if(breadth > 0 && height >0 ) {
						System.out.println("Area of the Triangle : "+(0.5*(breadth*height))+" (cm)");
					}
					else {
						System.out.println("!!! Invalid input !!!");
					}
					
					break;
					
					}
				case 2 : {
					System.out.println(" ****** Perimeter of Triangle *****");
					System.out.println("Enter side 1 in (cm)");
					double side1=scanner.nextDouble();
					System.out.println("Enter side 2 in (cm)");
					double side2=scanner.nextDouble();
					System.out.println("Enter side 3 in (cm)");
					double side3=scanner.nextDouble();
					if(side1 > 0 && side2 > 0 && side3 > 0) {
						System.out.println("Perimeter of the triangle : "+(side1+side2+side3)+" (cm)");
						break;
					}
					else {
						System.out.println("!!! Invalid input !!!");
						break;
					}
					
					
					}
				case 3 :{
					isExite=false;
					break;
					}
				default : {
					System.out.println("!!! Eneter a valid choice !!!");
					break;
					}
				}
		}
		
		
	}

}

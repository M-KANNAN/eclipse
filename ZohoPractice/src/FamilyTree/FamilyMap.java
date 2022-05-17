package FamilyTree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FamilyMap {
	
	Scanner scanner=new Scanner(System.in);
	char gender;
	String name;
	String fathersName;
	String mothersName;
	static LinkedHashMap<String, FamilyMap> map=new LinkedHashMap<String, FamilyMap>();
	

	public FamilyMap(char gender, String fathersName, String mothersName) {
		this.gender=gender;
		this.fathersName=fathersName;
		this.mothersName=mothersName;
	}


	public FamilyMap() {
		
	}


	public void createFamily() {
		System.out.println("*************************");
		System.out.println("Welcome to update menu : ");
		
		byte i=1;
		while(i <= 5) {
			if( i == 1) {
				System.out.println("Enter name of the person :");
				name=scanner.nextLine().toLowerCase();
				i++;
			}
			else if( i == 2) {
				System.out.println("Enter gender as M for male and F for female");
				gender=scanner.next().charAt(0);
				i++;
			}
			else if( i == 3) {
				System.out.println("Enter Fathers name :");
				fathersName=scanner.next().toLowerCase();
				i++;
			}
			else if( i == 4) {
				System.out.println("Enter Mother's name :");
				mothersName=scanner.next().toLowerCase();
				i++;
			}
			else if( i == 5){
				FamilyMap familyMap=new FamilyMap(gender,fathersName,mothersName);
				map.put(name, familyMap);
				i++;

			}
		}
		
	}

}

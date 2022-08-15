package FamilyTree;

import java.util.Iterator;
import java.util.Scanner;

public class EligibleChecker {
	
	Scanner scanner=new Scanner(System.in);
	String name;

	public void eligibleChecker() {
		
		System.out.println("*********************");
		System.out.println("Enter the name of the person to check :");
		name = scanner.nextLine();
		if(FamilyMap.map.get(name) != null) {
		
			
			if(name != null && FamilyMap.map.get(name).gender =='m') {
				this.checkingFunctionMale(name);
			}
			else if(name != null && FamilyMap.map.get(name).gender =='f') {
				this.checkingFunctionFemale(name);
			}

			
		}
		else {
			System.out.println("*****************");
			System.out.println("Name not found in the tree");
			
		}
		
	}

	private void checkingFunctionFemale(String name) {
		String fathersName=FamilyMap.map.get(name).fathersName;
		String mothersName=FamilyMap.map.get(name).mothersName;
		
		Iterator<String> iterator=FamilyMap.map.keySet().iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(fathersName)) {
				new FemaleFatherrelation().fatherRelation(fathersName);
				break;
			}
			else if(iterator.next().equals(mothersName)) {
				new FemaleMotherrelation().motherRelation(mothersName);
				break;
			}
		}
		
		
	}

	private void checkingFunctionMale(String name) { 
		
		String fathersName=FamilyMap.map.get(name).fathersName;
		String mothersName=FamilyMap.map.get(name).mothersName;
		
		Iterator<String> iterator=FamilyMap.map.keySet().iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(fathersName)) {
				new MaleFatherrelation().fatherRelation(fathersName);
				break;
			}
			else if(iterator.next().equals(mothersName)) {
				new MaleMotherrelation().motherRelation(mothersName);
				break;
			}
		}
		
	}


}

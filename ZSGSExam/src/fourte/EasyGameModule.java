package fourte;

import java.util.Scanner;

public class EasyGameModule {

	public void gameModule() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Welcome to easy Level ");
		System.out.println();
		
		System.out.println("Sample output");
		System.out.println("form a equation for this value : 5");
		System.out.println("Form a equation like : 1*5");
		System.out.println("Using a numbers  1,2,3,5 with operators +,-,*,/"  );
		
		
		boolean isExit=true;
		while(isExit) {
			System.out.println();
			System.out.println("Enter yor choice");
			System.out.println("Enter 1 to play");
			System.out.println("Enter 2 to quit");
			byte choice=scanner.nextByte();
			switch(choice) {
			case 1:
				String equation=logicalFunction();
				this.fourteEasyMode(equation);
				break;
			case 2 :
				isExit=false;
				break;
			default :
				System.out.println("Invalid choice");
				break;
			}
			
			
		}
		
			
	}


	private void fourteEasyMode(String equation) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		String arr[]=equation.split("=");
		System.out.println("CONSTRUCT THE EQUATION FOR THE OUPUT");
		
		System.out.println(arr[1]);
		
		System.out.println("Form a equation from these numbers");
		
		System.out.print((int)(Math.random()*6)+1 +"\t");
		for(int i=0;i<arr[0].length();i++) {
			if(Character.isDigit(arr[0].charAt(i))) {
				System.out.print(arr[0].charAt(i)+"\t");
			}
		}
		System.out.print((int)(Math.random()*6)+1+"\t");
		String userEquation=scanner.nextLine();
		
		if(equation.contains("/") || equation.contains("-")){
			System.out.println(userEquation.trim().equals(arr[0].trim()) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");
			System.out.println("Output : "+arr[0]);
		}
		else {
			StringBuilder builder=new StringBuilder();
			builder.append(userEquation);
			System.out.println(builder.reverse().toString().trim().equals(arr[0].trim()) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");
			System.out.println("Output : "+arr[0]);
		}
		
		//System.out.println(arr[1]);
		
		
		
	}



	public String logicalFunction() {
		// TODO Auto-generated method stub
		
		
		char SymbolArray[]= {'0','*','+','-','/'};
		StringBuilder equationFormation=new StringBuilder();
		
		
		
		int randomNumber1=(int)(Math.random()*6)+1;
		int randomNumber2=(int)(Math.random()*6)+1;
		
		
		char randomSymbol=SymbolArray[(int)(Math.random()*(4))+1];
		
		while(true) { // to achive multiplication
			if(randomSymbol == '0' ){
				randomSymbol=SymbolArray[(int)(Math.random()*(4))+1];
			}
			else {
				break;
			}
		}
		
		while(true) { // for division and subtraction number1 > number 2
			if((randomSymbol == '/' || randomSymbol == '-') && randomNumber1 < randomNumber2) {
				 randomNumber1=(int)(Math.random()*6)+1;
				randomNumber2=(int)(Math.random()*6)+1;
			}
			else {
				break;
			}
		}
		
		while(true) { // division rule
			if((randomSymbol == '/' && randomNumber1 % randomNumber2 !=0)) {
				randomNumber1=(int)(Math.random()*6)+1;
				randomNumber2=(int)(Math.random()*6)+1;
			}
			else {
				break;
			}
		}
		
		
		int reuslt=randomSymbol == '+' ? (randomNumber1 + randomNumber2) : randomSymbol == '-' ? (randomNumber1 - randomNumber2) : randomSymbol == '*' ? (randomNumber1 * randomNumber2) : (randomNumber1 / randomNumber2);
		
		equationFormation.append(randomNumber1+""+randomSymbol+""+randomNumber2 +"="+reuslt);
//		System.out.println(equationFormation);
//		System.out.println(reuslt);
		
		return equationFormation.toString();
		
		
	}

}
package fourte;

import java.util.Scanner;

public class HardGameModule {

	public void gameModule() {
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub

		
	
		
		System.out.println("Welcome to Hard  Level ");
		System.out.println();
		
		System.out.println("Sample output");
		System.out.println("form a equation for this value : 6");
		System.out.println("Equation like : 4	3	6	4  as (3+4)-(6-4)");
		System.out.println("by inserting proper in the given number spaces operators +,-,*,/,(,)"  );
		
		
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
				this.fourteHardMode(equation);
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

	private void fourteHardMode(String equation) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		String arr[]=equation.split("=");
		System.out.println("CONSTRUCT THE EQUATION FOR THE OUPUT");
		
		System.out.println(arr[1]);
		
		System.out.println("Form a equation from these number"+arr[0]);
		
		for(int i=0;i<arr[0].length();i++) {
			if(Character.isDigit(arr[0].charAt(i))) {
				System.out.print(arr[0].charAt(i)+"\t");
			}
		}
		
		String userEquation=scanner.nextLine();
		
		//if(equation.charAt(5) =='/' || equation.charAt(5) =='-' ){
			System.out.println(userEquation.trim().equals(arr[0].trim()) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");
			System.out.println("Output : "+arr[0]);
//		}
//		else {
//			StringBuilder builder=new StringBuilder();
//			builder.append(userEquation);
//			System.out.println(builder.reverse().toString().trim().equals(arr[0].trim()) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");
//			System.out.println("Output : "+arr[0]);
//		}
		
		
		
		
	}

	private String logicalFunction() {
		
		
		EasyGameModule easyGameModule = new EasyGameModule();
		StringBuilder equBuilder = new StringBuilder();

		char SymbolArray[] = { '0', '*', '+', '-', '/' };

		char randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];
		
		while (true) {
			if (randomSymbol == '0') {
				randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];
			} else {
				break;
			}
		}
		
		String leftPart[]=easyGameModule.logicalFunction().split("=");
		String rightPart[]=easyGameModule.logicalFunction().split("=");
		
		//System.out.println(Arrays.toString(leftPart)+" "+Arrays.toString(rightPart));
		int leftResult=Integer.parseInt(leftPart[1]);
		int rightResult=Integer.parseInt(rightPart[1]);
		
		int result=randomSymbol == '+' ? ( leftResult+ rightResult) : randomSymbol == '-' ? ( leftResult - rightResult) : randomSymbol == '*' ? ( leftResult - rightResult) : ( leftResult / rightResult);

		equBuilder.append("("+leftPart[0]+")"+randomSymbol+"("+rightPart[0]+")="+result);
		//System.out.println(equBuilder);
		return equBuilder.toString();
	}
	

}

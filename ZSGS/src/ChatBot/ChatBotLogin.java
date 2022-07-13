package ChatBot;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ChatBotLogin {

	Scanner sc=new Scanner(System.in);
	
	Stack<ChatBotDatas> layerSelection = new Stack<ChatBotDatas>(); 
	int count;
	
	
	void print(int choice ,int layer) {
		for(String printChoice : getChoice(layer,choice)) {
			System.out.println(printChoice);	
		}
	}
	
	void assign() {
		int choice;
		layerSelection.push(new ChatBotDatas(0,0));
		print(0,0);
		do {
			System.out.print("Enter your Choice ::");
			choice=sc.nextInt();
			if(choice == 9) {
				layerSelection.pop();
				if(layerSelection.isEmpty()) {
					break;
				}
				}
				else {
					layerSelection.push(new ChatBotDatas(choice,layerSelection.peek().getLayer()+1));
				}
				ChatBotDatas top=layerSelection.peek();
				print(top.getChoice(),top.getLayer());
			
		}while(choice!=0);
		System.out.println(Layer1.Exit);
		
	}
	
	ArrayList<String> getChoice(int layer ,int choice){
		ArrayList<String> showList = new ArrayList<>();
		if(layer==0) {
			showList.add(Layer1.OUTPUT.toString());
			showList.add(Layer1.CHOICE_1.toString());
			showList.add(Layer1.CHOICE_2.toString());
			showList.add(Layer1.CHOICE_X.toString());
		}
		else if(layer==1) {
			switch(choice) {
			case 1:
				showList.add(LayerA2.OUTPUT.toString());
				showList.add(LayerA2.CHOICE_1.toString());
				showList.add(LayerA2.CHOICE_2.toString());
				showList.add(LayerA2.CHOICE_X.toString());
				showList.add(LayerA2.CHOICE_BACK.toString());
				count=0;
				break;
			case 2:
				showList.add(LayerB2.OUTPUT.toString());
				showList.add(LayerB2.CHOICE_1.toString());
				showList.add(LayerB2.CHOICE_2.toString());
				showList.add(LayerB2.CHOICE_3.toString());
				showList.add(LayerB2.CHOICE_X.toString());
				showList.add(LayerB2.CHOICE_BACK.toString());
				count=1;
				break;
			}
			
		}
		else if(layer==2) {
			if(count==0) {
				switch(choice) {
				case 1:
					showList.add(LayerA3.OUTPUT.toString());
					showList.add(LayerA3.CHOICE_1.toString());
					showList.add(LayerA3.CHOICE_2.toString());
					showList.add(LayerA3.CHOICE_X.toString());
					showList.add(LayerA3.CHOICE_BACK.toString());
					break;
				case 2:
					showList.add(LayerB3.OUTPUT.toString());
					showList.add(LayerB3.CHOICE_1.toString());
					showList.add(LayerB3.CHOICE_2.toString());
					showList.add(LayerB3.CHOICE_X.toString());
					showList.add(LayerB3.CHOICE_BACK.toString());
					break;
				}
			}
			if(count==1) {
				switch(choice) {
				case 1:
					showList.add(LayerA3.OUTPUT.toString());
					showList.add(LayerA3.CHOICE_1.toString());
					showList.add(LayerA3.CHOICE_2.toString());
					
					showList.add(LayerA3.CHOICE_X.toString());
					showList.add(LayerA3.CHOICE_BACK.toString());
					break;
				case 2:
					showList.add(LayerB3.OUTPUT.toString());
					showList.add(LayerB3.CHOICE_1.toString());
					showList.add(LayerB3.CHOICE_2.toString());
					showList.add(LayerB3.CHOICE_3.toString());
					showList.add(LayerB3.CHOICE_X.toString());
					showList.add(LayerB3.CHOICE_BACK.toString());
					break;
				}
			}
		}
		else if(layer>=3) {
			
			System.out.println("Thank You Buddy");
			System.exit(0);
		}
		
		return showList;
	}
	

	public void initialStep() {
		System.out.println("Hi Buddy");
		
		while(true) {
			System.out.println("1.Login\n2.Create Account\n3.Exit");
			int n=sc.nextInt();
			switch(n) {
			case 1:
					break;
			case 2:
				break;
			case 3:
				System.out.println("Thank You Have a Nice Day");
				System.exit(0);
			
			}
		}
	}

}

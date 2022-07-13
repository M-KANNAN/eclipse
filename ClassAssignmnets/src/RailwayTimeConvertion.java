import java.util.Scanner;

public class RailwayTimeConvertion {
	
	private void railwayTimeConverter() {
		
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter a time in string format HH:MM:SS");
			String timeInAmPm=scanner.nextLine().toUpperCase();
//			String militryTime=null;
//			
//			String arr[]=timeInAmPm.split(":");
			
//			if(timeInAmPm.contains("AM")) {
//				if(arr[0].equals("12")) {
//					arr[0]="00";
//					militryTime=String.join(":", arr).replace("AM", " HRS");
//				}
//				else {
//					militryTime=String.join(":", arr).replace("AM", " HRS");
//				}
//			}
//			else {
//				if(!arr[0].equals("12")) {
//					arr[0]=String.valueOf(12+Integer.parseInt(arr[0]));
//					militryTime=String.join(":", arr).replace("PM", " HRS");
//				}
//				else {
//					militryTime=String.join(":", arr).replace("PM", " HRS");
//				}
//			}
			
			
			if(timeInAmPm.contains("AM")) {
				if(timeInAmPm.substring(0, 2).equals("12")) {
					timeInAmPm=timeInAmPm.replace(timeInAmPm.substring(0, 2), "00").replace("AM", " HRS");
				}
				else {
					timeInAmPm=timeInAmPm.replace("AM", " HRS");
				}
			}
			else {
				if(!timeInAmPm.substring(0, 2).equals("12")) {
					//String temp=String.valueOf(Integer.parseInt(timeInAmPm.substring(0, 2))+12);
					timeInAmPm=timeInAmPm.replace(timeInAmPm.subSequence(0, 2), String.valueOf(Integer.parseInt(timeInAmPm.substring(0, 2))+12)).replace("AM", " HRS");
					
				}
				else {
					timeInAmPm=timeInAmPm.replace("PM", " HRS");
				}
			}
			
			System.out.println(timeInAmPm);
			
			//System.out.println(militryTime);
			scanner.close();
		
	}

	public static void main(String[] args) {
		
		new RailwayTimeConvertion().railwayTimeConverter();

	}

	

}

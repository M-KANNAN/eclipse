import java.util.Date;
import java.util.Scanner;

public class ExampleClass {
	
@SuppressWarnings("deprecation")
private void timeStampConverter() {
	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a year");
		int year=scanner.nextInt();
		System.out.println("Enter a month");
		int month =scanner.nextInt();
		System.out.println("Enter a day ");
		int day=scanner.nextInt();
		
		System.out.println("Enter a hour 1 to 12 hours ");
		int hour=scanner.nextInt();
		System.out.println("Enter a minute 0 to 59 minute ");
		int minute=scanner.nextInt();
		System.out.println("Enter a second 0 to 59 seconds");
		int second=scanner.nextInt();
		
		Date date=new Date();
		Date date2=new  Date(year,month,day,hour,minute,second);
		
		
		if(date.getYear()+1900 > year) {
			System.out.println(Math.abs(date.getYear()+1900 - year) +" Years ago");
		}

		else if(date.getMonth() > month) {
			System.out.println(Math.abs(date.getMonth() - month) +" Months ago");
		}

		else if(date.getDate()> day) {
			System.out.println(Math.abs(date.getDate() - day) +" Days ago");
		}
		
		
		else if(date.getHours() > hour) {
			System.out.println(Math.abs(date.getHours() - hour) +" Hours ago");
		}
		
		else if(date.getMinutes() > minute) {
			System.out.println(Math.abs(date.getMinutes() - minute) +" Minute ago");
		}

		else if(date.getSeconds() > second) {
			System.out.println(Math.abs(date.getSeconds() - second) +" second ago");
		}
		
	}


	public static void main(String[] args) {
		new ExampleClass().timeStampConverter();
		
	}

	
}

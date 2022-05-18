import java.util.Scanner;

public class SimpleFrequencyOfWordInString {

	private int frequencyOfWord(String str1,String str2) {
		int intialLength=str1.length();
		String str3=str1.replace(str2, "");//new string must be used because strings are immutable
		int finalLength=str3.length();
		return intialLength-finalLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleFrequencyOfWordInString frequencyOfWordInString=new SimpleFrequencyOfWordInString();
		Scanner scanner=new Scanner(System.in);
		String str1=new String();
		System.out.println("Enter the String");
		str1=scanner.nextLine();
		String str2=new String();
		System.out.println("Enter the character");
		str2=scanner.next();
		System.out.println("Frequency of character "+str2+"in the string "+str1+"is "+frequencyOfWordInString.frequencyOfWord(str1, str2));
	}

}

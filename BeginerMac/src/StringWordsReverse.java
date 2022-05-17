import java.util.Arrays;
import java.util.Scanner;

public class StringWordsReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lineOfCurrencies = "USD JPY AUD SGD HKD CAD CHF GBP EURO INR";
		String[] currencies = lineOfCurrencies.split(" ");
		System.out.println("input string words separated by whitespace: " + lineOfCurrencies);
		System.out.println("output string: " + Arrays.toString(currencies));
		for(int j=currencies.length-1;j>=0;j--) {
			System.out.println(currencies[j]);
		}	 
	}

}

package set2.zoho.oncampus;

import java.util.regex.Pattern;

public class RegexPatternTester {

	public static void main(String[] args) {
		
		System.out.println(Pattern.compile("^[a-zA-Z]{8,20}$",Pattern.CASE_INSENSITIVE).matcher("qqqqqqqqqqqqqqqqqqqqqq").find());
		

	}

}
